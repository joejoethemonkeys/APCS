import java.util.Scanner;
import java.io.*;
import java.util.*;

public class IndexMaker {
	private String file = "fish.txt";
	ArrayList<String> wordList = new ArrayList<String>();
	ArrayList<IndexEntry> objList = new ArrayList<IndexEntry>();

	public IndexMaker(String file) {
		this.file = file;
	}

	public void makeIndex() {
		String input = "";
		String lineNum = "";
		int num = 0;
		try {
			Scanner reader = new Scanner(new File(file));
			while (reader.hasNext()) {
				input = reader.nextLine();
				num++;
				lineNum = num + " ";
				cleaner(input, lineNum);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File error" + e);
		}
	}

	private void cleaner(String input, String lineNum) {
		String result = "";
		Scanner clean = new Scanner(input);
		while (clean.hasNext()) {
			result = clean.next();
			result = result.toUpperCase();

			if (!Character.isLetter(result.charAt(0))) {
				result = result.substring(1);
			}
			if (!Character.isLetter(result.charAt(result.length() - 1))) {
				result = result.substring(0, result.length() - 1);
			}

			storage(result, lineNum);
		}
		clean.close();
	}

	private void storage(String word, String lineNum) {
		IndexEntry ie = new IndexEntry(word, lineNum);
		
		if (!wordList.contains(word)) {
			wordList.add(word);
			objList.add(ie);
		} else {
			for (int ij = 0; ij < objList.size(); ij++) {
				if (objList.get(ij).getWord().equals(word)) {
					objList.get(ij).setLineNum(lineNum);
				}
			}
		}
	}

	public void display() {
		for (int i = 0; i < objList.size(); i++) {
			System.out.println(objList.get(i));
		}
	}
}