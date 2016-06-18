package NovaAnn;

import java.io.IOException;
import java.sql.SQLException;

import NovaAnn.play.NovaAnnPlay;

public class NovaAnn {
	
	private final INovaAnnWorld	novaAnnWorld;
	private final NovaAnnPlay		novaAnnPlay;
	
	public NovaAnn(int lvl) throws IOException, SQLException{
		
		this.novaAnnWorld = new NovaAnnWorld(lvl);
		this.novaAnnPlay = new NovaAnnPlay(this.novaAnnWorld, lvl);
	}
	
	public void Play(){
	}
	
	public void getNovaAnnPlay(){
	}
	
	public void getNovaAnnWorld(){
	}
	
	public void run(){
	}
		
}
