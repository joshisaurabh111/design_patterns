package microwaveOven.service;

/**
 * @author sourabh
 * All the actions for states are defines here in this interface
 *
 */
public interface MicrowaveStateI {

	public void inputNumbers();
	public void startSet();
	public void cancelStop();
	public void displayTime();
	public void setClock();
	
}
