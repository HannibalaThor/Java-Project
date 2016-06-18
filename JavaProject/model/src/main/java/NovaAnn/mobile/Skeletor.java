package NovaAnn.mobile;


import NovaAnn.element.ActionOnHeroes;
import NovaAnn.element.Sprite;

public class Skeletor extends MonsterMobile {
	public Skeletor() {
		super(new Sprite("Skeletor.jpg"), ':');
	}
	
	public ActionOnHeroes getActionOnHeroes(){
		return ActionOnHeroes.DEATH;
	}
	
}
