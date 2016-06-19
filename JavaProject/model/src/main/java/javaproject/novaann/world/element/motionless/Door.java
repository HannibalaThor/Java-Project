package javaproject.novaann.world.element.motionless;

import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class Door extends MotionlessElement {

	public Door() {
		super(new Sprite("d", "gate_open.png"), Permeability.PENETRABLE, 'D');
	}
}