package project5;

/**
 * Implement a graph class that “builds a graph” using vertices and edges,
 * display the adjacency matrix for the graph and implemented Warshall Algorithm
 * (as discussed on pg. 662 of you text). Your graph class should support graphs
 * with at most 10 vertices.
 *
 * @author Jason Travis
 */
class Graph {

    private final int MAX_VERTS = 10;
    private Vertex vertexList[]; // array of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices

    public Graph() // constructor
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];

        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) // set adjacency
        {
            for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
            {
                adjMat[j][k] = 0;
            }
        }
    }

    public void addVertex(char lab) // argument is label
    {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    private class Vertex {

        // label (e.g. ‘A’)
        public char label;
        public boolean wasVisited;

        public Vertex(char lab) {
            label = lab;
            wasVisited = false;
        }
    }

}
