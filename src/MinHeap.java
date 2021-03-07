/************************************************************** 
Purpose/Description: < Write a method replaceKey in the MinHeap class with the 
following signature: public void replaceKey(Integer oldKey, Integer newKey)
The method will replace the first occurrence of oldKey with the newKey, and 
restore the Min-Heap property after the change. If the oldKey does not exist in 
the heap, the method prints an appropriate message and returns without changing 
the heap. >
Author’s Panther ID: < xxxxxxx >
Certification:
I hereby certify that this work is own and none of it is the work of
any other person. 
**************************************************************/


public class MinHeap {
    
 //Declare the class BinaryHeap
//which extends the comparable   
public static class BinaryHeap<AnyType extends Comparable<AnyType>>

{

       //Define the capacity of the heap
       private static final int CAPACITY = 2;

       private int size;

       //Define the heap
       private AnyType[] heap;

       //default constructor
       public BinaryHeap()

       {

             size = 0;

             heap = (AnyType[]) new Comparable[CAPACITY];

       }

       //Constructor
       public BinaryHeap(AnyType[] array)

       {

             //Get the size of the array

             size = array.length;

             heap = (AnyType[]) new Comparable[array.length+1];

             //copy the array elements in heap

             System.arraycopy(array, 0, heap, 1, array.length);

             //Call the build heap method

             buildHeap();

       }

      

       //Implement the build heap method

       private void buildHeap()

       {

             //using for-loop to call everytime

             //percolatingDown method

             for (int k = size/2; k > 0; k--)

             {

                    percolatingDown(k);

             }

       }

       //implement the percolatingDown method

       private void percolatingDown(int index)

       {           

             AnyType Temp = heap[index];

             int child;

             for(; 2*index <= size; index = child)

             {

                    child = 2*index;

                    if(child != size &&

                           heap[child].compareTo(heap[child + 1]) > 0) child++;

                    if(Temp.compareTo(heap[child]) > 0) heap[index] = heap[child];

                    else

                           break;

             }

             heap[index] = Temp;

       }

       //Implement the replaceKey method with the Previous and new keys

       public void replaceKey(Integer OldKey,Integer newKey)

       {

              boolean flag=false;

              int i=0;    

              for( i=1;i<size;i++)

              {

                    //convert heap[i] vlaue into AnyType

                    Integer temp=(Integer) heap[i];

                    //check OldKey==temp or no

                    if(OldKey.compareTo(temp)==0)

                    {

                           //set flag one if key exist

                           flag=true;

                           break;

                    }

              }

              //If the flag is false
              //then print the message
              if(flag==false)

              {

                    System.out.println("The previous key does not exist.");

              }

              
              //call build Heap method
              else

              {

                    heap[i]=(AnyType)newKey;

                    buildHeap();   

              }

       }

       //Implement the insert method

       public void insert(AnyType value)

       {

             if(size == heap.length - 1) doubleSize();

             //Insert a new item to the end of the array
             int idx = ++size;

             //Percolate up
             for(; idx > 1 && value.compareTo(heap[idx/2]) < 0; idx = idx/2 )

                    heap[idx] = heap[idx/2];

             heap[idx] = value;

       }

       //implement method to double the size of the heap

       private void doubleSize()

       {

             AnyType [] Previous = heap;

             heap = (AnyType []) new Comparable[heap.length * 2];

             System.arraycopy(Previous, 1, heap, 1, size);

       }

       //Implement the method toString()
       public String toString()

       {

             String output = "";

             for(int k = 1; k <= size; k++)

             {

                    output += heap[k]+" ";

             }

             return output;

       }

      

      
}
    
    //main method
    public static void main(String[] args) {
        // TODO code application logic here
        
             //create an integer array
             Integer[] Previous_Heap = {5,10,9,11,15,10,12,13,14,16,18};

             //create object for the class BinaryHeap
             BinaryHeap<Integer> bh;
             bh = new BinaryHeap<Integer>(Previous_Heap);

             //print the elements heap before calling the method
             System.out.println("Before Replacing Elements : ");

             System.out.println(bh.toString());

             //call the method using the binary object of integer values
             bh.replaceKey(new Integer(10),new Integer(3));

             //

             System.out.println("\nAfter replacing 10 with 3, The New Heap is: ");

             System.out.println(bh.toString());

    }
    
}
