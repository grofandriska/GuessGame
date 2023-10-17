package game.data;

public class Player {
	private String name;
	private int maxTry = 3;
	private int guessedNumbersCount = 0;

	public Player(String name) {
		this.name = name;
	}
	public int getMaxTry() {
		return maxTry;
	}
	public void setMaxTry(int maxTry) {
		this.maxTry = maxTry;
	}
	public int getGuessedNumbersCount() {
		return guessedNumbersCount;
	}
	public void setGuessedNumbersCount(int guessedNumbersCount) {
		this.guessedNumbersCount = guessedNumbersCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
