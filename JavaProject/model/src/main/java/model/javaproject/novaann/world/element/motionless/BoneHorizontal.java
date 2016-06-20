package model.javaproject.novaann.world.element.motionless;

import contract.ActionOnHeroes;
import contract.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class BoneHorizontal extends MotionlessElement {

	public BoneHorizontal() {
		super(new Sprite("o", "horizontal_bone.png"), Permeability.BLOCKING, 'O', false);
	}

	public ActionOnHeroes getActionOnHeroes() {
		// TODO Auto-generated method stub
		return null;
	}

}
