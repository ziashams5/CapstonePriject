package tek.capstone.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtility {
	
	// create a statice method with public access modifer 
	public static FileInputStream getFileInputStream (String filePath)
	throws FileNotFoundException{
	return new FileInputStream(new File(filePath));

}
}