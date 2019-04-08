package microwaveOven.driver;

import java.util.ArrayList;
import java.util.List;

import microwaveOven.service.MicrowaveContext;
import microwaveOven.util.FileDisplayInterface;
import microwaveOven.util.FileProcessor;
import microwaveOven.util.Logger;
import microwaveOven.util.Results;
import microwaveOven.util.StdoutDisplayInterface;

/**
 * @author sourabh
 * This is the driving area of the application.
 *
 */
public class Driver {

	public static void main(String[] args) {

		Driver d = new Driver();
		d.Drive(args);
		StdoutDisplayInterface stdout = Results.getInstance();
		stdout.DisplayToConsole();
		
		// Writing output to an output file
		String outputFile = args[1];
		FileDisplayInterface fdi =  Results.getInstance();
		fdi.WriteToFile(outputFile);
		
		// Writing logs for change in states		
		Logger.flushLogs("log.txt");
		
	}

	public void Drive(String[] args) {
		String input = args[0];
		List<Integer> inputList = new ArrayList<Integer>();
		FileProcessor fp = new FileProcessor(input);
		String st = "";
		while(st != null){
			st = fp.readFile();
			//System.out.println(st);
			if(st != null){
				inputList.add(Integer.parseInt(st));
			}
		}
		MicrowaveContext context = new MicrowaveContext();
		while(!inputList.isEmpty())
		{
			context.action(inputList.remove((0)));
		}
		
	}

}