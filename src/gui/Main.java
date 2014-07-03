// Basketball Sim Engine - Working Title
// Jem Gallego 2013

package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import player.Player;


@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener
{
	//Creates the frame object
    private static Main frame;
    
    //Creates a container object
    private Container container = getContentPane();	
        
    //Declare the buttons
    private JButton createPlayersButton = new JButton();
    private JButton displayPlayersButton = new JButton();
    private JButton clearTextArea = new JButton();
    private JButton exitButton = new JButton();
	
	private static JTextArea output = new JTextArea(20,20); // Scanner output
	
	String[] columnNames = {"Pos", "Name", "Height", "Weight", "Age", "College"};
	Object[][] test = {{4, "Jem Gallego", "5-9", "171", "27", "LBSU"},
			{4, "Jem Gallego", "5-9", "171", "27", "LBSU"}};
	
	private JTable table;
    private final JScrollPane scrollPane = new JScrollPane(table);	

    
	public Main()
	{		
    	container.setLayout(null);
    	
        //Set Background image
		JLabel backgroundLabel = new JLabel();
		BufferedImage img = null;
//    	try 
//    	{            
//    	    img = ImageIO.read(new File("images/mainMenu.jpg"));
//    	} 
//    	catch (IOException e) 
//    	{
//    		e.printStackTrace();
//    	}
    	
    	if(img != null)
    	{
    		ImageIcon icon = new ImageIcon(img);
    		backgroundLabel = new JLabel(icon);
    		backgroundLabel.setBounds(0,0,400,450);
    	}
    	 	
    	output.setEditable(false);
    	    	
    	//Initialize the New Game button
    	createPlayersButton.setVisible(true);
    	createPlayersButton.setEnabled(true);
    	createPlayersButton.setText("Create Players");
    	createPlayersButton.setBounds(100,100,200,50);
		createPlayersButton.addActionListener(this);
    	this.add(createPlayersButton);

    	//Initialize the Load Game button
    	displayPlayersButton.setVisible(true);
    	displayPlayersButton.setEnabled(true);
    	displayPlayersButton.setText("Display Players");
    	displayPlayersButton.setBounds(100,175,200,50);
		displayPlayersButton.addActionListener(this);
    	this.add(displayPlayersButton);

    	//Initialize the Directions button
    	clearTextArea.setVisible(true);
    	clearTextArea.setEnabled(true);
    	clearTextArea.setText("Clear Text Area");
    	clearTextArea.setBounds(100,250,200,50);
		clearTextArea.addActionListener(this);
    	this.add(clearTextArea);

    	//Initialize the Exit button
    	exitButton.setVisible(true);
    	exitButton.setEnabled(true);
    	exitButton.setText("EXIT GAME");
    	exitButton.setBounds(100,325,200,50);
		exitButton.addActionListener(this);
		exitButton.setMnemonic(KeyEvent.VK_W);
    	this.add(exitButton);
    	

    	scrollPane.setVisible(true);
    	scrollPane.setBounds(350, 100, 600, 400);
    	this.add(scrollPane);
    	
    	//add last so it will be underneath
    	this.add(backgroundLabel);
	}
	
	public static void main(String[] args)
	{			
        final int FRAME_WIDTH = 1000;
		final int FRAME_HEIGHT = 700;

		//initializes the frame object
        frame = new Main();

        frame.setTitle("Basketball Sim Engine (Working Title)");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocation(600,200);

		//Handle closing window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible (true);
		frame.setResizable(false);
	}
///////////////////////////////////////////////////////////////////////////////////
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton tempButton = null;
		if(e.getSource() instanceof JButton)
		{
			tempButton = (JButton)e.getSource();
		}
		if(tempButton == createPlayersButton)
		{
	        createPlayers();
		}
		else if (tempButton == displayPlayersButton)
		{
	        displayPlayers();
		}
		else if (tempButton == clearTextArea)
		{
	        clearOutput();
		}
		else if (tempButton == exitButton)
		{
			System.exit(0);
		}
	}

///////////////////////////////////////////////////////////////////////////////////

	private ArrayList<Player> players = new ArrayList<Player>();
	
	private void createPlayers()
	{	
		try 
		{
			File inputWorkbook = new File("files/players.xls");
			Workbook w  = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(0);
				
//				for (int j = 0; j < sheet.getColumns(); j++) 
//				{
//					Cell cell = sheet.getCell(j, 0);
//					firstLine += cell.getContents() + " ";
//				}
//			
//				// check to make sure the file is in the correct order.
//				if(!firstLine.equals(ORDER))
//				{
//					Main.updateOutput("\n===== START ERROR MESSAGE =====\n\n" +
//							"ERROR: There is an error in prospects.xls!\n\n" +
//							"Check the column names and order.\n\n" + 
//							"\n=====  END ERROR MESSAGE  =====\n\n" );
//					return;
//				}
			
			int pid=0;
			ArrayList<String> playerInfo = new ArrayList<String>();
			
			for(int i = 1; i < sheet.getRows(); i++) 
			{
				playerInfo.add(pid + "");
				pid++;
				
				Cell firstName = sheet.getCell(0,i);
				Cell lastName = sheet.getCell(1,i);
				
				String name = firstName.getContents().trim() + " " + lastName.getContents().trim();
				playerInfo.add(name);
				
				for(int j = 2; j < sheet.getColumns(); j++)
				{
					Cell cell = sheet.getCell(j,i);
					playerInfo.add(cell.getContents());
				}
				
				Player player = new Player(playerInfo);
				playerInfo.clear();			
				
				players.add(player);
			} 
			w.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			Main.updateOutput("\n===== START ERROR MESSAGE =====\n\n" +
					"ERROR: Invalid file" +
					"\n\n=====  END ERROR MESSAGE  =====\n\n" );
		} 
	}
	
	private void displayPlayers()
	{
		clearOutput();
		
		Object[][] data = new Object[players.size()][6];
		
		for(int i = 0; i < players.size(); i++)
		{
			Object[] playerData = players.get(i).getPlayerData();
	
			data[i] = playerData;
			
		}
		
		table = new JTable(data, columnNames);
	}
	
    public static void updateOutput(String str)
    {
    	output.append(str);
    }
    
    private static void clearOutput()
    {
    	output.setText(null);
    }

}
