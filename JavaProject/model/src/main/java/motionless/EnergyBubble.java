package motionless;
import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class EnergyBubble extends MotionlessElement {

	public EnergyBubble() {
		super(new Sprite("*", "crystal_ball.png"), Permeability.PENETRABLE, '*', false);
	}
}