package mazegame.control;

import mazegame.entity.Player;

public class ListCommand implements Command{

	public CommandResponse execute(ParsedInput userInput, Player thePlayer){
		return new CommandResponse(thePlayer.getInventory().toString());
	}
	
}
