package trabalho;

public class ItemVenda {

	private int quantidade;
	private Produto produto;
	private double precoUnitario;
	
	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = this.produto.getPrecoUnitario();
	}

	public ItemVenda(Produto produto, int quantidade, double precoUnitario) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
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

	public Produto getProduto(){
		return this.produto;
	}

	public String toLineFile() {
		return produto.toLineFile() + "," + getQuantidade() + "," + getTotal();
	}
	//Tem precoUnitario no toLineFile do produto tambem

	@Override
	public String toString() {
		return produto.toString().replaceAll("Preço unitário:", "Preço atual:") 
					+ " Preço unitário: " + precoUnitario 
					+ "\n Quantidade Itens: " + quantidade 
					+ " Preço total: " + getTotal();
	}
}
