public class Node{
 public Node(String value){
  data = value;
  next = null;
  prev = null;
  /*create a constructor*/
}
 private String data;
 private Node next,prev;
 //write get/set methods for all three instance variables.
 public String getData(){
   return data;
 }
 public Node getNext(){
   return next;
 }
 public Node getPrev(){
   return prev;
 }

 public void setData(String data){
   this.data = data;
 }
 public void setNext(Node next){
   this.next = next;
 }
 public void setPrev(Node prev){
   this.prev = prev;
 }

}
