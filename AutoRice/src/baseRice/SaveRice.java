package baseRice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveRice {
	public static void riceGrainsToFile(ArrayList<RiceGrain> listOfRiceGrains){
		for(RiceGrain m: listOfRiceGrains) {

			
			String newText = "fuck";
			
			
			Pattern pattern = Pattern.compile("#([0-9a-f]{6}|[0-9a-f]{3}|[0-9a-f]{8})");
			Matcher matcher = pattern.matcher(m.line);

			if (matcher.find())
			{
				System.out.println("Found a hex color:");
				System.out.println(matcher.group(0));

				
				newText = matcher.replaceFirst(m.textField.getText());


			} else {
				System.out.println("No hex found, looking for text in quotes");

				Pattern pattern2 = Pattern.compile("\"([^\"]*)\"");
				Matcher matcher2 = pattern2.matcher(m.line);

				if (matcher2.find())
				{
					System.out.println("Found a value:");
					System.out.println(matcher2.group(1));

					//value = matcher2.group(1);
					
					newText = matcher2.replaceFirst("\"" + m.textField.getText()+ "\"");
				} else {
					System.out.println("Nothing found, report back to user.");

				}

			}
			
			
			
			
			
			
			
			
			Path path = Paths.get(System.getProperty("user.home") + m.fileName);
			Charset charset = StandardCharsets.UTF_8;

			String content;
			try {
				content = new String(Files.readAllBytes(path), charset);
				content = content.replaceAll(m.line, newText);
				Files.write(path, content.getBytes(charset));
				
				m.line = newText;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		}
	}
}
