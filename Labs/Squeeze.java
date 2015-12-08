import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Squeeze {

	public Squeeze() {

	}

	public static void readWriteFile() {
		try {
			Scanner reader = new Scanner(new File("src\\squeeze.java"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("Output.TXT"));
			String line, temp = "", result = "";

			while (reader.hasNext()) {
				int counter = 0;
				line = reader.nextLine();
				for (int i = 0; i < line.length(); i++) {
					if (Character.isWhitespace(line.charAt(i))) {
						counter++;
					} else {
						temp = line.substring(i);
						break;
					}
				}
				result = counter + "  " + temp;
				System.out.println(result);
				writer.write(result);
				writer.newLine();
			}
			writer.close();
			reader.close();
		} catch (IOException e) {
			System.out.println("File error" + e);
		}
	}
}
