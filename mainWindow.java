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

public class mainWindow extends Application {

	public static int ct = 1;

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

				Text titleLabel = new Text("Tic Tac Something");
				titleLabel.setFont(new Font("Verdana", 30));
				titleLabel.setFont(Font.font(null, FontWeight.BOLD, 30));

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
							Button oneA = new Button();
								oneA.setPrefSize(buttonGridDim, buttonGridDim);
								oneA.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
							Button oneB = new Button();
								oneB.setPrefSize(buttonGridDim, buttonGridDim);
								oneB.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
							Button oneC = new Button();
								oneC.setPrefSize(buttonGridDim, buttonGridDim);
								oneC.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
						topRow.getChildren().addAll(oneA, oneB, oneC);
						topRow.setAlignment(Pos.CENTER);

					//Middle Row
						HBox middleRow = new HBox(10);
							Button twoA = new Button();
								twoA.setPrefSize(buttonGridDim, buttonGridDim);
								twoA.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
							Button twoB = new Button();
								twoB.setPrefSize(buttonGridDim, buttonGridDim);
								twoB.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
							Button twoC = new Button();
								twoC.setPrefSize(buttonGridDim, buttonGridDim);
								twoC.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
						middleRow.getChildren().addAll(twoA, twoB, twoC);
						middleRow.setAlignment(Pos.CENTER);

					//Bottom Row
						HBox bottomRow = new HBox(10);
							Button threeA = new Button();
								threeA.setPrefSize(buttonGridDim, buttonGridDim);
								threeA.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
							Button threeB = new Button();
								threeB.setPrefSize(buttonGridDim, buttonGridDim);
								threeB.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
							Button threeC = new Button();
								threeC.setPrefSize(buttonGridDim, buttonGridDim);
								threeC.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
						bottomRow.getChildren().addAll(threeA, threeB, threeC);
						bottomRow.setAlignment(Pos.CENTER);

				buttonGridBox.getChildren().addAll(topRow, middleRow, bottomRow);
				buttonGridBox.setStyle("-fx-background-color: #000000;");

				oneA.setDisable(true);
				oneB.setDisable(true);
				oneC.setDisable(true);
				twoA.setDisable(true);
				twoB.setDisable(true);
				twoC.setDisable(true);
				threeA.setDisable(true);
				threeB.setDisable(true);
				threeC.setDisable(true);

				oneA.setText("");
				oneB.setText("");
				oneC.setText("");
				twoA.setText("");
				twoB.setText("");
				twoC.setText("");
				threeA.setText("");
				threeB.setText("");
				threeC.setText("");

			buttonGrid.getChildren().addAll(buttonGridBox);
			buttonGrid.setAlignment(Pos.CENTER);
			buttonGrid.setStyle("-fx-background-color: #007FFF;");
			buttonGrid.setPadding(new Insets(10,10,10,10));

		window.setCenter(buttonGrid);

		//Bottom Layout
			HBox bottomBoxPrev = new HBox(10);

				Text turnLabel = new Text("Start a New Game to Play");
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
			stage.setTitle("Bad Tic Tac Toe Game");
			stage.show();
	
		//Functionality
			optionButton.setOnAction(e -> {
				optionStage.show();
			});

			ArrayList<Button> buttonList = new ArrayList<Button>();

			newGameButton.setOnAction(e -> {
				resetIncrement();

				//Set Button Settings

					oneA.setDisable(false);
					oneB.setDisable(false);
					oneC.setDisable(false);
					twoA.setDisable(false);
					twoB.setDisable(false);
					twoC.setDisable(false);
					threeA.setDisable(false);
					threeB.setDisable(false);
					threeC.setDisable(false);

					oneA.setText("");
					oneB.setText("");
					oneC.setText("");
					twoA.setText("");
					twoB.setText("");
					twoC.setText("");
					threeA.setText("");
					threeB.setText("");
					threeC.setText("");
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

				//Edit bottom panel
					turnLabel.setText("Player 1 (X) to move!");
			});

