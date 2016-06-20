package model.javaproject.novaann.play;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javaproject.novaann.DAO.DAONovaAnn;
import javaproject.novaann.DAO.DBConnection;
import javaproject.novaann.view.INovaAnnFrame;
import javaproject.novaann.view.NovaAnnView;
import javaproject.novaann.world.INovaAnnWorld;
import javaproject.novaann.world.element.mobile.Hero;
import javaproject.novaann.world.element.mobile.MonsterMobile;
import javaproject.novaann.world.element.motionless.IDoActionOnHeroes;

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
		this.novaAnnWorld.addMobile(new Hero(), this.daoNovaAnn.getX()-1 , this.daoNovaAnn.getY()-1);

	}

	/* (non-Javadoc)
	 * @see javaproject.novaann.play.INovaAnnPlay#play()
	 */
	@Override
	public void play() throws InterruptedException
	{
		for(;;)
		{
			TimeUnit.MILLISECONDS.sleep(250);
			for(MonsterMobile m : this.novaAnnWorld.getMobiles()){

				m.getAnimate(m);

				this.novaAnnWorld.destructCollected();
				System.out.println(this.novaAnnWorld.getScore());
			}
		}
	}

	/* (non-Javadoc)
	 * @see javaproject.novaann.play.INovaAnnPlay#getNovaAnnWorld()
	 */
	@Override
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
	@Override
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
		if (this.getPlayMode() == NovaAnnView.VIEW_MODE_MEETING) {
			return this.getNovaAnnMeeting();
		}
		return this.getNovaAnnWorld();
	}

	//@Override
	/* (non-Javadoc)
	 * @see javaproject.novaann.play.INovaAnnPlay#orderPerform(javaproject.novaann.play.UserOrder)
	 */
	@Override
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
		this.getWorldAnswer();
	}

	private void resolveWorldAnswer() throws IOException {
		this.getNovaAnnMeeting().addMobile(new Hero(), 0, 0);
		this.getNovaAnnFrame().setMeeting(this.getNovaAnnMeeting());
		this.setPlayMode(NovaAnnView.VIEW_MODE_MEETING);
	}

	private void exitMetting() throws IOException {
		this.setPlayMode(NovaAnnView.VIEW_MODE_MAP);
	}

	private void escapeMetting() throws IOException {
		this.exitMetting();
		this.getActuelNovaAnnWorld().getHero().moveBack();
	}

	private void getWorldAnswer() throws IOException {
		final IDoActionOnHeroes element = this.getActuelNovaAnnWorld().getElements(this.getActuelNovaAnnWorld().getHero().getX(),
				this.getActuelNovaAnnWorld().getHero().getY());

		switch (element.getActionOnHeroes()) {
		case ENTER_CAMP:
			NovaAnnView.displayMessage("You enter a camp.");

			break;
		case ENTER_TOWN:
			NovaAnnView.displayMessage("You enter a town.");

			break;
		case ENTER_MONASTERY:
			NovaAnnView.displayMessage("You enter a monastery.");

			break;
		case EXIT:
			NovaAnnView.displayMessage("You leave this place.");
			this.exitMetting();
			break;
		case ESCAPE:
			NovaAnnView.displayMessage("You escape this place.");
			this.escapeMetting();
			break;
		case NOP:
		default:
			break;
		}
	}

	private void setNovaAnnMeeting(final INovaAnnWorld novaAnnMeeting) {
		this.novaAnnMeeting = novaAnnMeeting;
	}
}
