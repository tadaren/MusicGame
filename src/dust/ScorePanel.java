package dust;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScorePanel extends JPanel{

	public ScorePanel(int score, int combo){
		JFrame frame = new JFrame("score");
		frame.setBounds(30, 30, 200, 150);

		frame.add(this);
		frame.setVisible(true);
	}

}
