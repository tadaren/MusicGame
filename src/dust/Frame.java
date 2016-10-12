package dust;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Frame();

	}

	public Frame(){
		setBounds(10, 10, 500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		BarPanel barPanel = new BarPanel();
		barPanel.setBounds(0, 700, 400, 10);

		mainPanel.add(barPanel);
		add(mainPanel);

		setVisible(true);

	}

}
