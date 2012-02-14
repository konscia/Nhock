package view;
import javax.swing.JFrame;

/**
 * Responsabilidade da Classe: Exiba a janela principal do jogo.
 */
public class JanelaPrincipal extends JFrame{
	public JanelaPrincipal(){
		super("Nhock Game - Preparado para o desafio?");
		this.setSize(420, 230);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
