package io.reflectoring.raito4rpi.rest;

import static org.mockito.Mockito.verify;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import io.reflectoring.raito4rpi.service.RgbLedService;

public class RgbLedControllerTest extends AbstractRestControllerTest {

	@Autowired
	private RgbLedService rgbLedService;

	@Test
	public void turnOn() throws Exception {
		this.mockMvc.perform(post("/rgb/on").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(rgbLedService).turnOn();
	}

	@Test
	public void turnOff() throws Exception {
		this.mockMvc.perform(post("/rgb/off").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(rgbLedService).turnOff();
	}
}
