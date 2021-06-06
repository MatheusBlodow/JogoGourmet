package teste;

public class NodeP {
	String prato;
	NodeP pratoAnterior;
	NodeP pratoEsquerda;
	NodeP pratoDireita;
	
	public NodeP(String prato) {
		this.prato = prato;
	}
	
	public NodeP(String prato, NodeP pratoAnterior) {
		this.prato = prato;
		this.pratoAnterior = pratoAnterior;
	}
	
	public String getNome() {
		return this.prato;
	}
	
	public void setNome(String nome) {
		this.prato = nome;
	}
	
	public NodeP getPratoAnterior() {
		return this.pratoAnterior;
	}
	
	public void setPratoAnterior(NodeP pratoAnterior) {
		this.pratoAnterior = pratoAnterior;
	}
	
	public NodeP getPratoEsquerda() {
		return this.pratoEsquerda;
	}
	
	public void setPratoEsquerda(NodeP pratoEsquerda) {
		pratoEsquerda.setPratoAnterior(this);
		this.pratoEsquerda = pratoEsquerda;
	}
	
	public NodeP getPratoDireita() {
		return this.pratoDireita;
	}
	
	public void setPratoDireita(NodeP pratoDireita) {
		pratoDireita.setPratoAnterior(this);
		this.pratoDireita = pratoDireita;
	}
}
