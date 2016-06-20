package model.javaproject.novaann.world.element.motionless;

import model.javaproject.novaann.world.element.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class EnergyBubble extends MotionlessElement {

	public EnergyBubble() {
		super(new Sprite("*", "crystal_ball.png"), Permeability.PENETRABLE, '*', false);
	}
}