package util;

import java.util.Random;

public class Util {

	static public void sleep(int miliseconds){
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException ex) {
			System.out.println("Erro: "+ex);
		}
	}

	static public int random(int max){
		Random r = new Random();
		return r.nextInt(max);
	}

}
