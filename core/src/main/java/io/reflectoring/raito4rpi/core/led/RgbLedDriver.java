package io.reflectoring.raito4rpi.core.led;

import static com.pi4j.io.gpio.PinState.HIGH;
import static com.pi4j.io.gpio.PinState.LOW;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

import io.reflectoring.raito4rpi.core.GpioDriver;

/**
 * Provides all methods to drive a {@link RgbLed}.
 */
public class RgbLedDriver {

	private final RgbLed rgbLed;
	private final GpioDriver gpioDriver;

	/**
	 * Creates an instance of {@link RgbLedDriver} to drive RGB-LEDs.
	 *
	 * @param rgbLed
	 *            the RGB-LED to drive
	 * @param gpioDriver
	 *            to set the states for the different pins
	 */
	public RgbLedDriver(RgbLed rgbLed, GpioDriver gpioDriver) {
		this.rgbLed = rgbLed;
		this.gpioDriver = gpioDriver;
	}

	/**
	 * Checks if any of the three pins is set to high.
	 *
	 * @return true if at least one of the three pins is set to high, else false
	 */
	boolean isOn() {
		GpioPinDigitalOutput redPin = gpioDriver.getDigitalOutputPinByAddress(rgbLed.getRedPinAddress());
		GpioPinDigitalOutput greenPin = gpioDriver.getDigitalOutputPinByAddress(rgbLed.getGreenPinAddress());
		GpioPinDigitalOutput bluePin = gpioDriver.getDigitalOutputPinByAddress(rgbLed.getBluePinAddress());
		return redPin.isHigh() || greenPin.isHigh() || bluePin.isHigh();
	}

	/**
	 * Sets all pins to high.
	 */
	public void setAllPinsHigh() {
		setPinsTo(HIGH, HIGH, HIGH);
	}

	/**
	 * Turns the RGB-LED red.
	 */
	public void turnRed() {
		setPinsTo(HIGH, LOW, LOW);
	}

	/**
	 * Turns the RGB-LED green.
	 */
	public void turnGreen() {
		setPinsTo(LOW, HIGH, LOW);
	}

	/**
	 * Turns the RGB-LED blue.
	 */
	public void turnBlue() {
		setPinsTo(LOW, LOW, HIGH);
	}

	/**
	 * Turns the RGB-LED yellow.
	 */
	public void turnYellow() {
		setPinsTo(HIGH, HIGH, LOW);
	}

	/**
	 * Turns the RGB-LED cyan.
	 */
	public void turnCyan() {
		setPinsTo(LOW, HIGH, HIGH);
	}

	/**
	 * Turns the RGB-LED magenta.
	 */
	public void turnMagenta() {
		setPinsTo(HIGH, LOW, HIGH);
	}

	/**
	 * Turns the RGB-LED white. Same as {@link #setAllPinsHigh()}
	 */
	public void turnWhite() {
		setAllPinsHigh();
	}

	/**
	 * Turns the RGB-LED off.
	 */
	public void turnOff() {
		setPinsTo(LOW, LOW, LOW);
	}

	/**
	 * Sets the RGB-LED to the given states.
	 */
	private void setPinsTo(PinState redPinState, PinState greenPinState, PinState bluePinState) {
		GpioPinDigitalOutput redPin = gpioDriver.getDigitalOutputPinByAddress(rgbLed.getRedPinAddress());
		GpioPinDigitalOutput greenPin = gpioDriver.getDigitalOutputPinByAddress(rgbLed.getGreenPinAddress());
		GpioPinDigitalOutput bluePin = gpioDriver.getDigitalOutputPinByAddress(rgbLed.getBluePinAddress());

		redPin.setState(redPinState);
		greenPin.setState(greenPinState);
		bluePin.setState(bluePinState);
	}
}
