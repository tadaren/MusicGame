package dust;

import javax.swing.SwingUtilities;

public class RemoveThread extends Thread {

	SubPanel panel;

    RemoveThread(SubPanel p) {
    	panel = p;
    }
    public void run() {
            // 時間のかかる処理を実行
            doLongTask();
            // イベントディスパッチスレッドでボタンを変更
            SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                            panel.changeColor();
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
