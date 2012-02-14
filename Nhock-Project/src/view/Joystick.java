package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Responsabilidade da Classe: Informa a direção para onde o nhock deve se mover e se algum botão do jogo foi pressionado.
 */
public class Joystick implements KeyListener {

	static final int DIREITA = 1;
	static final int ESQUERDA = 2;
	static final int CIMA = 3;
	static final int BAIXO = 4;

	private int teclaPressionada = 0;

	public boolean direitaPressionada(){ return teclaPressionada == DIREITA;}
	public boolean esquerdaPressionada(){ return teclaPressionada == ESQUERDA;}
	public boolean cimaPressionada(){ return teclaPressionada == CIMA;}
	public boolean baixoPressionada(){ return teclaPressionada == BAIXO;}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:
				teclaPressionada = DIREITA;
				break;
			case KeyEvent.VK_LEFT:
				teclaPressionada = ESQUERDA;
				break;
			case KeyEvent.VK_UP:
				teclaPressionada = CIMA;
				break;
			case KeyEvent.VK_DOWN:
				teclaPressionada = BAIXO;
				break;
		}
	}

	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}


}
