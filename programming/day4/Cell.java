public class Cell<T> implements ISLink<T>{
private T value;
private ISLink<T> pointer;

public Cell(T value,  Cell pointer){
  this.value=value;
  this.pointer=pointer;
}

public void setValue(T v){
  value=v;
}

public void setNext(ISLink<T> c){
  pointer=c;
}

public T getValue(){
  return value;
}

public ISLink<T> getNext(){
  return pointer;
}

}
