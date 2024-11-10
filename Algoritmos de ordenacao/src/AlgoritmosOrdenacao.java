import java.util.ArrayList;

public class AlgoritmosOrdenacao {

    public void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    trocarElementos(arr, j, j + 1);
                }
            }
        }
    }

    public void insertionSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            int chave = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > chave) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, chave);
        }
    }

    public void quickSort(ArrayList<Integer> arr, int baixo, int alto) {
        if (baixo < alto) {
            int pi = particionar(arr, baixo, alto);
            quickSort(arr, baixo, pi - 1);
            quickSort(arr, pi + 1, alto);
        }
    }

    private int particionar(ArrayList<Integer> arr, int baixo, int alto) {
        int pivo = arr.get(alto);
        int i = baixo - 1;

        for (int j = baixo; j < alto; j++) {
            if (arr.get(j) <= pivo) {
                i++;
                trocarElementos(arr, i, j);
            }
        }

        trocarElementos(arr, i + 1, alto);
        return i + 1;
    }

    private void trocarElementos(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}