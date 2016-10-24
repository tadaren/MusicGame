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

	public void changeColor(int colorNum){
		if(getBackground() == Color.CYAN){
			if(colorNum == 0){
				setBackground(Color.ORANGE);
			}else if(colorNum == 1){
				setBackground(Color.green);
			}else if(colorNum == 2){
				setBackground(new Color(190, 255, 255));
			}
		}else{
			setBackground(Color.CYAN);
		}
	}

	public void changeColor(){
		if(!(getBackground() == Color.CYAN)){
			setBackground(Color.CYAN);
		}
	}

}
