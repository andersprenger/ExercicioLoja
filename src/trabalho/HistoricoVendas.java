package trabalho;

import java.util.ArrayList;

public class HistoricoVendas {
	private ArrayList<Venda> vendas = new ArrayList<Venda>();
	
	public void addVenda(Venda v) {
		vendas.add(v);
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public int numeroVendas() {
		return vendas.size();
	}

	public Venda buscarVenda(int numero) {
		for (Venda venda : vendas) {
			if (venda.getCodigo() == numero){//numero ==index
				return venda;
			}
		}
		return null;
	}
}
