package io.reflectoring.raito4rpi.testclient.component.rgbled.action;

import io.reflectoring.raito4rpi.component.RgbLed;

public class TurnLedMagentaAction extends RgbLedAction {

	public TurnLedMagentaAction(String actionId, RgbLed led) {
		super(actionId, "Turn LED magenta", led);
	}

	@Override
	public void executeAction() {
		led.turnOff();
		led.turnMagenta();
	}
}
