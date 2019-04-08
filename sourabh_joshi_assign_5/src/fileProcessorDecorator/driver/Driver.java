package fileProcessorDecorator.driver;

import fileProcessorDecorator.fileOperations.FileProcessor;
import fileProcessorDecorator.fileOperations.FileProcessorAbstractBase;
import fileProcessorDecorator.fileOperations.InputDetails;
import fileProcessorDecorator.fileOperations.ParagraphDecorator;
import fileProcessorDecorator.fileOperations.SentenceDecorator;
import fileProcessorDecorator.fileOperations.WordDecorator;
import fileProcessorDecorator.fileOperations.WordFrequencyDecorator;

public class Driver{
	
	public static void main(String[] args) {
	
		if(args.length != 2){
			System.err.println("Invalid console input..");
			System.exit(1);
		}
		String ip = args[0];
		String op = args[1];
		
		FileProcessor fp =  new FileProcessor();
		InputDetails id = new InputDetails(ip, op, fp); 
		id.readAndParseInput();
		
		FileProcessorAbstractBase frequency = new WordFrequencyDecorator(null);
		FileProcessorAbstractBase word = new WordDecorator(frequency);
		FileProcessorAbstractBase sentence = new SentenceDecorator(word);
		FileProcessorAbstractBase paragraph = new ParagraphDecorator(sentence);
		
		paragraph.Decorate(id, fp);
				
		id.closeOpFile();
		
	}
}
