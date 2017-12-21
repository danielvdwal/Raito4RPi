package io.reflectoring.raito4rpi.rest;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.reflectoring.raito4rpi.service.RgbLedService;

@Configuration
public class MockitoUnitTestConfiguration {

	@Bean
	public RgbLedController rgbLedController() {
		return new RgbLedController(rgbLedService());
	}

	@Bean
	public RgbLedService rgbLedService() {
		return Mockito.mock(RgbLedService.class);
	}
}
