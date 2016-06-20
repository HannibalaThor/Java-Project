package contract;

public interface IMotionlessElement extends IElement{

	char getFileSymbol();

	boolean isCollected();

	void setCollected(boolean collected);

	//@Override
	ActionOnHeroes getActionOnHeroes();

}