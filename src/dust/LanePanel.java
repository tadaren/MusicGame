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

	private int[][] notes;

	public LanePanel(int FPS){
		panel1 = new LaneSubPanel();
		panel2 = new LaneSubPanel();
		panel3 = new LaneSubPanel();
		panel4 = new LaneSubPanel();
		Timer timer = new Timer(1000/FPS,this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel1.upDate();
		panel2.upDate();
		panel3.upDate();
		panel4.upDate();
	}

}
