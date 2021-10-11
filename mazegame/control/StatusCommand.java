package mazegame.control;

import java.util.HashMap;

import mazegame.entity.Exit;
import mazegame.entity.Player;
import mazegame.entity.ExitCollection;
import mazegame.entity.Item;
import mazegame.entity.Location;

public class StatusCommand implements Command{
	
private CommandResponse response;
	
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		String currentLocation = thePlayer.getCurrentLocation().getLabel();
		HashMap<String, Item> items = thePlayer.getCurrentLocation().getInventory().getItemList();
				
		return new CommandResponse("Current location is: " + currentLocation + " and items in this locations are: " + items);
	}	

}
