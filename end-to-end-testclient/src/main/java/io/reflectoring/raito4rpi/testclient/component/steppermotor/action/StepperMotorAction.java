package io.reflectoring.raito4rpi.testclient.component.steppermotor.action;

import com.pi4j.util.Console;

import io.reflectoring.raito4rpi.component.motor.StepperMotor;
import io.reflectoring.raito4rpi.testclient.component.Action;

/**
 * Abstract class for all StepperMotorActions. Provides a console for aditional input parameters.
 */
abstract class StepperMotorAction extends Action {

	static final String RETURNING_MESSAGE = "Returning to action-selection";
	static final String INVALID_INPUT_MESSAGE = "You have entered an invalid value.";

	protected static final Console CONSOLE = new Console();
	protected final StepperMotor stepperMotor;

	protected StepperMotorAction(String actionId, String actionName, StepperMotor stepperMotor) {
		super(actionId, actionName);
		this.stepperMotor = stepperMotor;
	}

}
