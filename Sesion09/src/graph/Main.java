package graph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GraphLink<String> grafoNoDirigido = new GraphLink<>();
        GraphListEdge<String, Void> grafoDirigido = new GraphListEdge<>();

        // Insertar nodos y aristas de prueba
        grafoNoDirigido.insertVertex("A");
        grafoNoDirigido.insertVertex("B");
        grafoNoDirigido.insertVertex("C");
        grafoNoDirigido.insertVertex("D");
        grafoNoDirigido.insertEdgeWeight("A", "B", 1);
        grafoNoDirigido.insertEdgeWeight("B", "C", 1);
        grafoNoDirigido.insertEdgeWeight("C", "D", 1);

        grafoDirigido.insertVertex("X");
        grafoDirigido.insertVertex("Y");
        grafoDirigido.insertVertex("Z");
        grafoDirigido.insertEdge("X", "Y");
        grafoDirigido.insertEdge("Y", "Z");

        while (true) {
            System.out.println("\n======= MENÚ PRINCIPAL =======");
            System.out.println("1. Mostrar representaciones (GraphLink)");
            System.out.println("2. Verificar tipo (GraphLink)");
            System.out.println("3. Verificar tipo (GraphListEdge)");
            System.out.println("4. Isomorfismo y autocomplementario (GraphListEdge)");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int op = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (op) {
                case 1:
                    System.out.println("\nRepresentación formal:");
                    System.out.println(GraphUtils.representacionFormal(grafoNoDirigido));
                    System.out.println("Lista de adyacencia:");
                    System.out.println(GraphUtils.listaAdyacencia(grafoNoDirigido));
                    System.out.println("Matriz de adyacencia:");
                    System.out.println(GraphUtils.matrizAdyacencia(grafoNoDirigido));
                    break;

                case 2:
                    System.out.println("Es camino: " + GraphUtils.esCamino(grafoNoDirigido));
                    System.out.println("Es ciclo: " + GraphUtils.esCiclo(grafoNoDirigido));
                    System.out.println("Es rueda: " + GraphUtils.esRueda(grafoNoDirigido));
                    System.out.println("Es completo: " + GraphUtils.esCompleto(grafoNoDirigido));
                    System.out.println("Es conexo: " + grafoNoDirigido.isConexo());
                    break;

                case 3:
                    System.out.println("Es camino dirigido: " + GraphUtils.esCaminoDirigido(grafoDirigido));
                    System.out.println("Es ciclo dirigido: " + GraphUtils.esCicloDirigido(grafoDirigido));
                    System.out.println("Es rueda dirigido: " + GraphUtils.esRuedaDirigido(grafoDirigido));
                    System.out.println("Es completo dirigido: " + GraphUtils.esCompletoDirigido(grafoDirigido));
                    System.out.println("Es conexo dirigido: " + GraphUtils.esConexo(grafoDirigido));
                    System.out.println("Es plano dirigido: " + GraphUtils.esPlano(grafoDirigido));
                    break;

                case 4:
                    // Crear clon isomorfo
                    GraphListEdge<String, Void> otro = new GraphListEdge<>();
                    otro.insertVertex("U");
                    otro.insertVertex("V");
                    otro.insertVertex("W");
                    otro.insertEdge("U", "V");
                    otro.insertEdge("V", "W");

                    System.out.println("¿Es isomorfo con otro?: " + GraphUtils.esIsomorfo(grafoDirigido, otro));
                    System.out.println("¿Es auto-complementario?: " + GraphUtils.esAutoComplementario(grafoDirigido));
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
