package javaproject.novaann.world.element.motionless;

import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class BoneHorizontal extends MotionlessElement {

	public BoneHorizontal() {
		super(new Sprite("O", "horizontal_bone.png"), Permeability.BLOCKING, 'O');
	}

}
