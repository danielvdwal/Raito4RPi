package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.RgbLed;

public class TurnLedRedAction extends RgbLedAction {

	public TurnLedRedAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED red", led);
	}

	@Override
	public void executeAction() {
		led.turnOff();
		led.turnRed();
	}
}
