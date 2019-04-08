package microwaveOven.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sourabh
 *	This is a logger class that maintains the logs.
 *	I have implemented all the logs for change in state only.
 *
 */
public class Logger {
	
	static List<String> logList = new ArrayList<String>();

	public static void writeLog(String message) {
		logList.add(LocalDateTime.now() + ": " + message + "\n");
	}

	public static void flushLogs(String fileName) 
	{
		
		File logFile = new File(fileName);
		FileWriter fw = null;
		try {
			fw = new FileWriter(logFile);
			for(String newstr : logList){
				fw.write(newstr);
			}
			logList.clear();
			fw.close();
		} catch (IOException e) {
			System.out.println("logFile not Found ..!!");
		}
	}
}
