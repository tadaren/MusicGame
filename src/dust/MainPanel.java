package dust;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements KeyListener{
	
	private SubPanel panel1 = new SubPanel();
	private SubPanel panel2 = new SubPanel();
	private SubPanel panel3 = new SubPanel();
	private SubPanel panel4 = new SubPanel();
	final char KEY1 = 'f';
	final char KEY2 = 'g';
	final char KEY3 = 'h';
	final char KEY4 = 'j';
	
	
	public MainPanel(){
		setFocusable(true);
		setLayout(new GridLayout(1, 4));
		addKeyListener(this);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == KEY1){
			panel1.changeColor();
		}else if(e.getKeyChar() == KEY2){
			panel2.changeColor();
		}else if(e.getKeyChar() == KEY3){
			panel3.changeColor();
		}else if(e.getKeyChar() == KEY4){
			panel4.changeColor();
		}
		
	}

}
