package javaproject.novaann;

import java.io.IOException;

import javax.swing.SwingUtilities;

import javaproject.novaann.play.NovaAnnPlay;
import javaproject.novaann.view.INovaAnnFrame;
import javaproject.novaann.view.NovaAnnFrame;
import javaproject.novaann.world.INovaAnnWorld;
import javaproject.novaann.world.NovaAnnWorld;

public final class NovaAnn implements Runnable {
	private final INovaAnnWorld	novaAnnWorld;
	private final NovaAnnPlay		novaAnnPlay;
	private INovaAnnFrame				novaAnnFrame;

	public NovaAnn() throws IOException {
		this.novaAnnWorld = new NovaAnnWorld("nettleWorld.txt");
		this.novaAnnPlay = new NovaAnnPlay(this.novaAnnWorld);
		SwingUtilities.invokeLater(this);
		this.novaAnnPlay.play();
	}

	//@Override
	public void run() {
		this.novaAnnFrame = new NovaAnnFrame("Loran", this.getNovaAnnWorld(), this.getNovaAnnPlay());
		this.novaAnnPlay.setNovaAnnFrame(this.novaAnnFrame);
	}

	private INovaAnnWorld getNovaAnnWorld() {
		return this.novaAnnWorld;
	}

	private NovaAnnPlay getNovaAnnPlay() {
		return this.novaAnnPlay;
	}
}


