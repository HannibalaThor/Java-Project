package model.javaproject.novaann.world.element.motionless;
import model.javaproject.novaann.world.element.Permeability;
import model.javaproject.novaann.world.element.Sprite;
class Floor extends MotionlessElement {

	public Floor() {
		super(new Sprite("l", "noimage.jpg"), Permeability.PENETRABLE, 'L', false);
	}

}
