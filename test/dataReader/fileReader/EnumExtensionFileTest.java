package dataReader.fileReader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maxime on 28/11/2015.
 */
public class EnumExtensionFileTest {

    @Test
    public void testParseEnum(){
        String aTest="txt";
        EnumExtensionFile anEnum=EnumExtensionFile.getEnum(aTest);
        assertEquals(aTest,anEnum.toString());
        aTest=".csv";
        anEnum=EnumExtensionFile.getEnum(aTest);
        assertEquals("UNKNOWN",anEnum.toString());
    }


}