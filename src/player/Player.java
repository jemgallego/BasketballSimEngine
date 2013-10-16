package player;

public class Player {

	// Rating
	// Skills
	// Contract
	// Attributes
	// 

	// Work Ethic - How likely they are to improve in offseason.
	// Coachability - How receptive they are to instructions.
	// Leadership - Raise synergy by a %. A small chance of lowering if too many leaders.   
	// Personality - Raise/lower synergy by a %.
	// Potential - How likely they are to improve midseason.
	private enum Intangibles {WE, COA, LEAD, PER, POT};
	
	// Height
	// Weight
	// Strength
	// Speed
	// Quickness
	// Vertical
	// Hustle
	// Stamina
	// Durability
	private enum Attribute {HT, WT, STR, SPD, QUI, VERT, HUS, STA, DUR}; 
	
	// FG Drive - Reflect %
	// FG Inside - Reflect %
	// FG Jumpshot - Reflect %
	// FG 3pt Shot - Reflect %
	// Free Throw - Reflect %
	// Draw Fouls - Ability to draw contact
	// Scoring - Scoring ability. Ability to make tough shots.
	// Pass 
	// Handle
	// Off Reb
	// Def Reb
	// Block
	// Steal
	// Defense
	// Discipline
	// Basketball IQ
	private enum Rating { FGD, FGI, FGJ, FG3, FT, DRFL, SCR,
		PAS, HDL, OREB, DREB, BLK, STL, DEF, DIS, IQ};
	
		
	private enum Tendency {SHOOT, PASS, DRIVE}; // Add hidden dribble tendency.  	
		
	public Player()
	{
		
	}
	
	// Change probability depending on shot.
	// Foul OFF - DRFL, 
	// Foul DEF - DEF, IQ
	
	// Driving OFF - FGD, STR, SPD, HDL, VERT
	// Driving DEF - DEF, STR, SPD, QUI, VERT, BLK, STL
	
	// Jumper OFF - FGJ/FG3, SCR
	// Jumper DEF - DEF, BLK, VERT, STL
	
	// Passing 
	
	
	
}
