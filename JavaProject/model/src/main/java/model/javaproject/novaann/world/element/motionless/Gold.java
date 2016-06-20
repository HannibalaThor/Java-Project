package model.javaproject.novaann.world.element.motionless;

import contract.ActionOnHeroes;
import contract.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class Gold extends MotionlessElement {

	public Gold() {
		super(new Sprite("G", "purse.png"), Permeability.PENETRABLE, 'G', false);
	}

	public ActionOnHeroes getActionOnHeroes() {
		// TODO Auto-generated method stub
		return null;
	}
}