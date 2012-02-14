package model;

/**
 * Responsabilidade da Classe: Realizar abstração de uma coordenada X,Y
 * @author KALEU
 */
public class Ponto {
	private int x;
	private int y;

	public Ponto(int x, int y){
		this.x = x;
		this.y = y;
	}

	/**
	 * Verifica se um determinado ponto é igual a este.
	 */
	public boolean equals(Ponto p){
		return p.getX() == this.getX() && p.getY() == this.getY();
	}
	
	public void upX(){ this.x++; }
	public void upY(){ this.y++; }
	public void downX(){ this.x--; }
	public void downY(){ this.y--; }

	public int getX() {	return x; }
	public void setX(int x) {this.x = x; }
	public int getY() {	return y; }
	public void setY(int y) {this.y = y; }

}
