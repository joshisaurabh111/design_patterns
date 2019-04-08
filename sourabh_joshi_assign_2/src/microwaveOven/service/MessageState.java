package microwaveOven.service;

import microwaveOven.util.Logger;

/**
 * @author sourabh
 *	This is the default state of the microwaveOven.
 *	This is also the starting state where all cancelStop functions end. 
 *	Naming it as message state since it displays msg by default when
 *	we plug in the microwave to an electricity supply
 *
 */
public class MessageState extends MicrowaveStateBase {

	
	public MessageState(MicrowaveContext context)
	{
		this.ctx = context;
		System.out.println("Welcome to my microwaveOven \n");
	}
	
	@Override
	public void inputNumbers() {
		ctx.setCurrentState(ctx.getDisplayNumbersState());
		result.saveToList("Parsing the entered numbers");
		Logger.writeLog("Change state : " + ctx.getCurrentStateName());
	}

	@Override
	public void startSet() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");	
	}

	@Override
	public void cancelStop() {
		ctx.setCurrentState(ctx.getMessageState());
		result.saveToList("Stay in the MessageState");
		Logger.writeLog("Change state : " + ctx.getCurrentStateName());
	}

	@Override
	public void displayTime() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");
	}

	@Override
	public void setClock() {
		ctx.setCurrentState(ctx.getCurrentDateState());
		result.saveToList("Setting the clock");
		Logger.writeLog("Change state : " + ctx.getCurrentStateName());
	}

}
