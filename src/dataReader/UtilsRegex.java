package dataReader;

import java.util.regex.*;

/**
 * Created by Maxime on 29/11/2015.
 */
class UtilsRegex {

    private static final String SEPARATOR ="(\\s+)";

   public static Pattern isPositionLine() {
       String re1="^([+-]?\\d*\\.?\\d+)(?![-+0-9\\.])";
       String re2=SEPARATOR;
       String re3="([+-]?\\d*\\.?\\d+)(?![-+0-9\\.])";
       String re4=SEPARATOR;
       String re5="([A-Z])$";
       return Pattern.compile(re1+re2+re3+re4+re5, Pattern.DOTALL);
   }

    public static Pattern isStartingLine() {
        String re1="^([+-]?\\d*\\.?\\d+)(?![-+0-9\\.])";
        String re2=SEPARATOR;
        String re3="([+-]?\\d*\\.?\\d+)(?![-+0-9\\.])$";
        return Pattern.compile(re1+re2+re3, Pattern.DOTALL);
    }

    public static Pattern isInstructionLine() {
        String re1="(^(?:[A-Z][A-Z]+)$)";
        return Pattern.compile(re1,Pattern.DOTALL);
    }
}
