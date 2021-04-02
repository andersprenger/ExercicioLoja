/**
 * TODO: doc
 */
public class Produto {
	
	private int codigo;
	private String descricao;
	private double precoUnitario;

	public Produto(int codigo, String descricao, double precoUnitario) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) throws RuntimeException {
		if (precoUnitario >= 0) {
			this.precoUnitario = precoUnitario;
		} else {
			throw new RuntimeException("Preço deve ser maior que 0.");
		}
	}

	public String toLineFile() {
		return codigo + "," + descricao + "," + precoUnitario;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + " Descrição: " + descricao + "Preço unitário: " + precoUnitario;
	}
}
