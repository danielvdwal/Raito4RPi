package io.reflectoring.raito4rpi.testclient.component.steppermotor.action;

import static io.reflectoring.raito4rpi.component.motor.StepSequenceStrategy.*;
import static io.reflectoring.raito4rpi.testclient.Raito4RPiEndToEndTestClient.READ_INPUT_INDICATOR;

import io.reflectoring.raito4rpi.component.motor.StepperMotor;

public class SetStepSequenceAction extends StepperMotorAction {

	public SetStepSequenceAction(String actionId, StepperMotor stepperMotor) {
		super(actionId, "Set a specific step sequence", stepperMotor);
	}

	@Override
	public void executeAction() {
		CONSOLE.println();
		CONSOLE.println("Please select one of the following step sequences:");
		CONSOLE.println("[0] - single step");
		CONSOLE.println("[1] - double step");
		CONSOLE.println("[2] - half step");
		CONSOLE.print(READ_INPUT_INDICATOR);
		String input = System.console().readLine();

		switch (input) {
		case "0":
			stepperMotor.setStepSequenceStrategy(SINGLE_STEP_SEQUENCE);
			break;
		case "1":
			stepperMotor.setStepSequenceStrategy(DOUBLE_STEP_SEQUENCE);
			break;
		case "2":
			stepperMotor.setStepSequenceStrategy(HALF_STEP_SEQUENCE);
			break;
		default:
			CONSOLE.println(INVALID_INPUT_MESSAGE);
		}
		CONSOLE.println();
		CONSOLE.println(RETURNING_MESSAGE);
	}
}
