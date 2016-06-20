package model.javaproject.novaann.world.element.motionless;
import contract.ActionOnHeroes;

import contract.Permeability;
import model.javaproject.novaann.world.element.Sprite;


class Floor extends MotionlessElement {

	public Floor() {
		super(new Sprite("l", "noimage.png"), Permeability.PENETRABLE, 'L', false);
	}

	public ActionOnHeroes getActionOnHeroes() {
		// TODO Auto-generated method stub
		return null;
	}

}
