package io.reflectoring.raito4rpi.component.motor;

import static com.pi4j.io.gpio.PinState.LOW;
import static com.pi4j.io.gpio.RaspiPin.*;
import static io.reflectoring.raito4rpi.component.motor.StepSequenceStrategy.SINGLE_STEP_SEQUENCE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class StepperMotorTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

	private StepperMotor sut;

	@Before
	public void setUp() {
		// initiate mocks
		GpioController gpioControllerMock = mock(GpioController.class);
		doReturn(mock(GpioPinDigitalOutput.class)).when(gpioControllerMock).provisionDigitalOutputPin(GPIO_00, LOW);
		doReturn(mock(GpioPinDigitalOutput.class)).when(gpioControllerMock).provisionDigitalOutputPin(GPIO_01, LOW);
		doReturn(mock(GpioPinDigitalOutput.class)).when(gpioControllerMock).provisionDigitalOutputPin(GPIO_02, LOW);
		doReturn(mock(GpioPinDigitalOutput.class)).when(gpioControllerMock).provisionDigitalOutputPin(GPIO_03, LOW);

		// initiate testSubject
		sut = new StepperMotor(GPIO_00, GPIO_01, GPIO_02, GPIO_03, gpioControllerMock);
	}

	@Test
	public void getStepSequenceStrategyIsNullWhenNotSet() {
		// when
		StepSequenceStrategy stepSequenceStrategy = sut.getStepSequenceStrategy();

		// then
		assertThat(stepSequenceStrategy).isNull();
	}

	@Test
	public void getStepSequenceReturnsSameSequenceAsSet() {
		// given
		sut.setStepSequenceStrategy(SINGLE_STEP_SEQUENCE);

		// when
		StepSequenceStrategy stepSequenceStrategy = sut.getStepSequenceStrategy();

		// then
		assertThat(stepSequenceStrategy).isEqualTo(SINGLE_STEP_SEQUENCE);
	}
}
