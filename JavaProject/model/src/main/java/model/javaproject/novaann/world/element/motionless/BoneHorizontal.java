package model.javaproject.novaann.world.element.motionless;

import model.javaproject.novaann.world.element.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class BoneHorizontal extends MotionlessElement {

	public BoneHorizontal() {
		super(new Sprite("o", "horizontal_bone.png"), Permeability.BLOCKING, 'O', false);
	}

}
