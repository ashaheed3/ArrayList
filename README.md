# ArrayList
## Purpose

The purpose of the program is to create an Array List data structure for use that operates like the Array List data structure in the java library. 

## Solution
The program defines 8 methods to mimic the functions of array list in the java library.
1. [add(Object x)](#add) 
2. [add(int index, Object x)](#add)
3. [get(int index)](#get) 
4. [size()](#size) 
5. [Empty()](#empty) 
6. [isIn(Object ob)](#isIn)
7. [find(Object n)](#find)
8. [remove(Object n)](#remove)  

Four additional methods were created to simplify the problem of designing an ADT to imitate the array list in the java library.

9. [expandCapacity()](#expandCapacity)
10. [expandCapacity(int x)](#expandCapacity) 
11. [getLength()](#getLength)
12. [isEmpty(int x)](#isEmpty)
13. [isFull()](#isFull)

### Add
 Add(Object x) appends an object to the end of the array list. In order to add a new element to the end of the array, add(Object x) needs to know if there is a space for the new object. So, Add(Object x)calls the method isFull() to check if the array is full. 
 
 If the array is full, Add(Object x) calls expandCapacity() to extend the size of the array to 2x list.length. Once it is established that there is a spot for Object x, a while loop checks each position in the array until it encounters a position that has a null value.

 The while loop calls the method isEmpty(int x), to see if a position contains an element. Object x is assigned to the first available spot add(Object x) encounters.



 Add(int index, Object x) inserts an object anywhere in the array.
 First, add(int index, Object x) uses the method isEmpty(int x) to check if the desired spot is available. If the space is empty, x is stored in list[index]. If not, add(int index, Object x) calls the  method expandCapacity(int x) to increase the lenght of the array by one. Then using a for loop, the method shifts all the elements after index one position to the right. Lastly, object x is assigned to list[index].

 ### get
 Get(int index) simply returns the object that is stored in list[index].

### size
 Size() returns how many elements are stored in the array. Size()starts from position 0 of the array and then calls isEmpty(int x) to determine if the position stores an element.
 
 If is empty returns false, the size counter is incremented. Size() repeats this process until it reaches the end of the array. Then it returns the size count.

### isEmpty
IsEmpty() determines if the array contains any elements. The method first assumes that the array is empty. IsEmpty() then calls isEmpty(int x) to check each spot in the array to see if it contains an element. If isEmpty(int x) encounters a slot that contains an element, isEmpty()returns false.

### isIn
IsIn(Object ob) checks if Object ob is in the array. The method compares each object in the array to object ob. If the equals method returns true, isIn()sets isIn to true and breaks out of the for loop designed to move through the array.

### find              
 Find(Object ob) returns position of object n. Find(Object ob)searches the array in the same manner as isIn(Object ob), except when the equals method returns true, Find(Object) returns position i.

### remove
 Remove(Object ob) removes Object n from array. First the method calls isIn(Object ob) to see if the object is in the array in the first place. If so, the method calls find(Object b) to locate the position of the object then sets that position equal to null. Finally a for loops shifts all the elements after the position, in which the
 object was found, one space to the left.

### expandCapacity
 ExpandCapacity() doubles the length of the array. The method calls the copyOf method to copy the elements in the original array into a temp array twice the length of the original array. ExpandCapacity() then, sets the original array equal to the temp array.

 ExpandCapacity(int x) ncreases length of array by x. The method works in the same way expandCapacity() does, except, expandCapacity(int x) creates a temp array of length list.length + x ExpandCapacity(int x) can also be used to decrease the length of the array if x<0.

### getLength
 GetLength simply returns the length of the array. IsEmpty(int x) checks if a specific position in the array contains an element by comparing the value in that position to null.

### isFull
IsFull() checks to see if the array is full by using size() to compare how many elements are in the array to the length of the array. 

### printArray
 PrintArray() uses a for loop and get() to print out all the elements in the array.
 
 
 ## Data Structures
 One-Dimentional Arrays
 
 ## Use
To use the program, the user must first initialize an instance of the class in a main method, then use one of the constuctors to create an array of the default length of 10 or an array of a length of their choosing.

Once that has been done the user can fill the array with elements of any type. 

 The user will also have access all the methods deffined in this class.
 
 ## Classes
  The arrayList class is an ADT that mimics the behavior of the array list in the java library. testArray.java tests all the methods of arrayList.java for correctness, then prints out a shuffled deck of cards.
 
