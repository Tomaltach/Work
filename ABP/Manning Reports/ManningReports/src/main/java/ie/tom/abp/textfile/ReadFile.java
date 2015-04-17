package ie.tom.abp.textfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	private static String userHome = "user.home";
	private static String path = System.getProperty(userHome) + "\\Desktop\\Manning Reports\\";
	
	public static List<String> readJobType() {
		FileInputStream fis;
		
		List<String> s = new ArrayList<String>();
		try {
			fis = new FileInputStream(path + "JobTypes.txt");
			
			//Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {
				//get int from line				
				s.add(line);				
			}			

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
