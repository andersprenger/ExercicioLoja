public class ItemEstoque {
	
	private int quantidade;
	private Produto produto;
	
	public ItemEstoque(Produto produto, int qtde) {
		this.produto = produto;
		this.quantidade = qtde;
	}
	
	public ItemEstoque(Produto produto) {
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

	public boolean decrementaProdutoDoEstoque(int n) {
		if (quantidade - n >= 0) {
			this.quantidade -= n;
			return true;
		} else {
			return false;
		}
	}
	
	public void incrementaProdutoDoEstoque(int n) {
		this.quantidade += n;
	}

	public String toLineFile() {
		return produto.toLineFile() + "," + quantidade;
	}
}
