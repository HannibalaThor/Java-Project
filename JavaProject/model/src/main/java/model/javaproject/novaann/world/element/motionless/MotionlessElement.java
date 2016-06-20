package model.javaproject.novaann.world.element.motionless;
import contract.ISprite;
import model.javaproject.novaann.world.element.Element;
import model.javaproject.novaann.world.element.Permeability;

public abstract class MotionlessElement extends Element implements IDoActionOnHeroes {
	private final char fileSymbol;
	private boolean collected;
	protected ObservableGold observer;


	public MotionlessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol, final boolean collected) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
		this.collected = collected;
		this.observer = new ObservableGold();
	}

	public char getFileSymbol() {
		return this.fileSymbol;
	}

	public boolean isCollected(){
		return this.collected;
	}

	public void setCollected(boolean collected){
		this.collected = collected;
		this.observer.notifyObserver(650);
	}

	//@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	}
}