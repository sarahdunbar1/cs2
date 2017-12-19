//Sarah Dunbar
//Computer Science 2
//Day 8 programming assignment
//12/11/17


//*** This implementation uses some code from the BSTree implementation that we
//did in class on 12/7/17***

public class BSTree<K extends Comparable<K>,V> implements IDict<K,V> {
    TreeNode<K,V> root;
    TreeNode<K,V> curr;
    int size;//how many elements are actually in our tree
    int index;
    K[] array;

    public BSTree() {
        root = null;
        curr = null;
        size=0;
        index=0;
    }

    public V add(K k, V v) {
        // if we are inserting at the root
        curr = root;
        if(curr==null) {
            root=new TreeNode<K,V>(k,v);
            size++;
            return null;
        }
        // What to do if we aren't inserting the root
        return helper(k,v);
    }

    // Helps with the insertion method
    public V helper(K k, V v) {
        //if we have found the key we are looking for in the tree, replace
        //value and return old one
        if(k.compareTo(curr.getKey())==0){
          V old_value=curr.getValue();
          curr.setValue(v);
          return old_value;
        }
        if((k.compareTo((K) curr.getKey())<0 && curr.getLeft()==null) || (k.compareTo( (K) curr.getKey())>0 && curr.getRight()==null) ){
            if(k.compareTo((K) curr.getKey())<0) {
                // insert value on the left
                curr.setLeft(new TreeNode<K,V>(k,v));
                size++;
                return null;
            }
            else {
                // insert value on the right
                curr.setRight(new TreeNode<K,V>(k,v));
                size++;
                return null;
            }
        }
        // Place the node with one of the children, based on if the key
        // goes to the left or the right
        if(k.compareTo((K) curr.getKey())<0) {
            curr = curr.getLeft();
        }
        else {
            curr = curr.getRight();
        }
        helper(k,v);
        return null;
    }

    //returns the value at a key were searching for, if it doesn't exist
    //return null
    public V fetch(K k) {
        // start at the root
        curr = root;
        // while we haven't found the key
        while(k.compareTo((K) curr.getKey())!=0) {
            if(k.compareTo((K) curr.getKey())>0) {
                // walk right
                curr = curr.getRight();
            }
            else {
                // walk left
                curr = curr.getLeft();
            }
        }
        if (k.compareTo((K) curr.getKey())==0){
        return (V) curr.getValue();
        }
        else{
          return null;
        }
    }


    public V remove(K k) {
        // Find the node to remove and it's parent
        TreeNode<K,V> parent = null;
        // start at the root
        curr = root;
        // while we haven't found the key
        while(k.compareTo((K) curr.getKey())!=0) {
            if(k.compareTo((K) curr.getKey())>0) {
                // walk right
                parent = curr;
                curr = curr.getRight();
            }
            else {
                // walk left
                parent = curr;
                curr = curr.getLeft();
            }
        }

        // Case 1: no children, just kill the node
        if(curr.isLeaf()){
          V holder=null;
          if(curr==root){
            holder= (V) curr.getValue();
            root=null;
          }
          //if we want to delete a node on the right side
          if(parent.getRight()==curr){
            holder= (V) curr.getValue();
            parent.setRight(null);
          }
          //if we want to delete a node on the left side
          if(parent.getLeft()==curr){
            holder=  (V) curr.getValue();
            parent.setLeft(null);
          }
          curr=root;
          size--;
          return holder;
          }

          //Case 2: 1 child, replace node with child
          if(curr.getRight()==null || curr.getLeft()==null) {
            //if we are trying to remove the root
            if(curr==root){
              V holder=null;
              //the root has nodes on the left side
              if (curr.getRight()==null){
                holder=(V) curr.getValue();
                curr=curr.getLeft();
              }
              // the root has nodes on the right side
              else{
                holder= (V) curr.getValue();
                curr=curr.getRight();
              }
              size--;
              return holder;
            }
            // the current position in the tree has nodes on the left side
            if(curr.getRight()==null){
              if(parent.getRight()==curr){
                parent.setRight(curr.getLeft());
              }
              else{
                parent.setLeft(curr.getLeft());
              }
              size--;
              return curr.getValue();
            }
            //the current position on the tree has nodes on the right side
            else{
              if(parent.getRight()==curr){
                parent.setRight(curr.getRight());
              }
              else{
                parent.setLeft(curr.getRight());
              }
              size--;
              return curr.getValue();
            }
          }

        // Case 3: Go right once, go left until you can't, remove that
        //         left most node, replace the node you wanted to remove
        //         with the left most node
        // Does this work if the curr is the root... Probably not
        TreeNode<K,V> swapparent = curr;
        TreeNode<K,V> swapnode = curr.getRight(); // trying to find the one to swap
                                            // into curr's place in the tree
        while(swapnode.getLeft() != null) {
            swapparent=swapnode;
            swapnode=swapnode.getLeft();
        }
        // want to set the left most parent to the right child if we have left most
        //node
        if(parent!=null){
        swapparent.setLeft(swapnode.getRight());
        swapnode.setLeft(curr.getLeft());
        swapnode.setRight(curr.getRight());
        if(parent.getRight()==curr) { parent.setRight(swapnode); }
        if(parent.getLeft()==curr)  { parent.setLeft(swapnode); }
        size--;
        }

        else{
          //check if swapnode is a leaf
          if(swapnode.isLeaf()==true){
            swapnode.setRight(curr.getRight());
            swapnode.setLeft(curr.getLeft());
            V holder=curr.getValue();
            curr=swapnode;
            root=swapnode;
            size--;
            return holder;
          }
          //case that swapnode is not a leaf
          else{
            if(swapparent==curr){
              swapnode.setLeft(curr.getLeft());
              V holder=curr.getValue();
              root=swapnode;
              curr=swapnode;
              size--;
              return holder;
            }
            else{
              swapparent.setLeft(swapnode.getRight());
              swapnode.setLeft(curr.getLeft());
              swapnode.setRight(curr.getRight());
              V holder=curr.getValue();
              curr=swapnode;
              size--;
              return holder;
            }
          }
        }
      curr=root;//reset current to the root
      return null;
    }

    public int size(){
      return size;
    }

    //uses function for in order traversal to print out keys in that order
    public K[] keys(){
      array= (K[]) new Comparable[size];
      index=0;
      this.inOrder(root, array);
      return array;
    }

  //found method on internet to print out an in order traversal
  // http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
    public void inOrder(TreeNode<K,V> node, K[] array){
      if(node==null){
        return;
      }
        inOrder(node.getLeft(), array);
        array[index++]=node.getKey();
        inOrder(node.getRight(),array);
      }

      public static void main(String[] argv) {
          BSTree t = new BSTree<String,Integer>();
          t.add("b",17);
          t.add("a",20);
          t.add("c",25);
          t.add("d",18);
          t.add("e",1);
          t.add("f",21);
          t.add("g",22);
          // t.remove("d");
          for(int i=0; i<t.size(); i++){
            System.out.println(t.keys()[i]);
          }
          // t.remove("d");
          // for(int i=0; i<t.size(); i++){
          //   System.out.println(t.keys()[i]);
          // }
          // t.add("l",5);
          // for(int i=0; i<t.size(); i++){
          //   System.out.println(t.keys()[i]);
          // }
    }
}
