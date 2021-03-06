package util;

import geometrics.Point;

/*
 * QuickSort Adaptado para ordenar um conjunto de Points, 
 * tendo como referência um ponto polo
 * Onde esse ponto polo pode qualquer posicao, como:
 * a origem, menor minYXCompareTo(), menor minXYCompareTo() ...
 * */

public class SortPoint { 
    private static final int PARTITION(Point polo, Point[] A, int p, int r) {
        Point pivo = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (polo.polarOrder(A[j], pivo)) {
                i = i + 1;
                Point temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        A[r] = A[i + 1];
        A[i + 1] = pivo;
        return i + 1;
    }
    public static final void SORT(Point polo, Point[] A, int p, int r) {
        if (p < r) {
            int q = PARTITION(polo, A, p, r);
            SORT(polo,A, p, q - 1);
            SORT(polo,A, q + 1, r);
        }
    }
}
