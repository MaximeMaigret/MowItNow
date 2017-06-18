package dataReader.fileReader;

import dataReader.IDataReader;
import dataReader.TextFileReader;
import dataReader.UnknownFileReader;

/**
 * Created by Maxime on 28/11/2015.
 */
interface ReaderBuilder{
    IDataReader buildReader(FileChecker checker);
}

enum EnumExtensionFile implements ReaderBuilder{

    TEXT("txt") {
        @Override
        public IDataReader buildReader(FileChecker checker) {
            return new TextFileReader(checker);
        }
    },
    UNKNOWN("UNKNOWN") {
        @Override
        public IDataReader buildReader(FileChecker checker) {
            return new UnknownFileReader(checker);
        }
    };

    private String name;

    EnumExtensionFile(String name) {
        this.name=name;
    }


    static EnumExtensionFile getEnum(String aName){
        for (EnumExtensionFile anEnum : EnumExtensionFile.values()) {
            if (anEnum.name.equalsIgnoreCase(aName)) {
                return anEnum;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return name;
    }

}
