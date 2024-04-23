package stepdef;

import java.io.IOException;

import io.cucumber.java.After;
import utils.Controller;

public class Hooks {
	
	Controller controller;
	
	public Hooks(Controller controller) {
		this.controller=controller;
	}
	
	@After
	public void AfterScenario() throws IOException {
		controller.basePage.WebDriverManager().quit();
	}

}
