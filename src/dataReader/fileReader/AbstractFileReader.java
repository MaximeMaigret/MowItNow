package dataReader.fileReader;

import dataReader.IDataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxime on 26/11/2015.
 */
public abstract class AbstractFileReader implements IDataReader {

    protected final File myFile;
    protected final FileInputStream myStream;
    protected final FileChecker myChecker;
    protected final InputStreamReader lecture;
    private final BufferedReader buff;
    protected final Scanner scan;

    protected AbstractFileReader(FileChecker checker) {
        this.myChecker =checker;
        myFile=checker.getFile();
        myStream=checker.getStream();
        lecture=new InputStreamReader(myStream);
        buff=new BufferedReader(lecture);
        scan= new Scanner(buff);
    }
}
