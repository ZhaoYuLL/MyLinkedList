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
   if(start == null){
     start = new Node(value);
     return true;
   }
   Node newNode = new Node(value);
   newNode.setNext(null);
   Node current = start;
   while(current.getNext() != null){
     current = current.getNext();
   }
   current.setNext(newNode);
   size++;
   return true;
 }

 public void add(int index, String value){
     if(index < 0 || index > size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!" + index);
     }
     Node temp = new Node(value);
     Node current = start;
     for(int i = 0; i < index && current.getNext() != null; i++){
       current = current.getNext();
     }
      temp.setNext(current.getNext());
      current.setNext(temp);
      temp.setPrev(current);
      current.getNext().setPrev(temp);
     size++;
 }

 private Node move(int index){
   if(index < 0 || index >= size()){
        throw new IndexOutOfBoundsException("Index is out of bounds!");
   }
   Node current = start;
   for(int i = 0; i <= index; i++){
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
	 if (start != null) {
		Node current = start.getNext();
		while (current != null) {
		    output += current.getData().toString();
        if(current.getNext() != null){
          output += ", ";
        }
				current = current.getNext();
		}
	}
  return "[" + output + "]";
 }; //shouldn't use get()- run time would be O(N^2)
 //Any helper method that returns a Node object MUST BE PRIVATE!

 public String remove(int index){
   if(index < 0 || index >= size()){
     throw new IndexOutOfBoundsException("Index is out of bounds!");
   }
   return "a";
 }
 public void extend(MyLinkedList other){
   //NO Loops, should be
 }
 public String toStringReversed(){
   //start from end, getPrev instead of getNext
   String output = "";
   int i = 1;
	 Node current = move(size()-i);
   output += current.getPrev().getData().toString();

   return "[" + output  + "]";
 }
}
