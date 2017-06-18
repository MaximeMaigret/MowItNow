package dirAndPos.position;

import dirAndPos.AbstractPosition;
import dirAndPos.EnumOrientation;

/**
 * Created by Maxime on 10/12/2015.
 */
public class PositionWithLocation extends AbstractPosition{

    public PositionWithLocation(int posX, int posY, EnumOrientation orientation){
        this.posX=posX;
        this.posY=posY;
        this.orientation =orientation;
    }

    public int setPosXMore() {
        return posX++;
    }

    public int setPosXLess() {
        if(posX>0)posX--;
        return posX;
    }

    public int setPosYMore() {
        return posY++;
    }

    public int setPosYLess() {
        if(posY>0)posY--;
        return posY;
    }

    @Override
    public AbstractPosition visit(AbstractPosition init) {
        if(this.equals(init)){
            return this;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
