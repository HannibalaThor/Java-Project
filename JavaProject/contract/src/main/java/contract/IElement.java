package contract;

import java.awt.Image;


public interface IElement<Permeability> {

	ISprite getSprite();

	Permeability getPermeability();

	void setNovaAnnWorld(INovaAnnWorld novaAnnWorld);

	//@Override
	Image getImage();

}