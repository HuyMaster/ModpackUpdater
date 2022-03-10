package root.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class processChecker {
	public static boolean start(String processname, String Windowtitle) {
		Boolean processFound = null;
		String command = System.getenv("windir") +"/system32/tasklist.exe /nh /fi \"Imagename eq " + processname +"\" /fi \"windowtitle eq " + Windowtitle + "\"";
		try {
			sleep.sleep(3);
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			ArrayList<String> procs = new ArrayList<String>();
			String line = null;
			while ((line = input.readLine()) != null) 
			    procs.add(line);
			input.close();
			processFound = procs.stream().filter(row -> row.indexOf(processname) > -1).count() > 0;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return processFound;
	}
}
