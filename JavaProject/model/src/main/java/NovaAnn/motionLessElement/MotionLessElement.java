package NovaAnn.motionLessElement;

import NovaAnn.element.Element;
import NovaAnn.element.ISprite;
import NovaAnn.element.Permeability;

public class MotionLessElement  extends Element implements /*IDoActionOnHeroes,*/ IMotionLessElement{
	private final char fileSymbol;
	
	public MotionLessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
	}
	
	public char getFileSymbol() {
		return this.fileSymbol;
	}
	
	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP; 
	}

	public static MotionLessElement getfileSymbole(char c) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
