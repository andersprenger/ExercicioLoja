import java.util.ArrayList;
import java.util.Scanner;

public class App {
	private Estoque estoque;
	private HistoricoVendas historicoVendas;
	private Scanner scn;

	public App(){
		this.estoque = new Estoque();
		this.historicoVendas = new HistoricoVendas();
		this.scn = new Scanner(System.in);
	}

	private void abrirVenda(){
		final int numeroVenda = historicoVendas.getVendas().size() + 1;
		ArrayList<ItemVenda> carrinho = new ArrayList<ItemVenda>();
		int porcentagemImposto = 100;
		int porcentagemDesconto = 0;
		while (true) {
			System.out.println();
			System.out.println("Digite no terminal uma opção: 🐒");
			System.out.println("1) 🧾 Ver encarte"); //listar estoque
			System.out.println("2) 🛒 Ver carrinho");
			System.out.println("3) ⭐️ Adicionar item no carrinho");
			System.out.println("4) 😭 Remover item do carinho");
			System.out.println("5) 🤠 Inserir cupom desconto");
			System.out.println("6) 🤬 Definir imposto:");
			System.out.println("7) 💰 Fechar compra");
			int opt = scn.nextInt();
			switch (opt) {
				case 1 -> estoque.listarEstoque();
				case 2 -> {
					for (ItemVenda item : carrinho) {
						System.out.println(item);
					}
				}
				case 3 -> addItemNoCarrinho(carrinho);
				case 4 -> removerItemNoCarrinho(carrinho);
				case 5 -> {
					System.out.println("Digite o código do cupom no terminal: 🤓");
					int codigoCupom = scn.nextInt();
					switch (codigoCupom) {
						case 40028922 -> {
							porcentagemDesconto = 20;
						}
						default -> System.out.println("Código não encontrado... 😙");
					}
				}
				case 6 -> {
					System.out.println("🤬 Digite a porcentagem do desconto:");
					porcentagemDesconto = scn.nextInt();
				}
				case 7 -> {
					float sumTotalPago = 0;
					for (ItemVenda item : carrinho) {
						sumTotalPago += item.getTotal();
					}
					Venda venda = new Venda(
							historicoVendas.numeroVendas(),
							porcentagemDesconto/100,
							porcentagemImposto/100,
							sumTotalPago,
							carrinho
							);
					return;
				}
				default -> System.out.println("💩 Opção invalida, tente novamente...");
			}
		}
	}

	private void addItemNoCarrinho(ArrayList<ItemVenda> carrinho) {
		System.out.println("🦊 Digite o código do item a ser colocado no carrinho:");
		int codigoProduto = scn.nextInt();

		ItemEstoque itemEstoque = estoque.getItem(codigoProduto);

		if (itemEstoque != null && itemEstoque.getQuantidade() > 0) {
			System.out.println("Digite a quantidade do produto a ser colocado no carrinho:");
			int quantidadePedido = scn.nextInt();

			if (quantidadePedido > itemEstoque.getQuantidade()) {

				itemEstoque.decrementaProdutoDoEstoque(itemEstoque.getQuantidade());
				ItemVenda itemVenda = new ItemVenda(itemEstoque.getProduto(), itemEstoque.getQuantidade());
				carrinho.add(itemVenda);

				System.out.println("😰 Não temos estoque suficiente de " + itemVenda + ".");
				System.out.println("🦊 Conseguimos colocar " + itemEstoque.getQuantidade() + " itens no carrinho.");
			} else {

				ItemVenda itemVenda = new ItemVenda(itemEstoque.getProduto(), quantidadePedido);
				itemEstoque.decrementaProdutoDoEstoque(quantidadePedido);

				System.out.println("🦊 Foram adicionados " + itemEstoque.getQuantidade() + " itens de " + itemVenda.getDescricao() +" no carrinho.");
			}
		} else {
			System.out.println("🙉 Não foi possível colocar no carrinho o item deste código.");
		}
	}

