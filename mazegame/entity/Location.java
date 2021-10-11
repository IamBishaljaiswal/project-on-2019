package mazegame.entity;

import java.util.HashMap;
import mazegame.entity.utility.*;

public class Location {
//	private HashMap<String, Exit> exits;
	private NonPlayerCharacterCollection characters;
	private Inventory items;
	private ExitCollection exitCollection;
	private String description;
	private String label;
	
	public Location () {
		exitCollection = new ExitCollection();
		items = new Inventory();
		characters = new NonPlayerCharacterCollection();
	}
	
	public Location (String description, String label){
		this();		// What does this accomplish
		this.setDescription(description);
		this.setLabel(label);
	}
	
//	public boolean addExit (String exitLabel, Exit theExit){
//	if (exits.containsKey(exitLabel))
//		return false;
//		exits.put(exitLabel, theExit);
//		return true;
//	}
//	
//	public Exit getExit(String exitLabel){
//		return (Exit) exits.get(exitLabel);
//	}
	
	public Inventory getInventory () {
		return items;
	}
	
//	public Location returnLocation () {
//		return label;
//	}
	
//	public 
	
	public ExitCollection getExitCollection () {
		return exitCollection;
	}
		
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}	
	
	

    public String toString()
    {
        return "**********\n" + this.label + "\n**********\n"
            + "Exits found :: " + exitCollection.availableExits() + "\n**********\n"
            +"\n NPC Found :: "+ characters + "\n ****** \n"
            + "\n" + items.toString()
            + this.description + "\n**********\n";
    }
//for non character player
	public NonPlayerCharacterCollection getCharacters() {
		return characters;
	}

	public void setCharacters(NonPlayerCharacterCollection characters) {
		this.characters = characters;
	}

//	public Exit getExit(String exitLabel) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
