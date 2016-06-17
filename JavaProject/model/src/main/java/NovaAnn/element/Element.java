package NovaAnn.element;



import java.awt.Image;

import NovaAnn.INovaAnnWorld;
import NovaAnn.NovaAnnWorld;



public abstract class Element implements INovaAnnWorld {
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

	protected INovaAnnWorld getNovaAnnWorld() {
		return this.novaAnnWorld;
	}

	public void setNovaAnnWorld(final INovaAnnWorld novaAnnWorld) {
		this.novaAnnWorld = novaAnnWorld;
	}

	//@Override
	public Image getImage() {
		return this.getSprite().getImage();
	}

}