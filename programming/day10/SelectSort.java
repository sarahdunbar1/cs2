//Sarah Dunbar
//Computer Science 2
//day 10 programming assignment
//12/11/17

//This implementation is similar to the SelectSort section of the textbook given
//to us in the syllabus and the implementation from http://www.geeksforgeeks.org/selection-sort/

public class SelectSort<T extends Comparable> implements ISort<T>{

public SelectSort(){
}

public void sort(T[] in){
for (int i=0; i<in.length-1; i++){//chooses the indexes items will be put into
    int new_index=i;
    for(int j=i+1; j<in.length; j++){//compare values to find minimum in array
    if(in[j].compareTo(in[new_index])<0){
      new_index=j;
    }
    }
    T holder=in[new_index];//next three lines swap minimum values with
    in[new_index]=in[i];   //first values in original list
    in[i]=holder;
}
}

public String sortName(){
return "Select Sort";
}


public void printme(T[] array){
  for(int i=0; i<array.length; i++){
    System.out.println(array[i] + " ");
  }
}

public static void main(String[] args){
SelectSort<String> sort= new SelectSort<String>();
String[] array={"a","z", "e", "f", "y", "h", "k"};
sort.sort(array);
sort.printme(array);
}
}
