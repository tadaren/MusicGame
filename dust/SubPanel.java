package dust;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class SubPanel extends JPanel{
	
	public SubPanel(){
		setBorder(new LineBorder(Color.BLACK,1));
		setBackground(Color.CYAN);
//		addKeyListener(this);
	}
	
	public void changeColor(){
		if(getBackground() == Color.CYAN){
			setBackground(Color.YELLOW);
		}else{
			setBackground(Color.CYAN);
		}
	}

}
