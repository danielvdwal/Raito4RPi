package io.reflectoring.raito4rpi.testclient.component.steppermotor.action;

import static io.reflectoring.raito4rpi.testclient.Raito4RPiEndToEndTestClient.READ_INPUT_INDICATOR;

import io.reflectoring.raito4rpi.component.motor.StepperMotor;

public class RotateAction extends StepperMotorAction {

	public RotateAction(String actionId, StepperMotor stepperMotor) {
		super(actionId, "Rotates the motor", stepperMotor);
	}

	@Override
	public void executeAction() {
		double revolutions;

		CONSOLE.println();
		CONSOLE.println("Please enter the number of revolutions you want the motor to rotate for:");
		CONSOLE.print(READ_INPUT_INDICATOR);
		String input = System.console().readLine();

		try {
			revolutions = Double.parseDouble(input);
			stepperMotor.rotate(revolutions);
		} catch (NumberFormatException ex) {
			CONSOLE.println(INVALID_INPUT_MESSAGE);
		}
		CONSOLE.println();
		CONSOLE.println(RETURNING_MESSAGE);
	}
}
