package dust;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LaneSubPanel extends JPanel {

	private final int bias;

	private byte[] notes;
	private ArrayList<byte[]> noteState = new ArrayList<byte[]>();
	private int noteIndex = 0;

	public LaneSubPanel(byte[] b, int bias){
		this.bias = bias;
		setOpaque(false);
		notes = b;
	}

	public void upDate(){
		System.out.println(noteIndex);
		for(int i = 0; i < noteState.size(); i++){
			noteState.get(i)[0] += 1;
		}
		switch(notes[noteIndex]){
		case 0: break;
		case 1: noteState.add(new byte[]{0,1});break;
		}
		noteIndex++;
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(5));
		for(int i = 0; i < noteState.size(); i++){
			g2.draw(new Line2D.Double(2,noteState.get(i)[0]*bias,getWidth()-3,noteState.get(i)[0]*bias));
//			g2.fillRect(0, 0, 200, 120);
		}
	}

}
