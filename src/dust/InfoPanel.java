package dust;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

	private final int FRAME_SIZE_X;
	private final int FRAME_SIZE_Y;

	private int combo = 0;
	private int score = 0;
	private final int scorePoint;
	private final double scoreNear;
	private boolean end = false;

	public InfoPanel(int x, int y){
		this(x, y, 100, 0.5);
	}
	public InfoPanel(int x, int y, int scorePoint){
		this(x, y, scorePoint, 0.5);
	}
	public InfoPanel(int x, int y, int scorePoint, double scoreNear){
		this.FRAME_SIZE_X = x;
		this.FRAME_SIZE_Y = y;
		this.scorePoint = scorePoint;
		this.scoreNear = scoreNear;
	}

	public void addCombo(){
		combo++;
	}
	public void comboReset(){
		combo = 0;
	}
	public void addScore(int judge){
		switch(judge){
		case 0: score += scorePoint*(1+(0.01*combo));
		case 1: score += scorePoint*scoreNear*(1+(0.01*combo));
		}

	}
	public int getScore(){
		return this.score;
	}

	public int getCombo(){
		return combo;
	}
	public void end(){
		end = true;
		repaint();
	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Double(0,FRAME_SIZE_Y-150,FRAME_SIZE_X-101,FRAME_SIZE_Y-150));

		g2.setFont(new Font("MSゴシック", Font.PLAIN, 20));
		g2.drawString("score", FRAME_SIZE_X-90, 100);
		g2.drawString(""+score, FRAME_SIZE_X-90, 120);
		g2.drawString("combo", FRAME_SIZE_X-90, 160);
		g2.drawString(""+combo, FRAME_SIZE_X-90, 180);
		if(end){
			g2.setFont(new Font("MSゴシック", Font.PLAIN, 50));
			g2.drawString("END", 100, 100);
		}

	}

}
