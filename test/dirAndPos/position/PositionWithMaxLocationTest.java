package dirAndPos.position;

import dirAndPos.EnumOrientation;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maxime on 13/12/2015.
 */
public class PositionWithMaxLocationTest {

    @Test
    public void testCloneLocal() throws Exception {
        PositionWithLocation localPos=new PositionWithLocation(1,2, EnumOrientation.EAST);
        PositionWithMaxLocation maxPos=new PositionWithMaxLocation(localPos,5,5);
        PositionWithMaxLocation copyMaxPos=maxPos.clone();
        assertTrue(copyMaxPos.equals(maxPos));
        maxPos.setPosXMore();
        assertFalse(localPos.equals(copyMaxPos.builtPosition));
        assertFalse(copyMaxPos.equals(maxPos));
    }

}
