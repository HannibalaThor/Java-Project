package model.javaproject.novaann.play;

import java.io.IOException;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import contract.IDoActionOnHeroes;
import contract.IMonsterMobile;
import contract.INovaAnnFrame;
import contract.INovaAnnPlay;
import contract.INovaAnnView;
import contract.INovaAnnWorld;
import contract.IOrderPerformed;
import contract.UserOrder;
import model.javaproject.novaann.DAO.DAONovaAnn;
import model.javaproject.novaann.DAO.DBConnection;
import model.javaproject.novaann.world.element.mobile.Hero;


@SuppressWarnings("rawtypes")
public class NovaAnnPlay implements IOrderPerformed, INovaAnnPlay {


	private final INovaAnnWorld	novaAnnWorld;
	private INovaAnnWorld				novaAnnMeeting;
	private INovaAnnFrame				novaAnnFrame;
	private int									playMode;
	private DAONovaAnn daoNovaAnn;

	public NovaAnnPlay(INovaAnnWorld novaAnnWorld, int lvl) throws SQLException{
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		this.daoNovaAnn = new DAONovaAnn(connection);
		this.novaAnnWorld = novaAnnWorld;
		this.daoNovaAnn.findMobile(lvl, 1);
		//this.novaAnnWorld.addMobile(new Hero(), this.daoNovaAnn.getX()-1 , this.daoNovaAnn.getY()-1);
		this.novaAnnWorld.addMobile(new Hero(),18 , 7);
	}

	/* (non-Javadoc)
	 * @see javaproject.novaann.play.INovaAnnPlay#play()
	 */
	public void play() throws InterruptedException
	{
		for(;;)
		{
			TimeUnit.MILLISECONDS.sleep(250);
			for(IMonsterMobile m : this.novaAnnWorld.getMobiles()){

				m.getAnimate(m);
				this.novaAnnWorld.destructCollected();
			}
		}
	}

	/* (non-Javadoc)
	 * @see javaproject.novaann.play.INovaAnnPlay#getNovaAnnWorld()
	 */
	public INovaAnnWorld getNovaAnnWorld() {
		return this.novaAnnWorld;
	}

	private INovaAnnWorld getNovaAnnMeeting() {
		return this.novaAnnMeeting;
	}

	private INovaAnnFrame getNovaAnnFrame() {
		return this.novaAnnFrame;
	}

	/* (non-Javadoc)
	 * @see javaproject.novaann.play.INovaAnnPlay#setNovaAnnFrame(javaproject.novaann.view.INovaAnnFrame)
	 */

	public void setNovaAnnFrame(final INovaAnnFrame novaAnnFrame) {
		this.novaAnnFrame = novaAnnFrame;
	}

	private int getPlayMode() {
		return this.playMode;
	}

	private void setPlayMode(final int playMode) {
		this.playMode = playMode;
		this.getNovaAnnFrame().setViewMode(playMode);
	}

	private INovaAnnWorld getActuelNovaAnnWorld() {
		return this.getNovaAnnWorld();
	}

	//@Override
	/* (non-Javadoc)
	 * @see javaproject.novaann.play.INovaAnnPlay#orderPerform(javaproject.novaann.play.UserOrder)
	 */
	public void orderPerform(final UserOrder userOrder) throws IOException {
		switch (userOrder) {
		case UP:
			this.getActuelNovaAnnWorld().getHero().moveUp();
			//	System.out.println();
			break;
		case RIGHT:
			this.getActuelNovaAnnWorld().getHero().moveRight();
			break;
		case DOWN:
			this.getActuelNovaAnnWorld().getHero().moveDown();
			break;
		case LEFT:
			this.getActuelNovaAnnWorld().getHero().moveLeft();
			break;
		case NOP:
		default:
			break;
		}
	}

	private void setNovaAnnMeeting(final INovaAnnWorld novaAnnMeeting) {
		this.novaAnnMeeting = novaAnnMeeting;
	}

	public void orderPerform(Object userOrder) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
