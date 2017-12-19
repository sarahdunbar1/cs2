import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class BreadthFirstSearcher<N,W> implements ISearcher<N,W>{
Queue<IEdge<N,W>> queue;
BSTree t;
INode<N> current_node;
IEdge<N,W> current_edge;
IList<INode<N>> path_nodes;



public BreadthFirstSearcher(){
  queue= new Queue<IEdge<N,W>>();
  t= new BSTree<String,IEdge<N,W>>();
  current_node=null;
  current_edge=null;
  path_nodes= new DoubleLinkList();
}

public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
current_node=s;
IEdge<N,W>[] edges_from=g.getEdgesFrom(current_node);
for(int i=0; i<edges_from.length; i++){
  queue.enqueue(edges_from[i]);
}
// String current_node_value=current_node.getValue();
// t.add(current_node_value)=null;
while(queue.size()>0){
  current_edge=queue.dequeue();
  // String dest_node=current_edge.getDestination().getValue();
  // t.add(dest_node,current_edge);
  if(current_edge.getDestination().equals(e)){
    return true;
  }
  current_node=current_edge.getDestination();
  edges_from=g.getEdgesFrom(current_node);
  System.out.println(edges_from);
  for(int i=0; i<edges_from.length; i++){
    queue.enqueue(edges_from[i]);
  }
}
return false;
}



public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
  current_node=s;
  IEdge<N,W>[] edges_from=g.getEdgesFrom(current_node);
  for(int i=0; i<edges_from.length; i++){
    queue.enqueue(edges_from[i]);
  }
  String current_node_value=(String)current_node.getValue();
  t.add(current_node_value,null);
  while(queue.size()>0){
    current_edge=queue.dequeue();
     String dest_node=(String)current_edge.getDestination().getValue();
     t.add(dest_node,current_edge);
     if(current_edge.getDestination().equals(e)){
      t.add(e.getValue().toString(),current_edge);
    }
    current_node=current_edge.getDestination();
    edges_from=g.getEdgesFrom(current_node);
    for(int i=0; i<edges_from.length; i++){
      queue.enqueue(edges_from[i]);
    }
  }
  return getPath2(g,s,e);
  }

  public IList<INode<N>> getPath2(IGraph<N,W> g, INode<N> s, INode<N> e){
    if(pathExists(g,s,e)==true){
    INode<N> new_node=e;
    IEdge<N,W> new_edge;
    boolean path_found=false;
    while(!path_found){
    path_nodes.insert(0,new_node);
    new_edge=(IEdge<N,W>) t.fetch(new_node.getValue().toString());
    new_node= new_edge.getSource();
    if(new_node==s){
      path_nodes.insert(0,new_node);
      path_found=true;
    }
    }
  }
    return path_nodes;
  }
    public void printMe(IList<INode<N>> list){
        list.jumpToHead();
        for(int i=0; i <list.size(); i++){
        System.out.println(list.fetch(i).getValue());
        list.next();
      }
    }

public static void main(String[] args) throws FileNotFoundException, IOException{
  IGraphReader r=new DiGraphReader();
  IGraph<String,Double> graph= r.read("graphfile.cs2");
  INode<String>[] nodes_array= graph.getNodeSet();
  BreadthFirstSearcher<String,Double> searcher=new BreadthFirstSearcher<String,Double>();
//  searcher.printNeighbors(nodes_array);
  //searcher.getPath(graph,nodes_array[0],nodes_array[4]));
  searcher.printMe(searcher.getPath(graph, nodes_array[1], nodes_array[3]));
  //searcher.printMe(searcher.getPath2(nodes_array[0], nodes_array[4]));
}

}
