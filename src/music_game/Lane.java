package music_game;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Lane extends JPanel{

	public void paintComponent(Graphics g){
		  Graphics2D g2 = (Graphics2D)g;
		  g2.drawString("aaa", 23, 23);

	}
}
