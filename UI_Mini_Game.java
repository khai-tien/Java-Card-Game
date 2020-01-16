import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI_Mini_Game extends Application{

	Player player = new Player();
	
	Card card = new Card();

	@Override
	public void start(Stage primaryStage) {
		// initialize card
		card.initializecard();
		// shuffle card
		card.shufflecard();
		
		/////////////////////////////////////////////////////////////
		// Card Game button
		Button btnstart = new Button("CARD GAME");
		
		VBox vbox2 = new VBox();
		vbox2.setStyle("-fx-border-color: blue");
		vbox2.setPadding(new Insets(5));
		vbox2.setStyle("-fx-background-color: pink");
		vbox2.getChildren().add(btnstart);
		// Click on card game button will call the function in the GameDemo
		btnstart.setOnAction(e->{
			CardGame cardgame = new CardGame();
			primaryStage.close();
			cardgame.playGame();
		});
		/////////////////////////////////////////////////////////////
		TextArea ta = new TextArea();
		ta.setFont(Font.font("Times News Roman",FontWeight.BOLD,30));
		ta.setStyle("-fx-border-color: blue");
		ta.setEditable(false);
		
		HBox hbox3 = new HBox();
		ta.setPrefColumnCount(20);
		ta.setPrefRowCount(2);
		
		Image image = new Image(getClass().getResourceAsStream("images_deck\\animation1.gif"));
		ImageView imgviewani = new ImageView(image);
		imgviewani.setFitHeight(150);
		imgviewani.setFitWidth(600);
		
		hbox3.getChildren().add(ta);
		hbox3.getChildren().add(imgviewani);
		hbox3.setStyle("-fx-border-color: red");
		hbox3.setPadding(new Insets(5));
		hbox3.setStyle("-fx-background-color: black");
		hbox3.setAlignment(Pos.BOTTOM_CENTER);
		//////////////////////////////////////////////////////////////
	
		HBox hbox1 = new HBox();
		TextField tf1 = new TextField();
		hbox1.getChildren().addAll(new Label("Everyone can play  "),tf1);
		tf1.setText("Mini Game before Card Game");
		tf1.setPrefColumnCount(20);
		tf1.setEditable(false);
		hbox1.setStyle("-fx-border-color: red");
		hbox1.setPadding(new Insets(5));
		BorderPane bpane = new BorderPane();
		
		//////////////////////////////////////////////////////////////////////////////
		
		Text txt = new Text();
		txt.setText("Created by");
		Image imgsig = new Image(getClass().getResourceAsStream("images_deck\\chuah_signature.png"));
		ImageView imgviewsig = new ImageView(imgsig);
		Text txt1 = new Text();
		txt1.setText("\n\nTips 1: \nWarm up before go\n to CARD GAME\n");
		Text txt2 = new Text();
		txt2.setText("Tips 2: \nPressed CARD GAME to\n exit this session and start\n the game in CONSOLE\n");
		Text txt3 = new Text();
		txt3.setText("Tips 3: \nPressed RESET to reinitialize\n and suffle the cards\n");
		Text txt4 = new Text(); 
		txt4.setText( "Tips 4: \nPressed EXIT to\n terminate the game");
		
		VBox vbox1 = new VBox();
		vbox1.setPadding(new Insets(5));
		vbox1.setStyle("-fx-border-color: yellow");	
		vbox1.setStyle("-fx-background-color: pink");
		vbox1.getChildren().addAll(txt,imgviewsig,txt1,txt2,txt3,txt4);
		vbox1.setPrefWidth(100);
		/////////////////////////////////////////////////////////////////////////////
		bpane.setStyle("-fx-border-color: green");
		
		GridPane gpane = new GridPane();
		
		Image image1 = new Image(getClass().getResourceAsStream("images_deck\\back.png"));
		Button btn1 = new Button();
		Button btn2 = new Button();
		Button btn3 = new Button();
		Button btn4 = new Button();
		Button btn5 = new Button();
		Button btn6 = new Button();
		Button btn7 = new Button();
		
		// image1 , button 1
		ImageView imgview1 = new ImageView(image1);
		imgview1.setFitHeight(200);
		imgview1.setFitWidth(100);
		btn1.setGraphic(imgview1);
		// click on card button, distribute a card and retrieve card path and show the card
		btn1.setOnAction(e->{
			card.UIshowcard();
			Image image11 = new Image(getClass().getResourceAsStream(card.getpath()));
			imgview1.setImage(image11);
			btn1.setGraphic(imgview1);
			ta.setText("Rank : " + card.getRank() + " Suit : " + card.getSuit());
		});
		
		// image2 , button 2
		Image image2 = new Image(getClass().getResourceAsStream("images_deck\\Back.jpg"));
		
		ImageView imgview2 = new ImageView(image2);
		imgview2.setFitHeight(200);
		imgview2.setFitWidth(100);
		btn2.setGraphic(imgview2);
		// click on card button, distribute a card and retrieve card path and show the card
		btn2.setOnAction(e->{
			card.UIshowcard();
			Image image22 = new Image(getClass().getResourceAsStream(card.getpath()));
			imgview2.setImage(image22);
			btn2.setGraphic(imgview2);
			ta.setText("Rank : " + card.getRank() + " Suit : " + card.getSuit());
		});
		
		// image3 , button 3
		Image image3 = new Image(getClass().getResourceAsStream("images_deck\\back.png"));
		
		ImageView imgview3 = new ImageView(image3);
		imgview3.setFitHeight(200);
		imgview3.setFitWidth(100);
		btn3.setGraphic(imgview3);
		// click on card button, distribute a card and retrieve card path and show the card
		btn3.setOnAction(e->{
			card.UIshowcard();
			Image image33 = new Image(getClass().getResourceAsStream(card.getpath()));
			imgview3.setImage(image33);
			btn3.setGraphic(imgview3);
			ta.setText("Rank : " + card.getRank() + " Suit : " + card.getSuit());
		});
		
		// image4 , button 4
		Image image4 = new Image(getClass().getResourceAsStream("images_deck\\Back.jpg"));
		
		ImageView imgview4 = new ImageView(image4);
		imgview4.setFitHeight(200);
		imgview4.setFitWidth(100);
		btn4.setGraphic(imgview4);
		// click on card button, distribute a card and retrieve card path and show the card
		btn4.setOnAction(e->{
			card.UIshowcard();
			Image image44 = new Image(getClass().getResourceAsStream(card.getpath()));
			imgview4.setImage(image44);
			btn4.setGraphic(imgview4);
			ta.setText("Rank : " + card.getRank() + " Suit : " + card.getSuit());
		});
		
		// image5 , button 5
		Image image5 = new Image(getClass().getResourceAsStream("images_deck\\back.png"));
		
		ImageView imgview5 = new ImageView(image5);
		imgview5.setFitHeight(200);
		imgview5.setFitWidth(100);
		btn5.setGraphic(imgview5);
		// click on card button, distribute a card and retrieve card path and show the card
		btn5.setOnAction(e->{
			card.UIshowcard();
			Image image55 = new Image(getClass().getResourceAsStream(card.getpath()));
			imgview5.setImage(image55);
			btn5.setGraphic(imgview5);
			ta.setText("Rank : " + card.getRank() + " Suit : " + card.getSuit());
		});
		
		// image6 , button 6
		Image image6 = new Image(getClass().getResourceAsStream("images_deck\\Back.jpg"));
		
		ImageView imgview6 = new ImageView(image6);
		imgview6.setFitHeight(200);
		imgview6.setFitWidth(100);
		btn6.setGraphic(imgview6);
		// click on card button, distribute a card and retrieve card path and show the card
		btn6.setOnAction(e->{
			card.UIshowcard();
			Image image66 = new Image(getClass().getResourceAsStream(card.getpath()));
			imgview6.setImage(image66);
			btn6.setGraphic(imgview6);
			ta.setText("Rank : " + card.getRank() + " Suit : " + card.getSuit());
		});
		
		// image7 , button 7
		Image image7 = new Image(getClass().getResourceAsStream("images_deck\\back.png"));
		
		ImageView imgview7 = new ImageView(image7);
		imgview7.setFitHeight(200);
		imgview7.setFitWidth(100);
		btn7.setGraphic(imgview7);
		// click on button, distribute a card and retrieve card path and show the card
		btn7.setOnAction(e->{
			card.UIshowcard();
			Image image77 = new Image(getClass().getResourceAsStream(card.getpath()));
			imgview7.setImage(image77);
			btn7.setGraphic(imgview7);
			ta.setText("Rank : " + card.getRank() + " Suit : " + card.getSuit());
		});
		
		gpane.add(btn1, 0, 0);
		gpane.add(btn2, 1, 0);
		gpane.add(btn3, 2, 0);
		gpane.add(btn4, 3, 0);
		gpane.add(btn5, 4, 0);
		gpane.add(btn6, 5, 0);
		gpane.add(btn7, 6, 0);
		gpane.setHgap(10);
	
		/////////////////////////////////////////////////////////
		Button btnreset = new Button("RESET");
		btnreset.setPrefWidth(80);
		//Show back side of card
		Image img1 = new Image(getClass().getResourceAsStream("images_deck\\Back.jpg"));
		ImageView imgviewreset1 = new ImageView();
		imgviewreset1.setImage(img1);
		imgviewreset1.setFitHeight(200);
		imgviewreset1.setFitWidth(100);
		//Show back side of card
		ImageView imgviewreset2 = new ImageView();
		imgviewreset2.setImage(new Image(getClass().getResourceAsStream("images_deck\\back.png")));
		imgviewreset2.setFitHeight(200);
		imgviewreset2.setFitWidth(100);
		//Show back side of card
		ImageView imgviewreset3 = new ImageView();
		imgviewreset3.setImage(new Image(getClass().getResourceAsStream("images_deck\\Back.jpg")));
		imgviewreset3.setFitHeight(200);
		imgviewreset3.setFitWidth(100);
		//Show back side of card
		ImageView imgviewreset4 = new ImageView();
		imgviewreset4.setImage(new Image(getClass().getResourceAsStream("images_deck\\back.png")));
		imgviewreset4.setFitHeight(200);
		imgviewreset4.setFitWidth(100);
		//Show back side of card
		ImageView imgviewreset5 = new ImageView();
		imgviewreset5.setImage(new Image(getClass().getResourceAsStream("images_deck\\Back.jpg")));
		imgviewreset5.setFitHeight(200);
		imgviewreset5.setFitWidth(100);
		//Show back side of card
		ImageView imgviewreset6 = new ImageView();
		imgviewreset6.setImage(new Image(getClass().getResourceAsStream("images_deck\\back.png")));
		imgviewreset6.setFitHeight(200);
		imgviewreset6.setFitWidth(100);
		//Show back side of card
		ImageView imgviewreset7 = new ImageView();
		imgviewreset7.setImage(new Image(getClass().getResourceAsStream("images_deck\\Back.jpg")));
		imgviewreset7.setFitHeight(200);
		imgviewreset7.setFitWidth(100);
		
		vbox2.getChildren().add(btnreset);
		vbox2.setSpacing(50);
		
		btnreset.setOnAction(e->{
			btn1.setGraphic(imgviewreset1);
			btn2.setGraphic(imgviewreset2);
			btn3.setGraphic(imgviewreset3);
			btn4.setGraphic(imgviewreset4);
			btn5.setGraphic(imgviewreset5);
			btn6.setGraphic(imgviewreset6);
			btn7.setGraphic(imgviewreset7);
			ta.setText("");
		});
		
		// exit button
		Button btnexit = new Button("EXIT");
		btnexit.setPrefWidth(80);
		vbox2.getChildren().add(btnexit);
		btnexit.setOnAction(e->{
			primaryStage.close();
			System.exit(0);
		});

		HBox hbox2 = new HBox();
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setPadding(new Insets(10));
		hbox2.getChildren().add(gpane);
		hbox2.setStyle("-fx-background-color: green");
		bpane.setBottom(hbox3);
		bpane.setRight(vbox2);
		bpane.setTop(hbox1);
		bpane.setCenter(hbox2);
		bpane.setLeft(vbox1);
	
		Scene scene = new Scene(bpane,1300,600);
		
		primaryStage.setTitle("Card Game");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
	}
	public static void main(String[] args){
		launch(args);
	}
	
}