			oneA.setOnAction(k -> {
				makeTurnChanges(oneA, turnLabel);
				evalBoard(buttonList, turnLabel);
			});

			oneB.setOnAction(k -> {
				makeTurnChanges(oneB, turnLabel);
				evalBoard(buttonList, turnLabel);
			});

			oneC.setOnAction(k -> {
				makeTurnChanges(oneC, turnLabel);
				evalBoard(buttonList, turnLabel);
			});

			twoA.setOnAction(k -> {
				makeTurnChanges(twoA, turnLabel);
				evalBoard(buttonList, turnLabel);
			});

			twoB.setOnAction(k -> {
				makeTurnChanges(twoB, turnLabel);
				evalBoard(buttonList, turnLabel);
			});

			twoC.setOnAction(k -> {
				makeTurnChanges(twoC, turnLabel);
				evalBoard(buttonList, turnLabel);
			});

			threeA.setOnAction(k -> {
				makeTurnChanges(threeA, turnLabel);
				evalBoard(buttonList, turnLabel);
			});

			threeB.setOnAction(k -> {
				makeTurnChanges(threeB, turnLabel);
				evalBoard(buttonList, turnLabel);
			});

			threeC.setOnAction(k -> {
				makeTurnChanges(threeC, turnLabel);
				evalBoard(buttonList, turnLabel);
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

	public static void makeTurnChanges(Button btn, Text turnLabel) {
		if (btn.getText().equals("")) {
			increment();
			int counter = getIncrement();
			if (!((counter & 1) == 0)) {
				btn.setText("X");
				turnLabel.setText("Player 2 (O) to move!");
			} else {
				btn.setText("O");
				turnLabel.setText("Player 1 (X) to move!");
			}
		}
	}

	public static void evalBoard(ArrayList<Button> buttonList, Text turnLabel) {
		
		//Horizontal
		String a = buttonList.get(0).getText() + buttonList.get(1).getText() + buttonList.get(2).getText();
		String b = buttonList.get(3).getText() + buttonList.get(4).getText() + buttonList.get(5).getText();
		String c = buttonList.get(6).getText() + buttonList.get(7).getText() + buttonList.get(8).getText();

		//Vertical
		String d = buttonList.get(0).getText() + buttonList.get(3).getText() + buttonList.get(6).getText();
		String e = buttonList.get(1).getText() + buttonList.get(4).getText() + buttonList.get(7).getText();
		String f = buttonList.get(2).getText() + buttonList.get(5).getText() + buttonList.get(8).getText();

		//Diagonal
		String g = buttonList.get(0).getText() + buttonList.get(4).getText() + buttonList.get(8).getText();
		String h = buttonList.get(2).getText() + buttonList.get(4).getText() + buttonList.get(6).getText();

		//boolean
		boolean xWins = false;
		boolean oWins = false;
		boolean tie = false;
		if ((a.equals("XXX")) || (b.equals("XXX")) || (c.equals("XXX")) || (d.equals("XXX")) || (e.equals("XXX")) || (f.equals("XXX")) || (g.equals("XXX")) || (h.equals("XXX"))) {
			xWins = true;
			turnLabel.setText("Player 1 (X) Wins!");
			for (int i = 0; i < buttonList.size(); i++) {
				buttonList.get(i).setDisable(true);
			}
		} else if ((a.equals("OOO")) || (b.equals("OOO")) || (c.equals("OOO")) || (d.equals("OOO")) || (e.equals("OOO")) || (f.equals("OOO")) || (g.equals("OOO")) || (h.equals("OOO"))) {
			oWins = true;
			turnLabel.setText("Player 2 (O) Wins!");
			for (int i = 0; i < buttonList.size(); i++) {
				buttonList.get(i).setDisable(true);
			}
		} else if (getIncrement() == 9) {
			tie = true;
			turnLabel.setText("It's a Tie!");
			for (int i = 0; i < buttonList.size(); i++) {
				buttonList.get(i).setDisable(true);
			}
		}

	}
}