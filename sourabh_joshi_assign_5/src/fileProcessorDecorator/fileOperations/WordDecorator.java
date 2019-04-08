package fileProcessorDecorator.fileOperations;

import java.util.Arrays;
import java.util.List;

public class WordDecorator extends FileProcessorAbstractBase {

	private List<String> words = null;
	private FileProcessor fileP = null;
	
	public WordDecorator(FileProcessorAbstractBase decorator) {
		super();
		this.dec = decorator;
	}
	
	@Override
	public void Decorate(InputDetails id, FileProcessor fp) {
		this.words = id.getData();
		this.fileP = fp;
		
		String[] temp2 = new String[1000];
		while (!words.isEmpty()) {
			temp2 = words.toString().split("\\W+");
			break;
		}

		System.out.println("\n\n /************ Words ***************/");
		fileP.writeOutputFile("\n\n /************ Words ***************/");
	//	for (int i = 0; i < temp2.length; i++) {
		//	temp2[i].replace("]","");
		//	temp2[i].replace("[","");
			//System.out.println(temp1[i]);
		//}
		
		id.setData(Arrays.asList(temp2));
		id.printData();
		this.dec.Decorate(id, fp);
	}

	
}
