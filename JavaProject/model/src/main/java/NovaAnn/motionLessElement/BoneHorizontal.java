package NovaAnn.motionLessElement;

import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;

public class BoneHorizontal extends MotionLessElement implements IWall {
	public BoneHorizontal() {
		super(new Sprite("O", "horizontal_bone.png"), Permeability.PENETRABLE, 'O');
	}
	
}