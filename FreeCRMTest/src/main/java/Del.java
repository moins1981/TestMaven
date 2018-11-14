import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Del {

	public static void main(String[] args) {
		//public TestBase() {
			//Read the properties
			
			try {
				Properties prop = new Properties();
				FileInputStream ip= new FileInputStream("/Users/Admin/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
				System.out.println(ip);		
				prop.load(ip);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();	
			}	
			
		}
		

	}

//}
