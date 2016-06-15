package NovaAnn;

public interface INovaAnnWorld {
	
	public int getWidth();
	
	public int getHeight();
	
	public Element[][] getElements();
	
	public Hero getHero();
	
	public void addMobile(Hero hero, int x, int y);
	
	public void setMobileHasChanged();
	
	public ArrayList<Mobile> getMobiles();
	
	public void addObserver(Observer o);
	
}
