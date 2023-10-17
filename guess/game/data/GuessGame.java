package game.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
	private Scanner scanner;
	private int numberOfPlayers;
	private List<Player> playerList;
	private Random random;
	private int upperBound = 100;
	private int secretNumber;
	
	public GuessGame() {
		this.random = new Random();
		this.playerList = new ArrayList<>();
		this.scanner = new Scanner(System.in);
		this.initGameAndPlayers();
		System.out.println(numberOfPlayers);
		System.out.println(startGame());
	}
	
	public String startGame() {
		
		secretNumber = random.nextInt(upperBound);
		int guess;
		boolean isWon = false;
		System.out.println("Starting the game");
		for (int i = 0; i < playerList.size(); i++) {
			System.out.println("\nIt's your turn player called: " + playerList.get(i).getName());
			for (int k = 0; k < playerList.get(i).getMaxTry(); k++) {
				System.out.println("Please type in the number of your guess! You have " + (playerList.get(i).getMaxTry() - playerList.get(i).getGuess()) + " guesses left");
				guess = scanner.nextInt();
				if (guess == secretNumber) {
					System.out.println("You have Won the game!");
					isWon = true;
				} else if (guess < secretNumber) {
					System.out.println("\nSecret number is bigger!");
				} else if (guess > secretNumber) {
					System.out.println("\nSecret number is smaller!");
				}
				if (isWon) {
					return "\nThe winner is : " + playerList.get(i).getName() + "! The Secret number was: " + secretNumber;
				}
			}
		}
		return "Noone won the game! The secret number was: " + secretNumber;
	}
	
	public void initGameAndPlayers() {
		initPlayerListSize();
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Please add " + i + ". player name");
			scanner = new Scanner(System.in);
			String userName = scanner.nextLine();
			
			validatePlayerName(userName);
			
		}
	}
	
	public void initPlayerListSize() {
		while (numberOfPlayers < 2) {
			initNumberOfPlayers();
		}
	}
	
	public void initNumberOfPlayers() {
		try {
			System.out.println("Type in the number of the Players!");
			numberOfPlayers = scanner.nextInt();
			if (numberOfPlayers <= 2) {
				System.out.println("Minimum player count is 2");
			}
		} catch (Exception e) {
			System.out.println("Error whene initalizing the number of the players");
			initNumberOfPlayers();
		}
	}
	
	public void validatePlayerName(String name) {
		try {
			System.out.println("validating player name");
			if (name != null && name.length() > 0) {
				System.out.println("player name is fine");
				
				for (Player p : playerList) {
					System.out.println("Looking for existing player name");
					if (p.getName().equals(name)) {
						System.out.println("games.guess.game.data.Player name is in use! Choose another name please.");
					} else {
						System.out.println("player added");
						playerList.add(new Player(name));
					}
				}
				if (playerList.size() < 1) {
					playerList.add(new Player(name));
				}
			} else {
				System.out.println("Give a valid player name");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong when setting player name!");
		}
	}
	
	
	public Scanner getScanner() {
		return scanner;
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public List<Player> getPlayerList() {
		return playerList;
	}
	
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
	public Random getRandom() {
		return random;
	}
	
	public void setRandom(Random random) {
		this.random = random;
	}
	
	public int getUpperBound() {
		return upperBound;
	}
	
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	
	public int getSecretNumber() {
		return secretNumber;
	}
	
	public void setSecretNumber(int secretNumber) {
		this.secretNumber = secretNumber;
	}
}
