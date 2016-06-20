package contract;

import java.awt.Image;

import javaproject.novaann.world.INovaAnnWorld;

public interface IElement {

	ISprite getSprite();

	Permeability getPermeability();

	void setNovaAnnWorld(INovaAnnWorld novaAnnWorld);

	//@Override
	Image getImage();

}