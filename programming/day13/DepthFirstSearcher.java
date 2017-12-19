import java.io.FileNotFoundException;
import java.io.IOException;

public class DepthFirstSearcher<N,W> implements ISearcher<N,W>{
INode<N> current_node;
INode<N>[] neighbors;
IList<INode<N>> path_nodes;

public DepthFirstSearcher(){
  current_node=null;
  path_nodes=new DoubleLinkList();
}

  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
  current_node=s;
  path_nodes.append(current_node);
  if(current_node.getValue().equals(e.getValue())){
    return true;
  }
  neighbors=g.getNeighbors(current_node);
  for(int i=0; i<neighbors.length; i++){
    current_node=neighbors[i];
    boolean path=pathExists(g,current_node,e);
    if(path==true){
    return true;
    }
  }
  return false;
  }


  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
  if(this.pathExists(g,s,e)==true){
    return path_nodes;
  }
  return null;
}

public void printMe(IList<INode<N>> list){
    list.jumpToHead();
    for(int i=0; i <list.size(); i++){
    System.out.println(list.fetch(i).getValue());
    list.next();
  }
}



  public void printNeighbors(INode<N>[] array){
    for(int i=0; i<array.length; i++){
      System.out.print(array[i].getValue() + " ");
      }
      System.out.println();
  }

  public static void main(String[] args) throws FileNotFoundException,IOException{
    IGraphReader r=new DiGraphReader();
    IGraph<String,Double> graph= r.read("graphfile.cs2");
    INode<String>[] nodes_array= graph.getNodeSet();
    DepthFirstSearcher<String,Double> searcher=new DepthFirstSearcher<String,Double>();
  //  searcher.printNeighbors(nodes_array);
    //searcher.getPath(graph,nodes_array[0],nodes_array[4]));
    searcher.printMe(searcher.getPath(graph, nodes_array[1], nodes_array[3]));
}
}
