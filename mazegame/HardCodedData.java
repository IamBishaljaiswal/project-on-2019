package mazegame;

import mazegame.boundary.IMazeData;
import mazegame.entity.*;
import mazegame.entity.utility.*;

public class HardCodedData implements IMazeData {
	private Location startHere, America,England, France, China, Australia, India, Thailand, Hongkong, Russia, Pakistan, Villain ;                                                          
	private Item M416, SCARL, UMP9, VSS, helmet,grenet, AKM, Bandage, Ak47, Armor ;
	private NonPlayerCharacter npc;
	
	public HardCodedData()
	{
		createItems();
		createLocations();
		populateWeightLimitTable();
		populateStrengthTable();
		populateAgilityTable();
		
		createNPC();
	}
	
//	get npc
	public void createNPC(){
		npc = new NonPlayerCharacter();
		npc.setHostile(true);
		startHere.getCharacters().put("trump", npc);
	}
	
	private void createItems() {
		// TODO Auto-generated method stub
		
		M416 = new Weapon("m416", 35, 20, "Infantry Automatic Rifle");
		SCARL = new Weapon("ScarL", 32, 22, "Special Operations Forces Combat Assault Rifle");
		UMP9 = new Weapon("rifle", 15, 8, "Magazine-fed submachine gun");
		VSS = new Weapon("VSS", 10, 8, "Special Sniper Rifle");
		helmet = new Shield("helmet",2,2,"a level 1 helmet pack");
		grenet = new Weapon("firstAidKit",3,1,"grenet");
		AKM = new Weapon("AKM",35,20,"Automatic with 30 Calibire gun");
		Bandage = new Shield("Bandage",4,5,"Bandage");
		Ak47 = new Weapon ("AK47",35,20,"Furious Gun with Atuomatic Firing Range");
		Armor = new Shield ("Body Armor",5, 5,"Level 5 Aromr");
		
		
		
		
		
	}

	public Location getStartingLocation()
	{
		return startHere;
	}
	
	public String getWelcomeMessage()
	{
		return "Welcome to the IIBIT MazeGame";
	}
	
	private void createLocations () 
	{
		
		//new locations
				startHere = new Location ("an Dungeon Headquarter. In this game you need to find the villain and catch the villain", "DUNGEON HEADQUARTER");
			/*west*/	 America = new Location ("You are in united state of America. \nThe suspect is moved from this country", "AMERICA");
			/*east*/	 England = new Location ("we cannot find the suspect here. please visit another place", "ENGLAND");
			/*north*/	 France = new Location ("We have found the suspect. Do you want to catch him?", "FRANCE");
			/*south*/	 China = new Location ("Here we have found one suspect. Do you want to catch him?", "CHINA");
			/*northeast*/	 Australia = new Location ("Our news source told that he is in Thailand.", "AUSTRALIA");
			/*northeast*/ India = new Location ("There are tow suspects here One is here and other flew to Thailand Do you want to catch the one who is here?", "INDIA");
			/*southeast*/	 Thailand = new Location ("We have another suspect for you. Do you want to catch him?", "THAILAND");
			/*southeast*/ Hongkong = new Location ("He looks like him and fits your description but do you want to catch the suspect?", "HONGKONG");
			/*northwest*/	 Russia = new Location ("We found the two suspects here do you want to catch?", "RUSSIA");
			/*northwest*/	 Pakistan = new Location ("Here is the villain in this place and do you want to catch him?", "PAKISTAN");
			/*northwest*/	 Villain = new Location ("catch him and take to the prision)", "Villain");
				
		        //new locations connection exits
		            		
		            		startHere.getExitCollection().addExit("west", new Exit("You are landed America", America));
		            		startHere.getExitCollection().addExit("east", new Exit("You are landed in England", England));
		            		startHere.getExitCollection().addExit("north", new Exit("This is one of the famous country and you are here in France.", France));
		            		
		            		America.getExitCollection().addExit("east", new Exit("You can't see the villain here in england.", England));  
		            		America.getExitCollection().addExit("south", new Exit("you are in china", China));
		            		America.getExitCollection().addExit("northeast", new Exit("you are in australia", Australia));
		            		
		            		
		            		
		            		
		                    England.getExitCollection().addExit("northeast", new Exit("You can't see the villain here in Australia.", Australia));
		                    England.getExitCollection().addExit("northeast", new Exit("you are in india", India));
		                    
		                   
		                    
		                    France.getExitCollection().addExit("northeast", new Exit("you are in india", India));
		                    France.getExitCollection().addExit("east", new Exit("you are in england", England));
		                    
		                   
		                    
		                    China.getExitCollection().addExit("southeast", new Exit("you are in thailand", Thailand));
		                    China.getExitCollection().addExit("southeast", new Exit("you are in hongKong", Hongkong));
		                    
		                   
		                    Australia.getExitCollection().addExit("southeast", new Exit("you are in thailand", Thailand));
		                    Australia.getExitCollection().addExit("southeast", new Exit("you are in hongkong", Hongkong));
		                    Australia.getExitCollection().addExit("south", new Exit("you are in china", China));
		                    
		                    India.getExitCollection().addExit("northeast", new Exit("you are in australia", Australia));
		                    India.getExitCollection().addExit("southeast", new Exit("you are in hongkong", Hongkong));
		                    
		                    
		                    Thailand.getExitCollection().addExit("northwest", new Exit("you are in russia", Russia));
		                    Thailand.getExitCollection().addExit("southeast", new Exit("you are in hongkong", Hongkong));
		                    
		                    
		                    Hongkong.getExitCollection().addExit("northwest", new Exit("You are in russia", Russia));
		                    
		                    Russia.getExitCollection().addExit("northwest", new Exit("You are Close to the villaian, you are in pakistan", Pakistan));
		                    
		                   
		                    
		                    
		                  	Pakistan.getExitCollection().addExit("northwest", new Exit("Catch the villain.", Villain));	
		                  	
		                  	startHere.getInventory().addItem(grenet);
		            		America.getInventory().addItem(SCARL);
		            		England.getInventory().addItem(M416);
		            		China.getInventory().addItem(VSS);
		            		France.getInventory().addItem(UMP9);
		            		Australia.getInventory().addItem(helmet);
		            		India.getInventory().addItem(AKM);
		            		Thailand.getInventory().addItem(Bandage);
		            		Hongkong.getInventory().addItem(Armor);
		            		Russia.getInventory().addItem(helmet);
		            		Pakistan.getInventory().addItem(Ak47);
		            		Villain.getInventory().addItem(helmet);
		            		
		 
		
//		adding getweopen and drop command
		
		
			
	}
	
//	from week 10
	
