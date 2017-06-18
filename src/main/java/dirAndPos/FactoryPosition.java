package dirAndPos;

import dataReader.IDataReader;
import dirAndPos.position.PositionWithLocation;
import dirAndPos.position.PositionWithMaxLocation;
import mower.FactoryException;

import java.util.List;

/**
 * Created by Maxime on 29/11/2015.
 */
public class FactoryPosition {

    public static PositionWithLocation createPositionWithLocation(IDataReader reader) throws FactoryException{
        List<String> positions=reader.readPosition();
        if(positions.size()!=3){ // X - Y - D
            throw new FactoryException("Wrong data entered.");
        }
        int posX=Integer.parseInt(positions.get(0));
        int posY=Integer.parseInt(positions.get(1));
        EnumOrientation orientation=EnumOrientation.getEnum(positions.get(2));
        if(orientation.equals(EnumOrientation.NONE)){
            throw new FactoryException("Wrong data entered.");
        }

        return new PositionWithLocation(posX,posY,orientation);
    }

    public static PositionWithMaxLocation createPositionWithMaxLocation(IDataReader reader, AbstractPosition old_position){
        List<String> positions=reader.readStartingLine();
        if(positions.size()!=2){ // max X - max Y
            throw new FactoryException("Wrong data entered.");
        }
        int posX=Integer.parseInt(positions.get(0));
        int posY=Integer.parseInt(positions.get(1));
        old_position.posX=verifyPosition(old_position.getPosX(), posX);
        old_position.posY=verifyPosition(old_position.getPosY(), posY);
        return new PositionWithMaxLocation(old_position,posX,posY);
    }

    private static int verifyPosition(int oldPos, int newPos) {
        if(oldPos> newPos){
            return newPos;
        }
        return oldPos;
    }
}
