
/* Ayanna Shaheed
 *Purpose: The purpose of the program is to create an Array List data structure
 *         for use that operates like the Array List data structure in the java 
 *         library. 
 *______________________________________________________________________________
 *Solution:     The program defines 9 methods; add(Object x), 
 *           add(int index, Object x),get(int index), size(), Empty(), isIn(Object ob), 
 *           find (Object n),and remove(Object n); to mimic the functions of array
 *           list in the java library. Four additional methods;expandCapacity(), 
 *           expandCapacity(int x), getLength(), isEmpty(int x), and isFull();  
 *           were created to simplify the problem of designing an ADT to imitate
 *           the array list in the java library.
 *                Add(Object x) appends an object to the end of the array list. In 
 *           order to add a new element to the end of the array, add(Object x) 
 *           needs to know if there is a space for the new object. So,
 *           Add(Object x)calls the method isFull() to check if the array is 
 *           full. If the array is full, Add(Object x) calls expandCapacity()
 *           to extend the size of the array to 2x list.length. Once it is established that
 *           there is a spot for Object x, a while loop checks each position
 *           in the array until it encounters a position that has a null value.
 *           The while loop calls the method isEmpty(int x), to see if a position
 *           contains an element. Object x is assigned to the first available spot
 *           add(Object x) encounters.
 *              Add(int index, Object x) inserts an object anywhere in the array.
 *           First, add(int index, Object x) uses the method isEmpty(int x) to
 *           check if the desired spot is available. If the space is empty, x is  
 *           stored in list[index]. If not, add(int index, Object x) calls the 
 *           method expandCapacity(int x) to increase the lenght of the array by one.
 *           Then using a for loop, the method shifts all the elements after 
 *           index one position to the right. Lastly, object x is assigned to list[index].
 *              Get(int index) simply returns the object that is stored in list[index].
 *              Size() returns how many elements are stored in the array. Size()
 *           starts from position 0 of the array and then calls isEmpty(int x) to 
 *           determine if the position stores an element. If is empty returns false,
 *           the size counter is incremented. Size() repeats this process until it 
 *           reaches the end of the array. Then it returns the size count.
 *              IsEmpty() determines if the array contains any elements. The method
 *           first assumes that the array is empty. IsEmpty() then calls isEmpty(int x)
 *           to check each spot in the array to see if it contains an element. If
 *           isEmpty(int x) encounters a slot that contains an element, isEmpty()
 *           returns false.
 *              IsIn(Object ob) checks if Object ob is in the array. The method
 *           compares each object in the array to object ob. If the equals
 *           method returns true, isIn()sets isIn to true and breaks out of the
 *           for loop designed to move through the array.
 *              Find(Object ob) returns position of object n. Find(Object ob)
 *           searches the array in the same manner as isIn(Object ob), except when the
 *           equals method returns true, Find(Object) returns position i.
 *              Remove(Object ob) removes Object n from array. First the method 
 *           calls isIn(Object ob) to see if the object is in the array in the 
 *           first place. If so, the method calls find(Object b) to locate the 
 *           position of the object then sets that position equal to null. Finally
 *           a for loops shifts all the elements after the position, in which the
 *           object was found, one space to the left.
 *              ExpandCapacity() doubles the length of the array. The method
 *           calls the copyOf method to copy the elements in the original array            
 *           into a temp array twice the length of the original array. ExpandCapacity();
 *           then, sets the original array equal to the temp array.
 *               ExpandCapacity(int x) ncreases length of array by x. The method
 *           works in the same way expandCapacity() does, except, expandCapacity(int x)
 *           creates a temp array of length list.length + x ExpandCapacity(int x)
 *           can also be used to decrease the length of the array if x<0.
 *           GetLength simply returns the length of the array.
 *              IsEmpty(int x) checks if a specific position in the array contains 
 *           an element by comparing the value in that position to null.
 *              IsFull() checks to see if the array is full by using size() to compare 
 *           how many elements are in the array to the length of the array. 
 *           PrintArray() uses a for loop and get() to print out all the elements
 *           in the array.
 *______________________________________________________________________________
 *Data Structures: One-Deimentional Arrays
 *______________________________________________________________________________
 *Use:  To use the program, the user must first initialize an instance of the class
 *      in a main method, then use one of the constuctors to create an array 
 *      of the default length of 10 or an array of a length of their choosing.
 *      Once that has been done the user can fill the array with elements of any type. 
 *      The user will also have access all the methods deffined in this class.
 *______________________________________________________________________________
 * Classses: The arrayList class is an ADT that mimics the behavior of the array     
 *           list in the java library. testArray.java tests all the methods of   
 *           arrayList.java for correctness, then prints out a shuffled deck of
 *           cards.
 */

import java.util.Arrays;


/*
 * @author Ayanna Shaheed
 */
public class arrayList {
    
   private final int DEFAULT = 10;
   private int nextAvailPos = 0;
   
   private Object[] list; 
    
   
   //initializes an array of default size 10
   public arrayList(){
      list = new Object[DEFAULT];  
    }
    
   //initializes array of objects of any size specified by user 
   public arrayList(int n){
       list = new Object[n];
    }
   /*Stores object x in next available empty slot in array.
    *Precondition: The calling code provides Object x, where x is any object.
    *Postcondition: If the array is not full, x is stored into the next available
    *               position. If the array is full, the array is doubled in length,
    *               then stores x into the next available space.
    */
   public void add(Object x){
       
       if(isFull()){
            expandCapacity();
       }
       while(!isEmpty(nextAvailPos))
           nextAvailPos++;
       list[nextAvailPos] = x;    
    }
   
