package microwaveOven.service;

import microwaveOven.util.Logger;

/**
 * @author sourabh
 * This class displays the input numbers that are passed by the user
 *
 */
public class DisplayNumbersState extends MicrowaveStateBase {

	public DisplayNumbersState(MicrowaveContext context)
	{
		this.ctx = context;
	}
	
	@Override
	public void inputNumbers() {
		System.out.println("Entered numbers are : " + ctx.getKeycodeEntry());
	}

	@Override
	public void startSet() {
		ctx.setCurrentState(ctx.getCookingState());
		result.saveToList("Microwave will start cooking now");
		Logger.writeLog("Change state : " + ctx.getCurrentStateName());
	}

	@Override
	public void cancelStop() {
		ctx.setCurrentState(ctx.getMessageState());
		result.saveToList("Cancelled cooking");
		Logger.writeLog("Change state : " + ctx.getCurrentStateName());
	}

	@Override
	public void displayTime() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");		
	}

	@Override
	public void setClock() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");
	}

}
