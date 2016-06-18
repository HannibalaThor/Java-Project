package NovaAnn.motionLessElement;

import java.util.ArrayList;

import NovaAnn.element.Element;
import NovaAnn.element.ISprite;
import NovaAnn.element.Permeability;
import NovaAnn.element.Sprite;
import NovaAnn.mobile.Hero;
import NovaAnn.mobile.Mobile;
import NovaAnn.mobile.MonsterMobile;


public class MotionLessElement  extends Element implements /*IDoActionOnHeroes,*/ IMotionLessElement{
	private final char fileSymbol;
	
	public MotionLessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
		super(sprite, permeability);
		this.fileSymbol = fileSymbol;
	}
	
	public char getFileSymbol() {
		return this.fileSymbol;
	}
	
/*@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP; 
	}*/

	public static MotionLessElement getfileSymbole(char c) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public MotionLessElement getElements(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public Hero getHero() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addMonster(Mobile monster, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void addMobile(Hero hero, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void setMobileHasChanged() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Mobile> getMobiles() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addMobile(MonsterMobile monsterMobile, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}
