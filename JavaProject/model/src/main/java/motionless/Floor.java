package motionless;
import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class Floor extends MotionlessElement {

	public Floor() {
		super(new Sprite("l", "noimage.jpg"), Permeability.PENETRABLE, 'L', false);
	}

}
