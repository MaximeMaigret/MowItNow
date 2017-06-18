package dataReader;

import java.util.List;

/**
 * Created by Maxime on 26/11/2015.
 */
public interface IDataReader {

    List<String> readPosition();
    List<String> readMove();
    List<String> readStartingLine();
    boolean isFinished();

}
