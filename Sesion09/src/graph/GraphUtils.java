package graph;

import java.util.*;

public class GraphUtils {

    // -------- Métodos para GraphLink (no dirigido) --------

    public static <E> int gradoNodo(GraphLink<E> g, E v) {
        Vertex<E> vertex = g.getVertex(v);
        return (vertex != null) ? contarAdyacentes(vertex) : -1;
    }

    public static <E> boolean esCamino(GraphLink<E> g) {
        int grado1 = 0, grado2 = 0, total = 0;

        for (Vertex<E> v = g.getFirstVertex(); v != null; v = g.getNextVertex(v)) {
            int grado = contarAdyacentes(v);
            if (grado == 1) grado1++;
            else if (grado == 2) grado2++;
            else return false;
            total++;
        }

        return grado1 == 2 && grado2 == (total - 2) && !tieneCiclos(g);
    }

    public static <E> boolean esCiclo(GraphLink<E> g) {
        for (Vertex<E> v = g.getFirstVertex(); v != null; v = g.getNextVertex(v)) {
            if (contarAdyacentes(v) != 2) return false;
        }
        return tieneCiclos(g) && g.isConexo();
    }

    public static <E> boolean esRueda(GraphLink<E> g) {
        int centro = 0, ciclo = 0, n = 0;
        int totalVertices = getCantidadVertices(g);

        for (Vertex<E> v = g.getFirstVertex(); v != null; v = g.getNextVertex(v)) {
            int grado = contarAdyacentes(v);
            if (grado == totalVertices - 1) centro++;
            else if (grado == 3) ciclo++;
            else return false;
            n++;
        }

        return centro == 1 && ciclo == (n - 1) && g.isConexo();
    }

    public static <E> boolean esCompleto(GraphLink<E> g) {
        int n = getCantidadVertices(g);
        int expectedEdges = n * (n - 1) / 2;
        int actualEdges = contarAristasNoDirigido(g);
        return actualEdges == expectedEdges;
    }

    public static <E> String representacionFormal(GraphLink<E> g) {
        StringBuilder sb = new StringBuilder();
        Set<E> vertices = new HashSet<>();
        Set<String> aristas = new HashSet<>();

        for (Vertex<E> v = g.getFirstVertex(); v != null; v = g.getNextVertex(v)) {
            E origen = v.getData();
            vertices.add(origen);
            for (Edge<E> e = g.getFirstEdge(v); e != null; e = g.getNextEdge(v, e)) {
                E destino = e.refDest.getData();
                String a = origen.toString().compareTo(destino.toString()) <= 0 ?
                        "(" + origen + ", " + destino + ")" :
                        "(" + destino + ", " + origen + ")";
                aristas.add(a);
            }
        }

        sb.append("Vértices: ").append(vertices).append("\n");
        sb.append("Aristas: ").append(aristas).append("\n");
        return sb.toString();
    }

    public static <E> String listaAdyacencia(GraphLink<E> g) {
        StringBuilder sb = new StringBuilder();

        for (Vertex<E> v = g.getFirstVertex(); v != null; v = g.getNextVertex(v)) {
            sb.append(v.getData()).append(" -> ");
            List<String> adyacentes = new ArrayList<>();
            for (Edge<E> e = g.getFirstEdge(v); e != null; e = g.getNextEdge(v, e)) {
                adyacentes.add(e.refDest.getData().toString());
            }
            sb.append(String.join(", ", adyacentes)).append("\n");
        }

        return sb.toString();
    }

    public static <E> String matrizAdyacencia(GraphLink<E> g) {
        StringBuilder sb = new StringBuilder();
        List<E> vertices = new ArrayList<>();

        for (Vertex<E> v = g.getFirstVertex(); v != null; v = g.getNextVertex(v)) {
            vertices.add(v.getData());
        }
        Collections.sort(vertices, Comparator.comparing(Object::toString));

        int n = vertices.size();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            Vertex<E> vi = g.getVertex(vertices.get(i));
            for (Edge<E> e = g.getFirstEdge(vi); e != null; e = g.getNextEdge(vi, e)) {
                int j = vertices.indexOf(e.refDest.getData());
                if (j != -1) {
                    matriz[i][j] = 1;
                }
            }
        }

