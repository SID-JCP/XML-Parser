package Main.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Main.XmlDoc;

public class Loader {
	
	
	static StringBuilder string = new StringBuilder();
	
	public static void load(XmlDoc doc , String path) 
	{
		File file = new File(path);
		
		
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			
			//first line 
			String temp;
			
			while((temp = bf.readLine())!= null) 
			{				
				string.append(temp);
			}
			
			

			doc.setContents(string.toString().replaceAll("\\t","").toCharArray());
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		Parser parser = new Parser(doc);
		
		parser.parse();

		
	}
	
	

}
