package dust;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class LanePanel extends JPanel implements ActionListener{

	private LaneSubPanel panel1;
	private LaneSubPanel panel2;
	private LaneSubPanel panel3;
	private LaneSubPanel panel4;
	private InfoPanel ip;

	Timer timer;

	private int max ;
	private int count;

	private MusicData md;

//	public LanePanel(int FPS, int max){
//		this.setLayout(new GridLayout(1,4));
//		panel1 = new LaneSubPanel(notes[0], bias, 10);
//		panel2 = new LaneSubPanel(notes[1], bias, 10);
//		panel3 = new LaneSubPanel(notes[2], bias, 10);
//		panel4 = new LaneSubPanel(notes[3], bias, 10);
//		this.max = max;
//		timer = new Timer(1000/FPS,this);
//	}

	public LanePanel(MusicData music, int FPS, InfoPanel ip){
		this.setLayout(new GridLayout(1,4));
		this.setBounds(0, 0, 500, 800);
		this.ip = ip;
		this.md = music;
		max = music.getLaneData(1).length-3;
		this.panel1 = new LaneSubPanel(music.getLaneData(1), music.getSpeed(), music.getCorrection(), ip);
		this.panel2 = new LaneSubPanel(music.getLaneData(2), music.getSpeed(), music.getCorrection(), ip);
		this.panel3 = new LaneSubPanel(music.getLaneData(3), music.getSpeed(), music.getCorrection(), ip);
		this.panel4 = new LaneSubPanel(music.getLaneData(4), music.getSpeed(), music.getCorrection(), ip);

		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);

		timer = new Timer(1000/FPS, this);
	}

	public void start(){
		timer.start();
	}

	public int checkNote(int index){
//		System.out.println(false);
		switch(index){
		case 1: return panel1.checkNote();
		case 2: return panel2.checkNote();
		case 3: return panel3.checkNote();
		case 4: return panel4.checkNote();
		}
		return 5;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel1.upDate();
		panel2.upDate();
		panel3.upDate();
		panel4.upDate();
		if(count > max*32/md.getCorrection()){
			timer.stop();
			ip.end();
		}
		count ++;
		repaint();
	}

}
