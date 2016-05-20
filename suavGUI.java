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
	import javafx.scene.chart.LineChart;
	import javafx.scene.chart.NumberAxis;
	import javafx.scene.chart.XYChart;
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

public class suavGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void start(Stage stage) {
		//Layout
			BorderPane window = new BorderPane();
			window.setPrefSize(900, 650);

			//Top Portion
				BorderPane titleBox = new BorderPane();

					Text titleLabel = new Text("Aircraft Designer");
					titleLabel.setFont(new Font("Verdana", 50));
						DropShadow ds = new DropShadow();
						ds.setOffsetY(3.0f);
						ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

						//titleLabel.setEffect(ds); //Uncomment to add a drop shadow effect
						titleLabel.setCache(true);
						titleLabel.setX(10.0f);
						titleLabel.setY(270.0f);
						titleLabel.setFill(Color.web("#23297A"));
						titleLabel.setFont(Font.font(null, FontWeight.BOLD, 60));

					VBox instructions = new VBox();

						Button instructButton = new Button("Instructions");
						instructButton.setPrefSize(150, 40);

					instructions.getChildren().add(instructButton);
					instructions.setAlignment(Pos.CENTER);

				titleBox.setCenter(titleLabel);
				titleBox.setRight(instructions);
				titleBox.setPadding(new Insets(10, 10, 10, 10));
				titleBox.setStyle("-fx-background-color: #daa520;");

			window.setTop(titleBox);
			window.setAlignment(titleBox, Pos.TOP_RIGHT);

			//Left Portion (Inputs)
				VBox inputsBox = new VBox(30);

					int fontSize = 20;

					Label inputsBoxTitle = new Label("Design Inputs");
					inputsBoxTitle.setFont(new Font("Courier", 30));

					HBox dragBox = new HBox(10);

						Label dragLabel = new Label("Counts of Drag:      ");
						dragLabel.setFont(new Font("Courier", fontSize));
						NumberTextField dragField = new NumberTextField();
						dragField.setPromptText("Cd,o");

					dragBox.getChildren().addAll(dragLabel, dragField);
					dragBox.setAlignment(Pos.CENTER);
					dragBox.setPadding(new Insets(5, 5, 5, 5));

					HBox speedBox = new HBox(10);

						Label speedLabel = new Label("Cruise Speed (mph):");
						speedLabel.setFont(new Font("Courier", fontSize));
						NumberTextField speedField = new NumberTextField();
						speedField.setPromptText("Speed in mph");

					speedBox.getChildren().addAll(speedLabel, speedField);
					speedBox.setAlignment(Pos.CENTER);
					speedBox.setPadding(new Insets(5, 5, 5, 5));

					HBox weightBox = new HBox(10);

						Label weightLabel = new Label("Weight (pounds):    ");
						weightLabel.setFont(new Font("Courier", fontSize));
						NumberTextField weightField = new NumberTextField();
						weightField.setPromptText("Weight (pounds)");

					weightBox.getChildren().addAll(weightLabel, weightField);
					weightBox.setAlignment(Pos.CENTER);
					weightBox.setPadding(new Insets(5, 5, 5, 5));

					HBox reynoldsBox = new HBox(10);

						Label reynoldsLabel = new Label("Reynolds Number:  ");
						reynoldsLabel.setFont(new Font("Courier", fontSize));
						NumberTextField reynoldField = new NumberTextField();
						reynoldField.setPromptText("Reynolds No.");

					reynoldsBox.getChildren().addAll(reynoldsLabel, reynoldField);
					reynoldsBox.setAlignment(Pos.CENTER);
					reynoldsBox.setPadding(new Insets(5, 5, 5, 5));

					HBox spanBox = new HBox(10);

						Label spanLabel = new Label("Wing Span (feet):   ");
						spanLabel.setFont(new Font("Courier", fontSize));
						NumberTextField spanField = new NumberTextField();
						spanField.setPromptText("Wing Span (ft.)");

					spanBox.getChildren().addAll(spanLabel, spanField);
					spanBox.setAlignment(Pos.CENTER);
					spanBox.setPadding(new Insets(5, 5, 5, 5));

					Button calculateStatic = new Button("Calculate");
					calculateStatic.setPrefSize(200, 40);

				inputsBox.getChildren().addAll(inputsBoxTitle, dragBox, speedBox,
					weightBox, reynoldsBox, spanBox, calculateStatic);
				inputsBox.setAlignment(Pos.CENTER);
				inputsBox.setPadding(new Insets(20, 20, 20, 20));
			window.setLeft(inputsBox);

			//Right Portion (Graphs)
				VBox rightSide = new VBox(10);

