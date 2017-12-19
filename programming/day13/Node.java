public class Node<T> implements IDLink<T>{
private IDLink<T> previous;
private IDLink<T> next;
private T value;

public Node(T val){
  previous=null;
  next=null;
  value=val;
}
public T getValue(){
  return value;
}
public void setValue(T v){
  value=v;
}
public IDLink<T> getNext(){
  return next;
}
public IDLink<T> getPrev(){
  return previous;
}
public void setNext(IDLink<T> n){
  next=n;
}
public void setPrev(IDLink<T> n){
  previous=n;
}
}
