package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.RgbLed;

public class TurnLedYellowAction extends RgbLedAction {

	public TurnLedYellowAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED yellow", led);
	}

	@Override
	public void executeAction() {
		led.turnOff();
		led.turnYellow();
	}
}
