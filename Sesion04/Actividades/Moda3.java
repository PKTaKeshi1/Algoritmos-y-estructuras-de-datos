import java.util.*;

public class Moda3 {

    static class SubVector {
        int[] a;
        int prim, ult;

        SubVector(int[] a, int prim, int ult) {
            this.a = a;
            this.prim = prim;
            this.ult = ult;
        }

        int length() {
            return ult - prim + 1;
        }
    }

    public static int moda3(int[] a, int prim, int ult) {
        Queue<SubVector> heterogeneo = new LinkedList<>();
        Queue<SubVector> homogeneo = new LinkedList<>();

        heterogeneo.add(new SubVector(a, prim, ult));

        while (longMayor(heterogeneo) > longMayor(homogeneo)) {
            SubVector p = mayor(heterogeneo);
            int mediana = p.a[(p.prim + p.ult) / 2];

            int[] izq_der = pivote2(p.a, mediana, p.prim, p.ult);
            int izq = izq_der[0];
            int der = izq_der[1];

            SubVector p1 = new SubVector(p.a, p.prim, izq - 1);
            SubVector p2 = new SubVector(p.a, izq, der - 1);
            SubVector p3 = new SubVector(p.a, der, p.ult);

            if (p1.prim <= p1.ult) heterogeneo.add(p1);
            if (p3.prim <= p3.ult) heterogeneo.add(p3);
            if (p2.prim <= p2.ult) homogeneo.add(p2);
        }

        if (homogeneo.isEmpty()) return a[prim];

        SubVector modaSub = mayor(homogeneo);
        return modaSub.a[modaSub.prim];
    }

    // Encuentra el subvector más largo
    private static SubVector mayor(Queue<SubVector> cola) {
        SubVector mayor = null;
        for (SubVector s : cola) {
            if (mayor == null || s.length() > mayor.length()) {
                mayor = s;
            }
        }
        cola.remove(mayor);
        return mayor;
    }

    // Devuelve la longitud del mayor subvector
    private static int longMayor(Queue<SubVector> cola) {
        int max = 0;
        for (SubVector s : cola) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    // Simula Pivote2: divide en <, ==, >
    private static int[] pivote2(int[] a, int pivote, int inicio, int fin) {
        int[] aux = Arrays.copyOfRange(a, inicio, fin + 1);
        Arrays.sort(aux);

        int izq = inicio;
        while (izq <= fin && a[izq] < pivote) izq++;

        int der = izq;
        while (der <= fin && a[der] == pivote) der++;

        return new int[]{izq, der};
    }

    public static void main(String[] args) {
        int[] arreglo = {4, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4};
        Arrays.sort(arreglo); // Puede ayudar a que pivote2 funcione mejor

        int moda = moda3(arreglo, 0, arreglo.length - 1);
        System.out.println("La moda es: " + moda);
    }
}
