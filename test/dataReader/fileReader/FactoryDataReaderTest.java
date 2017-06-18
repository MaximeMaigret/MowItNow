package dataReader.fileReader;

import dataReader.TextFileReader;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maxime on 28/11/2015.
 */
public class FactoryDataReaderTest {

    @Test
    public void testGetInstance() throws Exception {
        assertTrue(FactoryDataReader.getInstance("TestFile.txt") instanceof TextFileReader);
        assertFalse(FactoryDataReader.getInstance("TestFile.csv") instanceof TextFileReader);
    }
}