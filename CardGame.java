
import java.util.*;
import java.util.Map;

public class CardGame{
	
	
	String option;
	int playerno;
	String choice1;	
	Card[] cards = new Card[1000];  // more rounds can be played 
	Card card = new Card();
	Player[] player;
	List<Map<Player,Card>> list = new ArrayList<Map<Player,Card>>();
	String cardNumber;
	Scanner input = new Scanner(System.in);
	Map[] maps;
	
	// FUNCTION1 : playGame
	public void playGame(){
		
		System.out.println("Card Game");
		System.out.println("Player Options");
		System.out.println("1. Start Game");
		System.out.println("");
		System.out.println("2. Exit Game");
		System.out.println("Please provide your option: ");
		
		option = input.nextLine();
		
		// if player select "exit", terminate the program
		if(option.equals("2")){
			System.exit(0);
		}
		
		// if player choice not in range, program will prompt user to insert choice again
		while(! option.equals("1") && ! option.equals("2")){
			System.out.println("Card Game");
			System.out.println("Player Options");
			System.out.println("1. Start Game");
			System.out.println("");
			System.out.println("2. Exit Game");
			System.out.println("Please provide your option: ");
			
			option = input.nextLine();
		}
		// call getNoPlayer() to get the number of player and store in playerno
		playerno = Integer.parseInt(getNoPlayer());
		//create multiplayer depend on number of player
		player = createMultiPlayer(playerno);
		// prompt user to insert user name
		for(int i=1;i<=playerno;i++){
		System.out.println("Please insert name for player " + i);
		player[i] = new Player(input,i,0);
		}
		//initialize card
		card.initializecard();
		//shuffle card
		card.shufflecard();
		
		String choice1;
		
		// playing 7 rounds, and maximum gets 7 cards per player
		for(int round = 1; round <= 7; round++){
			System.out.println();
			System.out.println("Round " + round);
		// start game
		for(int i =1; i<=playerno ; i++){
			System.out.println("1. Display Cards Available");
			System.out.println("2. Stop Game");
		
			System.out.println("Chance for Player..." + player[i].getname() );
			System.out.println("Please provide your option: " );
			
			choice1 = getChoice(String.valueOf(i));
			
			if(choice1.equals("1")){
				
				selectCard(player,i);
				
			}else if(choice1.equals("2")){
				i += 1;
				
				if(i<=playerno){

					System.out.println("1. Display Cards Available");
					System.out.println("2. Stop Game");
				
					System.out.println("Chance for Player..." + player[i].getname() );
					
					choice1 = getChoice(String.valueOf(i));
					
					if(choice1.equals("1")){
						selectCard(player,i);
					}else if(choice1.equals("2")){
						i += 1;
						
						if(i<=playerno){
							System.out.println("1. Display Cards Available");
							System.out.println("2. Stop Game");
						
							System.out.println("Chance for Player..." + player[i].getname() );
							choice1 = getChoice(String.valueOf(i));
						}
						
						if(choice1.equals("1")){
							selectCard(player,i);
						}else if(choice1.equals("2")){
						i += 1;
						
						if(i<=playerno){
							System.out.println("1. Display Cards Available");
							System.out.println("2. Stop Game");
			
							System.out.println("Chance for Player..." + player[i].getname() );
							choice1 = getChoice(String.valueOf(i));
						}
						 if(choice1.equals("1")){
							selectCard(player,i);
						}
					}
				}		
			}
		}	
	}
		 maps = list.toArray(new HashMap[list.size()]);
					comparecard(maps);
					list.clear();
	}
		showWinner();
		System.out.println();
		System.out.println("GAME OVER");
		
	// ask player whether want to continue or not after 7 rounds
	String g1="";
	
	while(!g1.equals("1") && !g1.equals("2")){
		System.out.println();
		System.out.println("1. Start a new Game ");
		System.out.println("2. Terminate Game");
		g1 = input.next();
	
	
	if(g1.equals("1")){
		playGame();
	
	}else if(g1.equals("2")){
		System.exit(0); //terminate program
	}
	}	
}
	
