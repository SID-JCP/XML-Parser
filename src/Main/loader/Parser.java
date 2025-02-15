package Main.loader;

import Main.XmlDoc;
import Main.nodes.Node;
import Main.nodes.NodeAttribute;

public class Parser {
	
	
	XmlDoc doc;
	
	public Parser(XmlDoc doc) 
	{
		this.doc = doc;
	}
	
	
	
	public void parse() 
	{
		tokenize();
	}
	
	private void tokenize() 
	{
		char[] contents = doc.getContents();
		
		if(doc.getRootNode() == null) 
		{
			doc.setRootNode(new Node(null));
		}
		
		StringBuilder accum = new StringBuilder();
		
		
		Node cursor = null;
		
		//temp
		NodeAttribute temp = new NodeAttribute();
		
		for(int i = 0; i < contents.length; i++) 
		{
			
			
			
			if(contents[i] == '<') 
			{
				
				if(accum.length() != 0) 
				{
					if(cursor == null){return;
					}else {
						
						cursor.setText(accum.toString());
					}
					
				}
				
				i++;
				
				if(contents[i] == '/') 
				{
					i++;
					
					
					if(cursor == null)return;
					
					
					while(contents[i] != '>') 
					{
						accum.append(contents[i]);
						i++;
					}
					
					if(!cursor.getTag().equals(accum.toString())) 
					{
						return;
					}
					
					continue;
				}
				
				
				if(cursor == null) 
				{
					cursor = doc.getRootNode();	
					
				}else {				
					cursor = new Node(cursor);
				}
				
				
				
				while(contents[i] != '>') 
				{
					if(contents[i] == ' ') 
					{
						if(cursor.getTag() == null) 
						{
							cursor.setTag(accum.toString());
							accum.setLength(0);
							i++;
							continue;
							
						}else {i++; continue;}
			
					}
					
					if(contents[i] == '='){
					
						//key found
						temp.setKey(accum.toString());
						accum.setLength(0);				
						i++;
						continue;
					}
					
					
					if(contents[i] == '"')
					{
						i++;						
						while(contents[i] != '"') 
						{							
							accum.append(contents[i]);
							i++;
						}
						
						temp.setValue(accum.toString());
						cursor.attributes.add(new NodeAttribute(temp.getKey() , temp.getValue()));
						accum.setLength(0);
						i++;
						continue;
					}
					
					accum.append(contents[i]);
					i++;
				}
				
				if(cursor.getTag() == null) 
				{
					cursor.setTag(accum.toString());
					accum.setLength(0);
					
				}
				
				continue;
				
			}else {
								
				accum.append(contents[i]);
				
				
			}
			
			
			
		}
	}

}
