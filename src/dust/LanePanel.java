package dust;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import music_game.MP3Player;

@SuppressWarnings("serial")
public class LanePanel extends JPanel implements ActionListener{

	private LaneSubPanel panel1;
	private LaneSubPanel panel2;
	private LaneSubPanel panel3;
	private LaneSubPanel panel4;
	private InfoPanel ip;

	Timer timer;

	private int count;
	private boolean musicPlay = false;
	private final int FPS;

	private MusicData md;
	private MP3Player player;

	public LanePanel(MusicData music, int FPS, InfoPanel ip, String playerPath){
		this.setLayout(new GridLayout(1,4));
		this.setBounds(0, 0, 500, 800);
		this.ip = ip;
		this.md = music;
		this.FPS = FPS;
		this.panel1 = new LaneSubPanel(music.getLaneData(1), music.getSpeed()/FPS*100, FPS*60/md.getTempo(), ip);
		this.panel2 = new LaneSubPanel(music.getLaneData(2), music.getSpeed()/FPS*100, FPS*60/md.getTempo(), ip);
		this.panel3 = new LaneSubPanel(music.getLaneData(3), music.getSpeed()/FPS*100, FPS*60/md.getTempo(), ip);
		this.panel4 = new LaneSubPanel(music.getLaneData(4), music.getSpeed()/FPS*100, FPS*60/md.getTempo(), ip);

		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);

		try {
			player = new MP3Player(new File(playerPath));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "ERRORが発生しました。", "Error", JOptionPane.ERROR_MESSAGE);
		}
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
		if(!musicPlay){
			musicPlay = true;
			player.play();
		}

		if(count < md.getTime()*FPS){
			panel1.upDate();
			panel2.upDate();
			panel3.upDate();
			panel4.upDate();
		}else{
			timer.stop();
			ip.end();
			player.stop();
		}
		count ++;
		repaint();
	}

}
