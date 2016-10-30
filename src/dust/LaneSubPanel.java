package dust;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LaneSubPanel extends JPanel {

	private final float distance;
	private final int ERROR = 15;
	private final int barposition = 650;
	private final int interval;

	private byte[] notes;
	private ArrayList<float[]> noteState = new ArrayList<float[]>();
	private int noteIndex = 0;
	private final InfoPanel ip;

	private int count = 1;

	public LaneSubPanel(byte[] b, float distance, int interval, InfoPanel ip){
		this.distance = distance;
		this.ip = ip;
		this.interval = interval;
		setOpaque(false);
		notes = b;
	}

	public void upDate(){
//		System.out.println(noteIndex+1);
		moveNote();
		addNote();
	}

	private void moveNote(){
		for(int i = 0; i < noteState.size(); i++){
//			System.out.println(distance);
			noteState.get(i)[0] += distance;
		}
		if(noteState.size()>0){
			if(noteState.get(0)[0] > 800){
				noteState.remove(0);
				ip.comboReset();
				ip.repaint();
			}
		}
	}

	private void addNote(){
		if(count == interval){
			if(noteIndex < notes.length){
				switch(notes[noteIndex]){
				case 1: noteState.add(new float[]{0,1});break;
				}
				noteIndex++;
				count = 1;
			}
		}else{
			count++;
		}
	}

	public int checkNote(){
		for(int i = 0; i < noteState.size(); i++){
//			System.out.println(noteState.get(i)[0]);
			if(barposition-ERROR <= noteState.get(i)[0] && noteState.get(i)[0] <= barposition+ERROR+4){
				noteState.remove(i);
				return 0;
			}else if(barposition-ERROR*4 < noteState.get(i)[0] && noteState.get(i)[0] < barposition-ERROR
					|| barposition+ERROR < noteState.get(i)[0] && noteState.get(i)[0] < barposition+ERROR*4){
				noteState.remove(i);
				return 1;
			}else if(barposition-ERROR*6 < noteState.get(i)[0] && noteState.get(i)[0] < barposition-ERROR*4){
				ip.comboReset();
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
		}
	}

}
