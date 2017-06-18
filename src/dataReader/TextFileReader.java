package dataReader;

import dataReader.fileReader.AbstractFileReader;
import dataReader.fileReader.FileChecker;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by Maxime on 26/11/2015.
 */
public class TextFileReader extends AbstractFileReader {

    // todo could be refactored

    private String posX;
    private String posY;
    private String dir;
    private String startingX="0";
    private String startingY="0";

    public TextFileReader(FileChecker checker) {
        super(checker);
    }

    @Override
    public List<String> readPosition() {
        String aLine=getNextLine();
        if(isPositionLine(aLine)){

            return new LinkedList<>(Arrays.asList(posX,posY,dir));
        }
        return new LinkedList<>();
    }

    @Override
    public List<String> readMove() {
        String aLine=getNextLine();
        if(isInstructionLine(aLine)){
            return new LinkedList<>(Arrays.asList(aLine.split("")));
        }
        return new LinkedList<>();
    }

    @Override
    public List<String> readStartingLine() {
        String aLine=getNextLine();
        if(isStartingLine(aLine)){
            return new LinkedList<>(Arrays.asList(startingX,startingY));
        }
        return new LinkedList<>();
    }

    @Override
    public boolean isFinished() {
        boolean hasNext=scan.hasNextLine();
        if(!hasNext)scan.close();
        return !hasNext;
    }

    private static boolean isNumberValid(String group){
        try
        {
            throwValid(group);
            return true;
        }catch(PositionException  e)
        {
            System.err.println("The number : \""+group+"\" is not valid.");
            return false;
        }
    }

    private static void throwValid(String integer) throws PositionException{
        try {
            int i = Integer.parseInt(integer);
            if (i < 0) {
                throw new PositionException("The number : \"" + integer + "\" is not valid.");
            }
        }catch (NumberFormatException e){
            throw new PositionException("The number : \"" + integer + "\" is not valid.");
        }
    }

    protected boolean isPositionLine(String aLine){
       Matcher m = UtilsRegex.isPositionLine().matcher(aLine.trim());
       if (m.find()) {
            posX=m.group(1);
            posY=m.group(3);
            dir=m.group(5);
            // todo should erase if not valid ?
           return isNumberValid(posX) && isNumberValid(posY);
       }
        System.err.println("The position : \"" + aLine + "\" is not valid.");
        return false;
    }

    protected boolean isStartingLine(String aLine){
        Matcher m = UtilsRegex.isStartingLine().matcher(aLine.trim());
        if (m.find()) {
            startingX=m.group(1);
            startingY=m.group(3);

            return isNumberValid(startingX) && isNumberValid(startingY);
        }
        System.err.println("The max position : \"" + aLine + "\" are not valid.");
        return false;
    }

    protected boolean isInstructionLine(String aLine){
        Matcher m = UtilsRegex.isInstructionLine().matcher(aLine.trim());
        if (m.find()) {
            return true;
        }
        System.err.println("Instructions : \"" + aLine + "\" are not valid.");
        return false;
    }

    private String getNextLine(){
        if (scan.hasNextLine()){
            return scan.nextLine();
        }
        return "";
    }
}


