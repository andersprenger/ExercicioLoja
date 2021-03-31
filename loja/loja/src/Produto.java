public class Produto {
	
	private final EstoqueDoProduto estoque;
	private int codigo;
	private String descricao;
	private double preco;

	public Produto(int codigo, String descricao, double preco, int qtdeEstoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = new EstoqueDoProduto(this, qtdeEstoque);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public int getQuantidadeEmEstoque() {
		return this.estoque.getQuantidade();
	}
	
	public EstoqueDoProduto getEstoqueDoProduto() {
		return estoque;
	}

}
