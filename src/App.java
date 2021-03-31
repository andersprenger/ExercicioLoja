import java.util.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Produto p1 = new Produto(1, "Geladeira", 14.00, 10);
		Produto p2 = new Produto(2, "Calca", 19.00, 5);
		Produto p3 = new Produto(3, "Peruca", 19.00, 5);
	
		Estoque estoque = new Estoque();
		estoque.addItem(new ItemEstoque(p1,3));
		estoque.addItem(new ItemEstoque(p2,3));
		estoque.addItem(new ItemEstoque(p3,3));
		estoque.persiste();
		
		for (int i = 0; i < estoque.tamanhoEstoque(); i++) {
			System.out.println(estoque.getItem(i).toLineFile());
		}

		//c.addProduto(p6);
		
		//System.out.println(c);

		//System.out.println(c);
		
	}
	


}
