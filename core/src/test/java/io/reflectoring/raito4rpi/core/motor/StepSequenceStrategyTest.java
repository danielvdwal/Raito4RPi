package io.reflectoring.raito4rpi.core.motor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StepSequenceStrategyTest {

	private static final byte[] OVER_STEP_SEQUENCE_BYTES = { 0b0001, 0b0110, 0b1000, 0b0011, 0b0100, 0b1001, 0b0010, 0b1100 };
	private static final byte[] SINGLE_STEP_SEQUENCE_BYTES = { 0b0001, 0b0010, 0b0100, 0b1000 };
	private final static byte[] DOUBLE_STEP_SEQUENCE_BYTES = { 0b0011, 0b0110, 0b1100, 0b1001 };
	private final static byte[] HALF_STEP_SEQUENCE_BYTES = { 0b0001, 0b0011, 0b0010, 0b0110, 0b0100, 0b1100, 0b1000, 0b1001 };

	@Test
	public void overStepSequenceIsAOverStepSequence() {
		byte[] result = StepSequenceStrategy.OVER_STEP_SEQUENCE.getStepSequence();
		assertThat(result).isEqualTo(OVER_STEP_SEQUENCE_BYTES);
	}

	@Test
	public void overStepSequenceHasAModifierOf15() {
		double result = StepSequenceStrategy.OVER_STEP_SEQUENCE.getStepModifier();
		assertThat(result).isEqualTo(1.5);
	}

	@Test
	public void singleStepSequenceIsASingleStepSequence() {
		byte[] result = StepSequenceStrategy.SINGLE_STEP_SEQUENCE.getStepSequence();
		assertThat(result).isEqualTo(SINGLE_STEP_SEQUENCE_BYTES);
	}

	@Test
	public void singleStepSequenceHasAModifierOf1() {
		double result = StepSequenceStrategy.SINGLE_STEP_SEQUENCE.getStepModifier();
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void doubleStepSequenceIsADoubleStepSequence() {
		byte[] result = StepSequenceStrategy.DOUBLE_STEP_SEQUENCE.getStepSequence();
		assertThat(result).isEqualTo(DOUBLE_STEP_SEQUENCE_BYTES);
	}

	@Test
	public void doubleStepSequenceHasAModifierOf1() {
		double result = StepSequenceStrategy.DOUBLE_STEP_SEQUENCE.getStepModifier();
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void halfStepSequenceIsAHalfStepSequence() {
		byte[] result = StepSequenceStrategy.HALF_STEP_SEQUENCE.getStepSequence();
		assertThat(result).isEqualTo(HALF_STEP_SEQUENCE_BYTES);
	}

	@Test
	public void halfStepSequenceHasAModifierOf05() {
		double result = StepSequenceStrategy.HALF_STEP_SEQUENCE.getStepModifier();
		assertThat(result).isEqualTo(0.5);
	}
}
