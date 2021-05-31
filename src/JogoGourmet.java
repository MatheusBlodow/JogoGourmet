import java.awt.Container;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class JogoGourmet extends JFrame {
	private static final long serialVersionUID = 1L;
	
	static String tipoGrupo = "";
	static String tipoPrato = "";
	static ArrayList<String> prato = new ArrayList();
	static ArrayList<String> grupo = new ArrayList();
	static boolean encerrou = true;
	static boolean entrouOpcoes = true;
	
	void telaPrincipal() {
		 Container janela = getContentPane();
	     setLayout(null);

	     JLabel msg = new JLabel("Pense em um prato que gosta");
	     msg.setBounds(50, 40, 100, 20);
	     msg.setSize(200,20);
	     janela.add(msg);

	     setTitle("Jogo gourmet");
	     setSize(290, 150);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setResizable(false);
	     setVisible(true);
	     this.setLocationRelativeTo(null);
	        
	     JButton botao = new JButton("OK");
	     botao.setBounds(100, 70, 70, 30); 
	     janela.add(botao); 
	     
	     botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				perguntasTeste();
			}
	     	});  
	}
	
	static void perguntasTeste(){
		
		if(prato.size()==0) {
			prato.add("0 lasanha");
			grupo.add("massa");
		}
		
		entrouOpcoes = true;
		encerrou = true;
		for(int j=0; j<grupo.size();j++) {
			if(encerrou == true) {
				int validorEscolha = JOptionPane.showConfirmDialog(null, "O prato que você pensou foi "+ grupo.get(j) + "?","Confirm", JOptionPane.YES_NO_OPTION);
				if(validorEscolha == 1 && j == grupo.size()-1) {
					validorEscolha = JOptionPane.showConfirmDialog(null, "O prato que você pensou foi bolo de chocolate?","Confirm", JOptionPane.YES_NO_OPTION);
					if(validorEscolha == 0) {
						JOptionPane.showMessageDialog(null, "Acertei de novo","Jogo Gourmet",1);
						encerrou = false;
						break;
					}else{
						tipoPrato = JOptionPane.showInputDialog(null,"qual prato você pensou?","Desisto",3);
						prato.add(Integer.toString(grupo.size()) + " "+ tipoPrato);
						tipoGrupo = JOptionPane.showInputDialog(null,"é ________ mas Bolo de Chocolate não","Complete",3);
						grupo.add(tipoGrupo);
						break;
					}	
				}else if(validorEscolha == 0) {
					for(int i=0; i<prato.size();i++) {
						String testePrato = prato.get(i);
						if(testePrato.substring(0,1).equals(Integer.toString(j))) {
							validorEscolha = JOptionPane.showConfirmDialog(null, "O prato que você pensou foi "+ prato.get(i).substring(2)+ "?","Confirm", JOptionPane.YES_NO_OPTION);
							int testarPrato = Integer.parseInt(testePrato.substring(0,1));
							if(validorEscolha == 1 && i == prato.size()-1) {
								tipoPrato = JOptionPane.showInputDialog(null,"qual prato você pensou?","Desisto",3);
								prato.add(Integer.toString(grupo.size()-1) + " "+ tipoPrato);
								entrouOpcoes = false;
								break;
							}else if(validorEscolha == 0) {
								JOptionPane.showMessageDialog(null, "Acertei de novo", "Jogo Gourmet",1);
								encerrou = false;
								entrouOpcoes = false;
								break;
							}
						}
						encerrou = false;
					}
					if(entrouOpcoes==true) {
						tipoPrato = JOptionPane.showInputDialog(null,"qual prato você pensou?","Desisto",3);
						prato.add(Integer.toString(j) + " "+ tipoPrato);
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args ) {
		JogoGourmet janela = new JogoGourmet();
        janela.telaPrincipal();
		
	}
	
}
	

