package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.RgbLed;

public class TurnLedBlueAction extends RgbLedAction {

	public TurnLedBlueAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED blue", led);
	}

	@Override
	public void executeAction() {
		led.turnOff();
		led.turnBlue();
	}
}
