package Sesion04.Ejercicios;

public class SubconjuntoPotencias {
    public static boolean esPotenciaDeDos(int n) {
        return (n & (n - 1)) == 0 && n > 0;
    }

    public static boolean subsetConRestricciones(int[] arr, int index, int target) {
        if (index == arr.length) return target == 0;

        int current = arr[index];
        
        // Si es potencia de 2, debe incluirse
        if (esPotenciaDeDos(current)) {
            return subsetConRestricciones(arr, index + 1, target - current);
        }

        // Si es múltiplo de 5 y el siguiente es impar, no se puede incluir
        if (current % 5 == 0 && index + 1 < arr.length && arr[index + 1] % 2 != 0) {
            return subsetConRestricciones(arr, index + 1, target);
        }

        // Opción 1: incluir el elemento
        if (subsetConRestricciones(arr, index + 1, target - current)) return true;

        // Opción 2: no incluir el elemento
        return subsetConRestricciones(arr, index + 1, target);
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 10, 3, 5};
        int target = 27;
        System.out.println(subsetConRestricciones(arr, 0, target)); // true
    }
}
