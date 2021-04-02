import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {

	private ArrayList<ItemEstoque> estoque;
	
	public Estoque() {
        this.estoque = new ArrayList<ItemEstoque>();
		carrega();
	}

	public int tamanhoEstoque() {
	    return estoque.size();
    }

	public boolean addItem(ItemEstoque item) {
        for (ItemEstoque busca : estoque) {
            if (item.getProduto().getDescricao().equals(busca.getProduto().getDescricao())) {
                return false;
            }
        }
		return estoque.add(item);
	}

	public ItemEstoque getItem(Produto produto) {
        for (ItemEstoque item : estoque) {
            if (item.getProduto().getCodigo() == produto.getCodigo()) {
                return item;
            }
        }
        return null;
    }

    public ItemEstoque getItem(int codigo) {
        for (ItemEstoque item : estoque) {
            if (item.getProduto().getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    public void listarEstoque() {
        for (ItemEstoque item : estoque) {
            System.out.println(item);
        }
    }

	public void persiste() {
		String fileName = "estoque.txt";
        Path path = Path.of(fileName).toAbsolutePath();
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))) {
          for (ItemEstoque item : estoque) {
                String linha = item.toLineFile();
                writer.println(linha);
            }
        } catch (IOException x) {
          System.err.format("Erro de E/S: %s%n", x);
      }        
    }

	public void carrega(){
		String fileName = "estoque.txt";
        Path path = Path.of(fileName).toAbsolutePath();
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
			   String [] linhaSplitada = linha.split(",");
			   Produto produto = new Produto(
			           Integer.parseInt(linhaSplitada[0]),
                       linhaSplitada[1],
                       Double.parseDouble(linhaSplitada[2])
                       );
			   ItemEstoque item = new ItemEstoque(produto, Integer.parseInt(linhaSplitada[3]));
			   estoque.add(item);
           }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}
