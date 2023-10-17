
public class Player {
	private int maxTry = 3;
	private int guess = 0;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	public int getMaxTry() {
		return maxTry;
	}
	public void setMaxTry(int maxTry) {
		this.maxTry = maxTry;
	}
	public int getGuess() {
		return guess;
	}
	public void setGuess(int guess) {
		this.guess = guess;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
