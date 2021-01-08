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
   try{
     if(index < 0 || index > size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
     }
   }catch(NullPointerException e){
     throw new IndexOutOfBoundsException("Index is out of bounds!");
   }

   Node temp = new Node(value);
   Node current = start;
   if(current != null){
     for(int i = 0; i < index && current.getNext() != null; i++){
       current = current.getNext();
     }
   }
   temp.setNext(current.getNext());
   current.setNext(temp);
   size +=1;
 }
 public String get(int index){
   try{
     if(index < 0 || index > size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
     }
   }catch(NullPointerException e){
     throw new IndexOutOfBoundsException("Index is out of bounds!");
   }
   return "a";
 }
 public String set(int index, String value){
   try{
     if(index < 0 || index > size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
     }
   }catch(NullPointerException e){
     throw new IndexOutOfBoundsException("Index is out of bounds!");
   }
   return "a";
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
}
