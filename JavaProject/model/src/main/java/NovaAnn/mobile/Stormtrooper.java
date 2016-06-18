package NovaAnn.mobile;


import NovaAnn.element.ActionOnHeroes;
import NovaAnn.element.Sprite;

public class Stormtrooper extends MonsterMobile {
	public Stormtrooper() {
		super(new Sprite("Stormtrooper.jpg"), '$');
	}
	
	public ActionOnHeroes getActionOnHeroes(){
		return ActionOnHeroes.DEATH;
	}
	
}
