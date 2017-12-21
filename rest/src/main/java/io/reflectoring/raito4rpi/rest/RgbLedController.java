package io.reflectoring.raito4rpi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.raito4rpi.service.RgbLedService;

/**
 * Controls RGB-LEDs connect to the pi
 */
@RestController
@RequestMapping(value = "/rgb")
public class RgbLedController {

	private final RgbLedService rgbLedService;

	@Autowired
	public RgbLedController(RgbLedService rgbLedService) {
		this.rgbLedService = rgbLedService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/on")
	public ResponseEntity turnOn() {
		rgbLedService.turnOn();
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/off")
	public ResponseEntity turnOff() {
		rgbLedService.turnOff();
		return ResponseEntity.ok().build();
	}
}
