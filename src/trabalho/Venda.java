package trabalho;

import java.util.ArrayList;

public class Venda {
	private static int numeroVendas=0;
	private int codigo;
	private float desconto;
	private float imposto;
	private float valorPago;
	private float precoTotal;

	private ArrayList<ItemVenda> itensVenda;

	public Venda(float precoTotal, float desconto, float imposto, float valorPago, ArrayList<ItemVenda> iv) {
		numeroVendas++;
		this.codigo = numeroVendas ;
		this.precoTotal = precoTotal;
		this.desconto = desconto;
		this.imposto = imposto;
		this.valorPago = valorPago;
		itensVenda = iv;
		
		
		
	}
	public Venda(){
		itensVenda = new ArrayList<>();
		numeroVendas++;
		codigo = numeroVendas;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setDesconto(){
		if(this.itensVenda.size() >= 10){
			this.desconto = (float)(this.precoTotal * 0.09);
		}else{
			this.desconto = 0;
		}

	}
	public float getDesconto() {
		return desconto;
	}

	private void setImposto(float desconto){
		this.imposto = (float) ((this.precoTotal - desconto) * 0.25);
	}

	public float getImposto() {
		return imposto;
	}

	//Valor pago é a soma dos itens - desconto + imposto
	private void setValorPago(){
		setTotal();
		setDesconto();
		setImposto(getDesconto());
		this.valorPago = getTotal() - getDesconto() + getImposto();
	}

	public float getValorPago() {
		return valorPago;
	}

	//Total é a soma do valor de cada item
	private void setTotal(){
		for(ItemVenda iv: this.itensVenda){
			this.precoTotal += iv.getTotal();
		}
	}

	public float getTotal(){
		return this.precoTotal;
	}

	public String finalizaVenda(){
		setValorPago();
		String saida = "";
		for(ItemVenda iv : itensVenda){
			saida += iv + "\n";
		}
		saida += "Total: " + getTotal() + "\nDesconto: " + getDesconto() + "\nImposto: " + getImposto() +
				"\nValor pago: " + getValorPago();
		return saida;
	}

	public void addItemVenda(ItemVenda item){
		this.itensVenda.add(item);
	}

	public ArrayList<ItemVenda> getItemVenda(){
		return this.itensVenda;
	}

	public void setItensVenda(Carrinho carrinho){
		this.itensVenda = carrinho.getCarrinho();
	}

	public String toLineFile() {
		String str = getCodigo() + "," + getTotal() + "," + getDesconto() + "," + getImposto() + "," + getValorPago() + ",";
		for (ItemVenda item : itensVenda) {
			str += item.toLineFile() + ";";
		}
		str.replaceAll(";$","");
		return str;
	}
	@Override
	public String toString() {
		StringBuilder stg = new StringBuilder();
		stg.append("Venda " + "\ncodigo venda: " + codigo);
		stg.append(", desconto: " + desconto);
		stg.append(", imposto: " + imposto);
		stg.append(", itens venda: " + itensVenda.toString() );
		stg.append(", preco total vendas: " + precoTotal);
		stg.append(", valor pago: " + valorPago);

		return stg.toString();
	}
}
