package dirAndPos;

import utils.IDefaultable;

/**
 * Created by Maxime on 28/11/2015.
 */

interface IMovementStrategy {
    void turnLeft(AbstractPosition entry);
    void turnRight(AbstractPosition entry);
    void next(AbstractPosition entry);
}

public enum EnumOrientation implements IMovementStrategy, IDefaultable<EnumOrientation> {
    NORTH("N") {
        @Override
        public void turnLeft(AbstractPosition entry) {
            entry.setOrientation(WEST);
        }

        @Override
        public void turnRight(AbstractPosition entry) {
           entry.setOrientation(EAST);
        }

        @Override
        public void next(AbstractPosition entry) {
          entry.setPosYMore();
        }
    },
    SOUTH("S") {
        @Override
        public void turnLeft(AbstractPosition entry) {
            entry.setOrientation(EAST);
        }

        @Override
        public void turnRight(AbstractPosition entry) {
            entry.setOrientation(WEST);
        }

        @Override
        public void next(AbstractPosition entry) {
            entry.setPosYLess();
        }
    },
    EAST("E") {
        @Override
        public void turnLeft(AbstractPosition entry) {
           entry.setOrientation(NORTH);
        }

        @Override
        public void turnRight(AbstractPosition entry) {
            entry.setOrientation(SOUTH);
        }

        @Override
        public void next(AbstractPosition entry) {
            entry.setPosXMore();
        }
    },
    WEST("W") {
        @Override
        public void turnLeft(AbstractPosition entry) {
            entry.setOrientation(SOUTH);
        }

        @Override
        public void turnRight(AbstractPosition entry) {
            entry.setOrientation(NORTH);
        }

        @Override
        public void next(AbstractPosition entry) {
            entry.setPosXLess();
        }
    },
    NONE("") {
        @Override
        public void turnLeft(AbstractPosition entry) {

        }

        @Override
        public void turnRight(AbstractPosition entry) {

        }

        @Override
        public void next(AbstractPosition entry) {

        }
    };

    private final String name;

    EnumOrientation(String letter) {
        name = letter;
    }

    public String toString(){
        return name;
    }

     public static EnumOrientation getEnum(String aName){
        for (EnumOrientation anEnum : EnumOrientation.values()) {
            if (anEnum.name.equalsIgnoreCase(aName)) {
                return anEnum;
            }
        }
        return NONE;
    }

    @Override
    public EnumOrientation getDefaultValue() {
        return NONE;
    }


}
