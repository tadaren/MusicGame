package dust;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class SubPanel extends JPanel implements KeyListener{
	private char pattern;
	
	public SubPanel(char setpattern){
		setPattern(setpattern);
		setBorder(new LineBorder(Color.BLACK,1));
		setBackground(Color.CYAN);
		addKeyListener(this);
	}
	
	public char getPattern() {
		return pattern;
	}
	
	public void setPattern(char pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());
		if(e.getKeyChar() == pattern){
			if(getBackground() == Color.CYAN){
				setBackground(Color.YELLOW);
			}else{
				//setBackground(Color.CYAN);
			}
			
		}
	}

}
