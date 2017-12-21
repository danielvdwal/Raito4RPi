package io.reflectoring.raito4rpi.rest;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockitoUnitTestConfiguration.class)
@WebAppConfiguration
public abstract class AbstractRestControllerTest {

	@Rule
	public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

	@Autowired
	private WebApplicationContext context;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(documentationConfiguration(this.restDocumentation))
		        .alwaysDo(document("{ClassName}/{methodName}")).build();
	}
}
