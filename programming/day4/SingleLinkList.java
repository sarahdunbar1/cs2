public class SingleLinkList<T> implements IList<T>{
    ISLink<T> head;
    ISLink<T> tail;
    int current;//kind of like an index to keep track of where we are in the list
    int size;//number of elements currently in the list

    public SingleLinkList(){
        head = null;
        tail = null;
        current = 0;
    }

    //checks if were inserting at the end and if not adjusts pointers to move
    //cells to correct new positions
    public void insert(int pos, T v){
        ISLink<T> _new = new Cell<T>(v, null);
        ISLink<T> beginning= head;
        if(size == pos){//if were just putting new element in last position
          append(v);
        }
        else if(pos==0){//if inserting at beginning we must change head
          head=_new;
          head.setNext(beginning);
        }
        else{
          for (int i = 1; i <pos; i++){//starting at first position because we
            //took care of 0th case
            beginning = beginning.getNext();
          }
          _new.setNext(beginning.getNext());
          beginning.setNext(_new);
        }
        size++;
    }
    public void append(T v){
      ISLink<T> _new= new Cell(v, null);
      if (size == 0){
        _new.setNext(_new);
        head = _new;
        tail = _new;
      }
      else{
        tail.setNext(_new);
        tail = _new;
      }
      size++;
      current=size-1;
    }

    //remove cell at current position and set current to previous cell
    public void remove(){
        remove(current);
        prev();
    }

    public void remove(int pos){
      if (pos == 0){
          head = head.getNext();
      }
      else {
          ISLink<T> cell = head;
          for (int i = 1; i < pos; i++){
              cell = cell.getNext();
          }
          cell.setNext(cell.getNext().getNext());
      }
      size--;
    }

    //remove item at starting position and put that item into desired position
    public void move(int start, int end){
      T holder = fetch(start);
      remove(start);
      insert(end, holder);
    }

    //returns cell at current position in list
  	public T fetch(){
      return fetch(current);
    }

    //gets cell at specified position
  	public T fetch(int pos){
      ISLink<T> cell = null;
      for (int i = 0; i <= pos; i++){
        if (i==0){
          cell= head;
        }
        else{
        cell = cell.getNext();
        }
      }
      return cell.getValue();
    }

    //sets current cell to next cell, if it is within range
  	public void next(){
      if (current < size - 1){//indexes start at 0, last index is size-1
        current++;
      }
    }

    //sets current cell to previous cell if it is within range
  	public void prev(){
      int current_ = 0;
      for (int i = 0; i < current; i++){//gets to one before current position
        current_= i;
      }
      current = current_;//sets current to that previous position
    }


  	public void jumpToTail(){
      current = size-1;//last index is size-1 because start at 0
    }


  	public void jumpToHead(){
      current = 0;//changes current to first cell
    }


  	public int size(){
      return size;//size changes throughout so we can just return it
    }

    public void printMe(){
      ISLink<T> current_cell=head;
        for(int i=0; i <size; i++){
        System.out.println(current_cell.getValue());
        current_cell=current_cell.getNext();
      }
    }

public static void main(String[] args){
  SingleLinkList<Integer> sl=new SingleLinkList<Integer>();
  sl.append(1);
  sl.append(2);
  sl.append(3);
  sl.append(0);
  sl.append(5);
  sl.printMe();
  System.out.println(sl.fetch(3));
  sl.move(0,3);
  sl.printMe();
}
}
