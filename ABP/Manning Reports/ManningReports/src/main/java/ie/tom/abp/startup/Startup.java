package ie.tom.abp.startup;

import ie.tom.abp.entity.Jobs;
import ie.tom.abp.gui.GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Startup {
	private final static String PATH = "C:\\ITManningSheets\\";
	private String share;
	private String ip;
	private String jobarea = "JobAreas.txt";
	private String jobfq = "JobsFQ.txt";
	private String jobhq = "JobsHQ.txt";
	private String jobpad = "JobsPAD.txt";
	private String jobpacking = "JobsPacking.txt";
	private String jobabbatoir = "JobsAbbatoir.txt";
	private String emails = "Emails.txt";
	private String supervisors = "Supervisors.txt";
	private Jobs jobs;

	public Startup() {
		checkShare();
		createJobs();
		new GUI(ip, jobs, emails, supervisors, PATH, this);
	}
	public void reloadCache() {
		if(!ip.equals(null)) {
			if(!share.equals(null)) { 
				cache(share, PATH);
			}
		} else {
			ip = "10.6.1.70";
		}
	}
	private void createJobs() {
		jobs = new Jobs();
		jobs.setJobareas(jobarea);
		jobs.setJobsFQ(jobfq);
		jobs.setJobsHQ(jobhq);
		jobs.setJobsPAD(jobpad);
		jobs.setJobsPacking(jobpacking);
		jobs.setJobsAbbatoir(jobabbatoir);		
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
		
		reloadCache();
	}
	private boolean cache(String sourceFile, String destFile) {
		File source = new File(sourceFile);
		File dest = new File(destFile);
		
		try {
			if(!source.isDirectory()) {
				System.out.println("Share cannot be accessed");
				return false;
			}
			if(!dest.exists()) {
				dest.mkdir();
			}
					
			File[] files = source.listFiles(); 
	
			for(int i=0; i<files.length; i++) {	
				String x=(source + "\\" + files[i].getName());
				String y=(dest + "\\" + files[i].getName());
	
				File f1 = new File(x);
				f1.renameTo(new File(y));
				Files.copy(files[i].toPath(), new File(y).toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}