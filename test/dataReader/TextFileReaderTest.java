package dataReader;

import dataReader.fileReader.FileChecker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maxime on 29/11/2015.
 */
public class TextFileReaderTest {

    private TextFileReader myReader;

    @Before
    public void init(){
        String fileName="TestFile.txt";
        myReader=new TextFileReader(new FileChecker(fileName));
    }

    @Test
    public void testIsPositionLineOK() {
        assertTrue(myReader.isPositionLine("5 5 N"));
        assertTrue(myReader.isPositionLine("5 5 N "));
        assertTrue(myReader.isPositionLine(" 5 5 N"));

    }
    @Test
    public void testIsPositionLineNOK(){
        assertFalse(myReader.isPositionLine("5 5"));
        assertFalse(myReader.isPositionLine("5 5 "));
        assertFalse(myReader.isPositionLine(" 5 N"));
        assertFalse(myReader.isPositionLine("5  N"));
        assertFalse(myReader.isPositionLine("5 N"));
        assertFalse(myReader.isPositionLine(" "));
        assertFalse(myReader.isPositionLine(""));
        assertFalse(myReader.isPositionLine(" N "));
        assertFalse(myReader.isPositionLine(" 5 "));
        assertFalse(myReader.isPositionLine(" N"));
        assertFalse(myReader.isPositionLine(" 5"));
        assertFalse(myReader.isPositionLine("N "));
        assertFalse(myReader.isPositionLine("5 "));
        assertFalse(myReader.isPositionLine("N"));
        assertFalse(myReader.isPositionLine("5"));
        assertFalse(myReader.isPositionLine("-5 5 N"));
        assertFalse(myReader.isPositionLine("0.5 5 N"));
        assertFalse(myReader.isPositionLine("0,5 5 N"));
        assertFalse(myReader.isPositionLine("N N N"));
        assertFalse(myReader.isPositionLine("5 5 NA"));
        assertFalse(myReader.isPositionLine("5 5 N A"));
        assertFalse(myReader.isPositionLine("5 5 N 5"));
        assertFalse(myReader.isPositionLine("5 5 N 5 5"));
        assertFalse(myReader.isPositionLine("5 5 N 5 "));
        assertFalse(myReader.isPositionLine("5 5 5 N"));
        assertFalse(myReader.isPositionLine(" 5 5 5 N"));
        assertFalse(myReader.isPositionLine("55N"));
        assertFalse(myReader.isPositionLine("55 N"));
        assertFalse(myReader.isPositionLine("5 5N"));
        assertFalse(myReader.isPositionLine("55N N"));
        assertFalse(myReader.isPositionLine("5  n"));
    }

    @Test
    public void testIsFinished(){
        for(int i=0;i<5;i++) {
            assertFalse(myReader.isFinished());
            myReader.readPosition();
        }
        assertTrue(myReader.isFinished());
    }

    @Test
    public void testIsInstructionLine(){
        assertTrue(myReader.isInstructionLine("GAGAGAGAA"));
        assertFalse(myReader.isInstructionLine("GAGA GAGAA"));
        assertFalse(myReader.isInstructionLine("1234"));
        assertFalse(myReader.isInstructionLine("GAGA4GAGAA"));
    }
}