package io.reflectoring.raito4rpi.testclient.component.rgbled;

import static io.reflectoring.raito4rpi.testclient.Raito4RPiEndToEndTestClient.SEPARATOR_LINE;

import com.pi4j.util.Console;

import io.reflectoring.raito4rpi.component.led.RgbLed;
import io.reflectoring.raito4rpi.testclient.component.ComponentEndToEndTest;
import io.reflectoring.raito4rpi.testclient.component.ComponentFactory;
import io.reflectoring.raito4rpi.testclient.component.rgbled.action.*;

public final class RgbLedEndToEndTest extends ComponentEndToEndTest {

	private RgbLed sut;

	public RgbLedEndToEndTest(String componentId, String componentName, Console console) {
		super(componentId, componentName, console);
		sut = ComponentFactory.getRgbLed();
		fillActions();
	}

	@Override
	protected void fillActions() {
		actions.add(new TurnLedOffAction("0", sut));
		actions.add(new TurnLedOnAction("1", sut));
		actions.add(new TurnLedRedAction("2", sut));
		actions.add(new TurnLedGreenAction("3", sut));
		actions.add(new TurnLedBlueAction("4", sut));
		actions.add(new TurnLedYellowAction("5", sut));
		actions.add(new TurnLedMagentaAction("6", sut));
		actions.add(new TurnLedCyanAction("7", sut));
		actions.add(new TurnLedWhiteAction("8", sut));
	}

	protected void printConnectionInformation() {
		console.println();
		console.println("Please ensure that the RGB Led to test is connected as followed:");
		console.println(SEPARATOR_LINE);
		console.println(UPPER_PIN_LAYOUT);
		console.println("#  -   -  GND  -   -  Gre  -   -   -   -   -   -   -   -   -   -   -   -   -   -  #");
		console.println("#  -   -   -   -   -  Red Blu  -   -   -   -   -   -   -   -   -   -   -   -   -  #");
		console.println(LOWER_PIN_LAYOUT);
		console.println(SEPARATOR_LINE);
	}

	@Override
	protected void onExit() {
		sut.turnOff();
	}
}
