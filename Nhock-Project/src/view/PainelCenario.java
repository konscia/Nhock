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
	}

	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		this.cenario.desenha(g);
		this.nhock.desenha(g);
	}
}
