package dust;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

	final char KEY1 = 'd';
	final char KEY2 = 'f';
	final char KEY3 = 'j';
	final char KEY4 = 'k';

	private final int FRAME_SIZE_X = 600;
	private final int FRAME_SIZE_Y = 800;
	private final int FPS = 30;

	private JFrame frame = new JFrame();
	private SubPanel panel1 = new SubPanel();
	private SubPanel panel2 = new SubPanel();
	private SubPanel panel3 = new SubPanel();
	private SubPanel panel4 = new SubPanel();
	private LanePanel lanePanel;
	private JPanel infoPanel;

	public GamePanel(){
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

//		lanePanel = new LanePanel(FPS, 1);
		lanePanel = new LanePanel(new MusicData(".\\music\\music1\\music_note.txt"));
		lanePanel.start();
		lanePanel.setBounds(0, 0, FRAME_SIZE_X-100, FRAME_SIZE_Y);
		lanePanel.setOpaque(false);
		this.add(lanePanel,0);

		infoPanel = new JPanel(){
			public void paint(Graphics g){
				Graphics2D g2 = (Graphics2D)g;
				g2.setStroke(new BasicStroke(4));
				g2.draw(new Line2D.Double(0,FRAME_SIZE_Y-140,FRAME_SIZE_X-101,FRAME_SIZE_Y-140));
			}
		};
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
				if(e.getKeyChar() == KEY1){
					panel1.changeColor();
					frame.repaint();
					Thread removeThread = new RemoveThread(panel1,frame);
					removeThread.start();
				}else if(e.getKeyChar() == KEY2){
					panel2.changeColor();
					frame.repaint();
					Thread removeThread = new RemoveThread(panel2,frame);
					removeThread.start();
				}else if(e.getKeyChar() == KEY3){
					panel3.changeColor();
					frame.repaint();
					Thread removeThread = new RemoveThread(panel3,frame);
					removeThread.start();
				}else if(e.getKeyChar() == KEY4){
					panel4.changeColor();
					frame.repaint();
					Thread removeThread = new RemoveThread(panel4,frame);
					removeThread.start();
				}
				frame.repaint();
			}
		});

	}

}
