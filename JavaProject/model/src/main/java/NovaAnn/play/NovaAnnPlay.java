package NovaAnn.play;

import java.awt.Point;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import NovaAnn.INovaAnnWorld;
import NovaAnn.NovaAnnWorld;
import NovaAnn.DAO.DAONovaAnn;
import NovaAnn.DAO.DBConnection;
import NovaAnn.mobile.Hero;
import NovaAnn.mobile.Skeletor;

public class NovaAnnPlay implements IOrderPerformed{
	private INovaAnnWorld novaAnnWorld;
	private INovaAnnWorld novaAnnMeeting;
	//private INovaAnnFrame novaAnnFrame;
	DAONovaAnn daoNovaAnn;
	private int playMode;

	
	public NovaAnnPlay(INovaAnnWorld novaAnnWorld, int lvl) throws SQLException{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		daoNovaAnn = new DAONovaAnn(connection);
	this.novaAnnWorld = novaAnnWorld;
	boolean end = true;
	int id = 0;
	while(end){
		id++;
		daoNovaAnn.findMobile(lvl, id);
		if (daoNovaAnn.getX() != 0 && daoNovaAnn.getY() != 0){
		this.novaAnnWorld.addMobile(MotionElement.getElement(id), daoNovaAnn.getX() , daoNovaAnn.getY());
		}
		if (id > 4){
			end = false;
		}
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
