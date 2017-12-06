public class ArrayList<T> implements IList<T>{

  private T[] backing;
  private int current;

  public List(){
    backing=(T[]) new Object[0];
    current=0; //current index of the object in the arraylist
  }

  public void insert(int idx, T v){
  T[] temporary=(T[]) new Object[backing.length+1];
  for(int i=0; i<temporary.length; i++){
    if(i==idx){
      temporary[i]=v;
    }
    else if(i<idx){
      temporary[i] = backing[i];
    }
    else {
      temporary[i] = backing[i-1];
    }
  }
  backing=temporary;
  }

  public void append(T v){
  T[] temporary=(T[]) new Object[backing.length+1];
  for(int i=0; i<temporary.length; i++){
    if(i==temporary.length-1){
      temporary[i]=v;
    }
    else{
      temporary[i]=backing[i];
    }
  }
  backing=temporary;
  current=backing.length-1;
  }

  public void remove(){
  T[] temporary=(T[]) new Object[backing.length-1];
  for(int i=0; i<backing.length; i++) {
      if(i==current){
      }
      else if(i<current){
        temporary[i] = backing[i];
      }
      else {
        temporary[i-1] = backing[i];
      }
  }
  if(current>0){
    current=current-1;
  }
  backing = temporary;
  }


  //From List implementation in class
  public void remove(int idx){
  T[] temporary=(T[]) new Object[backing.length-1];
  for(int i=0; i<backing.length; i++) {
      if(i==idx){
      }
      else if(i<idx){
        temporary[i] = backing[i];
      }
      else {
        temporary[i-1] = backing[i];
      }
  }
  backing = temporary;
  }

  public void move(int start, int end){
    T[] temporary = (T[])new Object[backing.length];
    T move = backing[start];
    if(start< end){
        for (int i = 0; i < backing.length; i++)
            if (i < start){
            temporary[i] = backing[i];
            }
            else if (i == start){
            }
            else if (start < i && end > i){
              temporary[i-1] = backing[i];
            }
            else if (i == end){
              temporary[i-1] = backing[i];
              temporary[i] =move;
            }
            else{
              temporary[i] = backing[i];
            }
        }
    else{
        for (int i = 0; i < backing.length; i++){
            if (i < end){
              temporary[i] = backing[i];
            }
            else if (i == end){
              temporary[i] = move;
              temporary[i+1]= backing[i];
            }
            else if (end < i && start> i){
              temporary[i+1] = backing[i];
            }
            else if (i == start){
            }
            else{
              temporary[i] = backing[i];
            }
        }
    }
    backing= temporary;

    }


  public T fetch(){
  return backing[current];
  }

  public T fetch(int idx){
  return backing[idx];
  }

  public void next(){
  if(current<backing.length-1){
    current=current+1;
  }
  else{
    System.out.println("At last index, no further indecies");
  }
  }

  public void prev(){
  if (current>0){
    current=current-1;
  }
  else{
    System.out.println("At index 0, no previous index");
  }
  }

  public void jumpToTail(){
    current=backing.length-1;
  }

  public void jumpToHead(){
  current=0;
  }

  public int size(){
  return backing.length;
  }

  public void printMe() {
      for(int i=0; i<backing.length; i++) {
          System.out.print(" "+backing[i]+" ");
      }
      System.out.println("");
  }

public static void main(String[] args){
  ArrayList<Integer> list= new ArrayList<Integer>();
  list.append(1);
  list.insert(0,4);
  list.append(2);
  list.append(3);
  // list.prev();
  // list.prev();
  // list.prev();
  // list.prev();
  list.printMe();
  list.move(1,0);
  list.printMe();
  list.insert(2,4);
  list.printMe();
}
}
