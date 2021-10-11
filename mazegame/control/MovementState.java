package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Player;
import mazegame.entity.Shop;

public class MovementState extends CommandState {
    public MovementState()
    {
        this.getAvailableCommands().put("go", new MoveCommand());
        this.getAvailableCommands().put("quit", new QuitCommand());
        this.getAvailableCommands().put("move", new MoveCommand());
        this.getAvailableCommands().put("get", new GetCommand());
        this.getAvailableCommands().put("look", new LookCommand());
        this.getAvailableCommands().put("list", new ListCommand());
        //this.getAvailableCommands().put("unlock", new UnlockCommand());
        this.getAvailableCommands().put("attack", new AttackCommand());
        this.getAvailableCommands().put("status", new StatusCommand());
    }

    public CommandState update(Player thePlayer)
    {
        if (thePlayer.getCurrentLocation() instanceof Shop)
            return new CommerceState();
        return this;
    }
}
