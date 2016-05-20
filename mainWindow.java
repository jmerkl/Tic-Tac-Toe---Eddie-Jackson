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

	import java.util.ArrayList;

public class mainWindow extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {
		BorderPane window = new BorderPane();
		window.setPrefSize(600, 700);

		//Top Portion
			BorderPane titleBox = new BorderPane();

				Text titleLabel = new Text("Eddie is a Nerd");
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
			//titleBox.setStyle("-fx-background-color: #daa520;");
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
							Button oneB = new Button();
								oneB.setPrefSize(buttonGridDim, buttonGridDim);
							Button oneC = new Button();
								oneC.setPrefSize(buttonGridDim, buttonGridDim);
						topRow.getChildren().addAll(oneA, oneB, oneC);
						topRow.setAlignment(Pos.CENTER);

					//Middle Row
						HBox middleRow = new HBox(10);
							Button twoA = new Button();
								twoA.setPrefSize(buttonGridDim, buttonGridDim);
							Button twoB = new Button();
								twoB.setPrefSize(buttonGridDim, buttonGridDim);
							Button twoC = new Button();
								twoC.setPrefSize(buttonGridDim, buttonGridDim);
						middleRow.getChildren().addAll(twoA, twoB, twoC);
						middleRow.setAlignment(Pos.CENTER);

					//Bottom Row
						HBox bottomRow = new HBox(10);
							Button threeA = new Button();
								threeA.setPrefSize(buttonGridDim, buttonGridDim);
							Button threeB = new Button();
								threeB.setPrefSize(buttonGridDim, buttonGridDim);
							Button threeC = new Button();
								threeC.setPrefSize(buttonGridDim, buttonGridDim);
						bottomRow.getChildren().addAll(threeA, threeB, threeC);
						bottomRow.setAlignment(Pos.CENTER);

				buttonGridBox.getChildren().addAll(topRow, middleRow, bottomRow);
				buttonGridBox.setStyle("-fx-background-color: #000000;");

			buttonGrid.getChildren().addAll(buttonGridBox);
			buttonGrid.setAlignment(Pos.CENTER);

		window.setCenter(buttonGrid);

		//Set Scene

		Scene scene = new Scene(window);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}