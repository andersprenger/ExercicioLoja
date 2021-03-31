import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {

	 ArrayList<ItemEstoque> estoqueDeProdutos = new ArrayList<ItemEstoque>();
	
	public Estoque() {
		carrega();
	}

	public void addItem(ItemEstoque e) {
		estoqueDeProdutos.add(e);
	}



	public void persiste(){
		String fName = "estoque.txt";
        Path path = Path.of(fName).toAbsolutePath();
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
          for(ItemEstoque c : estoqueDeProdutos){
                String linha = c.toLineFile();
                writer.println(linha);
            }
        }catch (IOException x){
          System.err.format("Erro de E/S: %s%n", x);
      }        
    }

	public void carrega(){
		String fName = "estoque.txt";
        Path path = Path.of(fName).toAbsolutePath();
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
           while (sc.hasNext()){
               String linha = sc.nextLine();
			   String [] linhaSplitada = linha.split(",");
			   Produto p = new Produto(Integer.parseInt(linhaSplitada[0]), linhaSplitada[1], Double.parseDouble(linhaSplitada[2]), Integer.parseInt(linhaSplitada[3]));
			   addItem(p.getEstoqueDoProduto());
           }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}
