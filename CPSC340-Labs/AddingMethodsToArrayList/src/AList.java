import java.util.NoSuchElementException;

// Array-based list implementation
class AList implements List {
    private Object listArray[];             // Array holding list elements
    private static final int DEFAULT_SIZE = 10; // Default size
    private int maxSize;                    // Maximum size of list
    private int listSize;                   // Current # of list items
    private int curr;                       // Position of current element

    // Constructors
    // Create a new list object with maximum size "size"
    AList(int size) {
        maxSize = size;
        listSize = curr = 0;
        listArray = new Object[size];         // Create listArray
    }
    // Create a list with the default capacity
    AList() { this(DEFAULT_SIZE); }          // Just call the other constructor

    public void clear()                     // Reinitialize the list
    { listSize = curr = 0; }              // Simply reinitialize values

    // Insert "it" at current position
    public boolean insert(Object it) {
        if (listSize >= maxSize) return false;
        for (int i=listSize; i>curr; i--)  // Shift elements up
            listArray[i] = listArray[i-1];   //   to make room
        listArray[curr] = it;
        listSize++;                        // Increment list size
        return true;
    }

    // Append "it" to list
    public boolean append(Object it) {
        if (listSize >= maxSize) return false;
        listArray[listSize++] = it;
        return true;
    }

    // Remove and return the current element
    public Object remove() throws NoSuchElementException {
        if ((curr<0) || (curr>=listSize))  // No current element
            throw new NoSuchElementException("remove() in AList has current of " + curr + " and size of "
                    + listSize + " that is not a a valid element");
        Object it = listArray[curr];       // Copy the element
        for(int i=curr; i<listSize-1; i++) // Shift them down
            listArray[i] = listArray[i+1];
        listSize--;                        // Decrement size
        return it;
    }

    public void moveToStart() { curr = 0; }       // Set to front
    public void moveToEnd() { curr = listSize; }  // Set at end
    public void prev() { if (curr != 0) curr--; } // Move left
    public void next() { if (curr < listSize) curr++; } // Move right
    public int length() { return listSize; }      // Return list size
    public int currPos() { return curr; }         // Return current position

    // Set current list position to "pos"
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) return false;
        curr = pos;
        return true;
    }

    // Return true if current position is at end of the list
    public boolean isAtEnd() { return curr == listSize; }

    // Return the current element
    public Object getValue() throws NoSuchElementException {
        if ((curr < 0) || (curr >= listSize)) // No current element
            throw new NoSuchElementException("getvalue() in AList has current of " + curr + " and size of "
                    + listSize + " that is not a a valid element");
        return listArray[curr];
    }

    // Check if the list is empty
    public boolean isEmpty() { return listSize == 0; }

    // removes current position then inserts new value at same position
    public void set(int index, Object item){
        if (moveToPos(index)){
            remove();
            insert(item);
        }
        else
            throw new IndexOutOfBoundsException();
    }

    // loops through the array backwards to find the first occurrence from behind
    public int lastIndexOf(Object item){
        this.moveToEnd();
        this.prev();
        while (this.currPos()>=0) {
            if (this.getValue().equals(item)) {
                return this.currPos();
            }
            else
                this.prev();
        }
        return -1;
    }

    //finds the size of the array and stores in temp, clears array and resize, enter the temp into resized array
    public void trimToSize() {
        if (this.length() <= listArray.length) {
            Object[] listArrayTemp = listArray;
            listArray = new Object[this.length()];
            for (int j = 0; j < this.length(); j++) {
                listArray[j] = listArrayTemp[j];
            }
        }
        System.out.println("Size = "+this.length());
        System.out.println("Capacity = "+listArray.length);
    }

    //starts at the start of the array and just goes through each object
    public void displayArray(){
        this.moveToStart();
        while(!this.isAtEnd()){
            System.out.println(this.getValue());
            this.next();
        }
    }

    public static void main(String args[]) {
        AList names = new AList(30);
        names.insert("Alice");
        names.insert("Bob");
        names.insert("Claire");
        names.insert("Dominic");
        names.insert("Estelle");
        names.insert("Frank");
        names.insert("Gwen");
        names.insert("Hugo");
        names.insert("Irene");
        names.insert("Claire");
        names.insert("Jack");
        // test the set method
        names.set(0, "Billy");
        System.out.println(names.getValue());
        try {
            names.set(100, "Slartibartfast");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception thrown correctly");
        }
        // test the last index method
        int index = names.lastIndexOf("Claire");
        System.out.println("Last index of Claire is " + index);
        // call the trimToSize method -- should ensure that works in method
        names.trimToSize();
        // print the final list
        System.out.println("List contents:");
        names.displayArray();
    }

}

