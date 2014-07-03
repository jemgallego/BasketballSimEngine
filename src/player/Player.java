package player;

import gui.Main;

import java.io.File;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Player {

	// Profile
	// Ratings
	// Attributes
	// Tendencies
	// Preferences
	// Intangibles
	
	private int pid;
	private String name; 
	private int pos;
	private int age;
	private String college;
	private int[] ratings = new int[16];
	private int[] attributes = new int[9];
	private int[] tendencies = new int[3];
	private int[] preferences = new int[14];
	private int[] intangibles = new int[5];
	
	//	 FG Drive, FG Inside, FG Jumpshot, FG 3pt Shot, Free Throw - Reflect %
	//	 Draw Fouls - Ability to draw contact
	//	 Scoring - Scoring ability. Ability to make tough shots.
	//	 Passing, Handling, Off Rebound, Def Rebound, Block, Steal, Defense, Discipline, Basketball IQ
	private enum Rating { FGD, FGI, FGJ, FG3, FT, DRFL, SCR,
		PAS, HDL, OREB, DREB, BLK, STL, DEF, DIS, IQ};
	
	// Height, Weight, Strength, Speed, Quickness, Vertical, Hustle, Stamina, Durability};
	private enum Attribute {HT, WT, STR, SPD, QUI, VERT, HUS, STA, DUR}; 	
	
	// Tendency to do certain actions. Dribble allows player to move to spot.
	private enum Tendency {SHOOT, PASS, DRIBBLE};   	
	
	// Determine where the player likes to be on the floor.
	// LC3, RC3 - Left/Right Corner 3pt
	// L3, C3, R3 - Left/Center/Right 3pt
	// LB, RB - Left/Right Baseline
	// LMR, CMR, RMR - Left/Center/Right Midrange
	// LI, CI, RI - Left/Center/Right Inside
	// PBR = Point Blank Range
	private enum Preferences {LC3, L3, C3, R3, RC3, LB, LMR, CMR, RMR, RB, LI, CI, RI, PBR};
	
	// Work Ethic - How likely they are to improve in offseason.
	// Coachability - How receptive they are to instructions.
	// Leadership - Raise synergy by a %. A small chance of lowering if too many leaders.   
	// Personality - Raise/lower synergy by a %.
	// Potential - How likely they are to improve midseason.
	private enum Intangibles {WE, COA, LEAD, PER, POT};
		
	// the excel file being loaded should have this column order
	private static final String ORDER = "FirstName LastName Pos Age Height Weight " 
		+ "College"; 
	
	
	public Player(ArrayList<String> playerInfo)
	{
		pid = Integer.parseInt(playerInfo.get(0));
		name = playerInfo.get(1);
		pos = Integer.parseInt(playerInfo.get(2));
		age = Integer.parseInt(playerInfo.get(3));
		attributes[0] = Integer.parseInt(playerInfo.get(4)); 
		attributes[1] = Integer.parseInt(playerInfo.get(5)); 
		college = playerInfo.get(6);
		
		int index = 0;
		for(int j = 7; j < 23; j++)
		{
			ratings[index] = Integer.parseInt(playerInfo.get(j));
			index++;
		}
							
		index = 2;
		for(int j = 23; j < 28; j++)
		{
			attributes[index] = Integer.parseInt(playerInfo.get(j));
			index++;
		}
		
		index = 0;
		for(int j = 28; j < 31; j++)
		{
			tendencies[index] = Integer.parseInt(playerInfo.get(j));
			index++;
		}
		
		index = 0;
		for(int j = 31; j < 45; j++)
		{
			preferences[index] = Integer.parseInt(playerInfo.get(j));
			index++;
		}	
	}
	
	// Change probability depending on shot.
	// Foul OFF - DRFL, 
	// Foul DEF - DEF, IQ
	
	// Driving OFF - FGD, STR, SPD, HDL, VERT
	// Driving DEF - DEF, STR, SPD, QUI, VERT, BLK, STL
	
	// Jumper OFF - FGJ/FG3, SCR
	// Jumper DEF - DEF, BLK, VERT, STL
	
	// Passing 
	
	
	// Position must be between 1-5. If false, assign position base on height.
	private boolean validatePosition(int pos)
	{
		if(pos < 1 || pos > 5)
			return false;
		
		return true;
	}
	
	// Limit the age to between 18 and 50
	private int limitAge(int age)
	{
		if (age < 18) return 18;
		if (age > 50) return 50;
		
		return age;
	}
	
	// Limit the rating to between 30 and 100.
	private int limitRating(int rating)
	{
		if(rating < 30) return 30;
		if(rating > 100) return 100;
		
		return rating;
	}
	
	public String displayPlayer()
	{
		String player = pid + " " + name + " " + pos + " " + age + " " + college;
		
		return player;
	}
	
	public Object[] getPlayerData()
	{
		Object[] playerData = {pos, name, attributes[0], attributes[1], age, college};
		
		return playerData; 
	}
}
