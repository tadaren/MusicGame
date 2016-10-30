package dust;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ScoreLog {

	int[] scorelist = new int[10];
	File f;

	public ScoreLog(File filename){
		f = new File(filename+"/scorelog.txt");
		if(!f.exists()){
			f.mkdirs();
		}
		try{
			BufferedReader br = new BufferedReader(new FileReader(f));
			String str;
			for(int i = 0;(str = br.readLine()) != null && i < 10; i++){
				scorelist[i] = Integer.parseInt(str);
			}
			br.close();
		}catch(java.io.IOException e){
		}

	}

	public int[] getScoreList(){
		return scorelist;
	}
	public int getRankScore(int rank){
		return scorelist[scorelist.length-1];
	}
	public void addScore(int score){
		if(scorelist[0] < score){
			scorelist[0] = score;
			Arrays.sort(scorelist);
			writeScore();
		}
	}
	private void writeScore(){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			for(int i = 0; i < scorelist.length; i++){
				bw.write(scorelist[i]);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
		}
	}

}
