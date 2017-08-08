package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.RgbLed;

public class TurnLedOffAction extends RgbLedAction {

	public TurnLedOffAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED off", led);
	}

	@Override
	public void executeAction() {
		led.turnOff();
	}
}
