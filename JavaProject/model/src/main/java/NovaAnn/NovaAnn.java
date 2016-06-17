package NovaAnn;

import java.io.IOException;
import java.sql.SQLException;

import NovaAnn.play.NovaAnnPlay;

public class NovaAnn {
	
	private final INovaAnnWorld	novaAnnWorld;
	private final NovaAnnPlay		novaAnnPlay;
	
	public NovaAnn() throws IOException, SQLException{

		this.novaAnnWorld = new NovaAnnWorld();
		this.novaAnnPlay = new NovaAnnPlay(this.novaAnnWorld);
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
