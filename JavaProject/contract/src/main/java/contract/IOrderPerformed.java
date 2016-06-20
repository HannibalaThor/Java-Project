package contract;

import java.io.IOException;

public interface IOrderPerformed<UserOrder> {

	void orderPerform(UserOrder userOrder) throws IOException;

	void play() throws InterruptedException;

	INovaAnnWorld getNovaAnnWorld();

}