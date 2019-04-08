package microwaveOven.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import microwaveOven.util.Logger;

/**
 * @author sourabh
 * This class displays the input of current date and method to change
 * the same. Other functions than startSet are disabled in this class.
 *
 */
public class CurrentDateState extends MicrowaveStateBase {
	
	public CurrentDateState(MicrowaveContext context)
	{
		this.ctx = context;
	}
	
	@Override
	public void inputNumbers() {
		DateFormat dateFormat = new SimpleDateFormat("mm:dd:yyyy");
		Date date = new Date();
		result.saveToList("current date : " + dateFormat.format(date));
		displayNumbers();
	}

	@Override
	public void startSet() {
		ctx.setCurrentState(ctx.getMessageState());
		result.saveToList("Done setting time");
		Logger.writeLog("Change state : " + ctx.getCurrentStateName());
	}

	@Override
	public void cancelStop() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");		
	}

	@Override
	public void displayTime() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");
	}

	@Override
	public void setClock() {
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");		
	}
	
	void displayNumbers(){
		result.saveToList(ctx.getCurrentStateName() + ": Invalid Button");
	}

}
