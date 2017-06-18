package dirAndPos;

import dirAndPos.position.IVisitable;
import dirAndPos.position.PositionWithMaxLocation;

/**
 * Created by Maxime on 10/12/2015.
 */
public abstract class AbstractPosition implements IVisitable, Cloneable {

    protected int posX;
    protected int posY;
    protected int maxX;
    protected int maxY;
    protected EnumOrientation orientation;

    public void move(IReadStrategy strategy){
        strategy.move(this);
    }

    public EnumOrientation getOrientation(){
        return orientation;
    }

    public void setOrientation(EnumOrientation orientation) {
        this.orientation = orientation;
    }

    public int setPosYLess() {
        return posY;
    }

    public int setPosXMore() {
        return posX;
    }

    public int setPosXLess() {
        return posX;
    }

    public int setPosYMore() {
        return posY;
    }

    public final int getPosX() {
        return posX;
    }

    public final int getPosY() {
        return posY;
    }

    public boolean equals(AbstractPosition other){
        return posX == other.getPosX() && posY == other.getPosY() && orientation == other.getOrientation();
    }

    public boolean equals(PositionWithMaxLocation other){
        return other.equals(this);
    }

    public String toString(){
        return posX+" - "+posY+" | "+orientation.name();
    }

    public AbstractPosition clone(){
        try {
            AbstractPosition cloned = (AbstractPosition) super.clone();
            cloned.setOrientation(getOrientation());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
