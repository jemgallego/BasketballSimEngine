// Basketball Sim Engine - Working Title
// Jem Gallego 2013

package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener
{
	//Creates the frame object
    private static Main frame;
    
    //Creates a container object
    private Container container = getContentPane();	
        
    //Declare the buttons
    JButton newGameButton = new JButton();
	JButton loadGameButton = new JButton();
	JButton directionsButton = new JButton();
	JButton exitButton = new JButton();
	
	
	public Main()
	{		
    	container.setLayout(null);
    	
        //Set Background image
		JLabel backgroundLabel = new JLabel();
		BufferedImage img = null;
    	try 
    	{            
    	    img = ImageIO.read(new File("images/mainMenu.jpg"));
    	} 
    	catch (IOException e) 
    	{
    		e.printStackTrace();
    	}
    	
    	if(img != null)
    	{
    		ImageIcon icon = new ImageIcon(img);
    		backgroundLabel = new JLabel(icon);
    		backgroundLabel.setBounds(0,0,400,450);
    	}
    	
    	//Initialize the New Game button
    	newGameButton.setVisible(true);
    	newGameButton.setEnabled(true);
    	newGameButton.setText("NEW GAME");
    	newGameButton.setBounds(100,100,200,50);
		newGameButton.addActionListener(this);
    	this.add(newGameButton);

    	//Initialize the Load Game button
    	loadGameButton.setVisible(true);
    	loadGameButton.setEnabled(false);
    	loadGameButton.setText("LOAD GAME");
    	loadGameButton.setBounds(100,175,200,50);
		loadGameButton.addActionListener(this);
    	this.add(loadGameButton);

    	//Initialize the Directions button
    	directionsButton.setVisible(true);
    	directionsButton.setEnabled(true);
    	directionsButton.setText("DIRECTIONS");
    	directionsButton.setBounds(100,250,200,50);
		directionsButton.addActionListener(this);
    	this.add(directionsButton);

    	//Initialize the Exit button
    	exitButton.setVisible(true);
    	exitButton.setEnabled(true);
    	exitButton.setText("EXIT GAME");
    	exitButton.setBounds(100,325,200,50);
		exitButton.addActionListener(this);
		exitButton.setMnemonic(KeyEvent.VK_W);
    	this.add(exitButton);

    	//add last so it will be underneath
    	this.add(backgroundLabel);
	}
	
	public static void main(String[] args)
	{			
        final int FRAME_WIDTH = 1007;
		final int FRAME_HEIGHT = 628;

		//initializes the frame object
        frame = new Main();

        //set frame size
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        //Center the frame
        frame.setLocation(600,200);
       
        //Set frame title
		frame.setTitle("RISK: 2003 Edition :: MAIN MENU");
		
		//Handle closing window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Make frame visible
		frame.setVisible (true); 
	}
///////////////////////////////////////////////////////////////////////////////////
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton tempButton = null;
		if(e.getSource() instanceof JButton)
		{
			tempButton = (JButton)e.getSource();
		}
		if(tempButton == newGameButton)
		{
	        startGame();
		}
		else if (tempButton == loadGameButton)
		{
	        JOptionPane.showMessageDialog(frame, "Currently Not Available");
		}
		else if (tempButton == directionsButton)
		{
	        JOptionPane.showMessageDialog(frame, 
	        "Directions can be found at: http://www.hasbro.com/common/instruct/Risk_2003.pdf");
		}
		else if (tempButton == exitButton)
		{
			System.exit(0);
		}
	}

///////////////////////////////////////////////////////////////////////////////////

	private void startGame()
	{

	}

}
