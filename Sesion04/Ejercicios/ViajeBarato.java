package Sesion04.Ejercicios;

public class ViajeBarato {
    static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) C[i][j] = 0;
                else C[i][j] = tarifas[i][j];
            }
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                for (int k = i + 1; k < j; k++) {
                    C[i][j] = Math.min(C[i][j], tarifas[i][k] + C[k][j]);
                }
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int[][] tarifas = {
            {0, 2, 9, 10},
            {0, 0, 6, 4},
            {0, 0, 0, 8},
            {0, 0, 0, 0}
        };

        int[][] costos = calcularCostosMinimos(tarifas);
        System.out.println("Costo mínimo de 0 a 3: " + costos[0][3]); // Ejemplo
    }
}
