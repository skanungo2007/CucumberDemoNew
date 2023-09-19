package hooks;

import base.BaseClass;
import io.cucumber.java.After;


public class Hooks extends BaseClass {
	
	@After
	public void tearDown() {
		
		closeBrowser();
		
	}

}
