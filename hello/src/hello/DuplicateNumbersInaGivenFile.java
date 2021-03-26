package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumbersInaGivenFile {

	public static void main(String[] args) {
		File file = new File("F:/vino--programs-2021/duplicatenumbers.txt");
		Path path = Paths.get(file.toString());

		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> duplicate = new ArrayList<String>();

		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = reader.readLine()) != null) {

				list.add(line);
			}
			System.out.println("GIVEN NUMBERS: " + list);

			for (int i = 0; i < list.size(); i++) {

				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).equals(list.get(j)))

					{

						duplicate.add(list.get(j));

					}
				}

			}

			Set<String> set = new HashSet<String>(duplicate);
			System.out.println("Duplicate NUMBERS: " + set);

			reader.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}