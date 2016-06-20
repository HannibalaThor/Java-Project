package contract;

import java.io.IOException;

import javaproject.novaann.view.INovaAnnFrame;
import javaproject.novaann.world.INovaAnnWorld;

public interface INovaAnnPlay {

	void play() throws InterruptedException;

	INovaAnnWorld getNovaAnnWorld();

	void setNovaAnnFrame(INovaAnnFrame novaAnnFrame);

	//@Override
	void orderPerform(UserOrder userOrder) throws IOException;

}