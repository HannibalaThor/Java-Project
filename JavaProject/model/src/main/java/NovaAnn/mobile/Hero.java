package NovaAnn.mobile;

import java.awt.Point;
import java.util.ArrayList;

import NovaAnn.element.Sprite;
import NovaAnn.motionLessElement.MotionLessElement;


public class Hero extends Mobile{
	private final Point lastPosition;
	

	public Hero() {
		super(new Sprite("☺!", "Hero.png"));
		this.lastPosition = new Point();
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}

	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX())
				|| (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}

	public void moveUp() {
		this.saveLastPosition();
		super.moveUp();
	}

	public void moveLeft() {
		this.saveLastPosition();
		super.moveLeft();
	}

	public void moveDown() {
		this.saveLastPosition();
		super.moveDown();
	}

	public void moveRight() {
		this.saveLastPosition();
		super.moveRight();
	}

	public void moveBack() {
		this.setX(this.lastPosition.x);
		this.setY(this.lastPosition.y);
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