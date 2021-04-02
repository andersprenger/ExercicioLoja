public class ItemEstoque {

    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemEstoque(Produto produto) {
        this.produto = produto;
        this.quantidade = 0;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws RuntimeException {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            throw new RuntimeException("Quantidade de item no estoque deve ser maior que 0.");
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public boolean decrementaProdutoDoEstoque(int n) {
        if (quantidade - n >= 0) {
            this.quantidade -= n;
            return true;
        } else {
            return false;
        }
    }

    public void incrementaProdutoDoEstoque(int n) {
        this.quantidade += n;
    }

    public String toLineFile() {
        return produto.toLineFile() + "," + quantidade;
    }
}
