package NovaAnn.play;

import NovaAnn.mobile.Mobile;
import NovaAnn.mobile.*;

public class MotionElement {
	
	private static final Mobile Hero = new Hero();
	private static final Mobile Skeletor = new Skeletor();
	private static final Mobile Chainmail = new Chainmail();
	private static final Mobile Butterfly = new Butterfly();
	private static final Mobile Stormtrooper = new Stormtrooper();
	
	private static Mobile TableElement[] = {null , Hero , Skeletor, Butterfly, Chainmail, Stormtrooper};
	
	public static  Mobile getElement(int id){
		return TableElement[id];
		
	}
}
