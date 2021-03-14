/**
 * ItemVenda
 */
public class ItemVenda {

    private Produto produto;
    private int quantidade;
    private float precoDeVenda;
    
    public ItemVenda(Produto produto, int quantidade, float precoDeVenda) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoDeVenda = precoDeVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getPrecoDeVenda() {
        return precoDeVenda;
    }
}