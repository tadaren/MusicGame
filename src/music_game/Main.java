package music_game;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{

	public static void main(String[] args) {
		new Main();

	}

	public Main(){
		setTitle("音ゲー");
		setBounds(100, 100, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelMain = new JPanel();
//		panelMain.setPreferredSize(new Dimension(700,400));
		panelMain.setLayout(new BorderLayout());
		Lane one = new Lane();
		panelMain.add(one,BorderLayout.CENTER);
//		add(one);
		add(panelMain);
		setVisible(true);
	}

}
