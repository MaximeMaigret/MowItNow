package dirAndPos.position;

import dirAndPos.AbstractPosition;
import dirAndPos.EnumOrientation;

/**
 * Created by Maxime on 10/12/2015.
 */
public class PositionWithMaxLocation extends AbstractPosition{

    protected AbstractPosition builtPosition;

    public PositionWithMaxLocation(AbstractPosition builtPosition, int posX, int posY){
        this.builtPosition=builtPosition;
        maxX=posX;
        maxY=posY;
    }

    private void changeReference(AbstractPosition builtPosition){
        this.builtPosition=builtPosition;
    }

    @Override
    public int setPosYLess() {
        return builtPosition.setPosYLess();
    }

    @Override
    public int setPosXMore() {
        int value=builtPosition.setPosXMore();
        return value>maxX ? posX: value;
    }

    @Override
    public int setPosXLess() {
        return builtPosition.setPosXLess();
    }

    @Override
    public int setPosYMore() {
        int value=builtPosition.setPosYMore();
        return value>maxX ? posX: value;
    }

    @Override
    public boolean equals(AbstractPosition other){
        return builtPosition.getPosX() == other.getPosX() &&
                builtPosition.getPosY() == other.getPosY() &&
                builtPosition.getOrientation() == other.getOrientation();
    }

    public boolean equals(PositionWithMaxLocation other){
        return builtPosition.getPosX() == other.builtPosition.getPosX() &&
                builtPosition.getPosY() == other.builtPosition.getPosY() &&
                builtPosition.getOrientation() == other.builtPosition.getOrientation();
    }

    @Override
    public AbstractPosition visit(AbstractPosition init) {
        changeReference(init);
        return this.clone();
    }

    public PositionWithMaxLocation clone(){
        PositionWithMaxLocation cloned = (PositionWithMaxLocation) super.clone();
        cloned.builtPosition=builtPosition.clone();
        cloned.setOrientation(getOrientation());
        return cloned;
    }

    public EnumOrientation getOrientation(){
        return builtPosition.getOrientation();
    }

    public void setOrientation(EnumOrientation orientation) {
        builtPosition.setOrientation(orientation);
    }

    @Override
    public String toString(){
        return builtPosition.getPosX()+" - "+builtPosition.getPosY()+" | "+builtPosition.getOrientation().name();
    }
}