	//FUNCTION2 : Comparecard 
	public void comparecard(Map[] m){
		
		//set rank index and set suit index, from lowest to largest
		//Lowest rank = 2, highest rank = Aces
		for(int i = 0; i< m.length;i++){
			for(int p =1; p<=playerno;p++){
			if(m[i].containsKey(player[p])){
				if(m[i].get(player[p]).toString().substring(6,8).equals("Ac")){
					player[p].setrank(13);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("2 ")){
					player[p].setrank(1);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("Ja")){
					player[p].setrank(10);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("Qu")){
					player[p].setrank(11);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("Ki")){
					player[p].setrank(12);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("3 ")){
					player[p].setrank(2);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("4 ")){
					player[p].setrank(3);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("5 ")){
					player[p].setrank(4);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("6 ")){
					player[p].setrank(5);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("7 ")){
					player[p].setrank(6);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("8 ")){
					player[p].setrank(7);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("9 ")){
					player[p].setrank(8);
				}else if(m[i].get(player[p]).toString().substring(6,8).equals("10")){
					player[p].setrank(9);
				}
				// highest suit = Spades , Lowest suit = Diamonds
					if(m[i].get(player[p]).toString().contains("Diamonds")){
						player[p].setsuit(1);
					}else if(m[i].get(player[p]).toString().contains("Clubs")){
						player[p].setsuit(2);
					}else if(m[i].get(player[p]).toString().contains("Hearts")){
						player[p].setsuit(3);
					}else if(m[i].get(player[p]).toString().contains("Spades")){
						player[p].setsuit(4);
					}
				}
			}
		}
		
		if(m.length >= 2){
			
			int[] a = new int[4];
			int[] temp = new int[4];
			// determine rank of player and store in temp
			for(int i=1;i<=playerno;i++){
				
				a[i-1]  = player[i].getrank();
				temp[i-1] = a[i-1];
			}

			Arrays.sort(temp);	
			
			int count =0;
			int samerank=0;
			//determine duplicate rank, and store in samerank
			for(int i=0;i<4;i++){
				for(int j = i+1 ; j<4;j++){
					if(temp[i] == temp[j]){
						count++;
					}
					if(count == 1){
					samerank = temp[i];
					count = 0;
					}
				}
			}
			
			int[] q = new int[4];
			int[] tempq = new int[4];
			// player rank == duplicate rank , store suit into q[]
			for(int i=1;i<=playerno;i++){
			if(player[i].getrank() == samerank ){
				q[i-1] = player[i].getsuit();
				tempq[i-1] = q[i-1];
				}
			}
			
			Arrays.sort(tempq);
					
			if(playerno == 2){
				//player rank is the highest rank, and not duplicate rank and not equal to 0, add score
				if(player[1].getrank() == temp[3] && player[1].getrank() != samerank
				&& player[1].getrank() != 0){
					player[1].setaddscore(1);
				//player rank is the highest rank, duplicate rank,highest suit and not equal to 0, add score
				}else if(player[1].getrank() == temp[3] && player[1].getrank() == samerank
						&& player[1].getsuit() == tempq[3] && player[1].getrank() != 0 ){
					player[1].setaddscore(1);
				}else if(player[2].getrank() == temp[3] && player[2].getrank() != samerank
				&& player[2].getrank() != 0){
					player[2].setaddscore(1);
				}else if(player[2].getrank() == temp[3] && player[2].getrank() == samerank
						&& player[2].getsuit() == tempq[3] && player[2].getrank() != 0 ){
					player[2].setaddscore(1);
				}else if(player[3].getrank() == temp[3] && player[3].getrank() != samerank
				&& player[3].getrank() != 0){
					player[3].setaddscore(1);
				}else if(player[3].getrank() == temp[3] && player[3].getrank() == samerank
						&& player[3].getsuit() == tempq[3] && player[3].getrank() != 0 ){
					player[3].setaddscore(1);
				}else if(player[4].getrank() == temp[3] && player[4].getrank() != samerank
				&& player[4].getrank() != 0){
					player[4].setaddscore(1);
				}else if(player[4].getrank() == temp[3] && player[4].getrank() == samerank
						&& player[4].getsuit() == tempq[3] && player[4].getrank() != 0 ){
					player[4].setaddscore(1);
				}
			}
			
			else if(playerno == 3){
				//if player gets highest rank,samerank,rank not equal to 0 and highest suit,add score
				if(player[1].getrank() == temp[3] && player[1].getrank() == samerank 
					&& player[1].getsuit() == tempq[3] && player[1].getrank() !=0){
					player[1].setaddscore(1);
				}// player gets highest rank,not samerank, not euqal to 0
				else if(player[1].getrank() == temp[3] && player[1].getrank() != samerank 
						&& player[1].getrank() != 0){
						player[1].setaddscore(1);
						
				}else if(player[2].getrank() == temp[3] && player[2].getrank() == samerank 
						&& player[2].getsuit() == tempq[3] && player[2].getrank() !=0){
						player[2].setaddscore(1);
				}else if(player[2].getrank() == temp[3] && player[2].getrank() != samerank 
						&& player[2].getrank() != 0){
						player[2].setaddscore(1);
				
				}else if(player[3].getrank() == temp[3] && player[3].getrank() == samerank 
						&& player[3].getsuit() == tempq[3] && player[3].getrank() !=0){
						player[3].setaddscore(1);
				}else if(player[3].getrank() == temp[3] && player[3].getrank() != samerank 
						&& player[3].getrank() != 0){
						player[3].setaddscore(1);
				}
				else if(player[4].getrank() == temp[3] && player[4].getrank() == samerank 
						&& player[4].getsuit() == tempq[3] && player[4].getrank() !=0){
						player[4].setaddscore(1);
				}else if(player[4].getrank() == temp[3] && player[4].getrank() != samerank 
						&& player[4].getrank() != 0){
						player[4].setaddscore(1);
				}			
			}
			
			else if(playerno == 4){
				// all 4 player gets same rank, compare suit
				if(player[1].getrank() == temp[3] && player[1].getrank() == samerank 
					&& player[1].getrank() != 0 && player[1].getsuit() == tempq[3]){
					player[1].setaddscore(1);
				}
				else if(player[1].getrank() == temp[3] && player[1].getrank() != samerank
						&& player[1].getrank() != 0){
					player[1].setaddscore(1);
				}
				else if(player[2].getrank() == temp[3] && player[2].getrank() == samerank 
						&& player[2].getrank() != 0 && player[2].getsuit() == tempq[3]){
						player[2].setaddscore(1);
				}
				else if(player[2].getrank() == temp[3] && player[2].getrank() != samerank
							&& player[2].getrank() != 0){
						player[2].setaddscore(1);
				}
				else if(player[3].getrank() == temp[3] && player[3].getrank() == samerank 
						&& player[3].getrank() != 0 && player[3].getsuit() == tempq[3]){
						player[3].setaddscore(1);
				}
				else if(player[3].getrank() == temp[3] && player[3].getrank() != samerank
							&& player[3].getrank() != 0){
						player[3].setaddscore(1);
				}
				else 	if(player[4].getrank() == temp[3] && player[4].getrank() == samerank 
						&& player[4].getrank() != 0 && player[4].getsuit() == tempq[3]){
						player[4].setaddscore(1);
				}
				else if(player[4].getrank() == temp[3] && player[4].getrank() != samerank
						&& player[4].getrank() != 0){
						player[4].setaddscore(1);
				}
			}
		
					// show score , set array value to 0
					showScore();
					Arrays.fill(temp, 0);
					Arrays.fill(a, 0);
					Arrays.fill(q, 0);
					Arrays.fill(tempq,0);
		
	}
		if(m.length == 1){ // 1 player
					if(m[0].containsKey(player[1])){
					player[1].setaddscore(1);
					showScore();
					}else if(m[0].containsKey(player[2])){
						player[2].setaddscore(1);
						showScore();
					}else if(m[0].containsKey(player[3])){
						player[3].setaddscore(1);
						showScore();
					}else if(m[0].containsKey(player[4])){
						player[4].setaddscore(1);
						showScore();
					}
			}else if(m.length == 0){  // No player
				showScore();
			}  
	}
	

	
	
