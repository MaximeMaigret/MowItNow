package dirAndPos.position;

import dirAndPos.AbstractPosition;
import dirAndPos.EnumOrientation;

/**
 * Created by Maxime on 03/12/2015.
 */
public class EmptyPosition extends AbstractPosition {

    //NUll OBJECT

    public EmptyPosition() {
        this.orientation =EnumOrientation.NONE;
        this.posX=0;
        this.posY=0;
        this.maxX=0;
        this.maxY=0;
    }

    @Override
    public void setOrientation(EnumOrientation enumOrientation) {

    }

    @Override
    public AbstractPosition visit(AbstractPosition init) {
        return init;
    }
}
