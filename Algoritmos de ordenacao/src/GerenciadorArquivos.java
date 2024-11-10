import java.io.*;
import java.util.ArrayList;

public class GerenciadorArquivos {

    public ArrayList<Integer> lerDadosDoArquivo(String nomeArquivo) {
        ArrayList<Integer> numeros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            // Pula o cabeçalho
            br.readLine();
            while ((linha = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linha.trim()));
            }
            return numeros;
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
            return null;
        }
    }
}
