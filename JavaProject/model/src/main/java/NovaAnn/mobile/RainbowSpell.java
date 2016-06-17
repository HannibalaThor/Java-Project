package NovaAnn.mobile;


import java.util.ArrayList;

import NovaAnn.element.Sprite;
import NovaAnn.motionLessElement.MotionLessElement;

public class RainbowSpell extends Mobile {
	private static RainbowSpell INSTANCE = null;

	private RainbowSpell() {
		super(new Sprite("RainbowSpell.jpg"));
	}


	public static synchronized RainbowSpell getRainbowSpell() {
		if (INSTANCE == null) {
			INSTANCE = new RainbowSpell();
		}
		return INSTANCE;
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