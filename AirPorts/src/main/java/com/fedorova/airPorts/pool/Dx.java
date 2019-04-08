package com.fedorova.airPorts.pool;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;
public class Dx {
	private final static Logger logger= Logger.getLogger(Dx.class);
	  
	
	   private static final Graph.Edge[] GRAPH = {
	      new Graph.Edge("a", "b", 7),
	      new Graph.Edge("a", "c", 9),
	      new Graph.Edge("a", "f", 14),
	      new Graph.Edge("b", "c", 10),
	      new Graph.Edge("b", "d", 15),
	      new Graph.Edge("c", "d", 11),
	      new Graph.Edge("c", "f", 2),
	      new Graph.Edge("d", "e", 6),
	      new Graph.Edge("e", "f", 9),
	   };
	   private static final String START = "a";
	   private static final String END = "f";
	  
	   public static void main(String[] args) {
	      Graph g = new Graph(GRAPH);
	      g.dijkstra(START);
	      g.printPath(END);
	     //g.printAllPaths();
	   }
	}
	  
	class Graph {
		private final static Logger logger= Logger.getLogger(Graph.class);
	   private final Map<String, Vertex> graph; // mapping of vertex names to Vertex objects, built from a set of Edges
	  
	   /** One edge of the graph (only used by Graph constructor) */
	   public static class Edge {
	      public final String v1, v2;
	      public final int dist;
	      public Edge(String v1, String v2, int dist) {
	         this.v1 = v1;
	         this.v2 = v2;
	         this.dist = dist;
	         logger.info("/** One edge of the graph (only used by Graph constructor) */");
	      }
	   }
	  
	   /** One vertex of the graph, complete with mappings to neighbouring vertices */
	   public static class Vertex implements Comparable<Vertex> {
			private final static Logger logger= Logger.getLogger(Vertex.class);
	      public final String name;
	      public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
	      public Vertex previous = null;
	      public final Map<Vertex, Integer> neighbours = new HashMap<>();
	  
	      public Vertex(String name) {
	         this.name = name;
	         logger.info("public vertex");
	      }
	  
	      private void printPath() {
	         if (this == this.previous) {
	            System.out.printf("%s", this.name);
	            logger.info("printPath  this.name");
	         } else if (this.previous == null) {
	            System.out.printf("%s(unreached)", this.name);
	            logger.info("printPath  (unreached)\", this.name");
	         } else {
	            this.previous.printPath();
	            System.out.printf(" -> %s(%d)", this.name, this.dist);
	            logger.info("printPath   %s(%d)\", this.name, this.dist");
	         }
	      }
	  
	      public int compareTo(Vertex other) {
	    	  logger.info("compareTo ");
	         return Integer.compare(dist, other.dist);

	            
	      }
	   }
	  
	   /** Builds a graph from a set of edges */
	   public Graph(Edge[] edges) {
	      graph = new HashMap<>(edges.length);
	  
	      //one pass to find all vertices
	      for (Edge e : edges) {
	         if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));

	    	  logger.info("Graph [] 1 ");
	         if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));

	    	  logger.info("Graph [] 2 ");
	      }
	  
	      //another pass to set neighbouring vertices
	      for (Edge e : edges) {
	         graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
	         //graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
	         logger.info("Graph Edge [] 3 ");
	      }
	   }
	  
	   /** Runs dijkstra using a specified source vertex */
	   public void dijkstra(String startName) {
	      if (!graph.containsKey(startName)) {
	    	  logger.info(" dijkstra containskey");
	         System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
	         return;
	      }
	      final Vertex source = graph.get(startName);
	      NavigableSet<Vertex> q = new TreeSet<>();
	  
	      // set-up vertices
	      for (Vertex v : graph.values()) {
	         v.previous = v == source ? source : null;
	         logger.info(" dijkstra v.previous1 назначение предыдущей точки ");
	         v.dist = v == source ? 0 : Integer.MAX_VALUE;
	         logger.info(" dijkstra v.dist2  подсчет расстояний");
	         q.add(v);
	         logger.info(" dijkstra add3  добавление новой точки ");
	      }
	  
	      dijkstra(q);
	      logger.info(q);
	   }
	  
	   /** Implementation of dijkstra's algorithm using a binary heap. */
	   private void dijkstra(final NavigableSet<Vertex> q) {      
	      Vertex u, v;
	      while (!q.isEmpty()) {
	    	  	  
	         u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
	         logger.info(" dijkstra while final");
	         if (u.dist == Integer.MAX_VALUE) break; // we can ignore u (and any other remaining vertices) since they are unreachable
	         logger.info(" dijkstra if max");
	         //look at distances to each neighbour
	         for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
	            v = a.getKey(); //the neighbour in this iteration
	            logger.info(" dijkstra for map");
	  
	            final int alternateDist = u.dist + a.getValue();
	            if (alternateDist < v.dist) { // shorter path to neighbour found
	               q.remove(v);
	               logger.info(" dijkstra q.remove(v)");
	               v.dist = alternateDist;
	               logger.info(" dijkstra v.dist");
	               v.previous = u;
	               logger.info(" dijkstra v.previous");
	               q.add(v);
	               logger.info(" dijkstra q.add(v)");
	            } 
	         }
	      }
	   }
	  
	   /** Prints a path from the source to the specified vertex */
	   public void printPath(String endName) {
	      if (!graph.containsKey(endName)) {
	    	  logger.info(" printPath if end name");
	         System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
	         logger.info(" printPath 2 after Graph doesn't contain");
	         return;
	      }
	      logger.info(" printPath 1");
	      logger.info(" !!!!!!!!!!!!!!!!!"); graph.get(endName).printPath();
	    
	      //System.out.println();
	   }
	   /** Prints the path from the source to every vertex (output order is not guaranteed) */
	   public void printAllPaths() {
	      for (Vertex v : graph.values()) {
	    	  logger.info(" printAllPaths 1");
	         v.printPath();
	         logger.info(" printAllPaths 2");
	         System.out.println();
	      }
	   }
	}


