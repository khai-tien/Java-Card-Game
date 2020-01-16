

public class Card{
	
////////////////////////////////////////////////////////////////////////	
	// For UI_Mini_Game
	private String cardpath;
	
	//setpath for UI_MINI_GAME
	public void setpath(String rank,String suit){
		
		String rank1 = rank.substring(0, 1);
		if(rank1.toLowerCase().substring(0, 1) == "1"){
			rank1 = "10";
		}
		String suit1 = suit.toLowerCase().substring(0, suit.length()-1);
		
		cardpath = "images_deck\\" + rank1+ suit1 +".png";
		////
	}
	
	
	//getpath for UI_MINI_GAME
	public String getpath(){
		return cardpath;
	}
	
	//showcard for UI_Mini_Game
	public void UIshowcard(){
		int a = getindex();
				
		String suit = suits[deck[a] / 13];
		String rank = ranks[deck[a] % 13];
					
			setRank(rank);
			setSuit(suit);
			/// set path
			setpath(rank,suit);			
	}
////////////////////////////////////////////////////////////////////////////
	
	int[] deck = new int[52];
	final String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
	final String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
	                      "10", "Jack", "Queen", "King"};
	
	private String rank;
	private String suit;
	
    public Card(){
    	
    }
 
	//constructor for Card
    public Card(String rank,String suit){
    	this.rank = rank;
    	this.suit = suit;
    }

    //Card tostring
	 public String toString(){
		 return "Card: " + this.rank + " of " + this.suit;
	 }
	 

	//Initialize cards
	public void initializecard(){
		for (int i=0; i<deck.length;i++)
			deck[i] = i;
	}
			
	//Shuffle the cards
	public void shufflecard(){
		for (int i=0; i<deck.length;i++)
		{
		//Generate an index randomly
		int index = (int)(Math.random() * deck.length);
		int temp = deck[i];
		deck[i] = deck[index];
		deck[index] = temp;
		}
	}
			
			
	//showcard for main game
	public void showcard(){
		int a = getindex();
				
		String suit = suits[deck[a] / 13];
		String rank = ranks[deck[a] % 13];
					
		System.out.println("Card number " + deck[a] + ": "
									+ rank + " of " + suit);
			setRank(rank);
			setSuit(suit);
			/// set path
			setpath(rank,suit);	
	}
			
	int index = 0;
	// increment index and return index
	public int getindex(){
		if(index == 51){
			index = 0;  // if deck[51],set to 0 again
		}
		return index++;
	}
	
	// set card Rank
	public void setRank(String rank){
		this.rank = rank;
	}
	
	// set card Suit
	public void setSuit(String suit){
		this.suit = suit;
	}
			
	// get card Rank		
	public String getRank() {
		return this.rank;
	}
	
	// get card Suit
	public String getSuit() {
		return this.suit;
	}
			
	}

