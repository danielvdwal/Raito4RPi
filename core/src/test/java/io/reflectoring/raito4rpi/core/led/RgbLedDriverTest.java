package io.reflectoring.raito4rpi.core.led;

import static com.pi4j.io.gpio.PinState.HIGH;
import static com.pi4j.io.gpio.PinState.LOW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

import io.reflectoring.raito4rpi.core.GpioDriver;

public class RgbLedDriverTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

	private GpioPinDigitalOutput redPinMock;
	private GpioPinDigitalOutput greenPinMock;
	private GpioPinDigitalOutput bluePinMock;

	private RgbLedDriver sut;

	@Before
	public void setUp() {
		RgbLed rgbLed = new RgbLed(1, 2, 3);

		// initiate mocks
		redPinMock = mock(GpioPinDigitalOutput.class);
		greenPinMock = mock(GpioPinDigitalOutput.class);
		bluePinMock = mock(GpioPinDigitalOutput.class);

		GpioDriver gpioDriverMock = mock(GpioDriver.class);
		doReturn(redPinMock).when(gpioDriverMock).getDigitalOutputPinByAddress(1);
		doReturn(greenPinMock).when(gpioDriverMock).getDigitalOutputPinByAddress(2);
		doReturn(bluePinMock).when(gpioDriverMock).getDigitalOutputPinByAddress(3);

		// initiate system under test
		sut = new RgbLedDriver(rgbLed, gpioDriverMock);
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
		// when
		sut.turnOff();

		// then
		verify(redPinMock).setState(LOW);
		verify(greenPinMock).setState(LOW);
		verify(bluePinMock).setState(LOW);
		verifyNoMoreInteractions(redPinMock, greenPinMock, bluePinMock);
	}
}
