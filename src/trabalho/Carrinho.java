package trabalho;

import java.util.ArrayList;

public class Carrinho {
    private final ArrayList<ItemVenda> carrinho;
    public Carrinho(){
        carrinho = new ArrayList<ItemVenda>();
    }

    public void addItemNoCarrinho(ItemVenda iv){
        carrinho.add(iv);
    }

    public void removeItem(ItemVenda item){
        carrinho.remove(item);
    }

    public void mostraCarrinho(){
        for (ItemVenda item : carrinho) {
            System.out.println(item);
        }
    }

    public ArrayList<ItemVenda> getCarrinho() {
        return this.carrinho;
    }

}
