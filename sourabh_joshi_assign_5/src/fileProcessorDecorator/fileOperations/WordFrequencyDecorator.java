package fileProcessorDecorator.fileOperations;

import java.util.HashMap;
import java.util.List;

public class WordFrequencyDecorator extends FileProcessorAbstractBase {

	private List<String> wordfreq = null;
	private FileProcessor fileP = null;

	
	public WordFrequencyDecorator(FileProcessorAbstractBase decorator) {
		super();
		this.dec = decorator;
	}
	
	@Override
	public void Decorate(InputDetails id, FileProcessor fp) {
		this.wordfreq = id.getData();
		this.fileP  = fp;
		
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
	    for (String s : wordfreq){
	        if (wordCount.containsKey(s)){
	        	wordCount.replace(s, wordCount.get(s) + 1);
	        }
	        else {
	        	wordCount.put(s, 1);
	        }
	    }
	    
	    System.out.println("\n\n /************ Word Frequency ***************/");
	    fileP.writeOutputFile("\n\n /************ Word Frequency ***************/");
	    for(String word : wordCount.keySet() ){
	    	String key = word.toString();
	    	String value = wordCount.get(word).toString();
	    	System.out.println(key + " : " + value);
	    	fileP.writeOutputFile("" + key + " : " + value);
	    }
	    
	}

}
