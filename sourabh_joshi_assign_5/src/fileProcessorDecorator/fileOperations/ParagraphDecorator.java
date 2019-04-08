package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParagraphDecorator extends FileProcessorAbstractBase {

	private List<String> paragraphs = null;
	private FileProcessor fileP = null;
	
	public ParagraphDecorator(FileProcessorAbstractBase word) {
		super();
		this.dec = word;
	}


	@Override
	public void Decorate(InputDetails id, FileProcessor fp) {
		paragraphs =  new ArrayList<String>();
		this.paragraphs = id.getData(); 
		this.fileP = fp;
		
		String[] temp = new String[1000];
		while(!paragraphs.isEmpty()){
			temp = paragraphs.toString().split("(?<=[.]) \\s+|(?<=[.])\\n+");
			break;	
		}
		System.out.println("\n\n /************ Paragraphs ***************/");
		fileP.writeOutputFile("\n\n /************ Paragraphs ***************/");
	//	for(Integer i=0; i < temp.length; i++){
		//	temp[i] = temp[i].replace("[","");
		//	temp[i] = temp[i].replace("]","");
	//		System.out.println("\n\nparas : " + temp[i]);
	//	}
		id.setData(Arrays.asList(temp));
		id.printData();
		this.dec.Decorate(id, fp);
	}

}