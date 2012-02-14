
import javax.swing.JOptionPane;
import view.JanelaPrincipal;

/**
 * Responsabilidade da Classe: Executar o loop do Jogo com os objetos principais.
 * @author KALEU
 */
public class NhockGame {

	JanelaPrincipal janela;

	public NhockGame(){
		//Inicializa objetos como cenário, jogador, etc.

		this.janela = new JanelaPrincipal();
		this.janela.setVisible(true);
	}

	public void init(){
		//executa loop do jogo
			//Pega eventos
			//Processa
			//Desenha

		//Por enquanto, apenas exibe um Hello World para que possamos acompanhar o desenvolvimento.
		JOptionPane.showMessageDialog(this.janela, "Você está pronto para comer o máximo que puder?", "Nhock.!", JOptionPane.INFORMATION_MESSAGE);
	}
}
