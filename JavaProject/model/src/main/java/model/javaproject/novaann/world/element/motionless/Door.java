package model.javaproject.novaann.world.element.motionless;

import contract.ActionOnHeroes;
import contract.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class Door extends MotionlessElement {

	public Door() {
		super(new Sprite("d", "gate_open.png"), Permeability.PENETRABLE, 'D', false);
	}

	public ActionOnHeroes getActionOnHeroes() {
		// TODO Auto-generated method stub
		return null;
	}
}
