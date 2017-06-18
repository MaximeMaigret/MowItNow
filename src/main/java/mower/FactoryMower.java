package mower;

import dataReader.IDataReader;
import dirAndPos.AbstractPosition;
import dirAndPos.FactoryDirection;
import dirAndPos.FactoryPosition;
import dirAndPos.position.EmptyPosition;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maxime on 02/12/2015.
 */
public class FactoryMower {

    // todo could be refactored

    public static List<Mower> create(IDataReader reader) {
        List<Mower> mowerResult=new LinkedList<>();
        //todo find a better design to do this

        AbstractPosition basedPos = new EmptyPosition();
        AbstractPosition tryPos=basedPos;
        try {
            basedPos=FactoryPosition.createPositionWithMaxLocation(reader,basedPos);
        } catch (FactoryException e) {
            System.err.println("WARNING : No initial size.");
        }
        while(!reader.isFinished()) {
            try {
                tryPos = FactoryPosition.createPositionWithLocation(reader);

            } catch (FactoryException e) {
                System.err.println("ERROR : Mower not created.");
            }
            mowerResult.add(new Mower(basedPos.clone().visit(tryPos), FactoryDirection.create(reader))); //********************
        }
        return mowerResult;
    }
}
