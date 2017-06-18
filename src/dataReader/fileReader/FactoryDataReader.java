package dataReader.fileReader;

import dataReader.IDataReader;

/**
 * Created by Maxime on 28/11/2015.
 */
public class FactoryDataReader {

    public static IDataReader getInstance(String fileName) {
        FileChecker aChecker=new FileChecker(fileName);
        EnumExtensionFile anEnum=EnumExtensionFile.getEnum(aChecker.getExtension());
        return anEnum.buildReader(aChecker);
    }
}
