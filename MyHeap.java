import java.util.*;
public class MyHeap{

  public static String toString(int[] data){
    String toReturn = "";
    for(int i = 0 ; i < data.length; i++){
      toReturn+= data[i] +", ";
    }
    return toReturn;
  }
  public static String toString(int[] data,int size){
    String toReturn = "";
    for(int i = 0 ; i < data.length; i++){
      if(i == size){
        toReturn+="|";
      }
      toReturn+= data[i] +", ";
    }
    return toReturn;
  }
  private static int[] getChildren(int[] data, int index){
    int[] toReturn = {-1,-1};
    if(2*index + 1 < data.length){
      toReturn[0]=2*index + 1;
    }
    if(2*index + 2 < data.length){
      toReturn[1]=2*index + 2;
    }
    return toReturn;
  }
  private static void swap(int[] data, int ind1, int ind2){
    int temp = data[ind1];
    data[ind1] = data[ind2];
    data[ind2] = temp;
  }
  private static int getParent(int index){
    return index / 2 - 1;
  }
  private static void pushDown(int[] data,int index,int size){
    int[] children =getChildren(data,index);
    //System.out.println(index);
    //System.out.println(MyHeap.toString(data));
    //System.out.println(data[index]);
    int[] vals = {data[index],Integer.MIN_VALUE,Integer.MIN_VALUE};
    if(children[0]>0 && children[0]<size){
      vals[1]=data[children[0]];
    }
    if(children[1]>0 && children[0]<size){
      vals[2]=data[children[1]];
    }
    if(vals[0]>vals[1] && vals[0]>vals[2]){
      return;
    }
    if(vals[1]>=vals[2]){
      swap(data,index,children[0]);
      pushDown(data,children[0],size);
      return;
    }
    else{
      swap(data,index,children[1]);
      pushDown(data,children[1],size);
      return;
    }
  }
  public static void heapify(int[] arr){
    int numRows = 1;
    int counter = 1;
    while(counter*2 - 1<arr.length){
      counter*=2;
      numRows++;
    }
    for(int i = arr.length-1; i > -1;i--){
      pushDown(arr,i,arr.length);
    }
  }


  public static void heapsort(int[] arr){
    if(arr.length>2){
      heapify(arr);
      for(int i = arr.length - 1; i > -1; i--){
        swap(arr,0,i);

        //System.out.println(MyHeap.toString(arr));

        pushDown(arr,0,i-1);
        //System.out.println(MyHeap.toString(arr));
        //System.out.println("reheaped");
      }
      if(arr[1]<arr[0]){
        swap(arr,1,0);
      }
    }
    else{
      if(arr.length < 2){
        return;
      }
      else{
        if(arr[1]<arr[0]){
          swap(arr,1,0);
        }
      }
    }
  }
  public static boolean isSorted(int[] arr){
    for(int i = 0; i < arr.length - 1; i ++){
      if(arr[i]>arr[i+1]){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args){

    for(int i = 0; i < 20; i++){
      int size = 28;
      int[] data = new int[size];
      Random r = new Random();
      for(int j = 0; j < size; j ++){
        data[j]=r.nextInt();
      }
      heapsort(data);
      System.out.println(MyHeap.toString(data));

      System.out.println(isSorted(data));
      System.out.println("\n");
      //size*=2;
    }

    // data = new int[1];
    // heapify(data);
    // data = new int[2];
    // heapify(data);
    // data = new int[3];
    // heapify(data);
    // data = new int[4];
    // heapify(data);
    // data = new int[5];
    // heapify(data);
    // data = new int[6];
    // heapify(data);
    // data = new int[7];
    // heapify(data);
    // data = new int[8];
    // heapify(data);
  }
}
