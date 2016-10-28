package dust;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class StartPanel extends JPanel{

	private final String musicdir;
	private JList<String> musicList;

	public StartPanel(){
		JFrame frame = new JFrame("音ゲー");
		frame.setBounds(10, 10, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		Properties configuration = new Properties();
		try {
			InputStream inputStream = new FileInputStream(new File("game.properties"));
			configuration.load(inputStream);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Propertiesファイルが存在しません。", "Error", JOptionPane.ERROR_MESSAGE);
		}
		musicdir = "./"+configuration.getProperty("Directory");

		File f = new File(musicdir);
		String[] lis = f.list();
		Vector<String> list = new Vector<String>();
		for(int i = 0; i < lis.length; i++){
			File fi = new File(musicdir +"/"+ lis[i]);
			if(fi.isDirectory()){
				File file = new File(musicdir +"/"+ lis[i] + "/note.txt");
				if(file.exists()){
					list.add(lis[i]);
				}
			}
		}
		musicList = new JList<String>(list);
		musicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );

		JScrollPane sp = new JScrollPane();
		sp.getViewport().setView(musicList);
		sp.setBounds(150,160,300,100);

		this.setLayout(null);
		this.add(sp);

		JLabel title = new JLabel("音ゲー");
		title.setFont(new Font("MSゴシック",Font.BOLD | Font.ITALIC, 70));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setForeground(Color.ORANGE);
		title.setOpaque(false);
		title.setBounds(150, 30, 300, 100);
		this.add(title);

		JButton button = new JButton("START");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GamePanel(musicList.getSelectedValue(),musicdir+"/"+musicList.getSelectedValue()+"/note.txt");
			}
		});

		this.setBackground(Color.CYAN);
		frame.add(this);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new StartPanel();

	}

}
