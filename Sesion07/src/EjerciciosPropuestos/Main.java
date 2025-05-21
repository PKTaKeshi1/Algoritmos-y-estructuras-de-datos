package EjerciciosPropuestos;
import EjerciciosPropuestos.bstreelinklistinterfgeneric.LinkedBST;
import EjerciciosPropuestos.Exceptions.*;

public class Main {
    public static void main(String[] args) {
        LinkedBST<Integer> tree = new LinkedBST<>();
        LinkedBST<Integer> tree2 = new LinkedBST<>();

        try {
            // Insertar nodos en el árbol principal
            tree.insert(8);
            tree.insert(3);
            tree.insert(1);
            tree.insert(20);
            tree.insert(10);
            tree.insert(5);
            tree.insert(4);

            // Insertar nodos en segundo árbol para comparar área
            tree2.insert(7);
            tree2.insert(2);
            tree2.insert(1);
            tree2.insert(15);
            tree2.insert(9);
            tree2.insert(6);
            tree2.insert(5);

            // Dibujar árbol
            System.out.println("Dibujo del árbol:");
            tree.drawBST();
            
            System.out.println("Dibujo del segundo árbol:");
            tree2.drawBST();

            // Recorridos
            System.out.println("InOrden:");
            tree.inOrder();
            
            System.out.println("InOrden arbol2:");
            tree2.inOrder();

            System.out.println("PreOrden:");
            tree.preOrder();

            System.out.println("PreOrden arbol2:");
            tree2.preOrder();

            System.out.println("PostOrden:");
            tree.postOrder();

            System.out.println("PostOrden arbol2:");
            tree2.postOrder();

            // Búsqueda
            System.out.println("Buscar 10: " + tree.search(10));
            System.out.println("Buscar 99: ");
            try {
                tree.search(99);
            } catch (ItemNotFound e) {
                System.out.println("Elemento 99 no encontrado.");
            }

            // Mínimo y máximo
            System.out.println("Mínimo del árbol: " + tree.getMin());
            System.out.println("Máximo del árbol: " + tree.getMax());

            System.out.println("Mínimo del árbol2: " + tree2.getMin());
            System.out.println("Máximo del árbol2: " + tree2.getMax());

            // Área del árbol
            System.out.println("Área del árbol: " + tree.areaBST());
            System.out.println("Área del árbol2: " + tree2.areaBST());

            // Altura desde nodo 3
            System.out.println("Altura desde nodo 3: " + tree.height(3));
            System.out.println("Altura desde nodo 3 en arbol2: " + tree2.height(3));

            // Amplitud del nivel 2
            System.out.println("Amplitud en nivel 2: " + tree.amplitude(2));
            System.out.println("Amplitud en nivel 2 en arbol2: " + tree2.amplitude(2));

            // Parenthesize
            System.out.println("Representación con sangría y paréntesis:");
            System.out.println(tree.parenthesize());

            System.out.println("Representación con sangría y paréntesis en arbol2:");
            System.out.println(tree2.parenthesize());

            // Comparar áreas entre dos árboles
            System.out.println("¿tree y tree2 tienen la misma área? " + tree.sameArea(tree2));

            // Conteo de nodos
            System.out.println("Total de nodos: " + tree.countAllNodes());
            System.out.println("Total de hojas: " + tree.countLeafNodes());

            System.out.println("Total de nodos en arbol2: " + tree2.countAllNodes());
            System.out.println("Total de hojas en arbol2: " + tree2.countLeafNodes());

            // Destruir árbol
            tree.destroyNodes();
            System.out.println("Árbol1 destruido. ¿Está vacío?: " + (tree.countAllNodes() == 0));

        } catch (ItemDuplicated e) {
            System.err.println("Duplicado: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.err.println("No encontrado: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Árbol vacío: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}