	private void removerItemNoCarrinho(ArrayList<ItemVenda> carrinho) {
		System.out.println("🙈 Digite o código do item que você que tirar do carrinho:");
		int codigoItemVenda = scn.nextInt();
		for (ItemVenda busca : carrinho) {
			if (busca.getCodigo() == codigoItemVenda) {
				estoque.getItem(codigoItemVenda).incrementaQuantidade(busca.getQuantidade());
				carrinho.remove(busca);
				System.out.println("🐒 Item removido do carrinho.");
				return;
			}
		}
		System.out.println("Item não encontrado. 🙉");
	}

	private void listarVenda() {
		System.out.println("🤓 Digite o código da venda a ser listada:");
		int codigo = scn.nextInt();
		Venda busca = historicoVendas.buscarVenda(codigo);
		if (busca != null) {
			System.out.println(busca);
		} else {
			System.out.println("Venda não encontrada... 🙉");
		}
	}

	private void listarUltimas5Vendas(){
		final int numeroUltimaVenda = historicoVendas.numeroVendas() - 1;
		for (int index = numeroUltimaVenda; index > numeroUltimaVenda - 5 && index >= 0; index--) {
			System.out.println(historicoVendas.buscarVenda(index));
		}
	}

	public static void main(String[] args) {
		App app = new App();
		System.out.println("🦊 Lojas Raposa");
		while (true) {
			System.out.println("Digite no terminal uma opção... 🙈");
			System.out.println("1) 😃 Abrir venda");
			System.out.println("2) 🧐 Listar venda pelo numero do recibo");
			System.out.println("3) 🥸 Listar ultimas 5 vendas");
			System.out.println("0) 😥 Sair");
			int opt = app.scn.nextInt();
			switch (opt) {
				case 1 -> app.abrirVenda();
				case 2 -> app.listarVenda();
				case 3 -> app.listarUltimas5Vendas();
				case -9 -> app.iniciarEstoque();
				case 0 -> {
					app.estoque.persiste();
					return;
				}
				default -> System.out.println("💩 Opção invalida, tente novamente...");
			}
		}
	}

	private void iniciarEstoque(){
		Produto p1 = new Produto(
				1,
				"Geladeira Brastemp",
				1500.00);
		Produto p2 = new Produto(2,
				"Churrasqueira Controle Remoto Mor",
				49.00);
		Produto p3 = new Produto(
				3,
				"Camera Tecpix",
				19.00);
		Produto p4 = new Produto(
				4,
				"Chip da OI (com credito e bonus)",
				15.00);
		Produto p5 = new Produto(
				5,
				"Cyberbug 2076",
				299.00);
		Produto p6 = new Produto(
				6,
				"iPhone 6S 64GB Guerreiro Invicto",
				750.00);
		Produto p7 = new Produto(
				7,
				"Placa de Video GT 710",
				800.00);
		Produto p8 = new Produto(
				8,
				"Playstation 5",
				5000.00);
		Produto p9 = new Produto(
				9,
				"Chevrolet Corsa 94",
				4900.00);
		Produto p10 = new Produto(
				10,
				"Placa de Video RTX 3060ti",
				6500.00);

		ItemEstoque i1  = new ItemEstoque(p1,10);
		ItemEstoque i2  = new ItemEstoque(p2,10);
		ItemEstoque i3  = new ItemEstoque(p3,10);
		ItemEstoque i4  = new ItemEstoque(p4,10);
		ItemEstoque i5  = new ItemEstoque(p5,10);
		ItemEstoque i6  = new ItemEstoque(p6,10);
		ItemEstoque i7  = new ItemEstoque(p7,10);
		ItemEstoque i8  = new ItemEstoque(p8,10);
		ItemEstoque i9  = new ItemEstoque(p9,10);
		ItemEstoque i10 = new ItemEstoque(p10,10);

		estoque.addItem(i1);
		estoque.addItem(i2);
		estoque.addItem(i3);
		estoque.addItem(i4);
		estoque.addItem(i5);
		estoque.addItem(i6);
		estoque.addItem(i7);
		estoque.addItem(i8);
		estoque.addItem(i9);
		estoque.addItem(i10);
	}
}
