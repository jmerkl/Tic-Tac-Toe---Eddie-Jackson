import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TTTSquare {

	private boolean filled;
	static boolean turnTracker;
	private Button square = new Button();

	TTTSquare(int squareSize, Text turnLabel) {
		square.setPrefSize(squareSize, squareSize);
		square.setDisable(true);
		square.setOnAction(e -> {
			if (square.getText().isEmpty()) {
				square.setText(turnTracker ? "O" : "X");
				square.setStyle("-fx-font: 40 verdanna; -fx-background-color: #FFFFFF");
				filled = true;
				turnTracker = turnTracker ? false : true;
				MainWindow.makeTurnChanges(turnLabel, turnTracker);
				MainWindow.evalBoard(turnLabel);
			}
			
		});
	}

	public Button button() {
		return square;
	}

	public boolean equals(TTTSquare target) {
		return filled && square.getText().equals(target.button().getText());
	}

	public boolean turnTrack() {
		return turnTracker;
	}

	public void clear() {
		filled = false;
		square.setText("");
		square.setDisable(false);
	}
}