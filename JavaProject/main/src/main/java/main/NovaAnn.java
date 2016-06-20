package main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import contract.INovaAnnFrame;
import contract.INovaAnnPlay;
import contract.INovaAnnWorld;
import model.javaproject.novaann.world.NovaAnnWorld;
import view.NovaAnnFrame;


public final class NovaAnn implements Runnable {
	private final INovaAnnWorld	novaAnnWorld;
	private final INovaAnnPlay		novaAnnPlay;
	private INovaAnnFrame				novaAnnFrame;

	public NovaAnn(int lvl) throws IOException, SQLException, InterruptedException {
		this.novaAnnWorld = new NovaAnnWorld(lvl);
		this.novaAnnPlay = new NovaAnnPlay(this.novaAnnWorld, lvl);
		SwingUtilities.invokeLater(this);
		this.novaAnnPlay.play();
	}

	public void run() {
		this.novaAnnFrame = new NovaAnnFrame("Loran", this.getNovaAnnWorld(), this.getNovaAnnPlay());
		this.novaAnnPlay.setNovaAnnFrame(this.novaAnnFrame);
	}

	public INovaAnnWorld getNovaAnnWorld() {
		return this.novaAnnWorld;
	}

	private INovaAnnPlay getNovaAnnPlay() {
		return this.novaAnnPlay;
	}
}


