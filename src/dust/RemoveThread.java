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
    public void run() {
            // 時間のかかる処理を実行
            doLongTask();
            // イベントディスパッチスレッドでボタンを変更
            SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                            panel.changeColor();
                            frame.repaint();
                    }
            });
    }
    private void doLongTask() {
        try {
                Thread.sleep(100);
        } catch (InterruptedException ex) {
        }
}

}
