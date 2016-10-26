package dust;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{

	final char KEY1;
	final char KEY2;
	final char KEY3;
	final char KEY4;

	private final int FRAME_SIZE_X = 600;
	private final int FRAME_SIZE_Y = 800;
	private final int FPS;

	private JFrame frame = new JFrame();
	private SubPanel panel1 = new SubPanel();
	private SubPanel panel2 = new SubPanel();
	private SubPanel panel3 = new SubPanel();
	private SubPanel panel4 = new SubPanel();
	private LanePanel lanePanel;
	private InfoPanel infoPanel;

	public GamePanel(){
		KEY1 = 'd';
		KEY2 = 'f';
		KEY3 = 'j';
		KEY4 = 'k';
		FPS = 60;

		setFrame(frame);
		frame.add(this);

		this.setLayout(null);

		JPanel barpanel = new JPanel();
		barpanel.setLayout(new GridLayout(1, 4));
		barpanel.add(panel1);
		barpanel.add(panel2);
		barpanel.add(panel3);
		barpanel.add(panel4);
		barpanel.setBounds(0, 0, FRAME_SIZE_X-100, FRAME_SIZE_Y);
		this.add(barpanel);

		infoPanel = new InfoPanel(FRAME_SIZE_X, FRAME_SIZE_Y);

//		lanePanel = new LanePanel(FPS, 1);
		lanePanel = new LanePanel(new MusicData("./music/music1/music_note.txt"), FPS, infoPanel);
		lanePanel.start();
		lanePanel.setBounds(0, 0, FRAME_SIZE_X-100, FRAME_SIZE_Y);
		lanePanel.setOpaque(false);
		this.add(lanePanel,0);

//		infoPanel = new JPanel(){
//			public void paintComponent(Graphics g){
//				Graphics2D g2 = (Graphics2D)g;
//				g2.setStroke(new BasicStroke(5));
//				g2.draw(new Line2D.Double(0,FRAME_SIZE_Y-150,FRAME_SIZE_X-101,FRAME_SIZE_Y-150));
//			}
//		};
		infoPanel.setOpaque(false);
		infoPanel.setBounds(0, 0, FRAME_SIZE_X, FRAME_SIZE_Y);
		this.add(infoPanel,0);

		frame.setVisible(true);
	}

	public GamePanel(String filename){
		Properties configuration = new Properties();
		try {
			InputStream inputStream = new FileInputStream(new File("game.properties"));
			configuration.load(inputStream);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Propertiesファイルが存在しません。", "Error", JOptionPane.ERROR_MESSAGE);
		}
		KEY1 = configuration.get("KEY1").toString().charAt(0);
		KEY2 = configuration.get("KEY2").toString().charAt(0);
		KEY3 = configuration.get("KEY3").toString().charAt(0);
		KEY4 = configuration.get("KEY4").toString().charAt(0);
		FPS = Integer.parseInt(configuration.getProperty("FPS"));

		this.setLayout(null);

		setFrame(frame);
		frame.add(this);

		JPanel barpanel = new JPanel();
		barpanel.setLayout(new GridLayout(1, 4));
		barpanel.add(panel1);
		barpanel.add(panel2);
		barpanel.add(panel3);
		barpanel.add(panel4);
		barpanel.setBounds(0, 0, FRAME_SIZE_X-100, FRAME_SIZE_Y);
		this.add(barpanel);

		infoPanel = new InfoPanel(FRAME_SIZE_X, FRAME_SIZE_Y);
		lanePanel = new LanePanel(new MusicData(filename), FPS, infoPanel);
		lanePanel.start();
		lanePanel.setBounds(0, 0, FRAME_SIZE_X-100, FRAME_SIZE_Y);
		lanePanel.setOpaque(false);
		this.add(lanePanel,0);
		infoPanel.setOpaque(false);
		infoPanel.setBounds(0, 0, FRAME_SIZE_X, FRAME_SIZE_Y);
		this.add(infoPanel,0);

		frame.setVisible(true);
	}

	public void setFrame(JFrame frame){
		frame.setBounds(10, 10, FRAME_SIZE_X, FRAME_SIZE_Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
//				System.out.println(true);
				if(e.getKeyChar() == KEY1){
					if(panel1.changeColor(lanePanel.checkNote(1))){
						infoPanel.addCombo();
					}
					Thread removeThread = new RemoveThread(panel1,frame);
					removeThread.start();
				}else if(e.getKeyChar() == KEY2){
					if(panel2.changeColor(lanePanel.checkNote(2))){
						infoPanel.addCombo();
					}
					Thread removeThread = new RemoveThread(panel2,frame);
					removeThread.start();
				}else if(e.getKeyChar() == KEY3){
					if(panel3.changeColor(lanePanel.checkNote(3))){
						infoPanel.addCombo();
					}
					Thread removeThread = new RemoveThread(panel3,frame);
					removeThread.start();
				}else if(e.getKeyChar() == KEY4){
					if(panel4.changeColor(lanePanel.checkNote(4))){
						infoPanel.addCombo();
					}
					Thread removeThread = new RemoveThread(panel4,frame);
					removeThread.start();
				}
				frame.repaint();
			}
		});

	}

}
