package dust;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class LaneSubPanel extends JPanel {

	private byte[] notes;
	private int[][] noteState;
	private int noteIndex;

	public LaneSubPanel(byte[] b){
		setOpaque(false);
		notes = b;
	}

	public void upDate(){


	}

	public void paintCompornent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(3));
		for(int i = 0; i < noteState.length; i++){
			g2.draw(new Line2D.Double(0,noteState[i][0],getWidth(),noteState[i][0]));
		}



	}

}
