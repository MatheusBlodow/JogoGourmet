package teste;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private NodeP primeiroPrato;
	private JLabel titulo;
	private JButton botao;
	
	public void tela() {
		primeiroPrato = JogoGourmet.preCadastrarPratos();
		setSize(300,120);
		setTitle("Jogo Gourmet");
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		
		titulo = new JLabel("Pense em um prato que gosta");
		botao = new JButton("OK");
		add(titulo, gridBagConstraints);
		add(botao, gridBagConstraints);
		setVisible(true);
		
		JogoGourmet iniciar = new JogoGourmet(primeiroPrato);
		botao.addActionListener(iniciar);
			
	}
}
	

