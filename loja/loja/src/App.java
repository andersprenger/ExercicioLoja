import java.util.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Produto p1 = new Produto(1, "Geladeira", 14.00, 10);
		Produto p2 = new Produto(2, "Cal�a", 19.00, 5);
		Produto p3 = new Produto(3, "Peruca", 19.00, 5);
		Produto p4 = new Produto(4, "Paracetamol", 19.00, 5);
		Produto p5 = new Produto(5, "Machado", 19.00, 5);
		Produto p6 = new Produto(6, "Bola de basquete", 19.00, 5);
		Catalogo c = new Catalogo();
		c.addProduto(p1);
		c.addProduto(p2);
		c.addProduto(p3);
		c.addProduto(p4);
		c.addProduto(p5);
		c.addProduto(p6);
		//c.addProduto(p6);
		
		//System.out.println(c);

		System.out.println("Atendente 1");
		int aux;
		do {
			System.out.println(c);
			System.out.println("Digite o codigo do produto que voc� deseja aicionar ao carrinho: ");
			aux = in.nextInt();
		}while(aux>0);
		
		in.close();
		//System.out.println(c);
		
	}
	
	public boolean quantidadeEmEstoque(Produto p, int n) {
		if(n > p.getQuantidadeEmEstoque()) return false;
		return true;
	}

}
