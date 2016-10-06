package dust;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public Main(){
		setBounds(10, 10, 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(1, 4));
		
		SubPanel panel1 = new SubPanel('d');
		SubPanel panel2 = new SubPanel('f');
		SubPanel panel3 = new SubPanel('j');
		SubPanel panel4 = new SubPanel('k');
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		setVisible(true);
		
	}

}
