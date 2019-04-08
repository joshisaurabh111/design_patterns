package fileProcessorDecorator.fileOperations;

public abstract class FileProcessorAbstractBase {
	
	
	protected FileProcessorAbstractBase dec = null;
	public abstract void Decorate(InputDetails id, FileProcessor fp);
	
}