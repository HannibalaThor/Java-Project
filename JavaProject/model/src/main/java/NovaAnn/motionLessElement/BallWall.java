package NovaAnn.motionLessElement;

import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;

public class BallWall extends MotionLessElement implements IWall {
	public BallWall() {
		super(new Sprite("B", "bone.png"), Permeability.PENETRABLE, 'B');
	}
	
}