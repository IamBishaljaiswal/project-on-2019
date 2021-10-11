package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.*;

public class TestMoveCommand {

	 private ParsedInput playerInput;
     private Player thePlayer;
     private CommandHandler handler;
     private MoveCommand move;
//	 private GetCommand get;
     private Location t127, gregsoffice;
     private HardCodedData hd;
     
	@Before
	public void setup(){
		 hd = new HardCodedData();         
         playerInput = new ParsedInput("move", new ArrayList());      
         thePlayer = new Player("greg");
         t127 = new Location("a lecture theatre", "T127");
         gregsoffice = new Shop("a spinning vortex of terror", "Greg's Office");
         t127.getExitCollection().addExit("south", new Exit("you see a mound of paper to the south", gregsoffice));
         gregsoffice.getExitCollection().addExit("north", new Exit("you see a bleak place to the north", t127));
         gregsoffice.getInventory().addItem(new Weapon("m16",10,10,"gun"));
         thePlayer.setCurrentLocation(t127);
         handler = new CommandHandler();
         move = new MoveCommand();	
//		get = new GetCommand();		 
	}
	
	@Test
	public void testMoveNoWhere() {
		 Assert.assertSame(t127, thePlayer.getCurrentLocation());
         // test move command no arguments
         CommandResponse response = move.execute(playerInput, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
         Assert.assertTrue(response.getMessage().contains("If you want to move you need to tell me where."));
         Assert.assertSame(t127, thePlayer.getCurrentLocation());
	}

	@Test
	public void testMoveNoExit() {
		 Assert.assertSame(t127, thePlayer.getCurrentLocation());
		 playerInput.getArguments().add("west");
         // test move command no exit
         CommandResponse response = move.execute(playerInput, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
         Assert.assertTrue(response.getMessage().contains("There is no exit there . . . try moving somewhere else!"));         
         Assert.assertSame(t127, thePlayer.getCurrentLocation());
	}
	
	@Test
	public void testTakeExit() {
		 Assert.assertSame(t127, thePlayer.getCurrentLocation());
		 playerInput.getArguments().add("south");
         // test move command no exit
         CommandResponse response = move.execute(playerInput, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
         Assert.assertTrue(response.getMessage().contains("You successfully move"));
         Assert.assertSame(gregsoffice, thePlayer.getCurrentLocation());
	}
}