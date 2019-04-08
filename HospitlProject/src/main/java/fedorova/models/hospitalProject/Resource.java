package fedorova.models.hospitalProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

public class Resource {

	public static void main(String[] args)throws FileNotFoundException, IOException {
		final Logger logger = Logger.getLogger(Resource.class);
        try(FileReader read = new FileReader("Demo.txt")) {
        
        } catch(Exception e) {
        	logger.info("Error: File not found ");
        }
    
    }

}
