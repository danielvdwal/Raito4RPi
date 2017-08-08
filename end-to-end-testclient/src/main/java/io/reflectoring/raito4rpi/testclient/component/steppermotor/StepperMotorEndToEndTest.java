package io.reflectoring.raito4rpi.testclient.component.steppermotor;

import static com.pi4j.io.gpio.RaspiPin.*;
import static io.reflectoring.raito4rpi.testclient.Raito4RPiEndToEndTestClient.SEPARATOR_LINE;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.util.Console;

import io.reflectoring.raito4rpi.component.StepperMotor;
import io.reflectoring.raito4rpi.testclient.component.ComponentEndToEndTest;
import io.reflectoring.raito4rpi.testclient.component.steppermotor.action.RotateAction;
import io.reflectoring.raito4rpi.testclient.component.steppermotor.action.SetStepSequenceAction;

public final class StepperMotorEndToEndTest extends ComponentEndToEndTest {

	private final StepperMotor sut;

	public StepperMotorEndToEndTest(String componentId, String componentName, Console console, GpioController gpioController) {
		super(componentId, componentName, console);
		sut = new StepperMotor(GPIO_03, GPIO_04, GPIO_05, GPIO_06, gpioController);
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
