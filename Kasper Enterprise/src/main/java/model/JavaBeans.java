package model;

public class JavaBeans {
	private String idpro;
	private String produto;
	private String valor;
	private String quantidade;
	private String total;

	public String getIdpro() {
		return idpro;
	}

	public void setIdpro(String idpro) {
		this.idpro = idpro;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	} 
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	// construtor1
	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}

	// construtor2 -- usado no metodo select com ArrayList(vetor)
	public JavaBeans(String idpro, String produto, String valor, String quantidade, String total) {
		super();
		this.idpro = idpro;
		this.produto = produto;
		this.valor = valor;
		this.quantidade = quantidade;
		this.total = total;
	}

}
