package graph;

import java.util.*;

public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<>();
    }

    // Método para obtener un vértice por su dato
    protected Vertex<E> getVertex(E data) {
        for (ListLinked.Node<Vertex<E>> node = listVertex.getHead(); node != null; node = listVertex.getNext(node)) {
            if (node.data.getData().equals(data)) {
                return node.data;
            }
        }
        return null;
    }

    public void insertVertex(E data) {
        Vertex<E> v = new Vertex<>(data);
        if (!searchVertex(data)) {
            listVertex.add(v);
        }
    }

    public void insertEdge(E verOri, E verDes, int weight) {
        Vertex<E> vOri = getVertex(verOri);
        Vertex<E> vDes = getVertex(verDes);
        if (vOri != null && vDes != null && !searchEdge(verOri, verDes)) {
            Edge<E> edge = new Edge<>(vDes, weight);
            vOri.listAdj.add(edge);
        }
    }

    public boolean searchVertex(E v) {
        return getVertex(v) != null;
    }

    public boolean searchEdge(E v, E z) {
        Vertex<E> vOri = getVertex(v);
        Vertex<E> vDes = getVertex(z);
        if (vOri == null || vDes == null) return false;
        for (Edge<E> edge = getFirstEdge(vOri); edge != null; edge = getNextEdge(vOri, edge)) {
            if (edge.refDest.equals(vDes)) {
                return true;
            }
        }
        return false;
    }

    public void removeVertex(E v) {
        Vertex<E> vertex = getVertex(v);
        if (vertex != null) {
            for (Vertex<E> u = getFirstVertex(); u != null; u = getNextVertex(u)) {
                u.listAdj.remove(new Edge<>(vertex, 0));
            }
            listVertex.remove(vertex);
        }
    }

    public void removeEdge(E v, E z) {
        Vertex<E> vOri = getVertex(v);
        Vertex<E> vDes = getVertex(z);
        if (vOri != null && vDes != null) {
            vOri.listAdj.remove(new Edge<>(vDes, 0));
        }
    }

    public void dfs(E v) {
        Vertex<E> start = getVertex(v);
        if (start == null) return;
        Set<Vertex<E>> visited = new HashSet<>();
        dfsVisit(start, visited);
    }

    private void dfsVisit(Vertex<E> v, Set<Vertex<E>> visited) {
        System.out.println(v.getData());
        visited.add(v);
        for (Edge<E> edge = getFirstEdge(v); edge != null; edge = getNextEdge(v, edge)) {
            Vertex<E> adj = edge.refDest;
            if (!visited.contains(adj)) {
                dfsVisit(adj, visited);
            }
        }
    }

    private ListLinked.Node<Vertex<E>> currentVertexNode = null;
    private ListLinked.Node<Edge<E>> currentEdgeNode = null;

    Vertex<E> getFirstVertex() {
        currentVertexNode = listVertex.getHead();
        return (currentVertexNode != null) ? currentVertexNode.data : null;
    }

    Vertex<E> getNextVertex(Vertex<E> current) {
        if (currentVertexNode != null) {
            currentVertexNode = listVertex.getNext(currentVertexNode);
            return (currentVertexNode != null) ? currentVertexNode.data : null;
        }
        return null;
    }

    Edge<E> getFirstEdge(Vertex<E> v) {
        currentEdgeNode = v.listAdj.getHead();
        return (currentEdgeNode != null) ? currentEdgeNode.data : null;
    }

    Edge<E> getNextEdge(Vertex<E> v, Edge<E> current) {
        if (currentEdgeNode != null) {
            currentEdgeNode = v.listAdj.getNext(currentEdgeNode);
            return (currentEdgeNode != null) ? currentEdgeNode.data : null;
        }
        return null;
    }

    public void bfs(E v) {
        Vertex<E> start = getVertex(v);
        if (start == null) return;

        Set<Vertex<E>> visited = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            System.out.println(current.getData());

            for (Edge<E> edge = getFirstEdge(current); edge != null; edge = getNextEdge(current, edge)) {
                Vertex<E> neighbor = edge.refDest;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public ArrayList<E> bfsPath(E v, E z) {
        Vertex<E> start = getVertex(v);
        Vertex<E> goal = getVertex(z);
        ArrayList<E> path = new ArrayList<>();

        if (start == null || goal == null) return path;

        Map<Vertex<E>, Vertex<E>> parent = new HashMap<>();
        Set<Vertex<E>> visited = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();
            if (current.equals(goal)) break;

            for (Edge<E> edge = getFirstEdge(current); edge != null; edge = getNextEdge(current, edge)) {
                Vertex<E> neighbor = edge.refDest;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        if (!parent.containsKey(goal)) return path;

        for (Vertex<E> vtx = goal; vtx != null; vtx = parent.get(vtx)) {
            path.add(0, vtx.getData());
        }

        return path;
    }

    public void insertEdgeWeight(E v, E z, int w) {
        Vertex<E> origin = getVertex(v);
        Vertex<E> dest = getVertex(z);

        if (origin == null) {
            origin = new Vertex<>(v);
            listVertex.add(origin);
        }

        if (dest == null) {
            dest = new Vertex<>(z);
            listVertex.add(dest);
        }

        if (!searchEdge(v, z)) {
            origin.listAdj.add(new Edge<>(dest, w));
        }

        if (!searchEdge(z, v)) {
            dest.listAdj.add(new Edge<>(origin, w));
        }
    }

    public ArrayList<E> shortPath(E v, E z) {
        Vertex<E> start = getVertex(v);
        Vertex<E> goal = getVertex(z);
        ArrayList<E> path = new ArrayList<>();
        if (start == null || goal == null) return path;

        Map<Vertex<E>, Integer> dist = new HashMap<>();
        Map<Vertex<E>, Vertex<E>> prev = new HashMap<>();
        PriorityQueue<Vertex<E>> queue = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (Vertex<E> vertex = getFirstVertex(); vertex != null; vertex = getNextVertex(vertex)) {
            dist.put(vertex, Integer.MAX_VALUE);
        }

        dist.put(start, 0);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();

            for (Edge<E> edge = getFirstEdge(current); edge != null; edge = getNextEdge(current, edge)) {
                Vertex<E> neighbor = edge.refDest;
                int alt = dist.get(current) + edge.weight;
                if (alt < dist.get(neighbor)) {
                    dist.put(neighbor, alt);
                    prev.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        if (!prev.containsKey(goal) && !start.equals(goal)) return path;

        for (Vertex<E> at = goal; at != null; at = prev.get(at)) {
            path.add(0, at.getData());
        }

        return path;
    }

    public boolean isConexo() {
        if (listVertex.isEmpty()) return true;

        Set<Vertex<E>> visited = new HashSet<>();
        Queue<Vertex<E>> queue = new LinkedList<>();

        Vertex<E> start = getFirstVertex();
        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Vertex<E> current = queue.poll();

            for (Edge<E> edge = getFirstEdge(current); edge != null; edge = getNextEdge(current, edge)) {
                Vertex<E> neighbor = edge.refDest;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        int count = 0;
        for (Vertex<E> v = getFirstVertex(); v != null; v = getNextVertex(v)) {
            count++;
        }

        return visited.size() == count;
    }

    public Stack<E> Dijkstra(E v, E w) {
        ArrayList<E> path = shortPath(v, w);
        Stack<E> stack = new Stack<>();
        for (E element : path) {
            stack.push(element);
        }
        return stack;
    }

    public String toString() {
        return this.listVertex.toString();
    }
    public Map<E, Integer> dijkstra(E v) {
    Vertex<E> start = getVertex(v);
    Map<E, Integer> distances = new HashMap<>();
    Map<Vertex<E>, Integer> internalDistances = new HashMap<>();
    PriorityQueue<Vertex<E>> pq = new PriorityQueue<>(Comparator.comparingInt(internalDistances::get));

    if (start == null) return distances;

    for (ListLinked.Node<Vertex<E>> node = listVertex.getHead(); node != null; node = listVertex.getNext(node)) {
        Vertex<E> vertex = node.data;
        internalDistances.put(vertex, Integer.MAX_VALUE);
    }

    internalDistances.put(start, 0);
    pq.add(start);

    while (!pq.isEmpty()) {
        Vertex<E> current = pq.poll();
        int currentDist = internalDistances.get(current);

        for (Edge<E> edge = getFirstEdge(current); edge != null; edge = getNextEdge(current, edge)) {
            Vertex<E> neighbor = edge.refDest;
            int newDist = currentDist + edge.weight;
            if (newDist < internalDistances.get(neighbor)) {
                internalDistances.put(neighbor, newDist);
                pq.remove(neighbor); // Para actualizar su prioridad
                pq.add(neighbor);
            }
        }
    }

    for (Map.Entry<Vertex<E>, Integer> entry : internalDistances.entrySet()) {
        distances.put(entry.getKey().getData(), entry.getValue());
    }

    return distances;
}

}
