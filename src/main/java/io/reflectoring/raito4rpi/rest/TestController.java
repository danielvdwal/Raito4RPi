package io.reflectoring.raito4rpi.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Just a dummy controller for now
 */
@RestController
public class TestController {

	@RequestMapping("/helloworld")
	public String helloWorld() {
		return "Konnichiwa sekai (Hello World)!";
	}

}
