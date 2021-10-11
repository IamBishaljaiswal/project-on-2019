package mazegame.control; // this is inside control

import mazegame.entity.*;

public class GetCommand implements Command {

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		if(userInput.getArguments().size() == 0)
			return new CommandResponse("Please add your task / what you  want to do");
		
		String label = (String) userInput.getArguments().get(0);
		
		Item itemToGet = thePlayer.getCurrentLocation().getInventory().findItem(label);
		if(itemToGet == null)
			return new CommandResponse("THe Item " + label + " is not available");
		
	boolean added = thePlayer.getInventory().addItem(itemToGet);
	if(!added)
		return new CommandResponse("The item "+label+" cannot be added due to weight restriction");
	
	thePlayer.getCurrentLocation().getInventory().removeItem(label);
		
		// TODO Auto-generated method stub
		return new CommandResponse("You have successfully got the  item " +label);
	}
	
}
