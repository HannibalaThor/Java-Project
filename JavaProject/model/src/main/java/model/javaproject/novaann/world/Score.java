package model.javaproject.novaann.world;

import java.util.Observable;

import contract.IScore;

public class Score implements Observer, IScore {
	private int score;

	public Score(){
		this.score = 0;
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.IScore#getScore()
	 */
	public int getScore() {
		return this.score;
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.IScore#setScore(int)
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/* (non-Javadoc)
	 * @see model.javaproject.novaann.world.IScore#update(int)
	 */
	public void update(int score) {
		this.setScore(this.getScore() + score);
	}

	public void update(Observable o, Object arg) {
		this.setScore(this.getScore() + score);
	}

}