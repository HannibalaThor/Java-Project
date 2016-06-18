package NovaAnn.play;

import java.io.IOException;

import NovaAnn.INovaAnnWorld;
import NovaAnn.element.IDoActionOnHeroes;

public class NovaAnnPlay implements IOrderPerformed{
	private INovaAnnWorld novaAnnWorld;
	//private INovaAnnFrame novaAnnFrame;
	private int playMode;
	
	public NovaAnnPlay(INovaAnnWorld novaAnnWorld){
		this.novaAnnWorld = novaAnnWorld;
		//this.novaAnnWorld.addMobile(new Hero(), 15, 15);
	}
	 
	public INovaAnnWorld getNovaAnnWorld(){
		return novaAnnWorld;
	}
	
//	public INovaAnnFrame getNovaAnnFrame(){
	//	return novaAnnFrame;
	//}
	 
	//public void setNovaAnnFrame(INovaAnnFrame novaAnnFrame){
	//	this.novaAnnFrame = novaAnnFrame;
	//}
	
	public void setPlayMode(int playMode){
		this.playMode = playMode;
	}
	
	public int getPlayMode(){
		return playMode;
	}

	public void orderPerform(UserOrder userOrder) throws IOException{
		switch (userOrder) {
		case UP: 
			//this.getActualNovaAnnWorld().getHero().moveUp();
			break;
		case RIGHT:
			this.getNovaAnnWorld().getHero().moveRight();
			break;
		case DOWN:
			this.getNovaAnnWorld().getHero().moveDown();
			break;
		case LEFT:
			this.getNovaAnnWorld().getHero().moveLeft();
			break;
		case DOWNLEFT:
			this.getNovaAnnWorld().getHero().moveDownLeft();
			break;
		case DOWNRIGHT:
			this.getNovaAnnWorld().getHero().moveDownRight();
			break;
		case UPLEFT:
			this.getNovaAnnWorld().getHero().moveUpLeft();
			break;
		case UPRIGHT:
			this.getNovaAnnWorld().getHero().moveUpRight();
			break;
		case NOP:
		default:
			break;
		}
		this.getWorldAnswer();
	}
	
	private void resolveEnd() throws IOException {
		
	}
	
	private void resolveDeath() throws IOException {
		
	}

	private void resolveCollect() throws IOException {
		
	}
	
	
	public void getWorldAnswer() throws IOException {
		final IDoActionOnHeroes element =  this.getNovaAnnWorld().getElements(
		this.getNovaAnnWorld().getHero().getX(), this.getNovaAnnWorld().getHero().getY());

		switch (element.getActionOnHeroes()) {
		case DEATH:
			//ViewFrame.displayMessage("You're dead.");
			this.resolveDeath();
			break;
		case COLLECT:
			this.resolveCollect();
			break;
		case END:
			//ViewFrame.displayMessage("You reached the door, you won.");
			this.resolveEnd();
			break;
		case NOP:
		default:
			break;
		}
	}
	
}
