
public class Edge<N,W> implements IEdge<N,W>{
    // Field
    W weight;

    // Nodes connected by this edge
    INode<N> source;
    INode<N> destination;

    public Edge(INode<N> source, INode<N> destination, W w) {
        this.source = source;
        this.destination = destination;
        weight = w;
    }


    /**
     * Change the weight
     * @param w the new weight
     */
    public void setWeight(W w) {
      weight=w;
    }

    /**
     * Retrieve the current weight
     * @return weight
     */
    public W getWeight() {
      return weight;
    }

    /**
     * Get Node A
     * @return a side
     */
    public INode<N> getSource() {
      return source;
    }

    /**
     * Get Node B
     * @return b side
     */
    public INode<N> getDestination() {
      return destination;
    }

    public boolean equals(Edge<N,W> other){
      if(this.getSource()==(other.getSource()) && this.getDestination()==(other.getDestination())){
        return true;
      }
      else{
        return false;
      }
    }

    public static void main(String[] args){
      GraphNode<String> node_1=new GraphNode<String>("Hi");
      GraphNode<String> node_2=new GraphNode<String>("Howdy");
      GraphNode<String> node_3=new GraphNode<String>("Sarah");
      GraphNode<String> node_4=new GraphNode<String>("Computer");
      Edge<String,Double> new_edge= new Edge<String,Double>(node_1, node_2, 3.0);
      Edge<String,Double> new_edge1= new Edge<String,Double>(node_2, node_1, 3.0);
      Edge<String,Double> new_edge3= new Edge<String,Double>(node_1, node_3, 3.0);
      Edge<String,Double> new_edge4= new Edge<String,Double>(node_1, node_3, 5.0);
      System.out.println(new_edge3.equals(new_edge4));
    }

}
