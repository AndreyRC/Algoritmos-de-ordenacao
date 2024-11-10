import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GeradorRelatorio {

    public void imprimirResultados(Map<String, Map<String, Map<String, Long>>> resultados) {
        System.out.println("\n=================================================================");
        System.out.println("       COMPARAÇÃO DE DESEMPENHO DOS ALGORITMOS DE ORDENAÇÃO");
        System.out.println("                   (tempo em nanosegundos)");
        System.out.println("=================================================================\n");

        // Define larguras fixas para cada coluna
        String formato = "%-10s  %-15s  %-20s  %-15s%n";

        for (String tipoArquivo : resultados.keySet()) {
            System.out.println("Tipo de Dados: " + tipoArquivo.toUpperCase());
            System.out.println("-----------------------------------------------------------------");

            // Cabeçalho da tabela
            System.out.printf(formato,
                    "TAMANHO",
                    "BUBBLE SORT",
                    "INSERTION SORT",
                    "QUICK SORT");
            System.out.println("-----------------------------------------------------------------");

            Map<String, Map<String, Long>> resultadosTamanho = resultados.get(tipoArquivo);
            List<String> tamanhos = new ArrayList<>(resultadosTamanho.keySet());
            Collections.sort(tamanhos); // Ordena os tamanhos para exibição consistente

            for (String tamanho : tamanhos) {
                Map<String, Long> temposAlgoritmos = resultadosTamanho.get(tamanho);

                // Formata os tempos em microssegundos (mais legível que nanosegundos)
                double bubbleTime = temposAlgoritmos.get("Ordenação Bolha") / 1000.0;
                double insertionTime = temposAlgoritmos.get("Ordenação Inserção") / 1000.0;
                double quickTime = temposAlgoritmos.get("Ordenação Rápida") / 1000.0;

                System.out.printf(formato,
                        tamanho,
                        String.format("%.2f µs", bubbleTime),
                        String.format("%.2f µs", insertionTime),
                        String.format("%.2f µs", quickTime));
            }
            System.out.println("-----------------------------------------------------------------\n");
        }

        System.out.println("=================================================================");
        System.out.println("                         FIM DO RELATÓRIO");
        System.out.println("=================================================================\n");
    }
}