package utils;

public class ModuleObject {
	public int id;
	public String code;
	public String description;
	public String lecturer;
	public AssignmentObject[] assignments;
	
	public ModuleObject(){
		
	}
	
	public String toString() {
		return code;
	}
}
