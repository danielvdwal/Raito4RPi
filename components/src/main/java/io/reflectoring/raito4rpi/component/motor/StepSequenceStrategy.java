package io.reflectoring.raito4rpi.component.motor;

/**
 * Use this enum to define which step sequence strategy should be used in order to move a {@link StepperMotor}.
 */
public enum StepSequenceStrategy {

	HALF_STEP_SEQUENCE(new byte[] { 0b0001, 0b0011, 0b0010, 0b0110, 0b0100, 0b1100, 0b1000, 0b1001 }, 0.5), //
	SINGLE_STEP_SEQUENCE(new byte[] { 0b0001, 0b0010, 0b0100, 0b1000 }), //
	DOUBLE_STEP_SEQUENCE(new byte[] { 0b0011, 0b0110, 0b1100, 0b1001 }), //
	OVER_STEP_SEQUENCE(new byte[] { 0b0001, 0b0110, 0b1000, 0b0011, 0b0100, 0b1001, 0b0010, 0b1100 }, 1.5);

	private final byte[] stepSequence;
	private final double stepModifier;

	StepSequenceStrategy(byte[] stepSequence) {
		this(stepSequence, 1);
	}

	StepSequenceStrategy(byte[] stepSequence, double stepModifier) {
		this.stepSequence = stepSequence;
		this.stepModifier = stepModifier;
	}

	byte[] getStepSequence() {
		return stepSequence;
	}

	public double getStepModifier() {
		return stepModifier;
	}
}
