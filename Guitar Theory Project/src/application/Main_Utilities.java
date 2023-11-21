package application;

import java.io.InputStream;
import java.util.Scanner;

public class Main_Utilities {

	// scanner
	private static Scanner keyboard = new Scanner(System.in);

	// getting the user input for genre
	public static String get_Genre() {

		System.out.println("which Genre would you like to play: ");
		String Genre = keyboard.nextLine();

		return Genre;

	}

	// getting the user input for key
	public static String get_Key() {

		System.out.println("which key are you playing in: ");
		String Key = keyboard.nextLine();

		return Key;

	}

	// creating the file name
	public static String file_Name(String Key, String Genre) {
		// Converts the Key and Genre into the proper file name format
		String file_Name = Genre.toLowerCase() + "_" + Key.toLowerCase() + ".txt";

		return file_Name;

	}

	// getting the content from the file and out-puting it onto the screen
	public static String file_Output(String file_Name) {
		int singleDigitFretSpacing = 5; // 2 spaces before single-digit, fret number, then 2 spaces after
		int doubleDigitFretSpacing = 4; // 1 space before double-digit, fret number, then 1 space after

		try {
			InputStream inputStream = Main_Utilities.class.getClassLoader().getResourceAsStream(file_Name);
			if (inputStream == null) {
				return "Sorry, this file does not exist within our records.";
			}

			Scanner scanner = new Scanner(inputStream);
			StringBuilder fileContents = new StringBuilder();
			String line;

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();

				if (line.matches("^\\s*\\d.*")) { // If the line starts with numbers (fret markers)
					String[] frets = line.trim().split("\\s+"); // Split by whitespace

					for (int i = 0; i < frets.length; i++) {
						int fret = Integer.parseInt(frets[i]);
						// Adjust spacing based on whether the fret number is single or double-digit
						if (fret < 3) {
							// Single-digit fret number
							fileContents.append("    ").append(fret).append(" "); // 2 spaces before, 3 spaces after
						} else if (fret == 3) {
							// Double-digit fret number
							fileContents.append("     ").append(fret).append("   "); // 1 space before, 3 spaces after
						} else if (fret == 4) {

							fileContents.append("   ").append(fret).append("   ");

						} else if (fret == 5) {

							fileContents.append("  ").append(fret).append("   ");

						} else if (fret == 6) {

							fileContents.append("   ").append(fret).append("   ");

						} else if (fret == 7) {

							fileContents.append("   ").append(fret).append("   ");

						} else if (fret == 8) {

							fileContents.append("  ").append(fret).append("   ");

						} else if (fret == 9) {

							fileContents.append("   ").append(fret).append("   ");

						} else if (fret == 10) {

							fileContents.append(" ").append(fret).append("   ");

						} else if (fret == 11) {

							fileContents.append(" ").append(fret).append("   ");

						} else if (fret == 12) {

							fileContents.append(" ").append(fret).append("   ");

						} else if (fret == 13) {

							fileContents.append("").append(fret).append("   ");

						} else if (fret == 14) {

							fileContents.append("").append(fret).append("   ");

						} else if (fret == 15) {

							fileContents.append("").append(fret).append("   ");

						} else if (fret == 16) {

							fileContents.append("").append(fret).append("   ");

						} else if (fret == 17) {

							fileContents.append(" ").append(fret).append("   ");

						} else if (fret == 18) {

							fileContents.append(" ").append(fret).append("   ");

						} else if (fret == 19) {

							fileContents.append("").append(fret).append("  ");

						} else if (fret == 20) {

							fileContents.append("").append(fret).append("  ");

						} else if (fret == 21) {

							fileContents.append(" ").append(fret).append("   ");

						} else if (fret == 22) {

							fileContents.append(" ").append(fret).append("   ");

						}

					}
					fileContents.append("\n");
				} else {
					// Append other lines as is
					fileContents.append(line).append("\n");
				}
			}

			scanner.close();
			return fileContents.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Sorry, an error occurred while accessing our records.";
		}
	}

}
