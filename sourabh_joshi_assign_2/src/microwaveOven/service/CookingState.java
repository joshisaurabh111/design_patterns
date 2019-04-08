package microwaveOven.service;

import microwaveOven.util.Logger;

/**
 * @author sourabh
 * Cooking state of a microwave oven where valid and invalid buttons are 
 * mentioned in the implementation. This class extends from a abstract 
 * base class MicrowaveStateBase where used to gt instances of 
 * diffrent objects all at once instead of passing parameters.
 *
 */
public class CookingState extends MicrowaveStateBase {

	public CookingState(MicrowaveContext context)
	{
		this.ctx = context;
	}
	
	@Override
	public void inputNumbers() {
		result.saveToList(ctx.getCurrentStateName() + ": Microware is busy Cooking.");
	}

	@Override
	public void startSet() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");
	}

	@Override
	public void cancelStop() {
		ctx.setCurrentState(ctx.getPauesTimerState());
		result.saveToList("Cooking is paused");
		Logger.writeLog("Change in state");
	}

	@Override
	public void displayTime() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");		
	}

	@Override
	public void setClock() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");
	}
	
	@Override
	public String toString()
	{
		return "Cooking State";
	}
	
}
