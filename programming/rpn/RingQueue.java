//Sarah Dunbar
//Daily Assignment 5
//12/4/17

//Ring Queue implementation from class on Friday 12/1/17
public class RingQueue<T> implements IQueue<T>{
  int front;
  int back;
  int size; // maximum size
  T[] backingArray;
  int sz; //amount of elements "in the queue"  at the current time

  public RingQueue(int sz) {
      this.sz=sz; //set size for the queue that is set when you create a new queue
      size=0; //amount of elements that are in the queue at the current moment
      backingArray = (T[])new Object[sz];
      front = 0;
      back  = 0;
  }

  public T dequeue() throws UnderFlowException {
    if (size==0){throw new UnderFlowException();}
      T ret = backingArray[front];
      backingArray[front] = null; // makes the old value really go away (security)
      size--; //amount of the elements "in the queue" will decrease once we dequeue something
      front = (front+1)%sz;
      return ret;
  }

  public void enqueue(T v) throws OverFlowException {
    if (size==backingArray.length){throw new OverFlowException();}
      backingArray[back] = v;
      size++;//amount of elements "in the queue" will increase once we enqueue something
      back = (back+1)%sz;
  }

  public static void main(String[] argv) throws Exception {
      RingQueue<Integer> r = new RingQueue<Integer>(10);
      r.enqueue(1);
      r.enqueue(2);
      r.enqueue(3);
      System.out.println(r.dequeue());
      System.out.println(r.dequeue());
      System.out.println(r.dequeue());
  }

}
