
//**code from class implementation of graph**//
/**
 * Class to represent a Node in a graph
 */
public class GraphNode<N> implements INode<N>{
    // Fields
    N value;

    // Edge list?

    public GraphNode(N v) {
        setValue(v);
    }

    /**
     * Sets the value
     * @param v the value
     */
    public void setValue(N v) {
        value = v;
    }

    /**
     * Retrieve the nodes value
     * @return the value
     */
    public N getValue() {
        return value;
    }
}
