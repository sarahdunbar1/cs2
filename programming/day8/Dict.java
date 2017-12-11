public class Dict<K extends Comparable<K>,V> implements IDict<K,V> {
    private int size;//how many elements in dictionary
    private DoubleLinkList<Pair<K,V>> list;

    public Dict(){
      size=0;
      list=new DoubleLinkList<Pair<K,V>>();
    }

    //if key alredy exists, replace value at that key and return old value, if not
    //add key, value pair to the end of the list.
    public V add(K k, V v){
    list.jumpToHead();
    if(list.size()>0){
    for(int i=0; i<list.size(); i++){
      K current=list.fetch(i).getKey();
      if(k.compareTo(current)==0){//compare desired key with all keys in dictionary
        V old_value=list.fetch(i).getValue();
        list.fetch(i).setValue(v);
        return old_value;
      }
      if (k.compareTo(current)!=0 && i==list.size()-1){//if at end of dict and
        //havent found a matching key, make a new pair and append
        Pair<K,V> np= new Pair<K,V>();
        np.setValue(v);
        np.setKey(k);
        list.append(np);
        size++;
        return null;
      }
  }
  }
  else{//if the pair were appending is the first pair in the dictionary
    Pair<K,V> np=new Pair<K,V>();
    np.setValue(v);
    np.setKey(k);
    list.append(np);
    size++;
    return null;
  }
  return null;
}

//if key is in dictionary, remove key value pair, return value of pair
//that we have just removed.
    public V remove(K k){
    list.jumpToHead();
    if(list.size()>0){
    for(int i=0; i<list.size(); i++){
      K current=list.fetch(i).getKey();
      if(k.compareTo(current)==0){//compare desired key with all keys in dictionary
        V old_value=list.fetch(i).getValue();
        list.remove(i);
        size--;
        return old_value;
      }
      if (k.compareTo(current)!=0 && i==list.size()-1){//if at end of dict and
        //havent found a matching key, return null because not removing a value
        return null;
      }
  }
  }
  else{//if were trying to remove from an empty list, return null
    return null;
  }
  return null;
}

    //return the amount of key,value pairs that we currently have in the
    //dictionary
    public int size(){
    return size;
    }

    //if the key exists in the dictionary, return the value at that key,
    //if not, return null.
    public V fetch(K k){
      list.jumpToHead();
      if(list.size()>0){
      for(int i=0; i<list.size(); i++){
        K current=list.fetch(i).getKey();
        if(k.compareTo(current)==0){//compare desired key with all keys in dictionary
          V value=list.fetch(i).getValue();
          return value;
        }
        if (k.compareTo(current)!=0 && i==list.size()-1){//if at end of dict and
          //havent found a matching key, return null because not removing a value
          return null;
        }
    }
    }
    else{//if were trying to remove from an empty list, return null
      return null;
    }
    return null;
  }
    //iterate through all of the key value pairs in the list and create an array
    //consisting of all keys in ditionary.
    public K[] keys(){
    K[] key_array= (K[]) new Comparable[list.size()];
    for(int i=0; i<list.size(); i++){
      key_array[i]=list.fetch(i).getKey();
      System.out.print(key_array[i]+" ");
    }
    System.out.println("");
    return key_array;
    }

    public static void main(String[] args){
      Dict<String,Integer> dict= new Dict<String,Integer>();
      System.out.println(dict.add("b",5));
      System.out.println(dict.add("a",4));
      System.out.println(dict.add("a",6));
      System.out.println(dict.add("a",8));
      System.out.println(dict.add("b",7));
      System.out.println(dict.add("hello",1));
      dict.add("c",9);
      System.out.println(dict.fetch("b"));
      dict.keys();
    }

}
