public class Pair<K extends Comparable<K>,V> {
  private K key;
  private V value;

public Pair(){
  key=null;
  value=null;
}

public void setKey(K new_key){
  key=new_key;
}

public void setValue(V new_value){
  value=new_value;
}

public K getKey(){
  return key;
}

public V getValue(){
  return value;
}


}
