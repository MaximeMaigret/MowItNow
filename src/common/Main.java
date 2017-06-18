package common;

import dataReader.IDataReader;
import dataReader.fileReader.FactoryDataReader;
import mower.FactoryMower;
import mower.Mower;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final IDataReader myReader= FactoryDataReader.getInstance("TestFile.txt");
        List<Mower> todeuses=FactoryMower.create(myReader);
        for (Mower todeuse : todeuses) {
            // could be multithreaded
            todeuse.run();
        }
    }
}
