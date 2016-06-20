package model.javaproject.novaann.world.element.motionless;

import contract.ISprite;
import model.javaproject.novaann.world.element.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class BallWall extends MotionlessElement {

	public BallWall() {
		super(new Sprite("B", "bone.png"), Permeability.BLOCKING, 'B', false);
	}

}
