package dataReader;

import dataReader.fileReader.FactoryDataReader;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maxime on 01/12/2015.
 */
public class IDataReaderTest {

    private IDataReader myReader;

    @Before
    public void init(){
        String fileName="TestFile.txt";
        myReader= FactoryDataReader.getInstance(fileName);
    }

    @Test
    public void testReadPosition() {
        List<String> myTestList;
        assertTrue(myReader.readPosition().isEmpty());
        myTestList = myReader.readPosition();
        assertEquals(3, myTestList.size());
        assertTrue(myTestList.containsAll(Arrays.asList("1", "2", "N")));
        assertTrue(myReader.readPosition().isEmpty());
        myTestList = myReader.readPosition();
        assertEquals(3, myTestList.size());
        assertTrue(myTestList.containsAll(Arrays.asList("3", "3", "E")));
        assertTrue(myReader.readPosition().isEmpty());
        assertTrue(myReader.readPosition().isEmpty());
        assertTrue(myReader.readPosition().isEmpty());
        assertTrue(myReader.readPosition().isEmpty());
    }

    @Test
    public void testReadStartingLine() {
        List<String> myTestList=myReader.readStartingLine();
        assertEquals(2, myTestList.size());
        assertTrue(myTestList.containsAll(Arrays.asList("5", "5")));
        myTestList=myReader.readStartingLine();
        assertTrue(myTestList.isEmpty());
    }
}