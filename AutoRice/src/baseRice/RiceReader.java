package baseRice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RiceReader {



	public static ArrayList<RiceGrain> readData(String fileName){

		int type = 0;
		String value = "AutoRice";
		String description = "AutoRice";
		String textLine = null;

		ArrayList<RiceGrain> listOfRiceGrains = new ArrayList<RiceGrain>();



		File file = new File(System.getProperty("user.home") + fileName);

		try {
			System.out.println("SEARCHING IN " + fileName);
			Scanner scanner = new Scanner(file);
			System.out.println("SEARCHING IN " + fileName);

			int lineNum = 0;
			while (scanner.hasNextLine()) {
				System.out.println("SEARCHING IN " + fileName);
				
				String line = scanner.nextLine();
				lineNum++;
				if(line.indexOf("AutoRice")!=-1) {
					if (Main.DEBUG) {
						System.out.println("Found on line " +lineNum);
						System.out.println("Line comment: " + line.substring(line.lastIndexOf("AutoRice") + 8));
						System.out.println("Line: " + line + " File:" + fileName);
					}
					//Reset values
					type = 0;
					value = "AutoRice";
					description = "AutoRice";
					textLine = null;

					description = line.substring(line.lastIndexOf("AutoRice") + 8);
					textLine = line;


					Pattern pattern = Pattern.compile("#([0-9a-fA-F]{6}|[0-9a-fA-F]{3}|[0-9a-f]{8})");
					Matcher matcher = pattern.matcher(line);




					if (matcher.find())
					{
						System.out.println("Found a hex color:");
						System.out.println(matcher.group(0));

						type=1;
						value = matcher.group(0);

					} else {
						System.out.println("No hex found, looking for text in quotes");

						Pattern pattern2 = Pattern.compile("\"([^\"]*)\"");
						Matcher matcher2 = pattern2.matcher(line);

						if (matcher2.find())
						{
							System.out.println("Found a value:");
							System.out.println(matcher2.group(1));

							value = matcher2.group(1);
						} else {
							System.out.println("Nothing found, report back to user.");

						}

					}

					listOfRiceGrains.add(new RiceGrain(description, type, value, fileName, textLine));


				}
			}

			scanner.close();
		} catch(FileNotFoundException e) { 
			//Much error handling
			System.out.println("File not found!");
		}


		System.out.println("Done");

		return listOfRiceGrains;



	}



}
