package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class BuyCommand implements Command {
	public CommandResponse execute (ParsedInput userInput, Player thePlayer) {
		
//		ParsedInput userInput;
		if(userInput.getArguments().size() == 0)
			return new CommandResponse ("You entered the buy");
		
		
		String label = (String) userInput.getArguments().get(0);
		
		Item itemToGet = thePlayer.getCurrentLocation().getInventory().findItem(label);
		
		if( itemToGet == null)
			return new CommandResponse("The item "+label + " is not available");
		
		if(thePlayer.getInventory().getGold().getTotal() < itemToGet.getValue())
			return new CommandResponse("The item "+label+" cannot be purcchased due to money restriction");
		
		boolean added = thePlayer.getInventory().addItem(itemToGet);
		if( !added)
			return new CommandResponse(" The item "+label+ " cannot be adeded due to weight");
		
		thePlayer.getCurrentLocation().getInventory().removeItem(label);
		thePlayer.getInventory().getGold().Subtract(itemToGet.getValue());
		return new CommandResponse("You have sucessfully got the item "+label);
	}
}


