package model.javaproject.novaann.world.element.motionless;

import model.javaproject.novaann.world.element.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class BoneVertical extends MotionlessElement {

	public BoneVertical() {
		super(new Sprite("o", "vertical_bone.png"), Permeability.BLOCKING, 'o', false);
	}

}
