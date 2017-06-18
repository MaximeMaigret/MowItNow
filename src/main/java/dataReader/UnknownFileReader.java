package dataReader;

import dataReader.fileReader.AbstractFileReader;
import dataReader.fileReader.FileChecker;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maxime on 28/11/2015.
 */
public final class UnknownFileReader extends AbstractFileReader {

    //NULL OBJECT

    private final List<String> myEmptyList=new LinkedList<>();

    public UnknownFileReader(FileChecker checker) {
        super(checker);
    }

    @Override
    public List<String> readPosition() {
        return myEmptyList;
    }

    @Override
    public List<String> readMove() {
        return myEmptyList;
    }

    @Override
    public List<String> readStartingLine() {
        return myEmptyList;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
