package Main.nodes;

public class NodeAttribute {

	
	String key;
	String value;
	
	public NodeAttribute(String key , String value) 
	{
		this.key = key;
		this.value = value;
	}
	
	
	public NodeAttribute() 
	{
		
	}
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
}
