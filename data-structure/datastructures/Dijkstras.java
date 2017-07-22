package datastructures;
/**
 * @author budongbai
 * @version 2017年9月14日上午11:09:44
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstras {

    public static void main(String[] args) {
        Graphs g = new Graphs();
        g.addVertexs('A', Arrays.asList(new Vertexs('B', 7), new Vertexs('C', 8)));
        g.addVertexs('B', Arrays.asList(new Vertexs('A', 7), new Vertexs('F', 2)));
        g.addVertexs('C', Arrays.asList(new Vertexs('A', 8), new Vertexs('F', 6), new Vertexs('G', 4)));
        g.addVertexs('D', Collections.singletonList(new Vertexs('F', 8)));
        g.addVertexs('E', Collections.singletonList(new Vertexs('H', 1)));
        g.addVertexs('F', Arrays.asList(new Vertexs('B', 2), new Vertexs('C', 6), new Vertexs('D', 8), new Vertexs('G', 9), new Vertexs('H', 3)));
        g.addVertexs('G', Arrays.asList(new Vertexs('C', 4), new Vertexs('F', 9)));
        g.addVertexs('H', Arrays.asList(new Vertexs('E', 1), new Vertexs('F', 3)));
        System.out.println(g.getShortestPath('A', 'H'));
    }

}

class Vertexs implements Comparable<Vertexs> {

    private Character id;
    private Integer distance;

    public Vertexs(Character id, Integer distance) {
        super();
        this.id = id;
        this.distance = distance;
    }

    public Character getId() {
        return id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((distance == null) ? 0 : distance.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertexs other = (Vertexs) obj;
        if (distance == null) {
            if (other.distance != null)
                return false;
        } else if (!distance.equals(other.distance))
            return false;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Vertexs [id=" + id + ", distance=" + distance + "]";
    }

    @Override
    public int compareTo(Vertexs o) {
        if (this.distance < o.distance)
            return -1;
        else if (this.distance > o.distance)
            return 1;
        else
            return this.getId().compareTo(o.getId());
    }

}

class Graphs {

    private final Map<Character, List<Vertexs>> vertices;

    public Graphs() {
        this.vertices = new HashMap<Character, List<Vertexs>>();
    }

    public void addVertexs(Character character, List<Vertexs> vertex) {
        this.vertices.put(character, vertex);
    }

    public List<Character> getShortestPath(Character start, Character finish) {
        final Map<Character, Integer> distances = new HashMap<>();
        final Map<Character, Vertexs> previous = new HashMap<>();
        PriorityQueue<Vertexs> nodes = new PriorityQueue<>();

        for (Character vertex : vertices.keySet()) {
            if (vertex == start) {
                distances.put(vertex, 0);
                nodes.add(new Vertexs(vertex, 0));
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
                nodes.add(new Vertexs(vertex, Integer.MAX_VALUE));
            }
            previous.put(vertex, null);
        }

        while (!nodes.isEmpty()) {
            Vertexs smallest = nodes.poll();
            if (smallest.getId() == finish) {
                final List<Character> path = new ArrayList<>();
                while (previous.get(smallest.getId()) != null) {
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }
                return path;
            }

            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
                break;
            }

            for (Vertexs neighbor : vertices.get(smallest.getId())) {
                Integer alt = distances.get(smallest.getId()) + neighbor.getDistance();
                if (alt < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), alt);
                    previous.put(neighbor.getId(), smallest);

                    forloop:
                    for (Vertexs n : nodes) {
                        if (n.getId() == neighbor.getId()) {
                            nodes.remove(n);
                            n.setDistance(alt);
                            nodes.add(n);
                            break forloop;
                        }
                    }
                }
            }
        }

        return new ArrayList<Character>(distances.keySet());
    }

}