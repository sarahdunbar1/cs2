//Sarah Dunbar
//Daily Assignment 5
//12/4/17

//Ring Queue implementation from class on Friday 12/1/17
public class Queue<T> implements IQueue<T>{
  int front;
  int back;
  int size; // number of items in the queue
  DoubleLinkList<T> backingList;

  public Queue() {
      size=0; //amount of elements that are in the queue at the current moment
      backingList= new DoubleLinkList<T>();
      front = 0;
      back  = 0;
  }

  public T dequeue(){
    if (size==0){
      System.out.println("Array too small");
      return null;
    }
      T ret=  backingList.fetch(front);
      backingList.remove(front); // makes the old value really go away (security)
      size--; //amount of the elements "in the queue" will decrease once we dequeue something
      return ret;
  }

  public void enqueue(T v)  {
      backingList.append(v);
      size++;//amount of elements "in the queue" will increase once we enqueue something
  }

  public int size(){
    return size;
  }

  public static void main(String[] argv){
      Queue<Integer> r = new Queue<Integer>();
      r.enqueue(1);
      r.enqueue(2);
      r.enqueue(3);
      r.enqueue(4);
      System.out.println(r.dequeue());
      System.out.println(r.dequeue());
      System.out.println(r.dequeue());
      System.out.println(r.size());
  }

}
