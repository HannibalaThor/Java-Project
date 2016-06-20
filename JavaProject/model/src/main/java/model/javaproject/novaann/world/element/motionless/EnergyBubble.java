package model.javaproject.novaann.world.element.motionless;

import contract.ActionOnHeroes;
import contract.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class EnergyBubble extends MotionlessElement {

	public EnergyBubble() {
		super(new Sprite("*", "crystal_ball.png"), Permeability.PENETRABLE, '*', false);
	}

	public ActionOnHeroes getActionOnHeroes() {
		// TODO Auto-generated method stub
		return null;
	}
}