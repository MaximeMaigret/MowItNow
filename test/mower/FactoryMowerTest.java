package mower;

import dataReader.IDataReader;
import dataReader.fileReader.FactoryDataReader;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maxime on 12/12/2015.
 */
public class FactoryMowerTest {

    private static final IDataReader myReader= FactoryDataReader.getInstance("TestFile.txt");


    @Test
    public void testCreate() throws Exception {
        List<Mower> myMowers=FactoryMower.create(myReader);
        assertEquals(2,myMowers.size());
    }
}