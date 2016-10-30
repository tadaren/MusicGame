package dust;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RemoveThread extends Thread {

	SubPanel panel;
	JFrame frame;

    RemoveThread(SubPanel p, JFrame f) {
    	panel = p;
    	frame = f;
    }
    public RemoveThread(SubPanel panel1) {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void run() {
            doLongTask();
            SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                            panel.changeColor();
                            frame.repaint();
                    }
            });
    }
    private void doLongTask() {
        try {
                Thread.sleep(70);
        } catch (InterruptedException ex) {
        }
}

}
