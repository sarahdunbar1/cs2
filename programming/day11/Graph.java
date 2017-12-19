
//**Some of this code is from the class implementation of the IGraph interface**//
public class Graph<N,W> implements IGraph<N,W>{
    IList<INode<N>> nodes; // maybe?
    IList<Edge<N,W>> edges; // maybe?
    INode<N> curr; // current node in the graph?

    public Graph() {
        nodes = new DoubleLinkList<INode<N>>();
        edges = new DoubleLinkList<Edge<N,W>>();
        curr  = null;
    }

    //returns an array of all the nodes in the graoh using the nodes list
    public INode<N>[] getNodeSet(){
    INode<N>[] nodes_array= new GraphNode[nodes.size()];
    for(int i=0; i<nodes.size(); i++){
      nodes_array[i]=nodes.fetch(i);
    }
    return nodes_array;
    }

//searches the edge array to see which nodes does n point to
    public INode<N>[] getNeighbors(INode<N> n){
    IList<INode<N>> neighbors_list= new DoubleLinkList<INode<N>>();
    for(int i=0; i<edges.size(); i++){
      if(edges.fetch(i).getSource().equals(n)){
        neighbors_list.append(edges.fetch(i).getDestination());
      }
    }
    INode<N>[] neighbors= new GraphNode[neighbors_list.size()];
    for(int i=0; i<neighbors_list.size(); i++){
      neighbors[i]=neighbors_list.fetch(i);
    }
    return neighbors;
    }

//creates a new edge and appends it to the list, no duplicates
    public void addEdge(INode<N> s, INode<N> d, W w){
    Edge<N,W> new_edge= new Edge<N,W>(s,d,w);
    if(edges.size()<1){
      edges.append(new_edge);
    }
    else{
      for(int i=0; i<edges.size(); i++){
        if(edges.fetch(i).equals(new_edge)==true){
          System.out.println("edge already exists");
          return;
        }
      }

      edges.append(new_edge);
      return;
      }
    }

//returns an array of all the edges in the graph
  public IEdge<N,W>[] getEdgeSet(){
    IEdge<N,W>[] edges_array= new Edge[edges.size()];
    for(int i=0; i<edges.size(); i++){
      edges_array[i]=edges.fetch(i);
    }
    return edges_array;
    }

//returns list of all edges whos source is n
    public IEdge<N,W>[] getEdgesFrom(INode<N> n){
    IList<Edge<N,W>> edges_from_list= new DoubleLinkList<Edge<N,W>>();
    for(int i=0; i<edges.size(); i++){
      if(edges.fetch(i).getSource().equals(n)){
        edges_from_list.append(edges.fetch(i));
      }
    }
    IEdge<N,W>[] edges_from_array= new Edge[edges_from_list.size()];
    for(int i=0; i<edges_from_list.size(); i++){
      edges_from_array[i]=edges_from_list.fetch(i);
    }
    return edges_from_array;

  }

//creates an edge array containing all the source nodes whose destination node is
//n
    public IEdge<N,W>[] getEdgesTo(INode<N> n){
    IList<Edge<N,W>> edges_to_list= new DoubleLinkList<Edge<N,W>>();
    for(int i=0; i<edges.size(); i++){
      if(edges.fetch(i).getDestination().equals(n)){
        edges_to_list.append(edges.fetch(i));
      }
    }
    IEdge<N,W>[] edges_to_array= new Edge[edges_to_list.size()];
    for(int i=0; i<edges_to_list.size(); i++){
      edges_to_array[i]=edges_to_list.fetch(i);
    }
    return edges_to_array;
    }

    //adds node to the graph
    public INode<N> addNode(N v) {
        INode<N> n = new GraphNode<N>(v);
        curr = n;
        nodes.append(n);
        return n;
    }



    //an add node function that checks if we are trying to add duplicates
    public INode<N> addNodeCheck(N v){
        INode<N> new_node= new GraphNode<N>(v);
        if(nodes.size()<1){
          nodes.append(new_node);
          return new_node;
        }
        else{
          for(int i=0; i<nodes.size(); i++){
            if(nodes.fetch(i).getValue().equals(new_node.getValue())){
              System.out.println("node already exists");
              return nodes.fetch(i);
            }
          }
          nodes.append(new_node);
          return new_node;
        }
      }

//returns node with given value
    public INode<N> fetchNode(N v) {
        for(int i=0;i<nodes.size(); i++) {
            INode<N> n = nodes.fetch(i);
            if( n.getValue().equals(v) ) {
                return n;
            }
        }
        return null;
    }


    public void printNodes(INode<N>[] array){
      for(int i=0; i<array.length; i++){
        System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printEdges(IEdge<N,W>[] array){
      for(int i=0; i<array.length; i++){
        System.out.println("("+ array[i].getSource().getValue() + ", " + array[i].getDestination().getValue() + ")");
        }
    }

    public static void main(String[] args) {
        Graph<String,Double> g = new Graph<String,Double>();
        GraphNode<String> node_1=new GraphNode<String>("Hi");
        GraphNode<String> node_2=new GraphNode<String>("Howdy");
        GraphNode<String> node_3=new GraphNode<String>("Sarah");
        GraphNode<String> node_4=new GraphNode<String>("Computer");
        g.addNodeCheck(node_1.getValue());
        g.addNodeCheck(node_2.getValue());
        g.addNodeCheck(node_1.getValue());
        g.addNodeCheck(node_3.getValue());
        g.addNodeCheck(node_4.getValue());
        g.addNodeCheck(node_2.getValue());
        //System.out.println(node_2);
        g.addEdge(node_1, node_2, 3.0);
        g.addEdge(node_1, node_3, 5.0);
        g.addEdge(node_1, node_4, 5.0);
        g.addEdge(node_3,node_4, 3.0);
        g.addEdge(node_1, node_3, 5.0);
        g.addEdge(node_1, node_2, 5.0);
        g.addEdge(node_1, node_2, 3.0);
        //g.add("Howdy");
        System.out.println(g.fetchNode("Hi"));
        //g.printEdges(g.getEdgeSet());
        //System.out.println(g.fetchNode("Hi"));
        System.out.println(g.fetchNode("Bye bye"));
    }
}
