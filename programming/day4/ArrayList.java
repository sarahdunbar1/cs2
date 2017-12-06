public class ArrayList<T> implements IList<T>{

  private T[] backing;
  private int current;

  public ArrayList(){
    backing=(T[]) new Object[0];
    current=0; //current index of the object in the arraylist
  }

  public void insert(int idx, T v){
  T[] temporary=(T[]) new Object[backing.length+1];//creates temporary array 1 longer than
  //than backing array
  for(int i=0; i<temporary.length; i++){
    if(i==idx){
      temporary[i]=v;
    }
    else if(i<idx){
      temporary[i] = backing[i];
    }
    else {
      temporary[i] = backing[i-1];//moves indexes of backing array to be correct ones after
      //inserting a new value
    }
  }
  backing=temporary;//set backing equal to new list with +1 values
  }

  public void append(T v){
  T[] temporary=(T[]) new Object[backing.length+1];
  for(int i=0; i<temporary.length; i++){
    if(i==temporary.length-1){//last index
      temporary[i]=v;
    }
    else{
      temporary[i]=backing[i];//else we just copy over the values
    }
  }
  backing=temporary;
  current=backing.length-1;//sets current to last value in list
  }

  public void remove(){
  T[] temporary=(T[]) new Object[backing.length-1];//going to remove something
  //so our new array needs to be one less than the original
  for(int i=0; i<backing.length; i++) {
      if(i==current){//dont want to copy over current value because we are removing
      //it
      }
      else if(i<current){
        temporary[i] = backing[i];
      }
      else {
        temporary[i-1] = backing[i];//if index is greater than current index
        //we have to shift the index of the values of our backing array
      }
  }
  if(current>0){//if there is a previous value, change current to that value
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
    T[] temporary = (T[])new Object[backing.length];//new array is going to be
    //same length because moving existing values
    T move = backing[start];//the item that we want to move
    if(start< end){//if start index is before desired index
        for (int i = 0; i < backing.length; i++)
            if (i < start){
            temporary[i] = backing[i];
            }
            else if (i == start){//dont copy over that value, we want to
              //remove it
            }
            else if (start < i && end > i){
              temporary[i-1] = backing[i];//must shift indexs once we move
              //desired value
            }
            else if (i == end){
              temporary[i-1] = backing[i];
              temporary[i] =move;
            }
            else{
              temporary[i] = backing[i];//if none of these conditions, copy over directly
            }
        }
    else{
        for (int i = 0; i < backing.length; i++){
            if (i < end){//does the same thing as above, but is a little different
              //because takes care of position that desired index is less than
              //start index
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
  return backing[current];//gets value at current position in the list
  }

  public T fetch(int idx){
  return backing[idx];//gets value at desired index
  }

  public void next(){
  if(current<backing.length-1){//length-1 is last index because indexes start at 0
    current=current+1;
  }
  else{
    // System.out.println("At last index, no further indecies");
  }
  }

  public void prev(){//checks if there is a previous value, if so changes current to
    //that value
  if (current>0){
    current=current-1;
  }
  else{
    // System.out.println("At index 0, no previous index");
  }
  }

  public void jumpToTail(){
    current=backing.length-1;//sets current to last index in list
  }

  public void jumpToHead(){
  current=0;//puts current at 0th index(1st value) in list
  }

  public int size(){//returns size of current arraylist
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
  // list.insert(0,4);
  list.append(2);
  list.append(3);
  list.append(5);
  list.append(6);
  // list.prev();
  // list.prev();
  // list.prev();
  // list.prev();
  // list.printMe();
  list.move(1,0);
  list.printMe();
  // list.insert(2,4);
  // list.printMe();
}
}
