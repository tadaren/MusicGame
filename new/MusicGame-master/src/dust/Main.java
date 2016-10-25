package dust;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	public Main(){
		setBounds(10, 10, 500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		BarPanel mainPanel = new BarPanel();
		add(mainPanel);

		setVisible(true);

	}

}
