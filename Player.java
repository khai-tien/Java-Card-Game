
import java.util.Scanner;

public class Player {

	private String name;
	private int number;
	private int score=0;
	private int rank;
	private int suit;
	
	// Player Constructor
	public Player(){
		
	}
	
	// Player tostring
	public String toString(){
		return "Player Name: " + name + "  Player Number: " + number + "  Score: " + score + "  ";
		
	}
	
	// Player Constructor
	public Player(Scanner n,int no,int sc){
		 name = n.next();
		 number = no;
		 score = sc;
	}
	
	// set number for each Player
	public void setnumber(int number){
		this.number = number;
	}
	
	// get number for each Player
	public int getnumber(){
		return number;
	}
	
	// set name for each Player
	public void setname(Scanner n){
		name = n.nextLine();
	}
	
	// get name for each Player
	public String getname (){
		return name;
	}
	
	// add score for each Player
	public void setaddscore(int score){
		this.score += score;
	}
	
	// get score of each Player
	public int getscore(){
		return score;
	}
	
	// set rank for each Player
	public void setrank(int rank){
		this.rank = rank;
	}
	
	// get rank of each Player
	public int getrank(){
		return rank;
	}
	
	// set suit for each Player
	public void setsuit(int suit){
		this.suit = suit;
	}
	
	// get suit of each Player
	public int getsuit(){
		return suit;
	}
	
}
