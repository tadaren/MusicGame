package dust;

import java.io.File;

public class StartPanel {

	public static void main(String[] args) {
		File f = new File(".");
		String[] lis = f.list();
		for(int i = 0; i < lis.length; i++)
		System.out.println(lis[i]);

	}

}
