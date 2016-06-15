package NovaAnn;

import jpu2016.nettle.world.element.mobile.Hero;

public class NovaAnnWorld implements INovaAnnWorld{
	private int width;
	private int height;
	private int point = 0;
	public ArrayList<Mobile> mobiles;
	private Hero hero;
	public MontionlessElements[][] elements;
	
	public int getWidth(){
	}

	public int getHeight(){
	}
	
	public NovaAnnWorld(){
	}
	
	public NovaAnnWorld(int width, int height){
	}
	
	public NovaAnnWorld(String fileName){
	}
	
	public void addElement(Element element, int x, int y){
	}
	
	public void addMobile( Hero hero, int x, int y) {
	}
	
	public void addMonster( Mobile monster, int x, int y) {
	}
	
	public Element[][] getElements() {
	}
	
	public Hero getHero() {	
	}
	
	public ArrayList<Mobile> getMobiles() {
	}
	
	private void loadFile(String fileName){
	}
	
	public void setElements(Element[][] elements){
	}
	
	public void setHero(Hero hero) {
	}
	
	public void setMobileHasChanged(){
	}
	
	public void notifyObservers(){
	}
	
}
