package NovaAnn.mobile;

import java.awt.Point;

import NovaAnn.INovaAnnWorld;
import NovaAnn.element.Element;
import NovaAnn.element.ISprite;
import NovaAnn.element.Permeability;

public abstract class Mobile extends Element {
	private final Point position;
	
	public int getX() {
		return this.position.x;
	}

	protected void setX(int x) {
		if ((x >= 0) && (x < this.getNovaAnnWorld().getWidth())) {
			this.position.x = x;
			this.getNovaAnnWorld().setMobileHasChanged();
		}
	}

	public int getY() {
		return this.position.y;
	}

	protected void setY(int y) {
		if ((y >= 0) && (y < this.getNovaAnnWorld().getHeight())) {
			this.position.y = y;
			this.getNovaAnnWorld().setMobileHasChanged();
		}
	}

	public Point getPosition() {
		return this.position;
	}

	public Mobile(ISprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
	}
	
	public void setNovaAnnWorld(final INovaAnnWorld nettleWorld, final int x, final int y) {
		super.setNovaAnnWorld(nettleWorld);
		this.setX(x);
		this.setY(y);
	}

	private boolean isMovePossible(int x, int y) {
		return (this.getNovaAnnWorld().getElements(x, y).getPermeability() != Permeability.BLOCKING);
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

	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
		}
	}

	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
		}
	}

	public void moveUpLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
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

	public void moveDownLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() + 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}
	
	
}