	private void populateStrengthTable()
    {
        StrengthTable strengthModifiers = StrengthTable.getInstance();
        strengthModifiers.setModifier(1, -5);
        strengthModifiers.setModifier(2, -4);
        strengthModifiers.setModifier(3, -4);
        strengthModifiers.setModifier(4, -3);
        strengthModifiers.setModifier(5, -3);
        strengthModifiers.setModifier(6, -2);
        strengthModifiers.setModifier(7, -2);
        strengthModifiers.setModifier(8, -1);
        strengthModifiers.setModifier(9, -1);
        strengthModifiers.setModifier(10, 0);
        strengthModifiers.setModifier(11, 0);
        strengthModifiers.setModifier(12, 1);
        strengthModifiers.setModifier(13, 1);
        strengthModifiers.setModifier(14, 2);
        strengthModifiers.setModifier(15, 2);
        strengthModifiers.setModifier(16, 3);
        strengthModifiers.setModifier(17, 3);
        strengthModifiers.setModifier(18, 4);
        strengthModifiers.setModifier(19, 4);
        strengthModifiers.setModifier(20, 5);
        strengthModifiers.setModifier(21, 5);
        strengthModifiers.setModifier(22, 5);
        strengthModifiers.setModifier(23, 5);
        strengthModifiers.setModifier(24, 5);
        strengthModifiers.setModifier(25, 5);
        strengthModifiers.setModifier(26, 8);
        strengthModifiers.setModifier(27, 8);
        strengthModifiers.setModifier(28, 8);
        strengthModifiers.setModifier(29, 8);
        strengthModifiers.setModifier(30, 10);
        strengthModifiers.setModifier(31, 10);
        strengthModifiers.setModifier(32, 10);
        strengthModifiers.setModifier(33, 10);
        strengthModifiers.setModifier(34, 10);
        strengthModifiers.setModifier(35, 10);
        strengthModifiers.setModifier(36, 12);
        strengthModifiers.setModifier(37, 12);
        strengthModifiers.setModifier(38, 12);
        strengthModifiers.setModifier(39, 12);
        strengthModifiers.setModifier(40, 12);
        strengthModifiers.setModifier(41, 15);
        strengthModifiers.setModifier(42, 15);
        strengthModifiers.setModifier(43, 15);
        strengthModifiers.setModifier(44, 17);
        strengthModifiers.setModifier(45, 17);
        strengthModifiers.setModifier(46, 18);
    }

