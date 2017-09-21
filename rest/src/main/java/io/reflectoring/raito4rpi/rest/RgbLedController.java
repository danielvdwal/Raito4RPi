package io.reflectoring.raito4rpi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.raito4rpi.service.RgbLedService;

/**
 * Controls RGB-LEDs connect to the pi
 */
@RestController
public class RgbLedController {

	@Autowired
	private RgbLedService rgbLedService;

	@RequestMapping("/rgb/on")
	public void turnOn() {
		rgbLedService.turnOn();
	}

	@RequestMapping("/rgb/off")
	public void turnOff() {
		rgbLedService.turnOff();
	}
}
