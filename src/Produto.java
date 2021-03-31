public class Produto {
	
	private final ItemEstoque estoque;
	private int codigo;
	private String descricao;
	private double preco;

	public Produto(int codigo, String descricao, double preco, int qtdeEstoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = new ItemEstoque(this, qtdeEstoque);
	}

	public String getDescricao() {
		return descricao;
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
	
	public ItemEstoque getEstoqueDoProduto() {
		return estoque;
	}

	public String toLineFile() {
		return codigo + "," + descricao + "," + preco;
	}

}
