package mazegame.entity;

import mazegame.entity.utility.DiceRoller;
import mazegame.entity.utility.WeightLimit;

public class Player extends Character {
	
	private Location currentLocation;
	
	private Inventory inventory;
	
	public Inventory getInventory(){
		return inventory;
	}
	public Inventory setInventory(){
		return this.inventory = inventory;
	}
	
    public Player()
    {
    	inventory = new FiniteInventory(WeightLimit.getInstance().getModifier(DiceRoller.GetInstance().generateAbilityScore()));
    }

    public Player(String name)
	{
	    super (name);
	    inventory = new FiniteInventory(WeightLimit.getInstance().getModifier(DiceRoller.GetInstance().generateAbilityScore()));
	}
    public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}


}
