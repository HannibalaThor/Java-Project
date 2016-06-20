package motionless;
import javaproject.novaann.world.NovaAnnWorld;
import javaproject.novaann.world.element.Permeability;
import javaproject.novaann.world.element.Sprite;

class Gold extends MotionlessElement {

	public Gold() {
		super(new Sprite("G", "purse.png"), Permeability.PENETRABLE, 'G', false);
		this.observer.addObserver(NovaAnnWorld.getScoreScore());
	}
}