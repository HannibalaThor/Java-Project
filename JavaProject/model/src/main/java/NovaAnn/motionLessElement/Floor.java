package NovaAnn.motionLessElement;

import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;

public class Floor extends MotionLessElement implements IFloor {
	public Floor() {
		super(new Sprite("F", "noimage.jpg"), Permeability.PENETRABLE, 'f');
	}
}
