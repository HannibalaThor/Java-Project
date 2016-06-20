package model.javaproject.novaann.world.element.motionless;
import contract.IMotionlessElement;
import contract.INovaAnnWorld;
import contract.ISprite;
import contract.Permeability;
import model.javaproject.novaann.world.element.Element;

public abstract class MotionlessElement extends Element implements IMotionlessElement {
	private final char fileSymbol;
	private boolean collected;
	protected ObservableGold observer;


	public MotionlessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol, final boolean collected) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
		this.collected = collected;
		this.observer = new ObservableGold();
		}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.motionless.IMotionlessElement#getFileSymbol()
	 */
	public char getFileSymbol() {
		return this.fileSymbol;
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.motionless.IMotionlessElement#isCollected()
	 */
	public boolean isCollected(){
		return this.collected;
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.element.motionless.IMotionlessElement#setCollected(boolean)
	 */
	public void setCollected(boolean collected){
		this.collected = collected;
		this.observer.notifyObserver(650);
	}
}