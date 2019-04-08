package microwaveOven.service;

import microwaveOven.util.Logger;

/**
 * @author sourabh
 * This class is an intermediate state that only appears when you use
 * cancelStop while cooking is already in process. This states also has 
 * other actions invalid except startSet and cancelStop.
 *
 */
public class PauesTimerState extends MicrowaveStateBase {

	public PauesTimerState(MicrowaveContext context)
	{
		this.ctx = context;
	}
	
	@Override
	public void inputNumbers() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");
	}

	@Override
	public void startSet() {
		ctx.setCurrentState(ctx.getCookingState());	
		result.saveToList("We are back to cooking");
		Logger.writeLog("Change state : " + ctx.getCurrentStateName());
	}

	@Override
	public void cancelStop() {
		ctx.setCurrentState(ctx.getMessageState());
		result.saveToList("Done with cooking");
		Logger.writeLog("Change state : " + ctx.getCurrentStateName());
	}

	@Override
	public void displayTime() {
		Integer time = ctx.getKeycodeEntry();
		result.saveToList("Paused at : "+ time);		
	}

	@Override
	public void setClock() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");
	}

	@Override
	public String toString()
	{
		return "Pause Timer State";
	}
}
