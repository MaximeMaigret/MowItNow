package common;

import dirAndPos.AbstractPosition;
import dirAndPos.EnumOrientation;
import dirAndPos.position.PositionWithLocation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maxime on 01/12/2015.
 */
public class PositionTest {

    private AbstractPosition aTestPos;

    @Before
    public void init(){
        aTestPos=new PositionWithLocation(1,2, EnumOrientation.getEnum("N"));
    }

    @Test
    public void testConstructor(){

        assertEquals(1,aTestPos.getPosX());
        assertEquals(2,aTestPos.getPosY());
        assertEquals("N",aTestPos.getOrientation().toString());
    }

}