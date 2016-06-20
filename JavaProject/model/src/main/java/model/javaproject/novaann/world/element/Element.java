package model.javaproject.novaann.world.element;

import java.awt.Image;

import aedt.showboard.ISquare;
import javaproject.novaann.world.INovaAnnWorld;

public abstract class Element implements ISquare, IElement {
	private ISprite				sprite;
	private Permeability	permeability;
	private INovaAnnWorld	novaAnnWorld;

	public Element(final ISprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/* (non-Javadoc)
	 * @see javaproject.novaann.world.element.IElement#getSprite()
	 */
	@Override
	public ISprite getSprite() {
		return this.sprite;
	}

	private void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}

	/* (non-Javadoc)
	 * @see javaproject.novaann.world.element.IElement#getPermeability()
	 */
	@Override
	public Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	protected INovaAnnWorld getNovaAnnWorld() {
		return this.novaAnnWorld;
	}

	/* (non-Javadoc)
	 * @see javaproject.novaann.world.element.IElement#setNovaAnnWorld(javaproject.novaann.world.INovaAnnWorld)
	 */
	@Override
	public void setNovaAnnWorld(final INovaAnnWorld novaAnnWorld) {
		this.novaAnnWorld = novaAnnWorld;
	}

	//@Override
	/* (non-Javadoc)
	 * @see javaproject.novaann.world.element.IElement#getImage()
	 */
	@Override
	public Image getImage() {
		return this.getSprite().getImage();
	}
}
