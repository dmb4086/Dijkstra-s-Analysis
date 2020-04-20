import java.util.LinkedList;

/*
    This is the helper file for Dijkstra, this file is a list representation of a graph
 */
public class WeightedGraph {

    static class Edge {

        int source;
        int destination;
        int weight;

        /*
        The constructor for the Edges.
         */
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph{
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
        }
    }



}




