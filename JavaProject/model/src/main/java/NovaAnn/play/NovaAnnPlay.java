package NovaAnn.play;

import java.io.IOException;

import NovaAnn.INovaAnnWorld;
import NovaAnn.NovaAnnWorld;
import NovaAnn.DAO.DAONovaAnn;

public class NovaAnnPlay implements IOrderPerformed{
	private INovaAnnWorld novaAnnWorld;
	private INovaAnnWorld novaAnnMeeting;
	//private INovaAnnFrame novaAnnFrame;
	DAONovaAnn daoNovaAnn;
	private int playMode;
	
	public NovaAnnPlay(INovaAnnWorld novaAnnWorld){
	this.novaAnnWorld = novaAnnWorld;
	int lvl = 1;
	
	
	for(int id = 0; id>4; id++){
		this.novaAnnWorld.addMobile(MobileElement.tableElement[id], daoNovaAnn.findMobile(lvl, MobileElement.tableString[id]).x,daoNovaAnn.findMobile(lvl, MobileElement.tableString[id]).y);
	}
	
	}

	public void orderPerform(UserOrder userOrder) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	public INovaAnnWorld getNovaAnnWorld(){
		return novaAnnWorld;
	}
	
	public INovaAnnFrame getNovaAnnFrame(){
		return novaAnnFrame;
	}
	
	public INovaAnnWorld getNovaAnnMeeting(){
		return novaAnnMeeting;
	}
	 
	public void setNovaAnnFrame(INovaAnnFrame novaAnnFrame){
		this.novaAnnFrame = novaAnnFrame;
	}
	
	public void setPlayMode(int playMode){
		this.playMode = playMode;
	}
	
	public int getPlayMode(){
		return playMode;
	}

	public INovaAnnWorld getActualNovaAnnWorld(){
		// Waiting
	}
	
	public void orderPerform(UserOrder userOrder) throws IOException{
		switch (userOrder) {
		case UP: 
			this.getActualNovaAnnWorld().getHero().moveUp();
			break;
		case RIGHT:
			this.getActualNovaAnnWorld().getHero().moveRight();
			break;
		case DOWN:
			this.getActualNovaAnnWorld().getHero().moveDown();
			break;
		case LEFT:
			this.getActualNovaAnnWorld().getHero().moveLeft();
			break;
		case DOWNLEFT:
			this.getActualNovaAnnWorld().getHero().moveDownLeft();
			break;
		case DOWNRIGHT:
			this.getActualNovaAnnWorld().getHero().moveDownRight();
			break;
		case UPLEFT:
			this.getActualNovaAnnWorld().getHero().moveUpLeft();
			break;
		case UPRIGHT:
			this.getActualNovaAnnWorld().getHero().moveUpRight();
			break;
		case NOP:
		default:
			break;
		}
	}

	public void exitMeeting(){
	}
	
	public void setNovaAnnMeeting(INovaAnnWorld novaAnnMeeting){
		
	}
}
