package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.RgbLed;

public class TurnLedCyanAction extends RgbLedAction {

	public TurnLedCyanAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED cyan", led);
	}

	@Override
	public void executeAction() {
		led.turnOff();
		led.turnCyan();
	}
}
