
import javax.swing.JOptionPane;
import model.Cenario;
import model.Nhock;
import util.Util;
import view.JanelaPrincipal;
import view.PainelCenario;

/**
 * Responsabilidade da Classe: Executar o loop do Jogo com os objetos principais.
 */
public class NhockGame {

	//Modelo
	Cenario cenario;
	Nhock nhock;

	//Visão
	JanelaPrincipal janela;
	PainelCenario painel;

	public NhockGame(){
		//Inicializa objetos básicos do modelo
		this.cenario = new Cenario();
		this.nhock = new Nhock();
		this.nhock.turnDIREITA(); //Inicia andando para a direita para vermos movimento

		//Iniciliza objetos básicos da visão. Lembrando que a visão pode usar os dados do modelo
		//Por isso passamos os objetos do cenário e do nhock para o painel cenário.
		this.painel = new PainelCenario(this.cenario, this.nhock);

		this.janela = new JanelaPrincipal();
		this.janela.add(this.painel);
		this.janela.setVisible(true);
	}

	public void init(){
		while(true){

			//Pega eventos

			//Processa
			Util.sleep(180); //Põe o programa pra dormir por um tempo - mude akqui para aumentar ou diminuir a velocidade.
			this.nhock.step();

			//Desenha
			this.painel.repaint();
		}
			
	}
}
