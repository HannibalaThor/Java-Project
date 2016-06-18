package NovaAnn.mobile;


import NovaAnn.element.ActionOnHeroes;
import NovaAnn.element.Sprite;

public class Butterfly extends MonsterMobile {
	public Butterfly() {
		super(new Sprite("Butterfly.jpg"), '/');
	}
	
	public ActionOnHeroes getActionOnHeroes(){
		return ActionOnHeroes.DEATH;
	}
	
}
