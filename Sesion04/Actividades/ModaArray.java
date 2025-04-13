public class ModaArray {

    public static int moda2(int array[]) {
        int first = 1;
        int p = 0;
        int end = array.length - 1;
        int moda = array[0];
        int frec = 1;
        int maxfrec = 0;

        while (first <= end) {
            if (array[p] == array[first]) {
                frec++;
                first++;
            } else {
                if (frec > maxfrec) {
                    maxfrec = frec;
                    moda = array[p];
                }
                p = first;
                first = p + 1;
                frec = 1;
            }
        }

        // Asegurarse de verificar la última frecuencia
        if (frec > maxfrec) {
            moda = array[p];
        }

        return moda;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 1, 2, 2, 2, 3, 4, 4, 4, 4, 5};

        // IMPORTANTE: el método solo funciona con arreglos ORDENADOS
        java.util.Arrays.sort(arreglo);  // Por si acaso

        int resultado = moda2(arreglo);
        System.out.println("La moda del arreglo es: " + resultado);
    }
}
