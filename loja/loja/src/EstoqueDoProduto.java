public class EstoqueDoProduto {
	
	private int quantidade;
	private Produto produto;
	
	public EstoqueDoProduto(Produto produto, int qtde) {
		this.produto = produto;
		this.quantidade = qtde;
	}
	
	public EstoqueDoProduto(Produto produto) {
		this.produto = produto;
		this.quantidade = 0;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void decrementaProdutoDoEstoque(int n) {
		this.quantidade -= n;
	}
	
	public void incrementaProdutoDoEstoque(int n) {
		this.quantidade += n;
	}
}
