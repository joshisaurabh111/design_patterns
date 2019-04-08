package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.List;

public class InputDetails {

	private List<String> data = null;
	private FileProcessor filep = null;
	private String inputFile = "";
	private String outputFile = "";

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}	

	public InputDetails(String iFilename, String oFilename, FileProcessor fp) {
		data = new ArrayList<String>();
		this.filep = fp;
		this.inputFile = iFilename;
		this.outputFile = oFilename;
		fp.getOuputFileName(outputFile);
	}

	public void readAndParseInput() {
		String st = "";
		filep.getInputFileName(inputFile);
		while (st != null) {
			st = filep.readInputFile();
			if (st != null) {
				data.add(st);
			}
		}
		//System.out.println(data);
		filep.closeInputFile();
	}

	public void printData() {
		int num = 1;
		String some[] = {""};
		//	System.out.println(data);
		some = data.toString().split(",");
		for(int i=0; i<some.length; i++){
			System.out.println(num + " : " + some[i].toString().replace("]","").replace("[",""));
			String content = num + " : " + some[i].toString().replace("]","").replace("[","");
			writeToFile(content);
			num++;
			//System.out.println(num + " : " + dataIter.next().toString().replace("]","").replace("[",""));
		}
		
	}
	
	public void writeToFile(String content){
		filep.writeOutputFile(content);
	}
	
	public void closeOpFile(){
		filep.closeOutputFile();
	}

}
