import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	final char KEY1 = 'd';
	final char KEY2 = 'f';
	final char KEY3 = 'j';
	final char KEY4 = 'k';

	private JFrame frame = new JFrame();
	private SubPanel panel1 = new SubPanel();
	private SubPanel panel2 = new SubPanel();
	private SubPanel panel3 = new SubPanel();
	private SubPanel panel4 = new SubPanel();

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
		barpanel.setBounds(0, 0, 500, 800);
		add(barpanel);

		frame.setVisible(true);
	}

	public void setFrame(JFrame frame){
		frame.setBounds(10, 10, 600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.addKeyListener(new KeyAdapter() {
			public void KeyTyped(KeyEvent e){
				if(e.getKeyChar() == KEY1){
					panel1.changeColor();
					Thread removeThread = new RemoveThread(panel1);
					removeThread.start();
				}else if(e.getKeyChar() == KEY2){
					panel2.changeColor();
					Thread removeThread = new RemoveThread(panel2);
					removeThread.start();
				}else if(e.getKeyChar() == KEY3){
					panel3.changeColor();
					Thread removeThread = new RemoveThread(panel3);
					removeThread.start();
				}else if(e.getKeyChar() == KEY4){
					panel4.changeColor();
					Thread removeThread = new RemoveThread(panel4);
					removeThread.start();
				}
			}
		});
	}

}
