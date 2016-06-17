package NovaAnn.mobile;

import java.util.ArrayList;

import NovaAnn.element.ISprite;
import NovaAnn.motionLessElement.MotionLessElement;

public class MonsterMobile extends Mobile {
	private final char fileSymbol;

	public MonsterMobile(final ISprite sprite, final char fileSymbol) {
		super(sprite);
		this.fileSymbol = fileSymbol;
	}

	public char getFileSymbol() {
		return this.fileSymbol;
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