    private void populateAgilityTable()
    {
        AgilityTable agilityModifiers = AgilityTable.GetInstance();
        agilityModifiers.SetModifier(1, -5);
        agilityModifiers.SetModifier(2, -5);
        agilityModifiers.SetModifier(3, -5);
        agilityModifiers.SetModifier(4, -3);
        agilityModifiers.SetModifier(5, -3);
        agilityModifiers.SetModifier(6, -2);
        agilityModifiers.SetModifier(7, -2);
        agilityModifiers.SetModifier(8, -1);
        agilityModifiers.SetModifier(9, -1);
        agilityModifiers.SetModifier(10, 0);
        agilityModifiers.SetModifier(11, 0);
        agilityModifiers.SetModifier(12, 1);
        agilityModifiers.SetModifier(13, 1);
        agilityModifiers.SetModifier(14, 2);
        agilityModifiers.SetModifier(15, 2);
        agilityModifiers.SetModifier(16, 3);
        agilityModifiers.SetModifier(17, 3);
        agilityModifiers.SetModifier(18, 4);
        agilityModifiers.SetModifier(19, 4);
        agilityModifiers.SetModifier(20, 6);
        agilityModifiers.SetModifier(21, 6);
        agilityModifiers.SetModifier(22, 6);
        agilityModifiers.SetModifier(23, 6);
        agilityModifiers.SetModifier(24, 6);
        agilityModifiers.SetModifier(25, 6);
        agilityModifiers.SetModifier(26, 8);
        agilityModifiers.SetModifier(27, 8);
        agilityModifiers.SetModifier(28, 8);
        agilityModifiers.SetModifier(29, 8);
        agilityModifiers.SetModifier(30, 8);
        agilityModifiers.SetModifier(31, 8);
        agilityModifiers.SetModifier(32, 11);
        agilityModifiers.SetModifier(33, 11);
        agilityModifiers.SetModifier(34, 11);
        agilityModifiers.SetModifier(35, 11);
        agilityModifiers.SetModifier(36, 11);
        agilityModifiers.SetModifier(37, 11);
        agilityModifiers.SetModifier(38, 13);
        agilityModifiers.SetModifier(39, 13);
        agilityModifiers.SetModifier(40, 13);
        agilityModifiers.SetModifier(41, 13);
        agilityModifiers.SetModifier(42, 13);
        agilityModifiers.SetModifier(43, 13);
        agilityModifiers.SetModifier(44, 15);
        agilityModifiers.SetModifier(45, 15);
        agilityModifiers.SetModifier(46, 15);
    }

    private void populateWeightLimitTable()
    {
        WeightLimit weightModifier = WeightLimit.getInstance();
        weightModifier.setModifier(1, 6);
        weightModifier.setModifier(2, 13);
        weightModifier.setModifier(3, 20);
        weightModifier.setModifier(4, 26);
        weightModifier.setModifier(5, 33);
        weightModifier.setModifier(6, 40);
        weightModifier.setModifier(7, 46);
        weightModifier.setModifier(8, 53);
        weightModifier.setModifier(9, 60);
        weightModifier.setModifier(10, 66);
        weightModifier.setModifier(11, 76);
        weightModifier.setModifier(12, 86);
        weightModifier.setModifier(13, 100);
        weightModifier.setModifier(14, 116);
        weightModifier.setModifier(15, 133);
        weightModifier.setModifier(16, 153);
        weightModifier.setModifier(17, 173);
        weightModifier.setModifier(18, 200);
        weightModifier.setModifier(19, 233);
        weightModifier.setModifier(20, 266);
        weightModifier.setModifier(21, 306);
        weightModifier.setModifier(22, 346);
        weightModifier.setModifier(23, 400);
        weightModifier.setModifier(24, 466);
        weightModifier.setModifier(25, 533);
        weightModifier.setModifier(26, 613);
        weightModifier.setModifier(27, 693);
        weightModifier.setModifier(28, 800);
        weightModifier.setModifier(29, 933);
        weightModifier.setModifier(30, 1013);
        weightModifier.setModifier(31, 1093);
        weightModifier.setModifier(32, 1300);
        weightModifier.setModifier(33, 1433);
        weightModifier.setModifier(34, 1513);
        weightModifier.setModifier(35, 1593);
        weightModifier.setModifier(36, 1700);
        weightModifier.setModifier(37, 1833);
        weightModifier.setModifier(38, 1913);
        weightModifier.setModifier(39, 1993);
        weightModifier.setModifier(40, 2100);
        weightModifier.setModifier(41, 2233);
        weightModifier.setModifier(42, 2313);
        weightModifier.setModifier(43, 2393);
        weightModifier.setModifier(44, 2500);
        weightModifier.setModifier(45, 2633);
        weightModifier.setModifier(46, 2713);
    }
	
}
