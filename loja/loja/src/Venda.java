import java.util.ArrayList;

public class Venda {

	private static int numVenda = 0;
	private ArrayList<ItemVenda> itens = new ArrayList<>();
	private int produtosDiferentes;

	public Venda() {
		
	}
	
	public void decrementaEstoques() {
		for(int i = 0; i < itens.size(); i++) {
			itens.get(i).decrementaProdutoEstoque();
		}
	}
	
	@Override
	public String toString() {	
		return "";
	}

}
