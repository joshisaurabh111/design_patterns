package microwaveOven.service;

import microwaveOven.util.*;

/**
 * @author sourabh
 * Abstract base class for defining objects of diffrent classes.
 * All the classes that extend this class can make use of this objects
 * and reduce duplication of code.s
 *
 */
public abstract class MicrowaveStateBase implements MicrowaveStateI {

	protected Results result = Results.getInstance();
	protected MicrowaveContext ctx;

}
