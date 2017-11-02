package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.led.RgbLed;

public class TurnLedGreenAction extends RgbLedAction {

	public TurnLedGreenAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED green", led);
	}

	@Override
	public void executeAction() {
		led.turnOff();
		led.turnGreen();
	}
}
