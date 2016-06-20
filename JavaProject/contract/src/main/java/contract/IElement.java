package contract;

import java.awt.Image;

import aedt.showboard.ISquare;


public interface IElement extends ISquare{

	ISprite getSprite();

	Permeability getPermeability();

	void setNovaAnnWorld(INovaAnnWorld novaAnnWorld);

	//@Override
	Image getImage();

}