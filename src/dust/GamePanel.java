import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

	private JFrame frame = new JFrame();
	private SubPanel panel1 = new SubPanel();
	private SubPanel panel2 = new SubPanel();
	private SubPanel panel3 = new SubPanel();
	private SubPanel panel4 = new SubPanel();
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
		add(barpanel);
		
		JPanel LanePanel = new JPanel();
		
		infoPanel = new JPanel(){
			public void paint(Graphics g){
				Graphics2D g2 = (Graphics2D)g;
				g2.setStroke(new BasicStroke(2));
				g2.draw(new Line2D.Double(0,FRAME_SIZE_Y-140,FRAME_SIZE_X-101,FRAME_SIZE_Y-140));
			}
		};
		infoPanel.setOpaque(true);
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
					Thread removeThread = new RemoveThread(panel1);
					removeThread.start();
				}else if(e.getKeyChar() == KEY2){
					panel2.changeColor();
					frame.repaint();
					Thread removeThread = new RemoveThread(panel2);
					removeThread.start();
				}else if(e.getKeyChar() == KEY3){
					panel3.changeColor();
					frame.repaint();
					Thread removeThread = new RemoveThread(panel3);
					removeThread.start();
				}else if(e.getKeyChar() == KEY4){
					panel4.changeColor();
					frame.repaint();
					Thread removeThread = new RemoveThread(panel4);
					removeThread.start();
				}
				frame.repaint();
			}
		});
		
	}

}
