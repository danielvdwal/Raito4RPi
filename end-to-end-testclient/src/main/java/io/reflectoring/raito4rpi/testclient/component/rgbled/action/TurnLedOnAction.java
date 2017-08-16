package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.led.RgbLed;

public class TurnLedOnAction extends RgbLedAction {

	public TurnLedOnAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED on", led);
	}

	@Override
	public void executeAction() {
		led.setAllPinsHigh();
	}
}
