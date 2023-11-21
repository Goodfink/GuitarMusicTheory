package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MusicTheoryAppFX extends Application {

	private TextField keyTextField;
	private TextField genreTextField;
	private TextArea outputTextArea;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Guitar Music Theory App");

		// Create the UI components
		Label keyLabel = new Label("Enter the key:");
		Label genreLabel = new Label("Enter the genre:");
		keyTextField = new TextField();
		genreTextField = new TextField();
		Button showScalesButton = new Button("Show Scales");
		outputTextArea = new TextArea();

		// Customization for the labels
		keyLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: black");
		genreLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: black");
		showScalesButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white");

		// Button customization
		showScalesButton.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: black;");

		// Customization for ouputTextArea
		outputTextArea.setPrefWidth(1000);
		outputTextArea.setPrefHeight(600);
		outputTextArea.setStyle("-fx-background-color: black; -fx-text-fill: black;");

		// Handle the button click event
		showScalesButton.setOnAction(e -> showScales());

		// Create the scene
		VBox vbox = new VBox(10);
		// customization for the scene
		vbox.setStyle("-fx-background-color: rgb(253, 223, 175);");

		vbox.getChildren().addAll(keyLabel, keyTextField, genreLabel, genreTextField, showScalesButton, outputTextArea);
		Scene scene = new Scene(vbox, 1600, 900);
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
}
