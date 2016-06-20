package model.javaproject.novaann.world.element.motionless;

import contract.ActionOnHeroes;
import contract.ISprite;
import contract.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class BallWall extends MotionlessElement {

	public BallWall() {
		super(new Sprite("B", "bone.png"), Permeability.BLOCKING, 'B', false);
	}

	public ActionOnHeroes getActionOnHeroes() {
		// TODO Auto-generated method stub
		return null;
	}

}
