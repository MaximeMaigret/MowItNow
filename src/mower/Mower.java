package mower;

import dirAndPos.AbstractPosition;
import dirAndPos.EnumDirection;

import java.util.List;

/**
 * Created by Maxime on 29/11/2015.
 */
public class Mower {

    protected AbstractPosition myPos;
    protected List<EnumDirection> myInstructions;

    public Mower(AbstractPosition newPos, List<EnumDirection> instructions){
        myPos=newPos;
        myInstructions=instructions;
    }

    public AbstractPosition getPosition(){
        return myPos;
    }

    public void run(){
        for (EnumDirection singleInstruction : myInstructions) {
            myPos.move(singleInstruction);
        }
        System.out.println("Final position : "+myPos);
    }
}
