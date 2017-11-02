package io.reflectoring.raito4rpi.testclient;

import com.pi4j.util.Console;

import io.reflectoring.raito4rpi.component.led.RgbLed;
import io.reflectoring.raito4rpi.component.motor.StepSequenceStrategy;
import io.reflectoring.raito4rpi.component.motor.StepperMotor;
import io.reflectoring.raito4rpi.testclient.component.ComponentFactory;

/**
 * Just a test sequence for the later JiraAlerts usage
 */
class JiraAlertsTestSequence {

	void execute(Console console) {
		console.println("Starting JiraAlerts sequence for 3 half rotations back and forth!");
		RgbLed rgbLed = ComponentFactory.getRgbLed();
		StepperMotor stepperMotor = ComponentFactory.getStepperMotor();
		stepperMotor.setStepSequenceStrategy(StepSequenceStrategy.OVER_STEP_SEQUENCE);
		int nrOfRotations = 2;

		Runnable stepperMotorRotation = () -> {
			// half rotation takes approximately 2.1 seconds
			for (int i = 0; i < nrOfRotations; i++) {
				motorBackAndForth(stepperMotor);
			}
		};

		Runnable rgbLedBlinking = () -> {
			for (int i = 0; i < nrOfRotations; i++) {
				rgbRedAndOff(rgbLed);
				rgbRedAndOff(rgbLed);
				rgbRedAndOff(rgbLed);
				rgbRedAndOff(rgbLed);
			}
		};

		new Thread(stepperMotorRotation).start();
		new Thread(rgbLedBlinking).start();
	}

	private void motorBackAndForth(StepperMotor stepperMotor) {
		stepperMotor.rotate(0.5);
		stepperMotor.rotate(-0.5);
	}

	private void rgbRedAndOff(RgbLed rgbLed) {
		try {
			Thread.sleep(520);
			rgbLed.turnRed();
			Thread.sleep(520);
			rgbLed.turnOff();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
