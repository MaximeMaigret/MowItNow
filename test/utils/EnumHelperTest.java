package utils;

import dirAndPos.EnumOrientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maxime on 07/12/2015.
 */
public class EnumHelperTest {

    @Test
    public void testGetDefault() throws Exception {
        assertEquals("EAST",EnumHelper.getValue(EnumOrientation.class, "E").name());
        assertEquals("NONE", EnumHelper.getValue(EnumOrientation.class, "Z").name());
        assertEquals("NONE", EnumHelper.getValue(EnumOrientation.class, "").name());
    }

}