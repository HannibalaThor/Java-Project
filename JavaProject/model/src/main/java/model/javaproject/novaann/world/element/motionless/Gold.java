package model.javaproject.novaann.world.element.motionless;
import model.javaproject.novaann.world.NovaAnnWorld;
import model.javaproject.novaann.world.element.Permeability;
import model.javaproject.novaann.world.element.Sprite;

class Gold extends MotionlessElement {

	public Gold() {
		super(new Sprite("G", "purse.png"), Permeability.PENETRABLE, 'G', false);
		this.observer.addObserver(NovaAnnWorld.getScoreScore());
	}
}