package graph;

import java.util.*;

public class GraphListEdge<V, E> {
    private ArrayList<VertexObj<V, E>> secVertex;
    private ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    public void insertVertex(V data) {
        if (!searchVertex(data)) {
            secVertex.add(new VertexObj<>(data, secVertex.size()));
        }
    }

    public void insertEdge(V data1, V data2) {
        if (!searchEdge(data1, data2)) {
            VertexObj<V, E> v1 = getVertex(data1);
            VertexObj<V, E> v2 = getVertex(data2);
            if (v1 != null && v2 != null) {
                secEdge.add(new EdgeObj<>(v1, v2, null, secEdge.size()));
            }
        }
    }

    public boolean searchVertex(V data) {
        return getVertex(data) != null;
    }

    public boolean searchEdge(V data1, V data2) {
        VertexObj<V, E> v1 = getVertex(data1);
        VertexObj<V, E> v2 = getVertex(data2);
        if (v1 == null || v2 == null) return false;
        for (EdgeObj<V, E> e : secEdge) {
            if ((e.getEndVertex1().equals(v1) && e.getEndVertex2().equals(v2)) ||
                (e.getEndVertex1().equals(v2) && e.getEndVertex2().equals(v1))) {
                return true;
            }
        }
        return false;
    }

    VertexObj<V, E> getVertex(V data) {
        for (VertexObj<V, E> v : secVertex) {
            if (v.getInfo().equals(data)) {
                return v;
            }
        }
        return null;
    }

    public void bfs(V startData) {
        VertexObj<V, E> start = getVertex(startData);
        if (start == null) return;

        Set<VertexObj<V, E>> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            System.out.println(current.getInfo());

            for (EdgeObj<V, E> edge : secEdge) {
                VertexObj<V, E> neighbor = null;
                if (edge.getEndVertex1().equals(current)) {
                    neighbor = edge.getEndVertex2();
                } else if (edge.getEndVertex2().equals(current)) {
                    neighbor = edge.getEndVertex1();
                }

                if (neighbor != null && !visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    // ✅ Métodos para obtener las listas internas (solo lectura)
    public List<VertexObj<V, E>> getVertices() {
        return Collections.unmodifiableList(secVertex);
    }

    public List<EdgeObj<V, E>> getEdges() {
        return Collections.unmodifiableList(secEdge);
    }
    public boolean existEdge(V origen, V destino) {
    VertexObj<V, E> v1 = getVertex(origen);
    VertexObj<V, E> v2 = getVertex(destino);
    if (v1 == null || v2 == null) return false;

    for (EdgeObj<V, E> edge : secEdge) {
        if (edge.getEndVertex1().equals(v1) && edge.getEndVertex2().equals(v2)) {
            return true;
        }
    }
    return false;
}
// Método con información de la arista (por ejemplo, peso o etiqueta)
public void insertEdge(V data1, V data2, E info) {
    if (!searchEdge(data1, data2)) {
        VertexObj<V, E> v1 = getVertex(data1);
        VertexObj<V, E> v2 = getVertex(data2);
        if (v1 != null && v2 != null) {
            secEdge.add(new EdgeObj<>(v1, v2, info, secEdge.size()));
        }
    }
}

}
