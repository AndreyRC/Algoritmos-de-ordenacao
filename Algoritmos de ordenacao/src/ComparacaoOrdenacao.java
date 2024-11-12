import java.util.*;

public class ComparacaoOrdenacao {
    private final GerenciadorArquivos gerenciadorArquivos;
    private final AlgoritmosOrdenacao algoritmosOrdenacao;
    private final GeradorRelatorio geradorRelatorio;

    public ComparacaoOrdenacao() {
        this.gerenciadorArquivos = new GerenciadorArquivos();
        this.algoritmosOrdenacao = new AlgoritmosOrdenacao();
        this.geradorRelatorio = new GeradorRelatorio();
    }

    public void executarComparacao() {
        String[] tiposArquivo = {"aleatorio", "crescente", "decrescente"};
        String[] tamanhos = {"100", "1000", "10000"};

        Map<String, Map<String, Map<String, Long>>> resultados = new HashMap<>();

        for (String tipoArquivo : tiposArquivo) {
            resultados.put(tipoArquivo, new HashMap<>());
            for (String tamanho : tamanhos) {
                String nomeArquivo = tipoArquivo + "_" + tamanho + ".csv";
                ArrayList<Integer> dados = gerenciadorArquivos.lerDadosDoArquivo(nomeArquivo);
                if (dados != null) {
                    resultados.get(tipoArquivo).put(tamanho, executarTestesOrdenacao(dados));
                }
            }
        }

        geradorRelatorio.imprimirResultados(resultados);
    }

    private Map<String, Long> executarTestesOrdenacao(ArrayList<Integer> dadosOriginais) {
        Map<String, Long> temposAlgoritmos = new HashMap<>();

        ArrayList<Integer> dados = new ArrayList<>(dadosOriginais);
        long tempoInicial = System.nanoTime();
        algoritmosOrdenacao.bubbleSort(dados);
        long tempoFinal = System.nanoTime();
        temposAlgoritmos.put("Ordenação Bolha", tempoFinal - tempoInicial);

        dados = new ArrayList<>(dadosOriginais);
        tempoInicial = System.nanoTime();
        algoritmosOrdenacao.insertionSort(dados);
        tempoFinal = System.nanoTime();
        temposAlgoritmos.put("Ordenação Inserção", tempoFinal - tempoInicial);

        dados = new ArrayList<>(dadosOriginais);
        tempoInicial = System.nanoTime();
        algoritmosOrdenacao.quickSort(dados, 0, dados.size() - 1);
        tempoFinal = System.nanoTime();
        temposAlgoritmos.put("Ordenação Rápida", tempoFinal - tempoInicial);

        return temposAlgoritmos;
    }

    public static void main(String[] args) {
        ComparacaoOrdenacao comparacao = new ComparacaoOrdenacao();
        comparacao.executarComparacao();
    }
}