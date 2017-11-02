package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.led.RgbLed;

public class TurnLedWhiteAction extends RgbLedAction {

	public TurnLedWhiteAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED white", led);
	}

	@Override
	public void executeAction() {
		led.turnWhite();
	}
}
