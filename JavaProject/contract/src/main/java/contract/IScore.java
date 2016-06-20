package contract;

import java.util.Observer;

public interface IScore extends Observer{

	int getScore();

	void setScore(int score);

	void update(int score);

}