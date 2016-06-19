package javaproject.novaann.world.element.mobile;

import java.util.concurrent.TimeUnit;

import javaproject.novaann.world.NovaAnnWorld;

public class AISkeletor implements IStrategy {
	//@Override
	public void animate(Mobile mobile){
		try {
			int xL = NovaAnnWorld.getXhero();
			int yL = NovaAnnWorld.getYhero();
			int xM = mobile.getX();
			int yM = mobile.getY();
			int xOM = mobile.getLastPosition().x;
			int yOM = mobile.getLastPosition().y;
			int DA = 5;
			double rand = Math.random();

			TimeUnit.MILLISECONDS.sleep(250);

			if((Math.abs(xM - xL) < DA) && (Math.abs(yM - yL) < DA)){
				if((xL > xM) && (yL == yM)) {

					if(mobile.isMovePossibleM(xM+1, yM) == true){
						mobile.moveRightM();
					} else if(((mobile.isMovePossibleM(xM, yM-1) == true) && (mobile.isMovePossibleM(xM-1, yM) == false)) || (rand == 0)){
						mobile.moveUpM();
					}
					else if(((mobile.isMovePossibleM(xM, yM+1) == true)) || (rand == 1)){
						mobile.moveDownM();
					}
				} else if((xL < xM) && (yL == yM)){
					if(mobile.isMovePossibleM(xM-1, yM) == true){
						mobile.moveLeftM();
					} else if(((mobile.isMovePossibleM(xM, yM-1) == true) && (mobile.isMovePossibleM(xM-1, yM) == false)) || (rand == 0)){
						mobile.moveUpM();
					}
					else if(((mobile.isMovePossibleM(xM, yM+1) == true)) || (rand == 1)){
						mobile.moveDownM();
					}
				} else if((xL == xM) && (yL > yM)){
					mobile.moveDownM();
					if(mobile.isMovePossibleM(xM, yM+1) == true){
						mobile.moveDownM();
					} else if(((mobile.isMovePossibleM(xM+1, yM) == true) && (mobile.isMovePossibleM(xM-1, yM) == false)) || (rand == 0)){
						mobile.moveRightM();
					}
					else if(((mobile.isMovePossibleM(xM-1, yM) == true)) || (rand == 1)){
						mobile.moveLeftM();
					}
				} else if((xL == xM) && (yL < yM)){
					if(mobile.isMovePossibleM(xM, yM-1) == true){
						mobile.moveUp();
					} else if(((mobile.isMovePossibleM(xM+1, yM) == true) && (mobile.isMovePossibleM(xM-1, yM) == false)) || (rand == 0)){
						mobile.moveRightM();
					}
					else if(((mobile.isMovePossibleM(xM-1, yM) == true)) || (rand == 1)){
						mobile.moveLeftM();
					}
				} else if((xL > xM) && (yL > yM)) {
					if(mobile.isMovePossibleM(xM+1, yM+1) == true){
						mobile.moveDownRightM();
					} else if(((mobile.isMovePossibleM(xM+1, yM) == true) && (mobile.isMovePossibleM(xM, yM+1) == false)) || (rand == 0)){
						mobile.moveRightM();
					}
					else if(((mobile.isMovePossibleM(xM, yM+1) == true)) || (rand == 1)){
						mobile.moveDownM();
					}
				} else if((xL < xM) && (yL > yM)){
					if(mobile.isMovePossibleM(xM-1, yM+1) == true){
						mobile.moveDownLeftM();
					} else if(((mobile.isMovePossibleM(xM-1, yM) == true) && (mobile.isMovePossibleM(xM, yM+1) == false)) || (rand == 0)){
						mobile.moveLeftM();
					}
					else if(((mobile.isMovePossibleM(xM, yM+1) == true)) || (rand == 1)){
						mobile.moveDownM();
					}
				} else if((xL > xM) && (yL < yM)){
					if(mobile.isMovePossibleM(xM+1, yM-1) == true){
						mobile.moveUpRightM();
					} else if(((mobile.isMovePossibleM(xM+1, yM) == true) && (mobile.isMovePossibleM(xM, yM-1) == false)) || (rand == 0)){
						mobile.moveRightM();
					}
					else if(((mobile.isMovePossibleM(xM, yM-1) == true)) || (rand == 1)){
						mobile.moveUpM();
					}
				} else if((xL < xM) && (yL < yM)){
					if(mobile.isMovePossibleM(xM-1, yM-1) == true){
						mobile.moveUpLeftM();
					} else if(((mobile.isMovePossibleM(xM-1, yM) == true) && (mobile.isMovePossibleM(xM, yM-1) == false)) || (rand == 0)){
						mobile.moveLeftM();
					}
					else if(((mobile.isMovePossibleM(xM, yM-1) == true)) || (rand == 1)){
						mobile.moveUpM();
					}
				}
			} else {
				if((xOM == 0) && (yOM == 0)){
					if(mobile.isMovePossibleM(xM, yM+1) == true){
						mobile.moveDownM();
					} else {
						mobile.moveUpM();
					}
				} else if ((((yM - yOM) == 1) && (mobile.isMovePossibleM(xM, yM+1) == true)) || (mobile.isMovePossibleM(xM, yM-1) == false)){
					mobile.moveDownM();
				} else if ((((yM - yOM) == -1) && (mobile.isMovePossibleM(xM, yM-1) == true)) || (mobile.isMovePossibleM(xM, yM+1) == false)){
					mobile.moveUpM();
				}
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

