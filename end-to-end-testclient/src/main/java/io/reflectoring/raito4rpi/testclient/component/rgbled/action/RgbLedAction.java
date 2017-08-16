package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.led.RgbLed;
import io.reflectoring.raito4rpi.testclient.component.Action;

abstract class RgbLedAction extends Action {

	final RgbLed led;

	RgbLedAction(String actionId, String actionName, RgbLed led) {
		super(actionId, actionName);
		this.led = led;
	}
}
