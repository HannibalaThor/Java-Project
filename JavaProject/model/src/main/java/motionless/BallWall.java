package motionless;
import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class BallWall extends MotionlessElement {

	public BallWall() {
		super(new Sprite("B", "bone.png"), Permeability.BLOCKING, 'B', false);
	}

}
