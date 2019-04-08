package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceDecorator extends FileProcessorAbstractBase {

	private List<String> sentences = null;
	private FileProcessor fileP = null;
	
	public SentenceDecorator(FileProcessorAbstractBase decorator) {
		super();
		this.dec = decorator;
	}
	
	@Override
	public void Decorate(InputDetails id, FileProcessor fp) {
		sentences =  new ArrayList<String>();
		this.sentences = id.getData();
		this.fileP = fp;

		String[] temp1 = new String[100];
		while (!this.sentences.isEmpty()) {
			temp1 = this.sentences.toString().split("\\.\\W*");
			break;
		}

		System.out.println("\n\n/************** Sentences *****************/");
		fileP.writeOutputFile("\n\n/************** Sentences *****************/");
	//	for (int i = 0; i < temp1.length; i++) {
		//	temp1[i].replace("]","");
		//	temp1[i].replace("[","");
			//System.out.println(temp1[i]);
	//	}
		
		id.setData(Arrays.asList(temp1));
		id.printData();
		this.dec.Decorate(id, fp);
	}

}
