package teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class JogoGourmet implements ActionListener{
		
	private NodeP primeiroPrato;
	
	public JogoGourmet(NodeP primeiroPrato) {
		this.primeiroPrato = primeiroPrato;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		NodeP pratoAtual = primeiroPrato;
		
		try {
			do {
				boolean respostaCerta = perguntarPrato(pratoAtual);
				
				NodeP proximoPrato = respostaCerta ? pratoAtual.getPratoEsquerda() : pratoAtual.getPratoDireita();
				
				if (respostaCerta && proximoPrato == null) {
					acertar(pratoAtual);
				}
				
				if (!respostaCerta && proximoPrato == null) {
					desistir(pratoAtual);
				}
				
				pratoAtual = proximoPrato;
				
			} while (pratoAtual != null);
		} catch(Exception exception) {
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean perguntarPrato(NodeP prato){
		return JOptionPane.showConfirmDialog(null, "O prato que você pensou é "+prato.getNome()+"?","Pergunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
	
	private void acertar(NodeP prato){
		JOptionPane.showMessageDialog(null, "Acertei de novo!");
	}
	
	private void desistir(NodeP prato) throws Exception{
		String pratoEscolhido = JOptionPane.showInputDialog("Qual prato você pensou?");
		
		if (pratoEscolhido == null || pratoEscolhido.equals("")) {
			throw new Exception("É necessário informar o prato que você pensou!");
		}
		
		String tipoPrato = JOptionPane.showInputDialog(pratoEscolhido + " é _______ mas " + prato.getNome() + " não.");
		
		if (tipoPrato == null || tipoPrato.equals("")) {
			throw new Exception("É necessário informar o tipo de prato de " + pratoEscolhido + "!");
		}
		
		NodeP novoTipoPrato = adicionarPratoAnterior(prato, tipoPrato);
		adicionarPratoEspecifico(novoTipoPrato, pratoEscolhido);	
	}
	
	public static NodeP preCadastrarPratos() {
		NodeP primeiroPrato = new NodeP("massa");
		NodeP segundoPrato = new NodeP("bolo de chocolate");
		primeiroPrato.setPratoDireita(segundoPrato);
		primeiroPrato.setPratoEsquerda(new NodeP("lasanha"));
		
		return primeiroPrato;
	}
	
	public static NodeP adicionarPratoEspecifico(NodeP pratoBase, String nomeNovoPratoEspecifico) {
		NodeP novoPratoEspecifico = new NodeP(nomeNovoPratoEspecifico);
		pratoBase.setPratoEsquerda(novoPratoEspecifico);
		
		return novoPratoEspecifico;
	}
	
	public static NodeP adicionarPratoAnterior(NodeP pratoBase, String nomeNovoPrato) {
		NodeP novoPrato = new NodeP(nomeNovoPrato);
		
		if(pratoBase.getPratoAnterior().getPratoEsquerda().equals(pratoBase)) {
			pratoBase.getPratoAnterior().setPratoEsquerda(novoPrato);
		}else {
			pratoBase.getPratoAnterior().setPratoDireita(novoPrato);
		}
		
		novoPrato.setPratoDireita(pratoBase);
		
		return novoPrato;
	}
}
