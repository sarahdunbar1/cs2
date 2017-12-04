//Sarah Dunbar
//Daily Assignment 5
//12/4/17

public class Stack<T> implements IStack<T>{
private T[] stack_array;
private int top;
private int size;

public Stack(int s){
  size=0;
  stack_array=(T[]) new Object[s];
  top=0;
}

//checks if the stack is "full," if not pushes new element on to the stack
public void push(T v) throws OverFlowException{
  if (size==stack_array.length) {throw new OverFlowException();}
  stack_array[size]=v; //size is index of where next element will be pushed to the stack
  size++;
}

//Holds value that we will want to return, then pops it off the stack
public T pop() throws UnderFlowException{
  if(size==0){throw new UnderFlowException();}
  T holder=stack_array[size-1]; //size-1 because indexes in array start at 0
  stack_array[size-1]=null;
  size--;
  return holder;
}

//toString was to test if the program was working 
public String toString(){
  String s= "";
  for (int i=0; i<stack_array.length; i++){
    if(i<stack_array.length-1){
      s+=stack_array[i] + " ";
    }
    else{
      s+=stack_array[i];
    }
  }
  return s;
}

public static void main(String[] args) throws Exception{
  IStack<Object> stack=new Stack<Object>(10);
  stack.push(1.0);
  stack.push(2.0);
  stack.push(3.0);
  stack.push(4.0);
  stack.push(5.0);
  stack.pop();
  stack.pop();
  System.out.println(stack);
}
}
