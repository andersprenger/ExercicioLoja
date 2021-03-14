public class Venda {
    private int numero;
    private float desconto;
    private float imposto;
    private float valorPago;

    public Venda(int numero, float desconto, float imposto, float valorPago) {
        this.numero = numero;
        this.desconto = desconto;
        this.imposto = imposto;
        this.valorPago = valorPago;
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
