package javaproject.novaann;


public final class NovaAnn implements Runnable {
	private final INovaAnnWorld	novaAnnWorld;
	private final NovaAnnPlay		novaAnnPlay;
	private INovaAnnFrame				novaAnnFrame;

	public NovaAnn() throws IOException {
		this.novaAnnWorld = new NettleWorld("nettleWorld.txt");
		this.novaAnnPlay = new NovaAnnPlay(this.novaAnnWorld);
		SwingUtilities.invokeLater(this);
		this.novaAnnPlay.play();
	}

	@Override
	public void run() {
		this.novaAnnFrame = new NovaAnnFrame("Welcome to NettleWorld", this.getNovaAnnWorld(), this.getNovaAnnPlay());
		this.novaAnnPlay.setNovaAnnFrame(this.novaAnnFrame);
	}

	private INovaAnnWorld getNovaAnnWorld() {
		return this.novaAnnWorld;
	}

	private NovaAnnPlay getNovaAnnPlay() {
		return this.novaAnnPlay;
	}
}


