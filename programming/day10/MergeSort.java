//Sarah Dunbar
//Computer Science 2
//day 10 programming assignment
//12/11/17

public class MergeSort<T extends Comparable> implements ISort<T>{

public  void sort(T[] in){
split(in);

}

public T[] split(T[] array){
  int n=array.length;
  int left;
  int right;
  T[] left_array;
  T[] right_array;
  if(n<=1){
    return array;
  }
  if (n%2!=0){//checks if the length of input array is an odd number
    left=n/2;
    right=n-left;
  }
  else{
    left=n/2;
    right=left;//if even length of left and right arrays will be the same
  }
  left_array= (T[]) new Comparable[left];
  right_array= (T[]) new Comparable[right];
    for(int i=0; i<left; i++){//copies values into left array as it splits
      left_array[i]=array[i];
    }
    int count=0;
    for(int j=left; j<n; j++){//copies values into right array as it splits
      right_array[count]=array[j];
      count++;
    }
    left_array=split(left_array);//store the output of the sorted left array
    right_array=split(right_array);//store the output of the sorted right array
    return merge(left_array,right_array);

}


public T[] merge(T[] left, T[] right){
  T[] sorted_array= (T[]) new Comparable[left.length+right.length];
  int count_left=0;//keeps track of left array index
  int count_right=0;//keeps track of right array index
  int sorted_index=0;//keeps track of new sorted array index
  while(count_left<left.length && count_right<right.length){
    if(left[count_left].compareTo(right[count_right])<0){
      sorted_array[sorted_index]=left[count_left];
      count_left++;
      sorted_index++;
    }
    else{
      sorted_array[sorted_index]=right[count_right];
      count_right++;
      sorted_index++;
    }

}
while(count_left<left.length){//check if there is more to move in the left array
  sorted_array[sorted_index]=left[count_left];
  sorted_index++;
  count_left++;
}
while(count_right<right.length){//check if there is more to move in the right array
  sorted_array[sorted_index]=right[count_right];
  sorted_index++;
  count_right++;
}
return sorted_array;
}

public String sortName(){
return "Merge Sort";
}

public void printme(T[] array){
  for(int i=0; i<array.length; i++){
    System.out.print(array[i] + " ");
    }
    System.out.println();
}

public static void main(String[] args){
  MergeSort<String> sort= new MergeSort<String>();
  String[] array1= {"x", "a", "l", "g", "z", "sarah", "a", "t"};
  String[] array2={"c", "d", "e", "h"};
  sort.sort(array1);
}

}
