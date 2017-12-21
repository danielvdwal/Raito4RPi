package io.reflectoring.raito4rpi.core;

import com.pi4j.io.gpio.*;
import io.reflectoring.raito4rpi.core.exception.GpioPinDigitalOutputNotInitializedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Convenience class to provide additional methods for a {@link GpioController}.
 */
public class GpioDriver {

	private final GpioController gpioController;
	private final List<GpioPinDigitalOutput> digitalOutputPins = Collections.synchronizedList(new ArrayList<GpioPinDigitalOutput>());

	/**
	 * Creates an instance of {@link GpioDriver} to drive GPIO Pins.
	 *
	 * @param gpioController
	 *            to set the states for the different pins
	 */
	public GpioDriver(GpioController gpioController) {
		this.gpioController = gpioController;
	}

	public GpioPinDigitalOutput initializeDigitalOutputPin(int address, PinState pinState) {
		Pin pin = PinProvider.getPinByAddress(address);
		GpioPinDigitalOutput digitalOutputPin = gpioController.provisionDigitalOutputPin(pin, pinState);
		digitalOutputPins.add(digitalOutputPin);
		return digitalOutputPin;
	}

	public GpioPinDigitalOutput getDigitalOutputPinByAddress(int address) {
		Pin pin = PinProvider.getPinByAddress(address);
		for (GpioPinDigitalOutput digitalOutputPin : digitalOutputPins) {
			if (digitalOutputPin.getPin().equals(pin)) {
				return digitalOutputPin;
			}
		}
		throw new GpioPinDigitalOutputNotInitializedException();
	}

}
