package dataReader.fileReader;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Maxime on 28/11/2015.
 */
public class FileChecker {

    protected File myFile;
    protected FileInputStream myStream;

   public FileChecker(String name) {
        myFile=new File(name);
        try {
            myStream =new FileInputStream(myFile);
        } catch (FileNotFoundException e) {
            myFile=new File(".");
            System.err.println("File error : file not found." +
                    "\nActual path : "+myFile.getAbsolutePath()
                    +"\n"+e.getMessage());
        }
    }

    String getExtension(){
        return FilenameUtils.getExtension(myFile.getName());
    }


    File getFile(){
        return myFile;
    }

    FileInputStream getStream(){
        return myStream;
    }
}
