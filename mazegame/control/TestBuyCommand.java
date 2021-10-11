package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.*;

 public class TestBuyCommand {
	
	private ParsedInput playerInput;
    private Player thePlayer;
    private CommandHandler handler;
    private BuyCommand buy;
//	 private GetCommand get;
    private Weapon M416, SCARL;
    private Location startHere;
    private Shop Coles, kmart;
    private HardCodedData hd;
    
    @Before
	public void setup(){
		hd = new HardCodedData();         
        playerInput = new ParsedInput("buy", new ArrayList());      
        thePlayer = new Player("greg");
        
        startHere.getInventory().addItem(M416);
		Coles.getInventory().addItem(SCARL);
        
        
		Coles.getInventory().addItem(new Weapon("SCARL",32,22,"gun"));
        
        thePlayer.setCurrentLocation(Coles);
        handler = new CommandHandler();
        buy = new BuyCommand();	
//		get = new GetCommand();		 
	}

	@Test
	public void testOnlyBuy() {
		// Assert.assertSame(startHere, thePlayer.getCurrentLocation());
	        // test move command no arguments
	     CommandResponse response = buy.execute(playerInput, thePlayer);
	     Assert.assertFalse(response.isFinishedGame());
	     Assert.assertTrue(response.getMessage().contains("You entered the buy"));
	    
	}
	
	@Test
	public void testNoItem() {
		 thePlayer.setCurrentLocation(kmart);
		 
	     CommandResponse response = buy.execute(playerInput, thePlayer);
	     Assert.assertFalse(response.isFinishedGame());
	     Assert.assertTrue(response.getMessage().contains("You entered the buy"));
	     
	}
}
