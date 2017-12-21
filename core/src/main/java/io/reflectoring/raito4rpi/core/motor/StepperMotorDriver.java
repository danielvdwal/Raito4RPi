package io.reflectoring.raito4rpi.core.motor;

import com.pi4j.component.motor.impl.GpioStepperMotorComponent;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

import io.reflectoring.raito4rpi.core.GpioDriver;

/**
 * Provides all methods to drive a {@link StepperMotor}.
 */
public class StepperMotorDriver {

	private final StepperMotor stepperMotor;
	private final GpioStepperMotorComponent internalMotor;

	/**
	 * Creates an instance of {@link StepperMotorDriver} to drive StepperMotors.
	 *
	 * @param stepperMotor
	 *            the StepperMotor to drive
	 * @param gpioDriver
	 *            to set the states for the different pins
	 */
	public StepperMotorDriver(StepperMotor stepperMotor, GpioDriver gpioDriver) {
		this.stepperMotor = stepperMotor;

		GpioPinDigitalOutput[] pins = new GpioPinDigitalOutput[4];
		pins[0] = gpioDriver.getDigitalOutputPinByAddress(stepperMotor.getPinAddress1());
		pins[1] = gpioDriver.getDigitalOutputPinByAddress(stepperMotor.getPinAddress2());
		pins[2] = gpioDriver.getDigitalOutputPinByAddress(stepperMotor.getPinAddress3());
		pins[3] = gpioDriver.getDigitalOutputPinByAddress(stepperMotor.getPinAddress4());

		internalMotor = new GpioStepperMotorComponent(pins);
		updateSettings();
	}

	/**
	 * Updates all properties for the StepperMotor to be driven according to the current settings of the StepperMotor.
	 */
	public void updateSettings() {
		internalMotor.setStepInterval(stepperMotor.getStepInterval());
		internalMotor.setStepsPerRevolution(stepperMotor.getStepsPerRevolution());
		StepSequenceStrategy stepSequenceStrategy = stepperMotor.getStepSequenceStrategy();
		byte[] stepSequence = stepSequenceStrategy.getStepSequence();
		internalMotor.setStepSequence(stepSequence);
		int stepsPerRevolution = (int) (stepperMotor.getStepsPerRevolution() / stepSequenceStrategy.getStepModifier());
		internalMotor.setStepsPerRevolution(stepsPerRevolution);
	}

	/**
	 * Rotates the motor for the given number of revolutions. You can use the value 2 to rotate the motor twice, 0.5 to rotate only half way or
	 * negative numbers like -1 to rotate once in reverse.
	 *
	 * @param revolutions
	 *            the number of revolutions to rotate
	 */
	public void rotate(double revolutions) {
		internalMotor.rotate(revolutions);
	}

	/**
	 * Stops the motor at the current position.
	 */
	public void stop() {
		internalMotor.stop();
	}

}
