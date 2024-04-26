package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MusicTheoryAppFX extends Application {

	private TextField keyTextField;
	private TextField genreTextField;
	private TextArea outputTextArea;
	private TextArea chordProgressionsTextArea;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Guitar Music Theory App");

		// Create UI components for input
		Label keyLabel = new Label("Enter the key:");
		Label genreLabel = new Label("Enter the genre:");
		keyTextField = new TextField();
		genreTextField = new TextField();
		Button showScalesButton = new Button("Confirm");

		// Labels for output sections
		Label scalesLabel = new Label("Commonly Used Scales:");
		Label chordProgressionsLabel = new Label("Commonly Used Chord progressions:");

		// TextAreas for output
		outputTextArea = new TextArea();
		chordProgressionsTextArea = new TextArea();

		// Set the preferred sizes for the TextAreas
		outputTextArea.setPrefWidth(1000); // Adjust this value as needed
		outputTextArea.setPrefHeight(1000); // Adjust this value as needed

		chordProgressionsTextArea.setPrefWidth(1000); // Adjust this value as needed
		chordProgressionsTextArea.setPrefHeight(1000); // Adjust this value as needed

		// Handle the button click event
		showScalesButton.setOnAction(e -> {
			showScales();
			showProgressions();
		});

		// Create VBox for inputs and button
		VBox inputVBox = new VBox(10, keyLabel, keyTextField, genreLabel, genreTextField, showScalesButton);

		// Create VBox for scales output with title
		VBox scalesOutputVBox = new VBox(5, scalesLabel, outputTextArea);
		scalesOutputVBox.setStyle("-fx-padding: 10;");

		// Create VBox for chord progressions output with title
		VBox chordProgressionsVBox = new VBox(5, chordProgressionsLabel, chordProgressionsTextArea);
		chordProgressionsVBox.setStyle("-fx-padding: 10;");

		// Create HBox to contain both VBoxes for output
		HBox outputHBox = new HBox(20, scalesOutputVBox, chordProgressionsVBox);
		outputHBox.setStyle("-fx-alignment: center-left;");

		// Create the main VBox to hold all components
		VBox mainVBox = new VBox(20, inputVBox, outputHBox);
		mainVBox.setPadding(new Insets(15, 20, 15, 20));
		mainVBox.setStyle("-fx-background-color: lavender;");

		// Set the scene
		Scene scene = new Scene(mainVBox, 1200, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void showScales() {
		String key = keyTextField.getText();
		String genre = genreTextField.getText();

		// Use Main_Utilities to get the file name and retrieve the content
		String fileName = Main_Utilities.file_Name(key, genre);
		String content = Main_Utilities.file_Output(fileName);

		// Display the content in the outputTextArea
		outputTextArea.setText(content);
	}

	private void showProgressions() {
		String key = keyTextField.getText();
		String genre = genreTextField.getText();

		String fileNameProgression = Main_Utilities.file_Name_progression(key, genre);
		String content = Main_Utilities.file_Output(fileNameProgression);

		chordProgressionsTextArea.setText(content);
	}

}
