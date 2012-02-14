package model;

import util.Util;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Responsabilidade da Classe: Controla operações exclusivas do cenário.
 */
public class Cenario {

	/*
	 * Constantes, cada constante representa um elemento do cenário
	*/
	static int VAZIO = 0;
	static int MURO = 1;
	static int NHOCK = 2;

	//A Matriz é um vetor bidimensional que armazena todos os blocos da tela do jogador.
	private int[][] matriz;

	//A semente é a comida do Nhock. Ela é representada por um ponto.
	private Ponto semente;

	public Cenario(){
		//Cria cenário básico.
		//Cada número representa alguma coisa na Matriz
		//O número 1 é uma parede
		//O número zero é casa vazia.
		this.matriz = new int[][]{
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};

		this.sorteiaSemente();
	}

	/**
	 * Verifica se um detrminado ponto no cenário é um muro.
	 */
	public boolean ehMuro(Ponto p){
		int valueOfMatrix = this.matriz[p.getY()][p.getX()];
		return valueOfMatrix == Cenario.MURO;
	}

	/**
	 * Verifica se um determinado ponto do cenário é uma semente
	 */
	public boolean ehSemente(Ponto p){
		return this.semente.equals(p);
	}

	/**
	 * Desenha o cenário de acordo com a matriz.
	 * Cada número da matriz é representado por um quadrado.
	 */
	public void desenha(Graphics g) {
		g.setColor(Color.black); //pincel é preto
		for(int i = 0; i < 10; i++ ){
			for(int j = 0; j < 20; j++){
				if(this.matriz[i][j] == Cenario.MURO){
					g.fillRect(j*20, i*20, 20, 20); //Pinta todos os muros
				}
			}
		}
		//Desenha semente
		g.setColor(Color.red); //pincel é vermelho
		g.fillRect(this.semente.getX()*20, this.semente.getY()*20, 20, 20);
	}

	public void sorteiaSemente() {
		do {
			this.semente = new Ponto(Util.random(20),Util.random(10));
		}while(this.ehMuro(this.semente)); //Enquanto o ponto sorteado for muro, continua sorteando.
	}
}