					VBox rightTitleBox = new VBox(10);

						Label rightTitleLabel = new Label("Performance Graphs");
						rightTitleLabel.setFont(new Font("Courier", 30));

						HBox comboBox = new HBox(10);

							Label varyLabel = new Label("Vary");
							varyLabel.setFont(new Font("Courier", 15));

							Label byLabel = new Label("by");
							byLabel.setFont(new Font("Courier", 15));

							ComboBox yBox = new ComboBox();
							yBox.getItems().addAll("Cd,o", "Speed", "Weight", "Wingspan");
							yBox.setPromptText("Y-Value");
							ComboBox xBox = new ComboBox();
							xBox.getItems().addAll("Cd,o", "Speed", "Weight", "Wingspan");
							xBox.setPromptText("X-Value");

							Label taken = new Label("");

						comboBox.getChildren().addAll(varyLabel, yBox, byLabel, xBox);
						comboBox.setAlignment(Pos.CENTER);
						comboBox.setPadding(new Insets(10, 10, 10, 10));

					rightTitleBox.getChildren().addAll(rightTitleLabel, comboBox);
					rightTitleBox.setAlignment(Pos.CENTER);
					rightTitleBox.setPadding(new Insets(5, 5, 5, 5));

					VBox graphBox = new VBox(20);

						NumberAxis xAxisFake = new NumberAxis();
						NumberAxis yAxisFake = new NumberAxis();

						LineChart<Number, Number> lineChartFake =
							new LineChart<Number, Number>(xAxisFake, yAxisFake);

					graphBox.getChildren().addAll(lineChartFake);
					graphBox.setAlignment(Pos.CENTER);
					graphBox.setPadding(new Insets(10, 10, 10, 10));

				rightSide.getChildren().addAll(rightTitleBox, graphBox);

			window.setRight(rightSide);

			Scene scene = new Scene(window);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

			//Instructions
				final Stage instructionStage = new Stage();
					FlowPane instructionWindow = new FlowPane();
					instructionWindow.setPrefSize(400, 400);

						HBox messageBox = new HBox();

							Text message = new Text();
							message.setText("Aircraft Designer is a performance evaluation tool used to guide the design of conceptual aircraft.\n\n\n\nThe left side of the main menu serves as a static calculator. If you are able to fill in 4 or the 5 inputs, the fifth one can be calculated for you.\nThe inputs are:\n\nCounts of Drag (Cd,o): the parasitic drag coefficient in counts\n 	Cd,o is the drag coefficient at 0 angle of attack, AKA the parasitic drag coefficient. This number is obtained from the polar data of an airfoil\n 		and will only occur at a specific Reynolds Number (another input).  Counts of drag correspond to the drag coefficient in thousandths.\n  			e.g.- a Cd,o of 0.018 has 18 counts of drag.\n\nCruise Speed: the desired cruise speed (note: not the take off speed)\n\nWeight: The weight of the aircraft in pounds. Make sure to over-estimate by ~10% if you plan to build this thing.\n\nReynolds Number: A dimensionless ratio of the inertial to viscous forces of a given test condition.\n 	The Reynolds number indicates the type of flight condition your aircraft will be in. Every wing operates differently at different\n 	Reynolds Numbers, so when you are finding airfoils, make sure you write down the reynolds number corresponding to the polars you eventually use.\n  		Reynolds Number for UAV's tends to be around ~[50,000 - 200,000].\n  			The design influence this figure has is on the length of your wing's chord (trapezoidal height).\n\nWingspan: The spanwise length of the wing in feet.  Pretty straightforward.\n\n\nOnce every parameter has been filled out, the right side of the menu can be accessed.  Using the combo Boxes above, you can visually see the impact each\nvariable has on one another and use their relationships to guide your design.\n\n\nIt is important to note that, as with all design, optimization must be done with respect to a certain set of parameters.\nBecause Aircraft Designer is most accurate with unmanned vehicles, all parameters are optimized for MAX PERFORMANCE AT MINIMUM POWER.\n No factors of stability or handling are considered as they contribute less to the conceptual shaping of the vehicle. Fuel dispersion, v-n-loading, and\nother post-concept design features are also not handled... it's too risky to make those decisions for you ;)\n\n\nFor any technical questions, contact jackson.merkl@gatech.edu");
							message.setFont(new Font("Courier", 12));

						messageBox.getChildren().add(message);
						messageBox.setPadding(new Insets(10, 10, 10, 10));
					instructionWindow.getChildren().add(messageBox);

					Scene instructionScene = new Scene(instructionWindow);
					instructionStage.setScene(instructionScene);
					instructionStage.setResizable(false);
	}
}