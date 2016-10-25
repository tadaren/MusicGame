package dust;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BarPanel extends JPanel{

	private SubPanel panel1 = new SubPanel();
	private SubPanel panel2 = new SubPanel();
	private SubPanel panel3 = new SubPanel();
	private SubPanel panel4 = new SubPanel();
	final char KEY1 = 'd';
	final char KEY2 = 'f';
	final char KEY3 = 'j';
	final char KEY4 = 'k';


	public BarPanel(){
//		setFocusable(true);
		setLayout(new GridLayout(1, 4));
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
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
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
	}

}

