package NovaAnn.motionLessElement;

import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;

public class BoneVertical extends MotionLessElement implements IWall {
	public BoneVertical() {
		super(new Sprite("o", "vertical_bone.png"), Permeability.PENETRABLE, 'o');
	}
	
}