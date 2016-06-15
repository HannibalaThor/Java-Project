package NovaAnn.element;


import aedt.showboard.ISquare;
import java.awt.Image;

import NovaAnn.element.INovaAnnWorld;


public abstract class Element /*implements ISquare*/ {
	private ISprite				sprite;
	private Permeability	permeability;
	private INovaAnnWorld	novaAnnWorld;

	public Element(final ISprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public ISprite getSprite() {
		return this.sprite;
	}

	private void setSprite(final ISprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	protected INovaAnnWorld getNettleWorld() {
		return this.novaAnnWorld;
	}

	public void setNettleWorld(final INovaAnnWorld novaAnnWorld) {
		this.novaAnnWorld = novaAnnWorld;
	}

	//@Override
	public Image getImage() {
		return this.getSprite().getImage();
	}
}