	// FUNCTION3 : showScore
	public void showScore(){
		System.out.println();
		for(int i =1;i<=playerno;i++){
		System.out.println(player[i]);	
		}
	}
	
	// FUNCTION4 : showWinner
	public void showWinner(){
		System.out.println();
		
		int[] winner = new int[4];
		int [] tempwinner = new int[4];
		int duplicatescore = 0;
		for(int i=1;i<=playerno;i++){
			winner[i-1] = player[i].getscore();
			tempwinner[i-1] = winner[i-1];
		}
		Arrays.sort(tempwinner);
		
		int count=0;
		
		// determine duplicate score and store into duplicatescore
		for(int i=0;i<tempwinner.length;i++){
			for(int j=i+1;j<tempwinner.length;j++){
				if(tempwinner[i] == tempwinner[j]){
					count++;
				}
				if(count == 1){
					duplicatescore = tempwinner[i];
					count = 0;
				}
			}
		}
	
		for(int i =1;i<=playerno;i++){
			// Only 1 highest and no duplicate score exists, show 1 winner
			if(player[i].getscore() == tempwinner[3] && player[i].getscore() != 0 
				&& tempwinner[3] != 0 && tempwinner[3] != duplicatescore){
				System.out.println("Congratulations!!! The Winner is " + player[i].getname());
				// Multiple players gets same score , multiple winners
			}else if(player[i].getscore() == tempwinner[3] && player[i].getscore() != 0 
				&& tempwinner[3] != 0 && tempwinner[3] == duplicatescore){
				System.out.println("Congratulations!!! The Winner are " + player[i].getname());
				
				// All players gets 0 score, no winner
			}else if(player[i].getscore() == tempwinner[3] && player[i].getscore() == 0 
					&& tempwinner[3] == 0 && tempwinner[3] == duplicatescore){
				System.out.println("No Winner!!! Player "+ player[i].getname() +" gets "+ player[i].getscore());
			}
		}
	}
	
