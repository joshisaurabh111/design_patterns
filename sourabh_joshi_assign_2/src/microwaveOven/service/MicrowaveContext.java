package microwaveOven.service;

import microwaveOven.util.Logger;

/**
 * @author sourabh
 * This is the context class that a user uses to input methods to the
 * microwaveOven. This class is the base of operaion for the states and
 * it functions/actions as defined.
 *
 */
public class MicrowaveContext {

	private MicrowaveStateI currentState;
	private Integer keycodeEntry = 0;
	
	private CookingState cookingState;
	private CurrentDateState currentDateState;
	private MessageState messageState;
	private PauesTimerState pauesTimerState;
	private DisplayNumbersState displayNumbersState;
		
	public MicrowaveContext() {
		this.cookingState = new CookingState(this);
		this.currentDateState = new CurrentDateState(this);
		this.messageState = new MessageState(this);
		this.pauesTimerState = new PauesTimerState(this);
		this.displayNumbersState = new DisplayNumbersState(this);

		this.currentState = this.messageState;
	}

	public void action(int keycode) {
		if (keycode > 99) {
			while (keycode > 10000) {
				keycode = keycode / 10;
			}
			currentState.inputNumbers();
			keycodeEntry = keycode;
		} else {
			switch (keycode) {
			case 10:
				currentState.startSet();
				break;
			case 20:
				currentState.cancelStop();
				break;
			case 30:
				currentState.setClock();
				break;
			default:
				break;
			}
		}
	}

	public void setCurrentState(MicrowaveStateI currentState) {
		Logger.writeLog("Prevoius state:" + this.currentState + ", New State:" + currentState );
		this.currentState = currentState;
	}

	public MicrowaveStateI getCurrentState() {
		return currentState;
	}

	public CookingState getCookingState() {
		return cookingState;
	}

	public CurrentDateState getCurrentDateState() {
		return currentDateState;
	}

	public MessageState getMessageState() {
		return messageState;
	}

	public PauesTimerState getPauesTimerState() {
		return pauesTimerState;
	}

	public DisplayNumbersState getDisplayNumbersState() {
		return displayNumbersState;
	}
	
	public String getCurrentStateName() 
	{
		return this.currentState.toString();
	}

	public Integer getKeycodeEntry(){
		return keycodeEntry;
	}
}
