package mazegame.control;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import mazegame.entity.*;

public class TestDropCommand {

	private DropCommand drop;
	private ParsedInput playerInput;
	private Player thePlayer;
	@Before
	public void stup() {
		// TODO Auto-generated method stub
		thePlayer = new Player("Sanjeev");
		drop = new DropCommand();
		playerInput = new ParsedInput("drop", new ArrayList());    
		

	}
	@Test
	public void test() {
		CommandResponse response = drop.execute(playerInput, thePlayer);
		Assert.assertFalse(response.isFinishedGame());
		Assert.assertTrue(response.getMessage().contains("You entered the Drop Command"));

	}

}
