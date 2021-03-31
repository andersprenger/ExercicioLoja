public class Item {

	private int quantidade;
	private Produto produto;
	private double precoUnitario;
	
	public Item(Produto produto, int qtde) {
		this.produto = produto;
		this.quantidade = qtde;
		this.precoUnitario = this.produto.getPreco();
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public double getPrecoUnitario() {
		return this.precoUnitario;
	}
	
	public double getTotal() {
		return quantidade * precoUnitario;
	}
	
	public void decrementaProdutoEstoque() {
		produto.getEstoqueDoProduto().decrementaProdutoDoEstoque(quantidade);
	}


}
