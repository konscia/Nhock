package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import model.Cenario;
import model.Nhock;

/**
 * Responsabilidade da Classe: Gerencia e desenha os elementos do jogo.
 */
public class PainelCenario extends Canvas{

	Cenario cenario;
	Nhock nhock;

	//Constrói painel Cenário.
	//O painel é sempre composto por estes dois objetos que devem ser enviados do NhockGame.
	//Lembre-se: Só pode existir apenas um objeto nhock e um objeto cenário no jogo inteiro.
	public PainelCenario(Cenario cenario, Nhock nhock){
		this.cenario = cenario;
		this.nhock = nhock;

		this.setSize(400,200);

		this.setIgnoreRepaint(true);
	}

	public void desenha(){
		if (!getBufferStrategy().contentsLost()){
			getBufferStrategy().show();
		}
	}

	public void renderGraphics() {
		Graphics g = getBufferStrategy().getDrawGraphics();

		//Criamos um contexto gráfico que não leva em conta as bordas
		Graphics g2 = g.create();
		//Limpamos a tela
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());

		this.cenario.desenha(g2);
		this.nhock.desenha(g2);

		//Liberamos os contextos criados.
		g.dispose();
		g2.dispose();
	}
}
