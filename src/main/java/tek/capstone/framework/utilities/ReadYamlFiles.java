package tek.capstone.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	
	// Singleton pattern concept:
	// we apply oops c
	
	//Create a private constructor (object resticted to current class)
	//Create a private Static variable reference of class
	//Declare a private HashMap 
	//Create a private constructor to restrict it to the class itself
	//Create a public Static method to create instance of class
	//Create a public method to get Yaml file properties 
	

	private static ReadYamlFiles readYamlFiles;
    private HashMap propertyMap;
    
    private ReadYamlFiles(String filepath) throws FileNotFoundException {
        FileInputStream fileInputStream = FileUtility.getFileInputStream(filepath);
        Yaml yaml = new Yaml();
        this.propertyMap = yaml.load(fileInputStream);
    }
    
    public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
        if (readYamlFiles == null)
            readYamlFiles = new ReadYamlFiles(filePath);
        return readYamlFiles;
    }
    
    public HashMap getYamlProperty(String key) {
        return (HashMap) this.propertyMap.get(key);
    }
}
