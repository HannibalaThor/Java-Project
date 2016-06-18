package javaproject.novaann.world.element.mobile;


import java.awt.Point;

import aedt.showboard.IPawn;
import javaproject.novaann.world.INovaAnnWorld;
import javaproject.novaann.world.element.Element;
import javaproject.novaann.world.element.ISprite;
import javaproject.novaann.world.element.Permeability;

public abstract class Mobile extends Element implements IPawn {
	private final Point position;
	private final Point lastPosition;

	public Mobile(final ISprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
		this.lastPosition = new Point();
		this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
	}

	@Override
	public int getX() {
		return this.position.x;
	}

	protected void setX(final int x) {
		if ((x >= 0) && (x < this.getNovaAnnWorld().getWidth())) {
			this.position.x = x;
			this.getNovaAnnWorld().setMobileHasChanged();
		}
	}

	@Override
	public int getY() {
		return this.position.y;
	}

	protected void setY(final int y) {
		if ((y >= 0) && (y < this.getNovaAnnWorld().getHeight())) {
			this.position.y = y;
			this.getNovaAnnWorld().setMobileHasChanged();
		}
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	public Point getLastPosition(){
		return this.lastPosition;
	}

	public void setNovaAnnWorld(final INovaAnnWorld novaAnnWorld, final int x, final int y) {
		super.setNovaAnnWorld(novaAnnWorld);
		this.setX(x);
		this.setY(y);
	}

	private boolean isMovePossible(final int x, final int y) {
		return (this.getNovaAnnWorld().getElements(x, y).getPermeability() != Permeability.BLOCKING);
	}

	public boolean isMovePossibleM( int x, int y) {
		char c = this.getNovaAnnWorld().getElements(x, y).getFileSymbol();
		if (c == 'L'){
			return (true);
		}
		else {
			return(false);
		}
	}

	public void moveUp() {
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.setX(this.getX() - 1);
		}
	}

	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
		}
	}

	public void moveUpRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY() - 1)) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveDownRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY() + 1)) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}

	public void moveUpLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveDownLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() + 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}

	public void moveUpM() {
		if (this.isMovePossibleM(this.getX(), this.getY() - 1)) {
			this.saveLastPosition();
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeftM() {
		if (this.isMovePossibleM(this.getX() - 1, this.getY())) {
			this.saveLastPosition();
			this.setX(this.getX() - 1);
		}
	}

	public void moveDownM() {
		if (this.isMovePossibleM(this.getX(), this.getY() + 1)) {
			this.saveLastPosition();
			this.setY(this.getY() + 1);
		}
	}

	public void moveRightM() {
		if (this.isMovePossibleM(this.getX() + 1, this.getY())) {
			this.saveLastPosition();
			this.setX(this.getX() + 1);
		}
	}

	public void moveUpRightM() {
		if (this.isMovePossibleM(this.getX() + 1, this.getY() - 1)) {
			this.saveLastPosition();
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveDownRightM() {
		if (this.isMovePossibleM(this.getX() + 1, this.getY() + 1)) {
			this.saveLastPosition();
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}

	public void moveUpLeftM() {
		if (this.isMovePossibleM(this.getX() - 1, this.getY() - 1)) {
			this.saveLastPosition();
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveDownLeftM() {
		if (this.isMovePossibleM(this.getX() - 1, this.getY() + 1)) {
			this.saveLastPosition();
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}

	private void saveLastPosition() {
		if ((this.lastPosition.getX() != this.getPosition().getX()) || (this.lastPosition.getY() != this.getPosition().getY())) {
			this.lastPosition.setLocation(this.getPosition().x, this.getPosition().y);
		}
	}
}
