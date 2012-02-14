package model;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Responsablidade da Classe: Gerencia o Nhock. A Minhoca que passa o jogo inteiro indo atrás das sementes.
 * Agradecimentos especiais à Suélen Rebello pelo nome do Jogo.
 */
public class Nhock {
	//Constantes de Direação
	static final int DIREITA = 1;
	static final int ESQUERDA = 2;
	static final int CIMA = 3;
	static final int BAIXO = 4;

	//O corpo é uma lista de pontos do Nhock. Sempre que ele se alimenta da um seed ele ganha um novo ponto no corpo.
	ArrayList<Ponto> corpo;
	//Qual a direção na qual o Nhock está andando.
	int direcao;
	//um novo ponto é adicionado ao Nhock durante o método STEP
	//Se ele comer uma semente, este campo é marcado como verdadeiro
	//E assim que o método step for executado, o Nhock ganha um novo ponto.
	boolean addPonto = false;

	//Cria o corpo do Nhock.
	public Nhock(){
		this.corpo = new ArrayList<Ponto>();
		this.corpo.add(new Ponto(10,5));
	}

	public Ponto getCabeca(){
		return this.corpo.get(0);
	}

	public Ponto getCauda(){
		return this.corpo.get( this.corpo.size()-1 );
	}

	public ArrayList<Ponto> getPontos(){
		return this.corpo;
	}

	public void turnDIREITA(){
		this.direcao = Nhock.DIREITA;
	}
	public void turnESQUERDA(){
		this.direcao = Nhock.ESQUERDA;
	}
	public void turnCIMA(){
		this.direcao = Nhock.CIMA;
	}
	public void turnBAIXO(){
		this.direcao = Nhock.BAIXO;
	}

	public void step(){
		//Grava último ponto
		//Será útil quando precisar adicionar um novo ponto na cobra
		Ponto last = this.getCauda();
		int xLast = last.getX();
		int yLast = last.getY();

		//Move todo o corpo um ponto para frente pra frente
		//Quem estava atrás ocupa a posição de quem estava na frente
		//Neste loop, não movimenta a cabeça, que será posicionada depois.
		Ponto frente;
		Ponto atras;
		for(int i = this.corpo.size()-1; i > 0; i--){
			frente = this.corpo.get(i-1);
			atras = this.corpo.get(i);

			atras.setX(frente.getX());
			atras.setY(frente.getY());
		}

		//Movimenta a cabeça da cobra na direção correta
		switch(this.direcao){
			case Nhock.BAIXO :
				this.getCabeca().upY();
				break;
			case Nhock.CIMA:
				this.getCabeca().downY();
				break;
			case Nhock.ESQUERDA:
				this.getCabeca().downX();
				break;
			case Nhock.DIREITA:
				this.getCabeca().upX();
				break;
		}

		//Se for necessário adicionar um novo ponto,
		//Adiciona-o ao final da lista antes dela ter andado pra frente
		if(this.addPonto){
			Ponto novo = new Ponto(xLast, yLast);
			this.corpo.add(novo);
			this.addPonto = false;
		}
	}

	/*
	 * Registra que um novo ponto deve ser adicionado ao corpo do Nhock.
	 */
	public void addPonto(){
		this.addPonto = true;
	}

	//Desenha o Nhock
	public void desenha(Graphics g) {
		g.setColor(Color.green);
		for(Ponto p : this.corpo){
			g.fillOval(p.getX()*Config.TAMANHO, p.getY()*Config.TAMANHO, Config.TAMANHO, Config.TAMANHO);
		}
	}

	/**
	 * Este método verifica se a cobra colidiu com ela mesma
	 * o algoritmo verifica se a cabeça da cobra bate em algum outro ponto.	 
	 */
	public boolean temColisao() {
		Ponto cabeca = this.getCabeca();
		Ponto atual;
		//para cada ponto do corpo, verifica se ele é igual a cabeça.
		for(int i = 1; i < this.corpo.size(); i++){
			atual = this.corpo.get(i);
			if(cabeca.equals(atual)){
				return true;
			}
		}
		return false;
	}

}
