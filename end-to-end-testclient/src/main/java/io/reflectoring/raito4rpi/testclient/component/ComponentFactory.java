package io.reflectoring.raito4rpi.testclient.component;

import static com.pi4j.io.gpio.RaspiPin.*;

import com.pi4j.io.gpio.GpioController;

import io.reflectoring.raito4rpi.component.led.RgbLed;
import io.reflectoring.raito4rpi.component.motor.StepperMotor;

/**
 * Factory to provide components, since the GPIO-Pins can only be assigned once.
 */
public final class ComponentFactory {

	private static RgbLed rgbLed;
	private static StepperMotor stepperMotor;

	private ComponentFactory() {}

	public static void init(GpioController gpioController) {
		rgbLed = new RgbLed(GPIO_00, GPIO_01, GPIO_02, gpioController);
		stepperMotor = new StepperMotor(GPIO_03, GPIO_04, GPIO_05, GPIO_06, gpioController);
	}

	public static RgbLed getRgbLed() {
		return rgbLed;
	}

	public static StepperMotor getStepperMotor() {
		return stepperMotor;
	}

}
