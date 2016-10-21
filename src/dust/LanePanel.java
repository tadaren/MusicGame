package dust;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class LanePanel extends JPanel implements ActionListener{

	private LaneSubPanel panel1;
	private LaneSubPanel panel2;
	private LaneSubPanel panel3;
	private LaneSubPanel panel4;

	Timer timer;

	private byte[][] notes;
	private int max ;
	private int count;

	public LanePanel(int FPS, int max){

		panel1 = new LaneSubPanel(notes[0]);
		panel2 = new LaneSubPanel(notes[1]);
		panel3 = new LaneSubPanel(notes[2]);
		panel4 = new LaneSubPanel(notes[3]);
		this.max = max;
		timer = new Timer(1000/FPS,this);
	}

	public void start(){
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel1.upDate();
		panel2.upDate();
		panel3.upDate();
		panel4.upDate();
		count ++;
		if(count > max){
			timer.stop();
		}
	}

}
