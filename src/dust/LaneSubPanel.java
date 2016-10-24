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
	private final int barposition = 650;

	private byte[] notes;
	private ArrayList<int[]> noteState = new ArrayList<int[]>();
	private int noteIndex = 0;

	public LaneSubPanel(byte[] b, int bias){
		this.bias = bias;
		setOpaque(false);
		notes = b;
	}

	public void upDate(){
//		System.out.println(noteIndex+1);
		for(int i = 0; i < noteState.size(); i++){
			noteState.get(i)[0] += bias;
		}
		if(noteState.size()>0){
			if(noteState.get(0)[0] > 800){
				noteState.remove(0);
			}
		}
		switch(notes[noteIndex]){
		case 1: noteState.add(new int[]{0,1});break;
		}
		noteIndex++;
	}

	public int checkNote(){
		for(int i = 0; i < noteState.size(); i++){
			System.out.println(noteState.get(i)[0]);
			if(barposition-5 < noteState.get(i)[0] && noteState.get(i)[0] < barposition+5){
				return 0;
			}else if(barposition-15 < noteState.get(i)[0] && noteState.get(i)[0] < barposition-5
					|| barposition+5 < noteState.get(i)[0] && noteState.get(i)[0] < barposition+15){
				return 1;
			}
		}
		return 2;

	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(7));
		for(int i = 0; i < noteState.size(); i++){
			g2.draw(new Line2D.Double(2,noteState.get(i)[0],getWidth()-3,noteState.get(i)[0]));
//			g2.fillRect(0, 0, 200, 120);
		}
	}

}
