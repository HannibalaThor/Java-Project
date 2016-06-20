package contract;

import java.io.IOException;


public interface INovaAnnPlay<UserOrder> {

	void play() throws InterruptedException;

	INovaAnnWorld getNovaAnnWorld();

	void setNovaAnnFrame(INovaAnnFrame novaAnnFrame);

	//@Override
	void orderPerform(UserOrder userOrder) throws IOException;

}