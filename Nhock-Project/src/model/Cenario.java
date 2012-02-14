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
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
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
		g.setColor(new Color(60, 60, 60)); //pincel é preto
		for(int i = 0; i < this.matriz.length; i++ ){
			for(int j = 0; j < this.matriz[i].length; j++){
				if(this.matriz[i][j] == Cenario.MURO){
					g.fillRect(j*Config.TAMANHO, i*Config.TAMANHO, Config.TAMANHO, Config.TAMANHO); //Pinta todos os muros
				}
			}
		}
		//Desenha semente
		g.setColor(Color.green); //pincel é vermelho
		g.fillRect(this.semente.getX()*Config.TAMANHO, this.semente.getY()*Config.TAMANHO, Config.TAMANHO, Config.TAMANHO);
	}

	public void sorteiaSemente() {
		do {
			this.semente = new Ponto(Util.random(this.matriz[0].length-1),Util.random(this.matriz.length-1));
		}while(this.ehMuro(this.semente)); //Enquanto o ponto sorteado for muro, continua sorteando.
	}
}
