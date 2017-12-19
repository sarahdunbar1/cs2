public class DoubleLinkList<T> implements IList<T>{

private IDLink<T> head;
private IDLink<T> tail;
private IDLink<T> current;
private int size;

public DoubleLinkList(){
  size=0;
  head=null;
  tail=null;
  current=null;
}

public void insert(int pos, T v){
IDLink<T> n= new Node<T>(v);
IDLink<T> temp_current=head;
int count=0;
for(int i=0; i<pos; i++){
temp_current=temp_current.getNext();
count++;//checks if the loop is entered, wont be entered if trying to insert at 0
}
if(count==size){//if the position is not 0
append(v);
}
else if(count!=0){
IDLink<T> prev=temp_current.getPrev();
prev.setNext(n);
n.setPrev(prev);
n.setNext(temp_current);
temp_current.setPrev(n);
size++;
}
else{//if we are inserting at the 0th index
head=n;
head.setNext(temp_current);
temp_current.setPrev(head);
size++;
}
}

public void append(T v){
IDLink<T> n= new Node<T>(v);
if (size==0){//if theres nothing currently in the list
  head=n;
  tail=n;
  n.setPrev(head);
  n.setNext(tail);
  size++;
}
else{//if there is 1 or more items already in the list
  IDLink<T> old_tail=tail;
  tail=n;
  tail.setPrev(old_tail);
  tail.setNext(tail);
  old_tail.setNext(tail);
  current=n;
  size++;
  }
}

//removes current item and changes current to previous if it exists
public void remove(){
IDLink<T> prev=current.getPrev();
// System.out.println(prev.getValue());
IDLink<T> next=current.getNext();
prev.setNext(next);
next.setPrev(prev);
if(current==head){
current=next;
head=current;
}
else{
  current=prev;
}
size--;
}


public void remove(int pos){
  current = head;
  for (int i = 0; i <pos; i++){//iterates until 1 less than position but get next
    //gets desired cell, then we remove current
    current= current.getNext();
  }
  this.remove();

  }

//moves item from one index to another and then shifts all other items based
//on previous position
public void move(int start, int end){
  IDLink<T> _new= new Node<T>(null);
  for (int i = 0; i <=start; i++){//takes care of the condition your moving// something to the 0th index
    if (i == 0){
      _new= head;
    }
    else{
      _new = _new.getNext();
    }
  }
  remove(start);
  insert(end, _new.getValue());
  }


public T fetch(){//returns cell value of current current
  return current.getValue();
}


public T fetch(int pos){
current=head;//so we can iterate through the list starting at the beginning
for(int i=0; i<pos; i++){
current=current.getNext();
}
return current.getValue();
}


public void next(){
  current=current.getNext();//changes current to next pointer of current
}


public void prev(){
current=current.getPrev();//changes current to previous pointer of current
}


public void jumpToTail(){
current=tail;//current becomes tail node
}


public void jumpToHead(){
current=head;//current becomes head node
}


public int size(){
return size;//have been keeping track of the size in every method that changes it
}

public void printMe(){
  IDLink<T> current_node=head;
    for(int i=0; i <size; i++){
    System.out.println(current_node.getValue());
    current_node=current_node.getNext();
  }
}

public static void main(String[] args){
  DoubleLinkList<Integer> dl=new DoubleLinkList<Integer>();
  dl.append(1);
  dl.append(2);
  dl.append(3);
  dl.append(4);
  dl.move(3,0);
  dl.printMe();
  // dl.prev();
  // dl.prev();
  // dl.remove();
  // dl.printMe();
}
}
