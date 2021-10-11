package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class SellCommand implements Command {
	public CommandResponse execute (ParsedInput userInput, Player thePlayer) {
		
		if(userInput.getArguments().size() == 0)
			return new CommandResponse ("You entered the Sell Command");
		
		String label = (String) userInput.getArguments().get(0);
		Item itemToGet = thePlayer.getInventory().findItem(label);
		
		thePlayer.getInventory().removeItem(label);
		thePlayer.getInventory().getGold().Add(itemToGet.getValue());
		return new CommandResponse("You have sucessfully sold the item "+label);
		
	}
}