	// FUNCTION 5 : mapPlayerCard
	public void mapPlayerCard(Player p,Card c){
		Map<Player,Card> hm1 = new HashMap<Player,Card>();
		Map<Player,Card> hm2 = new HashMap<Player,Card>();
		Map<Player,Card> hm3 = new HashMap<Player,Card>();
		Map<Player,Card> hm4 = new HashMap<Player,Card>();
	
		
		if(p.getnumber() == 1){	
			hm1.put(p, c);
			list.add(hm1);
		}else if(p.getnumber() == 2){
			hm2.put(p, c);
			list.add(hm2);		
		}else if(p.getnumber() == 3){		
			hm3.put(p, c);
			list.add(hm3);
		}else if(p.getnumber() == 4){
			hm4.put(p, c);
			list.add(hm4);
		}
	}
	
	String club = "Clubs";
	String diamond = "Diamonds";
	String heart = "Hearts";
	String spade = "Spades";

	// FUNCTION 6 : getNoplayer
	public String getNoPlayer(){
	String playernum;

	System.out.println("Provide the Number of Players( should be grater than 1 and less than 4 )");
		
		playernum = input.next();
		
		while(  !playernum.equals("2") && !playernum.equals("3") && !playernum.equals("4") )
		{
			System.out.println("Provide the Number of Players( should be grater than 1 and less than 4 )");
			playernum = input.next();
		}
		return playernum;
	}
	
	// FUNCTION 7 : createMultiPlayer
	public Player[] createMultiPlayer(int playerno){
		//return player;
		return new Player[playerno+1];
	}
	
	// FUNCTION 8 : getChoice
	public String getChoice(String i){
		String choice;
		choice = input.next();
		int nameindex = Integer.parseInt(i);
		while(!choice.equals("1") && !choice.equals("2")){
		System.out.println("1. Display Cards Available");
		System.out.println("2. Stop Game"); 
		System.out.println("Chance for Player..." + player[nameindex].getname() );
		System.out.println("Please provide your option: " );
		choice = input.nextLine();
		}
		return choice;
	}
	
	// FUNCTION 9 : selectCard
	public void selectCard(Player[] player,int i){
		
		System.out.println("1 2 3 4 Select your card number");
		cardNumber = input.next();
		
		while(!cardNumber.equals("1") && !cardNumber.equals("2") && !cardNumber.equals("3")
				&& !cardNumber.equals("4"))
		{
			System.out.println("1 2 3 4 Select your card number");
			cardNumber = input.next();
		}
			
			card.showcard();
			
			if(i == 1){
			mapPlayerCard(player[i],cards[getindex1(i)] = new Card(card.getRank(),card.getSuit()));  
			}else if(i == 2){
				mapPlayerCard(player[i],cards[getindex2(i)] = new Card(card.getRank(),card.getSuit()));  
			}else if(i == 3){
				mapPlayerCard(player[i],cards[getindex3(i)] = new Card(card.getRank(),card.getSuit()));  
			}else if(i == 4){
				mapPlayerCard(player[i],cards[getindex4(i)] = new Card(card.getRank(),card.getSuit()));  
			}
			System.out.println("");
	}

	int index1 = 0;
	int index2 = 0;
	int index3 = 0;
	int index4 = 0;

	//FUNCTION 10 : getindex
	// increment index and return index
	public int getindex1(int i){
		return index1++;
	}
	public int getindex2(int i){
		return index2++;
	}
	public int getindex3(int i){
		return index3++;
	}
	public int getindex4(int i){
		return index4++;
	}
	


	
}		
	