package model.javaproject.novaann.world.element.motionless;

import contract.ActionOnHeroes;
import contract.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class BoneVertical extends MotionlessElement {

	public BoneVertical() {
		super(new Sprite("o", "vertical_bone.png"), Permeability.BLOCKING, 'o', false);
	}

	public ActionOnHeroes getActionOnHeroes() {
		// TODO Auto-generated method stub
		return null;
	}

}
