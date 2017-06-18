package dirAndPos;

import utils.IDefaultable;

/**
 * Created by Maxime on 28/11/2015.
 */
interface IReadStrategy{
    void move(AbstractPosition initial);
}

public enum EnumDirection implements IReadStrategy, IDefaultable<EnumDirection> {
    A("A") {
        @Override
        public void move(AbstractPosition initial) {
            initial.getOrientation().next(initial);
        }
    },
    D("D") {
        @Override
        public void move(AbstractPosition initial) {
            initial.getOrientation().turnRight(initial);
        }
    },
    G("G") {
        @Override
        public void move(AbstractPosition initial) {
            initial.getOrientation().turnLeft(initial);
        }
    },
    NONE("") {
        @Override
        public void move(AbstractPosition initial) {

        }
    };

    private String name;

    EnumDirection(String direction) {
        this.name=direction;
    }

    @Override
    public String toString() {
        return name;
    }

    public static EnumDirection getEnum(String aName){
        for (EnumDirection anEnum : EnumDirection.values()) {
            if (anEnum.name.equalsIgnoreCase(aName)) {
                return anEnum;
            }
        }
        return NONE;
    }

    @Override
    public EnumDirection getDefaultValue() {
        return NONE;
    }
}
