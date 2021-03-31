import java.util.ArrayList;

public class HistoricoVendas {
	private ArrayList<Venda> vendas = new ArrayList<>();
	
	public void addVenda(Venda v) {
		vendas.add(v);
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}
}
