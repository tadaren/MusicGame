package dust;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class SubPanel extends JPanel{

	public SubPanel(){
		setBorder(new LineBorder(Color.BLACK,1));
		setBackground(Color.CYAN);
	}

	public boolean changeColor(int colorNum){
		if(getBackground() == Color.CYAN){
			if(colorNum == 0){
				setBackground(Color.ORANGE);
				return true;
			}else if(colorNum == 1){
				setBackground(Color.green);
				return true;
			}else if(colorNum == 2){
				setBackground(new Color(190, 255, 255));
				return false;
			}
		}
		return false;
	}

	public void changeColor(){
		if(!(getBackground() == Color.CYAN)){
			setBackground(Color.CYAN);
		}
	}

}
