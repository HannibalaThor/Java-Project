package NovaAnn.motionLessElement;

import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;

public class Door extends MotionLessElement implements IDoor {	
	public Door() {
		super(new Sprite("D", "gate_closed.png"), Permeability.PENETRABLE, 'D');
	}
}