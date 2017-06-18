package dirAndPos.Movements;

import dirAndPos.AbstractPosition;
import dirAndPos.EnumDirection;
import dirAndPos.EnumOrientation;
import dirAndPos.position.PositionWithLocation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Maxime on 06/12/2015.
 */
public class IMovementStrategyTest {

    private AbstractPosition start;

    @Before
    public void init(){
        start=new PositionWithLocation(0,0,EnumOrientation.NORTH);
    }

    @Test
    public void testMove() throws Exception {
        AbstractPosition end=new PositionWithLocation(0,0,EnumOrientation.EAST);
        start.move(EnumDirection.D);
        assertTrue(end.equals(start));

        end.setPosXMore();
        start.move(EnumDirection.A);
        assertTrue(end.equals(start));

        end.setOrientation(EnumOrientation.NORTH);
        start.move(EnumDirection.G);
        assertTrue(end.equals(start));

        end.setPosYMore();
        start.move(EnumDirection.A);
        assertTrue(end.equals(start));

        end.setOrientation(EnumOrientation.WEST);
        start.move(EnumDirection.G);
        assertTrue(end.equals(start));

        end.setOrientation(EnumOrientation.NORTH);
        start.move(EnumDirection.D);
        assertTrue(end.equals(start));

        end.setOrientation(EnumOrientation.EAST);
        start.move(EnumDirection.D);
        assertTrue(end.equals(start));

        end.setOrientation(EnumOrientation.SOUTH);
        start.move(EnumDirection.D);
        assertTrue(end.equals(start));

        end.setPosYLess();
        start.move(EnumDirection.A);
        assertTrue(end.equals(start));

        start.move(EnumDirection.A);
        assertTrue(end.equals(start));

        end.setOrientation(EnumOrientation.WEST);
        start.move(EnumDirection.D);
        assertTrue(end.equals(start));

        end.setPosXLess();
        start.move(EnumDirection.A);
        assertTrue(end.equals(start));

        start.move(EnumDirection.A);
        assertTrue(end.equals(start));
    }
}