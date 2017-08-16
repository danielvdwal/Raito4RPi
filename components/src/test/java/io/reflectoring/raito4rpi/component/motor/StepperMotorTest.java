package io.reflectoring.raito4rpi.component.motor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import org.junit.Before;
import org.junit.Test;

import static com.pi4j.io.gpio.PinState.LOW;
import static com.pi4j.io.gpio.RaspiPin.*;
import static io.reflectoring.raito4rpi.component.motor.StepSequenceStrategy.SINGLE_STEP_SEQUENCE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StepperMotorTest {

	private StepperMotor sut;

	@Before
	public void setUp() {
		// initiate mocks
		GpioController gpioControllerMock = mock(GpioController.class);
		when(gpioControllerMock.provisionDigitalOutputPin(GPIO_00, LOW)).thenReturn(mock(GpioPinDigitalOutput.class));
		when(gpioControllerMock.provisionDigitalOutputPin(GPIO_01, LOW)).thenReturn(mock(GpioPinDigitalOutput.class));
		when(gpioControllerMock.provisionDigitalOutputPin(GPIO_02, LOW)).thenReturn(mock(GpioPinDigitalOutput.class));
		when(gpioControllerMock.provisionDigitalOutputPin(GPIO_03, LOW)).thenReturn(mock(GpioPinDigitalOutput.class));

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