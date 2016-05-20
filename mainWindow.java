//Imports
	import javafx.application.Application;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.image.*;
	import javafx.scene.paint.Color;
	import javafx.scene.paint.CycleMethod;
	import javafx.scene.paint.LinearGradient;
	import javafx.scene.paint.Stop;
	import javafx.scene.shape.Rectangle;
	import javafx.scene.text.Font;
	import javafx.scene.text.FontWeight;
	import javafx.scene.text.Text;
	import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.scene.control.*;
	import javafx.stage.*;
	import javafx.scene.*;
	import javafx.scene.layout.*;
	import javafx.scene.control.*;
	import javafx.geometry.*;
	import javafx.scene.shape.*;
	import javafx.scene.effect.*;
	import javafx.scene.paint.*;
	import javafx.scene.text.*;

	import java.util.*;
	import javafx.collections.FXCollections;
	import javafx.collections.ListChangeListener;
	import javafx.collections.ObservableList;

public class MainWindow extends Application {

	public static int ct = 1;
	public static boolean enableAI = false;
	public static String humanPlyr = "Player 1";
	public static String compPlyr = "Player 2";
	public static ArrayList<TTTSquare> buttonList = new ArrayList<TTTSquare>();
	public static Text turnLabel = new Text("Start a New Game to Play");

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {

		BorderPane window = new BorderPane();
		window.setPrefSize(600, 500);
		window.setStyle("-fx-background-color: #007FFF;");

		//Top Portion
			BorderPane titleBox = new BorderPane();

				Text titleLabel = new Text("Tic Tac Plus");
				titleLabel.setFont(new Font("Verdana", 40));
				titleLabel.setFont(Font.font(null, FontWeight.BOLD, 40));

				Button newGameButton = new Button("New Game");
				newGameButton.setStyle("-fx-font: 14 verdana; -fx-base: #7fd87f;");
				newGameButton.setPrefSize(100, 40);

				Button optionButton = new Button("Options");
				optionButton.setStyle("-fx-font: 14 verdana; -fx-base: #D3D3D3;");
				optionButton.setPrefSize(100, 40);

			titleBox.setCenter(titleLabel);
			titleBox.setRight(optionButton);
			titleBox.setLeft(newGameButton);
			titleBox.setStyle("-fx-background-color: #E3E3E3;");
			titleBox.setPadding(new Insets(10,10,10,10));
		
		window.setTop(titleBox);

		//TTT Button Grid
			HBox buttonGrid = new HBox();

				int buttonGridDim = 125;

				VBox buttonGridBox = new VBox(10);

					//Top Row
						HBox topRow = new HBox(10);
							TTTSquare oneA = new TTTSquare(buttonGridDim, turnLabel);
							TTTSquare oneB = new TTTSquare(buttonGridDim, turnLabel);
							TTTSquare oneC = new TTTSquare(buttonGridDim, turnLabel);
						topRow.getChildren().addAll(oneA.button(), oneB.button(), oneC.button());
						topRow.setAlignment(Pos.CENTER);

					//Middle Row
						HBox middleRow = new HBox(10);
							TTTSquare twoA = new TTTSquare(buttonGridDim, turnLabel);
							TTTSquare twoB = new TTTSquare(buttonGridDim, turnLabel);
							TTTSquare twoC = new TTTSquare(buttonGridDim, turnLabel);
						middleRow.getChildren().addAll(twoA.button(), twoB.button(), twoC.button());
						middleRow.setAlignment(Pos.CENTER);

					//Bottom Row
						HBox bottomRow = new HBox(10);
							TTTSquare threeA = new TTTSquare(buttonGridDim, turnLabel);
							TTTSquare threeB = new TTTSquare(buttonGridDim, turnLabel);
							TTTSquare threeC = new TTTSquare(buttonGridDim, turnLabel);
						bottomRow.getChildren().addAll(threeA.button(), threeB.button(), threeC.button());
						bottomRow.setAlignment(Pos.CENTER);

				buttonGridBox.getChildren().addAll(topRow, middleRow, bottomRow);
				buttonGridBox.setStyle("-fx-background-color: #000000;");

				buttonList.add(oneA);
					buttonList.add(twoA);
					buttonList.add(threeA);
					buttonList.add(oneB);
					buttonList.add(twoB);
					buttonList.add(threeB);
					buttonList.add(oneC);
					buttonList.add(twoC);
					buttonList.add(threeC);

				for (int i = 0; i < buttonList.size(); i++) {
					buttonList.get(i).button().setDisable(true);
					buttonList.get(i).button().setText("");
				}


			buttonGrid.getChildren().addAll(buttonGridBox);
			buttonGrid.setAlignment(Pos.CENTER);
			buttonGrid.setStyle("-fx-background-color: #007FFF;");
			buttonGrid.setPadding(new Insets(10,10,10,10));

		window.setCenter(buttonGrid);

		//Bottom Layout
			HBox bottomBoxPrev = new HBox(10);

				turnLabel.setFont(new Font("Verdana", 30));
				turnLabel.setFont(Font.font(null, FontWeight.BOLD, 30));

			bottomBoxPrev.getChildren().addAll(turnLabel);
			bottomBoxPrev.setPadding(new Insets(10,10,10,10));
			bottomBoxPrev.setAlignment(Pos.CENTER);
			bottomBoxPrev.setStyle("-fx-background-color: #ffd27f");

		window.setBottom(bottomBoxPrev);

		//Options Window
			final Stage optionStage = new Stage();

				BorderPane optionsWindow = new BorderPane();

					Text optionsTitle = new Text("Options");
					optionsTitle.setFont(new Font("Verdana", 20));
					optionsTitle.setFont(Font.font(null, FontWeight.BOLD, 25));
					optionsWindow.setTop(optionsTitle);

					VBox optionsBox = new VBox(40);

						VBox playerSelectBox = new VBox(5);
							Text playerSelectText = new Text("Who will you play as?");
							playerSelectText.setFont(Font.font(null, FontWeight.BOLD, 15));
							final ToggleGroup playerBtnGroup = new ToggleGroup();
								RadioButton playerOneBtn = new RadioButton("Player 1 (X)");
									playerOneBtn.setToggleGroup(playerBtnGroup);
									playerOneBtn.setSelected(true);
								RadioButton playerTwoBtn = new RadioButton("Player 2 (O)");
									playerTwoBtn.setToggleGroup(playerBtnGroup);
						playerSelectBox.getChildren().addAll(playerSelectText, playerOneBtn, playerTwoBtn);
						playerSelectBox.setAlignment(Pos.CENTER);


						VBox difficultySelectBox = new VBox(10);
							Text difficultySelectText = new Text("Select a difficulty");
							difficultySelectText.setFont(Font.font(null, FontWeight.BOLD, 15));
							ComboBox difficultyBox = new ComboBox();
								difficultyBox.getItems().addAll("Easy", "Medium", "Hard");
								difficultyBox.setValue("Easy");
								difficultyBox.setDisable(false);

							CheckBox compCheck = new CheckBox("Play against the Computer");
							compCheck.setSelected(true);

								compCheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
								    @Override
								    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
								        if (compCheck.isSelected()) {
								        	difficultyBox.setDisable(false);
								        } else {
								        	difficultyBox.setDisable(true);
								        }
								    }
								});
						difficultySelectBox.getChildren().addAll(compCheck,difficultySelectText,difficultyBox);
						difficultySelectBox.setAlignment(Pos.CENTER);

					optionsBox.getChildren().addAll(playerSelectBox, difficultySelectBox);
					optionsBox.setAlignment(Pos.CENTER);
					optionsBox.setPadding(new Insets(5,5,5,5));

				optionsWindow.setPrefSize(250, 250);
				optionsWindow.setCenter(optionsBox);
				optionsWindow.setAlignment(optionsTitle, Pos.CENTER);

			Scene optionScene = new Scene(optionsWindow);
			optionStage.setScene(optionScene);
			optionStage.setResizable(false);

		//Set Scene

			Scene scene = new Scene(window);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Shitty Tic Tac Toe Game");
			stage.show();
	
		//Functionality
			optionButton.setOnAction(e -> {
				optionStage.show();
			});

			newGameButton.setOnAction(e -> {
				resetIncrement();

				//Set Button Settings

					buttonList.clear();
					buttonList.add(oneA);
					buttonList.add(twoA);
					buttonList.add(threeA);
					buttonList.add(oneB);
					buttonList.add(twoB);
					buttonList.add(threeB);
					buttonList.add(oneC);
					buttonList.add(twoC);
					buttonList.add(threeC);

					for (int i = 0; i < buttonList.size(); i++) {
						buttonList.get(i).button().setDisable(false);
						buttonList.get(i).button().setText("");
					}

				//Edit bottom panel
					turnLabel.setText("Player 1 (X) to move!");

				//Activating the AI
					if (compCheck.isSelected()) {
						if (playerTwoBtn.isSelected()) {
							humanPlyr = "Player 2";
							compPlyr = "Player 1";
						}
						//initializeAI(humanPlyr);
					}
			});
	}

	public static void increment() {
		ct = ct + 1;
	}

	public static int getIncrement() {
		return ct;
	}

	public static void resetIncrement() {
		ct = 0;
	}

	public static void makeTurnChanges(Text turnLabel, boolean turnTracker) {
		turnLabel.setText(turnTracker ? "Player 2 (O) to move!" : "Player 1 (X) to move!");
	}

	public static void evalBoard(Text turnLabel) {
		
		//Horizontal
		String a = buttonList.get(0).button().getText() + buttonList.get(1).button().getText() + buttonList.get(2).button().getText();
		String b = buttonList.get(3).button().getText() + buttonList.get(4).button().getText() + buttonList.get(5).button().getText();
		String c = buttonList.get(6).button().getText() + buttonList.get(7).button().getText() + buttonList.get(8).button().getText();

		//Vertical
		String d = buttonList.get(0).button().getText() + buttonList.get(3).button().getText() + buttonList.get(6).button().getText();
		String e = buttonList.get(1).button().getText() + buttonList.get(4).button().getText() + buttonList.get(7).button().getText();
		String f = buttonList.get(2).button().getText() + buttonList.get(5).button().getText() + buttonList.get(8).button().getText();

		//Diagonal
		String g = buttonList.get(0).button().getText() + buttonList.get(4).button().getText() + buttonList.get(8).button().getText();
		String h = buttonList.get(2).button().getText() + buttonList.get(4).button().getText() + buttonList.get(6).button().getText();

		//boolean
		boolean xWins = false;
		boolean oWins = false;
		boolean tie = false;
		if ((a.equals("XXX")) || (b.equals("XXX")) || (c.equals("XXX")) || (d.equals("XXX")) || (e.equals("XXX")) || (f.equals("XXX")) || (g.equals("XXX")) || (h.equals("XXX"))) {
			xWins = true;
			turnLabel.setText("Player 1 (X) Wins!");
			for (int i = 0; i < buttonList.size(); i++) {
				buttonList.get(i).button().setDisable(true);
			}
		} else if ((a.equals("OOO")) || (b.equals("OOO")) || (c.equals("OOO")) || (d.equals("OOO")) || (e.equals("OOO")) || (f.equals("OOO")) || (g.equals("OOO")) || (h.equals("OOO"))) {
			oWins = true;
			turnLabel.setText("Player 2 (O) Wins!");
			for (int i = 0; i < buttonList.size(); i++) {
				buttonList.get(i).button().setDisable(true);
			}
		} else if (getIncrement() == 9) {
			tie = true;
			turnLabel.setText("It's a Tie!");
			for (int i = 0; i < buttonList.size(); i++) {
				buttonList.get(i).button().setDisable(true);
			}
		}

	}

	public static int[][] boardToMatrix(ArrayList<TTTSquare> buttonList) {
		int[][] boardArray = new int[3][3];
		int j = 0;
		int k = 0;
		for (int i = 0; i < buttonList.size(); i++) {
			String marker = buttonList.get(i).button().getText();
			if (marker.equals("X")) {
				boardArray[j][k] = 1;
			} else if (marker.equals("O")) {
				boardArray[j][k] = 0;
			} else {
				boardArray[j][k] = -1;
			}
			
			//Bump to the next column
			j = j + 1;
			if (j > 2) {
				k = k + 1;
				j = 0;
			}
		}

		return boardArray;
	}

	public static void intializeAI(String human) {
		enableAI = true;
	}
}