package io.reflectoring.raito4rpi.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioFactory;

import io.reflectoring.raito4rpi.core.GpioDriver;
import io.reflectoring.raito4rpi.core.led.RgbLed;
import io.reflectoring.raito4rpi.core.led.RgbLedDriver;
import io.reflectoring.raito4rpi.core.motor.StepperMotor;
import io.reflectoring.raito4rpi.core.motor.StepperMotorDriver;

/**
 * Specific REST API for JiraAlerts
 */
@RestController
@RequestMapping(value = "/jiraAlerts")
public class JiraAlertsController {

	private static final long MOTOR_REPEAT_VALUE = 3;
	private static final long RGB_LED_BLINK_REPEAT_VALUE = 32;
	private static final long RGB_LED_ON_OFF_DURATION = 300;

	private static final GpioDriver GPIO_DRIVER = new GpioDriver(GpioFactory.getInstance());
	private static final RgbLedDriver RGB_LED_DRIVER = new RgbLedDriver(new RgbLed(0, 1, 2), GPIO_DRIVER);
	private static final StepperMotorDriver STEPPER_MOTOR_DRIVER = new StepperMotorDriver(new StepperMotor(3, 4, 5, 6), GPIO_DRIVER);

	@RequestMapping(method = RequestMethod.GET, value = "/alarm")
	public ResponseEntity alarm() {
		Runnable ledRunnable = () -> {
			try {
				for (int i = 0; i < RGB_LED_BLINK_REPEAT_VALUE; i++) {
					RGB_LED_DRIVER.turnRed();
					Thread.sleep(RGB_LED_ON_OFF_DURATION);
					RGB_LED_DRIVER.turnOff();
					Thread.sleep(RGB_LED_ON_OFF_DURATION);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new IllegalStateException("RGB-LEDs were interrupted", e);
			}
		};

		Runnable motorRunnable = () -> {
			for (int i = 0; i < MOTOR_REPEAT_VALUE; i++) {
				STEPPER_MOTOR_DRIVER.rotate(0.5);
				STEPPER_MOTOR_DRIVER.rotate(-0.5);
			}
		};

		new Thread(ledRunnable).start();
		new Thread(motorRunnable).start();

		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/warning")
	public ResponseEntity warning() {
		Runnable ledRunnable = () -> {
			try {
				for (int i = 0; i < RGB_LED_BLINK_REPEAT_VALUE; i++) {
					RGB_LED_DRIVER.turnBlue();
					Thread.sleep(RGB_LED_ON_OFF_DURATION);
					RGB_LED_DRIVER.turnOff();
					Thread.sleep(RGB_LED_ON_OFF_DURATION);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new IllegalStateException("RGB-LEDs were interrupted", e);
			}
		};

		Runnable motorRunnable = () -> {
			for (int i = 0; i < MOTOR_REPEAT_VALUE; i++) {
				STEPPER_MOTOR_DRIVER.rotate(0.5);
				STEPPER_MOTOR_DRIVER.rotate(-0.5);
			}
		};

		new Thread(ledRunnable).start();
		new Thread(motorRunnable).start();

		return ResponseEntity.ok().build();
	}

}