        sb.append("    ");
        for (E v : vertices) {
            sb.append(String.format("%4s", v));
        }
        sb.append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(String.format("%4s", vertices.get(i)));
            for (int j = 0; j < n; j++) {
                sb.append(String.format("%4d", matriz[i][j]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static <E> int getCantidadVertices(GraphLink<E> g) {
        int count = 0;
        for (Vertex<E> v = g.getFirstVertex(); v != null; v = g.getNextVertex(v)) count++;
        return count;
    }

    private static <E> int contarAdyacentes(Vertex<E> v) {
        int count = 0;
        for (ListLinked.Node<Edge<E>> node = v.listAdj.getHead(); node != null; node = v.listAdj.getNext(node)) {
            count++;
        }
        return count;
    }

    private static <E> boolean tieneCiclos(GraphLink<E> g) {
        Set<Vertex<E>> visited = new HashSet<>();
        Vertex<E> start = g.getFirstVertex();
        if (start == null) return false;
        return dfsCiclo(g, start, null, visited);
    }

    private static <E> boolean dfsCiclo(GraphLink<E> g, Vertex<E> actual, Vertex<E> padre, Set<Vertex<E>> visitados) {
        visitados.add(actual);
        for (Edge<E> arista = g.getFirstEdge(actual); arista != null; arista = g.getNextEdge(actual, arista)) {
            Vertex<E> vecino = arista.refDest;
            if (!visitados.contains(vecino)) {
                if (dfsCiclo(g, vecino, actual, visitados)) return true;
            } else if (!vecino.equals(padre)) {
                return true;
            }
        }
        return false;
    }

    private static <E> int contarAristasNoDirigido(GraphLink<E> g) {
        Set<String> vistas = new HashSet<>();
        int count = 0;

        for (Vertex<E> v = g.getFirstVertex(); v != null; v = g.getNextVertex(v)) {
            for (Edge<E> e = g.getFirstEdge(v); e != null; e = g.getNextEdge(v, e)) {
                String a1 = v.getData().toString() + "-" + e.refDest.getData().toString();
                String a2 = e.refDest.getData().toString() + "-" + v.getData().toString();
                if (!vistas.contains(a1) && !vistas.contains(a2)) {
                    vistas.add(a1);
                    count++;
                }
            }
        }

        return count;
    }

    // -------- Métodos para GraphListEdge (dirigido) --------

    public static <V, E> String gradoNodoDirigido(GraphListEdge<V, E> g, V dato) {
        int in = 0, out = 0;
        VertexObj<V, E> v = g.getVertex(dato);
        if (v == null) return "Nodo no encontrado";

        for (EdgeObj<V, E> e : g.getEdges()) {
            if (e.getEndVertex1().equals(v)) out++;
            if (e.getEndVertex2().equals(v)) in++;
        }

        return "Grado de salida: " + out + ", Grado de entrada: " + in;
    }

    public static <V, E> boolean esCaminoDirigido(GraphListEdge<V, E> g) {
        int startNodes = 0;
        int endNodes = 0;

        for (VertexObj<V, E> v : g.getVertices()) {
            int out = 0, in = 0;
            for (EdgeObj<V, E> e : g.getEdges()) {
                if (e.getEndVertex1().equals(v)) out++;
                if (e.getEndVertex2().equals(v)) in++;
            }
            if (out - in == 1) startNodes++;
            else if (in - out == 1) endNodes++;
            else if (in != out) return false;
        }

        return startNodes == 1 && endNodes == 1;
    }

    public static <V, E> boolean esCicloDirigido(GraphListEdge<V, E> g) {
        for (VertexObj<V, E> v : g.getVertices()) {
            int in = 0, out = 0;
            for (EdgeObj<V, E> e : g.getEdges()) {
                if (e.getEndVertex1().equals(v)) out++;
                if (e.getEndVertex2().equals(v)) in++;
            }
            if (in != 1 || out != 1) return false;
        }
        return true;
    }

    public static <V, E> boolean esRuedaDirigido(GraphListEdge<V, E> g) {
        int n = g.getVertices().size();
        int centro = 0, periferia = 0;

        for (VertexObj<V, E> v : g.getVertices()) {
            int in = 0, out = 0;
            for (EdgeObj<V, E> e : g.getEdges()) {
                if (e.getEndVertex1().equals(v)) out++;
                if (e.getEndVertex2().equals(v)) in++;
            }

            if (in == n - 1 && out == n - 1) centro++;
            else if (in == 2 && out == 2) periferia++;
        }

        return centro == 1 && periferia == (n - 1);
    }

    public static <V, E> boolean esCompletoDirigido(GraphListEdge<V, E> g) {
        int n = g.getVertices().size();
        int expectedEdges = n * (n - 1);
        return g.getEdges().size() == expectedEdges;
    }
    public static <V, E> boolean esIsomorfo(GraphListEdge<V, E> g1, GraphListEdge<V, E> g2) {
        if (g1.getVertices().size() != g2.getVertices().size()) return false;
        if (g1.getEdges().size() != g2.getEdges().size()) return false;

        // Comparación estructural por matriz de adyacencia
        int[][] m1 = matrizAdyacenciaDirigido(g1);
        int[][] m2 = matrizAdyacenciaDirigido(g2);

        return Arrays.deepEquals(m1, m2);
    }

    public static <V, E> boolean esPlano(GraphListEdge<V, E> g) {
        int v = g.getVertices().size();
        int a = g.getEdges().size();
        return a <= 3 * v - 6;
    }

    public static <V, E> boolean esConexo(GraphListEdge<V, E> g) {
        if (g.getVertices().isEmpty()) return true;
        Set<VertexObj<V, E>> visitados = new HashSet<>();
        dfsConexo(g, g.getVertices().get(0), visitados);
        return visitados.size() == g.getVertices().size();
    }

    private static <V, E> void dfsConexo(GraphListEdge<V, E> g, VertexObj<V, E> actual, Set<VertexObj<V, E>> visitados) {
        if (visitados.contains(actual)) return;
        visitados.add(actual);
        for (EdgeObj<V, E> e : g.getEdges()) {
            if (e.getEndVertex1().equals(actual)) {
                dfsConexo(g, e.getEndVertex2(), visitados);
            }
        }
    }

    public static <V, E> boolean esAutoComplementario(GraphListEdge<V, E> g) {
        GraphListEdge<V, E> complementario = construirComplemento(g);
        return esIsomorfo(g, complementario);
    }

    private static <V, E> GraphListEdge<V, E> construirComplemento(GraphListEdge<V, E> g) {
        GraphListEdge<V, E> nuevo = new GraphListEdge<>();

        for (VertexObj<V, E> v : g.getVertices()) {
            nuevo.insertVertex(v.getInfo());
        }

        List<VertexObj<V, E>> vertices = nuevo.getVertices();
        for (VertexObj<V, E> v1 : vertices) {
            for (VertexObj<V, E> v2 : vertices) {
                if (!v1.equals(v2) && !g.existEdge(v1.getInfo(), v2.getInfo())) {
                    nuevo.insertEdge(v1.getInfo(), v2.getInfo(), null);
                }
            }
        }

        return nuevo;
    }

    private static <V, E> int[][] matrizAdyacenciaDirigido(GraphListEdge<V, E> g) {
        int n = g.getVertices().size();
        int[][] matriz = new int[n][n];
        Map<VertexObj<V, E>, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(g.getVertices().get(i), i);
        }

        for (EdgeObj<V, E> e : g.getEdges()) {
            int i = indexMap.get(e.getEndVertex1());
            int j = indexMap.get(e.getEndVertex2());
            matriz[i][j] = 1;
        }

        return matriz;
    }
}
