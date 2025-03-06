package Main;
import Main.loader.Loader;

public class Main {

	public static void main(String[] args) {
	
		XmlDoc doc = new XmlDoc();
		
		
		
		Loader.load(doc , args[0]);
		
		
		Viewer.displayAsList(doc);
		
		

	}

}
