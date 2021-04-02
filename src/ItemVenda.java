public class ItemVenda {

	private int quantidade;
	private Produto produto;
	private double precoUnitario;
	
	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = this.produto.getPrecoUnitario();
	}

	public String getDescricao() {
		return produto.getDescricao();
	}

	public int getCodigo() {
		return produto.getCodigo();
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

	public boolean decrementaProdutoEstoque(Estoque estoque) {
		try {
			ItemEstoque item = estoque.getItem(produto);
			if (estoque.getItem(produto).getQuantidade() > 0) {
				quantidade--;
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			System.out.println("O item: \"" + produto.getDescricao() + "\" não foi encontrado no estoque.");
			return false;
		}
	}

	public String toLineFile() {
		return produto.toLineFile() + "," + quantidade + "," + precoUnitario;
	}

	@Override
	public String toString() {
		return produto.toString().replaceAll("Preço unitário:", "Preço atual:") + " Preço unitário: " + precoUnitario +
				"\n Quantidade Itens: " + quantidade + " Preço total: " + getTotal();
	}
}
