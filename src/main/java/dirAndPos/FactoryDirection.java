package dirAndPos;

import dataReader.IDataReader;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maxime on 28/11/2015.
 */
public class FactoryDirection {

    public static List<EnumDirection> create(IDataReader reader) {
        return convert(reader.readMove());
    }

    private static List<EnumDirection> convert(List<String> instructions){
        List<EnumDirection> result =new LinkedList<>();
        for (String direction : instructions) {
            result.add(EnumDirection.getEnum(direction));
        }
        return result;
    }
}
