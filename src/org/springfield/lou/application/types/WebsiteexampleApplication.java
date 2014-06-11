package org.springfield.lou.application.types;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

import org.dom4j.*;
import org.springfield.lou.application.*;
import org.springfield.lou.application.components.ComponentInterface;
import org.springfield.lou.fs.*;
import org.springfield.lou.homer.*;
import org.springfield.lou.screen.Screen;

public class WebsiteexampleApplication extends Html5Application{
	
	
	
 	public WebsiteexampleApplication(String id) {
		super(id); 
		// map a component from a other app to a local name using a referid (import)
		//addReferid("elementone","/websiteserviceone/defaultoutput");
	}
	
    public void onNewScreen(Screen s) {
        super.onNewScreen(s); // needs to be called to make sure actionlist is called

        // since we are new lets tell all the others in the same scope we joined
        ComponentInterface notification = getComponentManager().getComponent("notification");
        notification.putOnScope(s,"euscreenxlpreview", "show(new viewer joined shared screen "+s.getShortId()+")");
        // now that the init is done we have a 'running' connection to screen and commands can be send both ways.
		log("Hello LogWorld ! "+s.getShortId());
		s.log("Screen test log "+s.getShortId());
		s.log("Screen test log "+s.getShortId(),LOG_WARNING);
		s.log("Screen test log "+s.getShortId(),LOG_ERROR);
    }

    public void seturl(Screen s,String content) {
    		System.out.println("WANT TO SET BROWSER URL TO = "+content);
        ComponentInterface notification = getComponentManager().getComponent("notification");
        notification.putOnScope(s,"euscreenxlpreview", "show("+content+")");
        notification.putOnScope(s,"euscreenxlpreview", "setbrowser("+content+")");
    }
	

}
