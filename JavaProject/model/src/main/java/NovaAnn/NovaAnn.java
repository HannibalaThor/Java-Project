package NovaAnn;

import java.io.IOException;

//import javax.swing.SwingUtilities;

import NovaAnn.play.NovaAnnPlay;

public class NovaAnn {
	
	private final NovaAnnPlay novaAnnPlay;
	private final INovaAnnWorld novaAnnWorld; 
	
	public NovaAnn() throws IOException{
		this.novaAnnWorld = new NovaAnnWorld();
		this.novaAnnPlay = new NovaAnnPlay(this.novaAnnWorld);
		//SwingUtilities.invokeLater(this);
	}
	
	public NovaAnnPlay getNovaAnnPlay(){
		return this.novaAnnPlay;
	} 
	
	public INovaAnnWorld getNovaAnnWorld(){
		return this.novaAnnWorld;
	}
	
	public void run(){
		//this.novaAnnFrame = new ViewFrame("Lorann", this.getNovaAnnWorld(), this.getNovaAnnPlay());
		//this.novaAnnPlay.setNovaAnnFrame(this.novaAnnFrame);
	}
		
}
