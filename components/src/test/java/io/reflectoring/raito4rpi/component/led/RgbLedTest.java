package io.reflectoring.raito4rpi.component.led;

import static com.pi4j.io.gpio.PinState.HIGH;
import static com.pi4j.io.gpio.PinState.LOW;
import static com.pi4j.io.gpio.RaspiPin.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class RgbLedTest {

	private GpioPinDigitalOutput redPinMock;
	private GpioPinDigitalOutput greenPinMock;
	private GpioPinDigitalOutput bluePinMock;

	private RgbLed sut;

	@Before
	public void setUp() {
		// initiate mocks
		redPinMock = mock(GpioPinDigitalOutput.class);
		greenPinMock = mock(GpioPinDigitalOutput.class);
		bluePinMock = mock(GpioPinDigitalOutput.class);

		GpioController gpioControllerMock = mock(GpioController.class);
		when(gpioControllerMock.provisionDigitalOutputPin(GPIO_00, "red", LOW)).thenReturn(redPinMock);
		when(gpioControllerMock.provisionDigitalOutputPin(GPIO_01, "green", LOW)).thenReturn(greenPinMock);
		when(gpioControllerMock.provisionDigitalOutputPin(GPIO_02, "blue", LOW)).thenReturn(bluePinMock);

		// initiate system under test
		sut = new RgbLed(GPIO_00, GPIO_01, GPIO_02, gpioControllerMock);
	}

	@Test
	public void isOnIsTrueWhenAnyPinIsHigh() {
		// given
		when(redPinMock.isHigh()).thenReturn(false);
		when(greenPinMock.isHigh()).thenReturn(false);
		when(bluePinMock.isHigh()).thenReturn(true);

		// when
		boolean on = sut.isOn();

		// then
		assertThat(on).isTrue();
	}

	@Test
	public void isOnIsTrueWhenAllPinsAreHigh() {
		// given
		when(redPinMock.isHigh()).thenReturn(true);
		when(greenPinMock.isHigh()).thenReturn(true);
		when(bluePinMock.isHigh()).thenReturn(true);

		// when
		boolean on = sut.isOn();

		// then
		assertThat(on).isTrue();
	}

	@Test
	public void isOnIsFalseWhenAllPinsAreLow() {
		// given
		when(redPinMock.isHigh()).thenReturn(false);
		when(greenPinMock.isHigh()).thenReturn(false);
		when(bluePinMock.isHigh()).thenReturn(false);

		// when
		boolean on = sut.isOn();

		// then
		assertThat(on).isFalse();
	}

	@Test
	public void setAllPinsHigh() {
		// given

		// when
		sut.setAllPinsHigh();

		// then
		verify(redPinMock).setState(HIGH);
		verify(greenPinMock).setState(HIGH);
		verify(bluePinMock).setState(HIGH);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}

	@Test
	public void turnRed() {
		// given

		// when
		sut.turnRed();

		// then
		verify(redPinMock).setState(HIGH);
		verify(greenPinMock).setState(LOW);
		verify(bluePinMock).setState(LOW);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}

	@Test
	public void turnGreen() {
		// given

		// when
		sut.turnGreen();

		// then
		verify(redPinMock).setState(LOW);
		verify(greenPinMock).setState(HIGH);
		verify(bluePinMock).setState(LOW);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}

	@Test
	public void turnBlue() {
		// given

		// when
		sut.turnBlue();

		// then
		verify(redPinMock).setState(LOW);
		verify(greenPinMock).setState(LOW);
		verify(bluePinMock).setState(HIGH);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}

	@Test
	public void turnYellow() {
		// given

		// when
		sut.turnYellow();

		// then
		verify(redPinMock).setState(HIGH);
		verify(greenPinMock).setState(HIGH);
		verify(bluePinMock).setState(LOW);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}

	@Test
	public void turnCyan() {
		// given

		// when
		sut.turnCyan();

		// then
		verify(redPinMock).setState(LOW);
		verify(greenPinMock).setState(HIGH);
		verify(bluePinMock).setState(HIGH);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}

	@Test
	public void turnMagenta() {
		// given

		// when
		sut.turnMagenta();

		// then
		verify(redPinMock).setState(HIGH);
		verify(greenPinMock).setState(LOW);
		verify(bluePinMock).setState(HIGH);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}

	@Test
	public void turnWhite() {
		// given

		// when
		sut.turnWhite();

		// then
		verify(redPinMock).setState(HIGH);
		verify(greenPinMock).setState(HIGH);
		verify(bluePinMock).setState(HIGH);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}

	@Test
	public void turnOff() {
		// given

		// when
		sut.turnOff();

		// then
		verify(redPinMock).setState(LOW);
		verify(greenPinMock).setState(LOW);
		verify(bluePinMock).setState(LOW);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}
}
