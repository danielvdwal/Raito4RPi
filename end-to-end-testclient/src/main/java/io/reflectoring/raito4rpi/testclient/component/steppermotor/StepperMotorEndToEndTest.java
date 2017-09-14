package io.reflectoring.raito4rpi.testclient.component.steppermotor;

import static io.reflectoring.raito4rpi.testclient.Raito4RPiEndToEndTestClient.SEPARATOR_LINE;

import com.pi4j.util.Console;

import io.reflectoring.raito4rpi.component.motor.StepperMotor;
import io.reflectoring.raito4rpi.testclient.component.ComponentEndToEndTest;
import io.reflectoring.raito4rpi.testclient.component.ComponentFactory;
import io.reflectoring.raito4rpi.testclient.component.steppermotor.action.RotateAction;
import io.reflectoring.raito4rpi.testclient.component.steppermotor.action.SetStepSequenceAction;

public final class StepperMotorEndToEndTest extends ComponentEndToEndTest {

	public StepperMotor sut;

	public StepperMotorEndToEndTest(String componentId, String componentName, Console console) {
		super(componentId, componentName, console);
		sut = ComponentFactory.getStepperMotor();
		fillActions();
	}

	@Override
	protected void fillActions() {
		actions.add(new SetStepSequenceAction("0", sut));
		actions.add(new RotateAction("1", sut));
	}

	@Override
	protected void printConnectionInformation() {
		console.println();
		console.println("Please ensure that the StepperMotor to test is connected as followed:");
		console.println(SEPARATOR_LINE);
		console.println(UPPER_PIN_LAYOUT);
		console.println("# VCC  -  GND  -   -   -   -  P1  P2   -  P3   -   -   -   -   -   -   -   -   -  #");
		console.println("#  -   -   -   -   -   -   -  P0   -   -   -   -   -   -   -   -   -   -   -   -  #");
		console.println(LOWER_PIN_LAYOUT);
		console.println(SEPARATOR_LINE);
	}

	@Override
	protected void onExit() {
		sut.stop();
	}
}
