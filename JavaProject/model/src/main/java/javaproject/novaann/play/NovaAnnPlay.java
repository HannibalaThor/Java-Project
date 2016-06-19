package javaproject.novaann.play;

import java.io.IOException;

import javaproject.novaann.view.INovaAnnFrame;
import javaproject.novaann.view.NovaAnnView;
import javaproject.novaann.world.INovaAnnWorld;
import javaproject.novaann.world.NovaAnnWorld;
import javaproject.novaann.world.element.mobile.Hero;
import javaproject.novaann.world.element.mobile.MonsterMobile;
import javaproject.novaann.world.element.motionless.IDoActionOnHeroes;

public class NovaAnnPlay implements IOrderPerformed {
	private final INovaAnnWorld	novaAnnWorld;
	private INovaAnnWorld				novaAnnMeeting;
	private INovaAnnFrame				novaAnnFrame;
	private int									playMode;

	public NovaAnnPlay(final INovaAnnWorld novaAnnWorld) {
		this.novaAnnWorld = novaAnnWorld;

		this.novaAnnWorld.addMobile(new Hero(), 16, 5);

	}

	public void play()
	{
		for(;;)
		{
			for(MonsterMobile m : this.novaAnnWorld.getMobiles()){
				m.getAnimate(m);
				this.novaAnnWorld.death();
			}
		}
	}

	private INovaAnnWorld getNovaAnnWorld() {
		return this.novaAnnWorld;
	}

	private INovaAnnWorld getNovaAnnMeeting() {
		return this.novaAnnMeeting;
	}

	private INovaAnnFrame getNovaAnnFrame() {
		return this.novaAnnFrame;
	}

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

	private void resolveEnterCamp() throws IOException {
		this.setNovaAnnMeeting(new NovaAnnWorld("camp.txt"));
		this.resolveWorldAnswer();
	}

	private void resolveEnterTown() throws IOException {
		this.setNovaAnnMeeting(new NovaAnnWorld("town.txt"));
		this.resolveWorldAnswer();
	}

	private void resolveEnterMonastery() throws IOException {
		this.setNovaAnnMeeting(new NovaAnnWorld("monastery.txt"));
		this.resolveWorldAnswer();
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
			this.resolveEnterCamp();
			break;
		case ENTER_TOWN:
			NovaAnnView.displayMessage("You enter a town.");
			this.resolveEnterTown();
			break;
		case ENTER_MONASTERY:
			NovaAnnView.displayMessage("You enter a monastery.");
			this.resolveEnterMonastery();
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
