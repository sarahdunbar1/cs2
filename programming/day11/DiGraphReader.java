import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    private double weight;
    public DiGraphReader() {
    weight=0.0;
    }


    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        Graph<String,Double> r = new Graph<String,Double>();
        BufferedReader br= new BufferedReader(new FileReader(filename));
        String line=br.readLine();
        while(line!=null){
          String[] line_=line.split(":");//creates array containing tbe three fields from
          //that line
            if(line_.length==3){//skips lines that dont have three fields
              INode<String> node_1=new GraphNode<String>((String) line_[0]);
              INode<String> node_2= new GraphNode<String>((String)line_[1]);
              weight=Double.parseDouble(line_[2]);//cast string  to a double
              r.addNodeCheck(node_1.getValue());
              r.addNodeCheck(node_2.getValue());
              r.addEdge(node_1,node_2,weight);
              line=br.readLine();//read next line
            }
        }
        return r;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}
