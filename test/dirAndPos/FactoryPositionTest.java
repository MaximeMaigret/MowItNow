package dirAndPos;

import dataReader.IDataReader;
import dataReader.fileReader.FactoryDataReader;
import dirAndPos.position.EmptyPosition;
import dirAndPos.position.PositionWithLocation;
import mower.FactoryException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Maxime on 03/12/2015.
 */
public class FactoryPositionTest {

    private IDataReader myReader;

    @Before
    public void init(){
        myReader=FactoryDataReader.getInstance("TestFile.txt");
    }

    @Test
    public void testCreatePositionWithLocation() throws Exception {
        AbstractPosition aTestPos=new PositionWithLocation(1,2,EnumOrientation.getEnum("N"));
        AbstractPosition aTestPos2=new PositionWithLocation(3,3,EnumOrientation.getEnum("E"));

        assertFalse(aTestPos.equals(tryPosition()));
        assertTrue(aTestPos.equals(tryPosition()));
        assertFalse(aTestPos2.equals(tryPosition()));
        assertTrue(aTestPos2.equals(tryPosition()));
    }

    @Test
    public void testCreatePositionWithMaxLocationOverMax(){
        AbstractPosition aTestPos=new PositionWithLocation(6,7,EnumOrientation.getEnum("N"));
        AbstractPosition aTestPos2=new PositionWithLocation(6,7,EnumOrientation.getEnum("N"));
        AbstractPosition result=FactoryPosition.createPositionWithMaxLocation(myReader, aTestPos);
        AbstractPosition attempted=new PositionWithLocation(5,5,EnumOrientation.getEnum("N"));
        assertTrue(result.equals(aTestPos));
        assertTrue(result.equals(attempted));
        assertFalse(result.equals(aTestPos2));
        assertFalse(aTestPos.equals(aTestPos2));
    }

    @Test
    public void testCreatePositionWithMaxLocation() throws Exception {
        AbstractPosition aTestPos=new PositionWithLocation(1,2,EnumOrientation.getEnum("N"));
        AbstractPosition result=FactoryPosition.createPositionWithMaxLocation(myReader, aTestPos);
        assertTrue(result.equals(aTestPos));
    }

    private AbstractPosition tryPosition() {
        try {
            return FactoryPosition.createPositionWithLocation(myReader);
        }catch (FactoryException e){
            System.err.println("Position not created.");
            return new EmptyPosition();
        }
    }
}