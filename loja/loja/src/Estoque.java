import java.util.ArrayList;

public class Estoque {

	private ArrayList<EstoqueDoProduto> estoqueDeProdutos = new ArrayList<EstoqueDoProduto>();
	
	public Estoque() {
		
	}

	public void addEstoqueProduto(EstoqueDoProduto e) {
		estoqueDeProdutos.add(e);
	}
}
