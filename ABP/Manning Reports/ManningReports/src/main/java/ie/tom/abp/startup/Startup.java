package ie.tom.abp.startup;

import ie.tom.abp.gui.GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

public class Startup {
	private final static String PATH = "C:\\ITManningSheets\\";
	private String share;
	private String ip;
	private String jobtype = "JobTypes.txt";
	private String emails = "Emails.txt";

	public Startup() {
		checkShare();
		new GUI(ip, jobtype, emails, PATH);
	}
	private void checkShare() {
		try {
			FileInputStream fis = new FileInputStream(PATH + "Preferences.txt");
			
			//Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {			
				String[] temp = line.split("\\-");
				String check = temp[0];
				switch(check) {
					case "SHARE":
						share = temp[1];
						break;
					case "IP":
						ip = temp[1];
						break;
					default:
						System.out.println("ERROR!");
						break;
				}					
			}			

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(!ip.equals(null)) {
			if(!share.equals(null)) { 
				cache(new File(share), new File(PATH));
			}
		} else {
			ip = "10.6.1.70";
		}
	}
	@SuppressWarnings("resource")
	private boolean cache(File sourceFile, File destFile) {
		try {
			if(!sourceFile.exists()) {
				return false;
			}
			if (!destFile.exists()) {
				destFile.createNewFile();
			}
			FileChannel source = null;
			FileChannel destination = null;
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			if (destination != null && source != null) {
				destination.transferFrom(source, 0, source.size());
			}
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}