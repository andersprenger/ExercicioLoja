import java.util.ArrayList;

public class Venda {
	final private  int numero;
	final private float desconto;
	final private float imposto;
	private float valorPago;

	private ArrayList<ItemVenda> itensVenda;

	public Venda(int numero, float desconto, float imposto, float valorPago) {
		this.numero = numero;
		this.desconto = desconto;
		this.imposto = imposto;
		this.valorPago = valorPago;
		this.itensVenda = new ArrayList<ItemVenda>();
	}

	public int getNumero() {
		return numero;
	}

	public float getDesconto() {
		return desconto;
	}

	public float getImposto() {
		return imposto;
	}

	public float getValorPago() {
		return valorPago;
	}
}
