package gel_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

	/**
	 * A method to read a csv file and stores its content in an arraylist of string arrays
	 * @param file - The path to the csv file to read
	 * @return An ArrayList of String arrays containing the csv data
	 */
	public ArrayList<String[]> readCSV(String file, char delimiter, boolean skipFirstLine) {
		// Create an empty ArrayList to store the csv data
		ArrayList<String[]> data = new ArrayList<>();

		// Declare a variable to store each line of the csv file
		String line;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			// Read each line of the csv file excluding the first line which has headings
			while ((line = br.readLine()) != null) {
				if (skipFirstLine) {
					skipFirstLine = false;
					continue;
				}
				/**Split the line into an array of strings using the ';' delimiter
				 *  and add it to the ArrayList
				 */
				data.add(line.split(String.valueOf(delimiter)));
			}
		} catch (IOException e) {
			e.printStackTrace();// Print the stack trace if an IOException occurs
		}
		return data;// Return the ArrayList of csv data
		//System.out.println(data);
	}
}//class
