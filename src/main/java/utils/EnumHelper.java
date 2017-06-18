package utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by Maxime on 07/12/2015.
 */
public class EnumHelper {

    public static  <T extends Enum<T> & IDefaultable<T>> T getValue(Class<T> classType, String value) throws NullEnumException{

        T[] enumConstants = classType.getEnumConstants();
        try {
            return Arrays.stream(enumConstants).filter(p -> p.toString().equals(value)).findFirst().get();
        }catch (NoSuchElementException e){
            if(enumConstants.length > 1 ) {
                T firstEnum = enumConstants[0];
                return firstEnum.getDefaultValue();
            }
            else{
                throw new NullEnumException("Cannot find the default value for the enum : "+classType);
            }
        }
    }

    private static class NullEnumException extends NullPointerException {
        public NullEnumException(String s){
            super(s);
        }
    }
}
