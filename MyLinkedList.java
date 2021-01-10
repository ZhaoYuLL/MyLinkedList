public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
   start = new Node(null);
   end = new Node(null);
 /*create a constructor*/
}
 public int size(){
   return size;
 }

 public boolean add(String value){
   Node temp = new Node(value);
   if(size() ==0){
     start = temp;
     end = temp;
   }else{
     end.setNext(temp);
     temp.setPrev(end);
     end = temp;
   }
   size++;
   return true;
 }

 public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in range");
        }

        Node temp = new Node(value);
        if (size == 0) {
            start = temp;
            end = temp;
        } else if (index == size) {
            end.setNext(temp);
            temp.setPrev(end);
            end = temp;
        } else if (index == 0) {
            start.setPrev(temp);
            temp.setNext(start);
            start = temp;
        } else {
            Node newPrev = move(index - 1);
            Node newNext = move(index);
            temp.setNext(newNext);
            newPrev.setNext(temp);
            newNext.setPrev(temp);
            temp.setPrev(newPrev);
        }

        size ++;
  }

 private Node move(int index){
   if(index < 0 || index >= size()){
        throw new IndexOutOfBoundsException("Index is out of bounds!");
   }
   if (index == 0) return start;
   if (index == size - 1) return end;
   Node current = start;
   for(int i = 0; i < index; i++){
     current = current.getNext();
   }
   return current;
 }

 public String get(int index){
  if(index < 0 || index >= size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
  }
   Node current = move(index);
   return current.getData();
 }

 public String set(int index, String value){
  if(index < 0 || index >= size()){
    throw new IndexOutOfBoundsException("Index is out of bounds!");
  }
  Node current = move(index);
  String prev = current.getData();
  current.setData(value);
  return prev;
}
 public String toString(){
  String output = "";
  if(size()==0){
    return "[]";
  }
  Node current = start;
  while(current.getNext() != null){
    output += current.getData() + ", ";
    current = current.getNext();
  }
  output += current.getData();
  return "[" + output + "]";
 }; //shouldn't use get()- run time would be O(N^2)
 //Any helper method that returns a Node object MUST BE PRIVATE!

 public String remove(int index){
   if(index < 0 || index >= size()){
     throw new IndexOutOfBoundsException("Index is out of bounds!");
   }
   String oldValue = "";
   if(size() == 1){
     oldValue = start.getData();
     start = null;
     end = null;
   }else if(index == 0){
     oldValue = start.getData();
     Node head = start.getNext();
     head.setPrev(null);
     start.setNext(null);
     start = head;
   }else if(index == size() -1){
     oldValue = end.getData();
     Node old = end.getPrev();
     old.setNext(null);
     end.setPrev(null);
     end = old;
   }else{
     Node old = move(index);
     oldValue = old.getData();
     old.getPrev().setNext(old.getNext());//set the previous one's next to the old node's next
     old.getNext().setPrev(old.getPrev());//set the next one's previous to the old node's previous
     old.setNext(null);
     old.setPrev(null);
   }
   size--;
   return oldValue;
 }
 public void extend(MyLinkedList other){
   //NO Loops, should be
   end.setNext(other.start);
   other.start.setPrev(end);
   size += other.size();
   other.size = 0;
   other.start = null;
   other.end = null;
 }
 public String toStringReversed(){
   //start from end, getPrev instead of getNext
   String output = "";
   if(size()==0){
     return "[]";
   }
   Node current = end;
   while(current.getPrev() != null){
     output += current.getData() + ", ";
     current = current.getPrev();
   }
   output += current.getData();
   return "[" + output + "]";
 }
}
