package io.reflectoring.raito4rpi.service;

import static com.pi4j.io.gpio.RaspiPin.*;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioFactory;

import io.reflectoring.raito4rpi.component.led.RgbLed;

/**
 * Service to control a RGB LED connected to the RaspberryPi
 */
@Service
public class RgbLedService {

	private RgbLed rgbLed = new RgbLed(GPIO_00, GPIO_01, GPIO_02, GpioFactory.getInstance());

	public void turnOn() {
		rgbLed.turnWhite();
	}

	public void turnOff() {
		rgbLed.turnOff();
	}

}
