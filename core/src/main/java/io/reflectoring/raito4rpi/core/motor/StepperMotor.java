package io.reflectoring.raito4rpi.core.motor;

/**
 * Represents an actual Stepper Motor.
 */
public class StepperMotor {

	// anything lower than 3 ms seems not to work when using a over step sequence
	private static final int DEFAULT_STEP_INTERVAL = 3;

	// Using a 28BYJ-48 there are 32*64 (64 because of the different gears rotating) steps per revolution
	private static final int DEFAULT_STEPS_PER_REVOLUTION = 2048;

	private int stepInterval;

	private int stepsPerRevolution;
	private int pinAddress1;
	private int pinAddress2;
	private int pinAddress3;
	private int pinAddress4;

	private StepSequenceStrategy stepSequenceStrategy;

	/**
	 * Contructs an instance using a default step interval as well as a default steps per revolution configuration.
	 *
	 * @param pinAddress1
	 *            the first pin the motor is connected to
	 * @param pinAddress2
	 *            the second pin the motor is connected to
	 * @param pinAddress3
	 *            the third pin the motor is connected to
	 * @param pinAddress4
	 *            the forth pin the motor is connected to
	 */
	public StepperMotor(int pinAddress1, int pinAddress2, int pinAddress3, int pinAddress4) {
		this(pinAddress1, pinAddress2, pinAddress3, pinAddress4, DEFAULT_STEP_INTERVAL, DEFAULT_STEPS_PER_REVOLUTION);
	}

	/**
	 * Contructs an instance using the given step interval as well as the given steps per revolution configuration.
	 *
	 * @param pinAddress1
	 *            the first pin the motor is connected to
	 * @param pinAddress2
	 *            the second pin the motor is connected to
	 * @param pinAddress3
	 *            the third pin the motor is connected to
	 * @param pinAddress4
	 *            the forth pin the motor is connected to
	 * @param stepInterval
	 *            time in ms to wait before next step should be executed in milliseconds
	 * @param stepsPerRevolution
	 *            number of steps it takes the motor to perform a whole revolution (360 degrees)
	 */
	public StepperMotor(int pinAddress1, int pinAddress2, int pinAddress3, int pinAddress4, int stepInterval, int stepsPerRevolution) {
		this.pinAddress1 = pinAddress1;
		this.pinAddress2 = pinAddress2;
		this.pinAddress3 = pinAddress3;
		this.pinAddress4 = pinAddress4;
		this.stepInterval = stepInterval;
		this.stepsPerRevolution = stepsPerRevolution;
		this.stepSequenceStrategy = StepSequenceStrategy.SINGLE_STEP_SEQUENCE;
	}

	public int getStepInterval() {
		return stepInterval;
	}

	public void setStepInterval(int stepInterval) {
		this.stepInterval = stepInterval;
	}

	public int getStepsPerRevolution() {
		return stepsPerRevolution;
	}

	public void setStepsPerRevolution(int stepsPerRevolution) {
		this.stepsPerRevolution = stepsPerRevolution;
	}

	public int getPinAddress1() {
		return pinAddress1;
	}

	public void setPinAddress1(int pinAddress1) {
		this.pinAddress1 = pinAddress1;
	}

	public int getPinAddress2() {
		return pinAddress2;
	}

	public void setPinAddress2(int pinAddress2) {
		this.pinAddress2 = pinAddress2;
	}

	public int getPinAddress3() {
		return pinAddress3;
	}

	public void setPinAddress3(int pinAddress3) {
		this.pinAddress3 = pinAddress3;
	}

	public int getPinAddress4() {
		return pinAddress4;
	}

	public void setPinAddress4(int pinAddress4) {
		this.pinAddress4 = pinAddress4;
	}

	public StepSequenceStrategy getStepSequenceStrategy() {
		return stepSequenceStrategy;
	}

	public void setStepSequenceStrategy(StepSequenceStrategy stepSequenceStrategy) {
		this.stepSequenceStrategy = stepSequenceStrategy;
	}
}
