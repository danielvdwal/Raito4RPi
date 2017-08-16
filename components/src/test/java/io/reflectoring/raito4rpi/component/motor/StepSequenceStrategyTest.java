package io.reflectoring.raito4rpi.component.motor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StepSequenceStrategyTest {

	private static final byte[] SINGLE_STEP_SEQUENCE_BYTES = { 0b0001, 0b0010, 0b0100, 0b1000 };
	private final static byte[] DOUBLE_STEP_SEQUNECE_BYTES = new byte[] { 0b0011, 0b0110, 0b1100, 0b1001 };
	private final static byte[] HALF_STEP_SEQUNECE_BYTES = new byte[] { 0b0001, 0b0011, 0b0010, 0b0110, 0b0100, 0b1100, 0b1000, 0b1001 };

	@Test
	public void singleStepSequenceIsASingleStepSequence() {
		byte[] result = StepSequenceStrategy.SINGLE_STEP_SEQUENCE.getStepSequence();
		assertThat(result).isEqualTo(SINGLE_STEP_SEQUENCE_BYTES);
	}

	@Test
	public void doubleStepSequenceIsADoubleStepSequence() {
		byte[] result = StepSequenceStrategy.DOUBLE_STEP_SEQUENCE.getStepSequence();
		assertThat(result).isEqualTo(DOUBLE_STEP_SEQUNECE_BYTES);
	}

	@Test
	public void halfStepSequenceIsAHalfStepSequence() {
		byte[] result = StepSequenceStrategy.HALF_STEP_SEQUENCE.getStepSequence();
		assertThat(result).isEqualTo(HALF_STEP_SEQUNECE_BYTES);
	}
}
