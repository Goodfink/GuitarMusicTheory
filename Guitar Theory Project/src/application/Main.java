package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Create and show the main application window
		MusicTheoryAppFX musicTheoryApp = new MusicTheoryAppFX();
		musicTheoryApp.start(primaryStage);
	}
}