   /*Stores object x in position index of array.
    *Precondition: The calling code provides Object x, where x is any object, and
    *              int index, where 0 <= index < list.length. When calling the 
    *              method, the code assumes that int index is not outside the
    *              bounds of the array.The code also assumes the array is full.
    *Postcondition:If list[index] is empty, object x is stored in position index.
    *              If list[index] is full, all the elements after position index 
    *              are shifted one position to the right, then object x is stored
    *              into position index.
    */
    public void add(int index, Object x){
        if(isEmpty(index))
            list[index] = x;
        else{
            expandCapacity(1);
            for(int i = (list.length-1); i > index; i--){
                if (i-1 < index){
                    break;
                }else{
                    list[i] = list[i-1];
                    
                }
            }
            list[index] = x;
        }    
    }
    
    /*Returns the object stored in position index of array.
    *Precondition: The calling code provides int index, where 0 <= index < 
    *              list.length. When calling the method,the code assumes that int 
    *              index is not outside the bounds of the array.
    *Postcondition: The method returns the object stored in list[index].
    */
    public Object get(int index){
        return list[index];    
    }
    
    /*Returns number of elements in array
    *Preconditon: The calling code has no parameters. 
    *Postcondition: The method returns the number of elements in the array.
    */
    public int size(){
        int size = 0;
        for(int i = 0; i < list.length; i++){
          if(!isEmpty(i)){
              size++;
          }
        }
        return size;
    }
    
    /*Checks if array is empty.
     *Preconditon: The calling code has no parameters. The method assumes
     *             that the array is empty.
     *Postcondition: The method returns true if array contains no elements. Returns
     *               false otherwise.
     */
    public boolean isEmpty(){
      boolean isEmpty = true;
      if(size() != 0){
              isEmpty = false;
        }
  
      return isEmpty;
    }
   
     /*Checks if Object ob is in the array.
    *Precondition: The calling code provides Object ob to be found. The method
    *              assumes that Object ob is not in the array.
    *Postcondition: The method returns true if object ob is in the array. The 
    *               method returns false otherwise.
    */
    public boolean isIn(Object ob){
        boolean isIn = false;
        for(int i = 0; i < size(); i++){
            if(list[i].equals(ob)){
                isIn = true;
                break;
            }
        }      
        return isIn;
    }
    
    /*Returns position i of object n.
    *Precondition: The calling code provides Object n to be located. 
    *Postcondition: The method checks if Object n is in the array. If the object
    *               is found the method returns the position i. Else the method 
    *               returns -1
    */
    public int find (Object n){
        if(isIn(n)){
            int i = 0;
            for(; i < list.length; i++){
                if(list[i].equals(n))
                    break;
            }
            return i;
        }else
            return -1;
    }
    
      /*Removes Object n from array.
    *Precondition: The calling code provides Object n, where n is any object. The
                   method assumes the array is full.
    *Postcondition: If Object n is not in the array, the method does nothing. If
    *               the object is in the array, a new array is created, l less 
    *               the length of the original array and doesn't contain Object
    *               n. Objects in the array following object n are shifted one 
    *               position to the left.
    */
    public void remove (Object n){
        if (isIn(n)){
            int position = find(n);
            list[find(n)] = null;
     
            for(int i = position; i < nextAvailPos; i++){
                if (i+1 > nextAvailPos){
                    break;
                }else{
                    list[i] = list[i+1];
                    
                }
            }
          expandCapacity(-1);  
        }   
    }
    
   /*Doubles the length of the array
    *Precondition: The calling code has no parameters.
    *Postcondition: The array is doubled in length.
    *               
    */
   public void expandCapacity(){
        Object[] temp;
        temp = Arrays.copyOf(list, (list.length*2));
        list = temp;
   }
   
   /*Increases length of array by x.
    *Precondition: The calling code provides int x. 
    *Postcondition: The array is expanded in length by x.
    */
    public void expandCapacity(int x){
       Object[] temp;
       temp = Arrays.copyOf(list, list.length+x);
       list = temp;
    }
     
    /*Returns length of array
    *Preconditon: The calling code has no parameters. 
    *Postcondition: The method returns the length of the array.
    */
    public int getLength(){
        return list.length;
    }
    
    /*Checks if list[x] contains an element.
     *Preconditon: The calling code provides position int x, where 0 <= x < list.length. 
     *             The method assumes that int x is within the bounds of the array.
     *Postcondition: The method returns false if list[x] contains an object. Method
     *               returns true otherwise.
     */
     public boolean isEmpty(int x){
        boolean isEmpty;
        if(list[x] == null){
            isEmpty = true;
        }else{
            isEmpty = false;
        }
        return isEmpty;
     }
     
    /*Checks if array is full.
     *Preconditon: The calling code has no parameters. The method assumes
     *             that the array is not full.
     *Postcondition: The method returns true if evey slot in the array contains 
     *               contains an element. Returns false otherwise.
     */
    public boolean isFull(){
        boolean isFull = false;
        if(size()== list.length){
              isFull = true;
        }
        return isFull;
    }
    
    /*Prints out all elements in the array
     *Preconditon: The calling code has no parameters. 
     *Postcondition: The method prints out all elements in array.
     */
    public void printArray(){
         for(int i = 0; i < list.length; i++)
            System.out.print(" " + get(i));
    }
    
}
