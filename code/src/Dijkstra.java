import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
   public static HashMap<Character,Integer> mappp = new HashMap<>();
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

   static class Graph {
      int vertices;
      LinkedList<Edge>[] adjacencylist;

      public Graph(int vertices) {
         this.vertices = vertices;
         adjacencylist = new LinkedList[vertices];

         for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
         }
      }

      public void addEdge(int source, int destination, int weight) {
         Edge edge = new Edge(source, destination, weight);
         adjacencylist[source].addFirst(edge);

         edge = new Edge(destination, source, weight);
         adjacencylist[destination].addFirst(edge);
      }


      public void dijkstra(int source) {

         // denotes shortest distance from source node to all other nodes
         int distances[] = new int[vertices];
         // indicates if the node has been visited or not (defaults to false)
         boolean visited[] = new boolean[vertices];

         // initialize shortest distance to all nodes as "infinity"
         for (int i = 0; i < vertices; i++)
            distances[i] = Integer.MAX_VALUE;

//         distances[source] = 0; // distance from source vertex to itself is 0

         // find shortest path to all nodes
         for (int count = 0; count < vertices; count++) {
            // choose the minimum distance node from the set of nodes
            // not yet visited
            int min = Integer.MAX_VALUE;
         }

         // Manually changing the compare methods to comapre using distances
         PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {

               // This is to ensure that the comparator sorts using Distance values
               int key1 = p1.getKey();
               int key2 = p2.getKey();
               return key1 - key2;
            }
         });

         Pair<Integer, Integer> p0 = new Pair<>(distances[0], 0);
         queue.offer(p0); // adding the first pair with a distance to itself as 0 .. same as the given code but using Pair

         while (!queue.isEmpty()) {
            Pair<Integer, Integer> extractedPair = queue.poll();

            int extractedVertex = extractedPair.getValue();
            if (!visited[extractedVertex]) {
               visited[extractedVertex] = true;

               LinkedList<Edge> list = adjacencylist[extractedVertex];
               for (int i = 0; i < list.size(); i++) {
                  Edge edge = list.get(i);
                  int destination = edge.destination;

                  if (visited[destination] == false) {
                     int newKey = distances[extractedVertex] + edge.weight;
                     int currentKey = distances[destination];

                     if (currentKey > newKey) {
                        Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                        queue.offer(p);
                        distances[destination] = newKey;
                     }
                  }

               }
            }
         }
         printDistances(distances, source);
      }


      // helper function for the conversion of A to 0 B to 1 etc ..
      protected static void PopulateMap(int vertices){
         int start = 'A';
         for (int i = 0; i <= vertices; i++) {
            mappp.put((char)start,i);
            start++;
         }
      }

      // helper function for the conversion of A to 0 B to 1 etc ..
      protected static int LetterToNum(Character letter) {

         return mappp.get(letter);
      }

      public void printDistances(int distances[], int source) {

//         int N = distances.length;
         System.out.println("Node  Distance");

         for (int i = 0; i < vertices; i++)
            System.out.println("Source Vertex " + source + "to vertex " + i + " distance: " + distances[i]);
      }

      public static void main(String[] args) {
         int vertices = 6;
         PopulateMap(6);
         Graph graph = new Graph(vertices);

         System.out.println(LetterToNum('G'));

//         graph.addEdge(LetterToNum('G'), LetterToNum('C'),5);
//         graph.addEdge(LetterToNum('C'),LetterToNum('B'),1);
//         graph.addEdge(LetterToNum('B'),LetterToNum('A'),1);
//         graph.addEdge(LetterToNum('A'),LetterToNum('D'),1);
//         graph.addEdge(LetterToNum('D'),LetterToNum('E'),4);
//         graph.addEdge(LetterToNum('D'),LetterToNum('F'),6);
//         graph.addEdge(LetterToNum('F'),LetterToNum('E'),3);



         graph.addEdge(0, 1, 4);
         graph.addEdge(0, 2, 3);
         graph.addEdge(1, 2, 1);
         graph.addEdge(1, 3, 2);
         graph.addEdge(2, 3, 4);
         graph.addEdge(3, 4, 2);
         graph.addEdge(4, 5, 6);
         graph.dijkstra(0);




      }
   }
}