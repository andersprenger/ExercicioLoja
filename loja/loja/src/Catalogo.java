import java.util.ArrayList;

public class Catalogo {

	private ArrayList<Produto> catalogo = new ArrayList<>();

	public ArrayList<Produto> getCatalogo() {
		return catalogo;
	}

	public void addProduto(Produto produto) {
		catalogo.add(produto);
	}
	
	@Override
	public String toString() {
		String saida = "";
		for(int i = 0; i < catalogo.size(); i++) {
			
			Produto p = catalogo.get(i);
			saida+= p.getCodigo() + "  " + 
					p.getDescricao() + "  " + p.getPreco()
					+ "\n";
		}
		return saida;
	}

}
