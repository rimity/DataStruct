package chapter_3;
import java.util.*;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	private int theSize;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	private static class Node<AnyType>{    //静态内部类，内部类对象不引用外部类对象
		private AnyType data;
		private Node<AnyType> prev;
		private Node<AnyType> next;
		
		public Node( AnyType d, Node<AnyType> p, Node<AnyType> n){
			data = d;
			prev = p;
			next = n;
		}
	}
	
	public MyLinkedList(){
		doClear();
	}
	public void clear(){
		doClear();
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return(size()==0);
	}
	
	public Node<AnyType> getNode(int idx){
		if(idx<0 || idx>(size()-1)){
			throw new IndexOutOfBoundsException();
		}
		Node<AnyType> gNode;
		if(idx < size()/2){
			gNode = beginMarker.next;
			for(int i=0; i<idx; i++){
				gNode = gNode.next;
			}
		}
		else{
			gNode = endMarker.prev;
			for(int i=size(); i>idx; i--){
				gNode = gNode.prev;
			}
		}
		return gNode;
	}
	
	public void add(AnyType newVal, int idx){
		if( idx<size() && 0<=idx ){
			Node<AnyType> iNode = getNode(idx);
			Node<AnyType> addNode = new Node<AnyType>(newVal, iNode.prev, iNode);		
			iNode.prev.next = addNode;
			iNode.prev = addNode;			
		}
		else if(idx==size()){
			Node<AnyType> addNode = new Node<AnyType>(newVal, endMarker.prev,endMarker);
			endMarker.prev.next = addNode;
			endMarker.prev = addNode;
		}
		else{
			throw new IndexOutOfBoundsException();
		}
		theSize ++;
		modCount ++;
	}
	
	public boolean add(AnyType newVal){
		add(newVal, size());
		return true;
	}
	
	public void remove(Node<AnyType> rNode){
		if(rNode!=null && rNode!=endMarker && rNode!=beginMarker){
			rNode.prev.next = rNode.next;
			rNode.next.prev = rNode.prev;
		}
		else{
			throw new IndexOutOfBoundsException();
		}
		theSize --;
		modCount --;
	}
	
	public void remove(int idx){
		if( idx<size()-1 && 0<=idx){
			Node<AnyType> rNode = getNode(idx);
			rNode.prev.next = rNode.next;
			rNode.next.prev = rNode.prev;
		}
		else if(idx == size()-1){
			endMarker.prev.prev.next = endMarker;
			endMarker.prev = endMarker.prev.prev;
		}
		else{
			throw new IndexOutOfBoundsException();
		}
		theSize --;
		modCount --;
	}
	
 	private void doClear(){   //初始化
		beginMarker = new Node<AnyType>(null,null,null);
		endMarker = new Node<AnyType>(null,beginMarker,null);
		beginMarker.next = endMarker;
		theSize = 0;
		modCount ++;
	}
 	
 	public Iterator<AnyType> iterator(){
 		return new LinkedListIterator();
 	}
 	
 	private class LinkedListIterator implements Iterator<AnyType>{
 		private Node<AnyType> current = beginMarker.next;
 		private int expectedModCount = modCount;
 		private boolean okToRemove = false;
 		
 		public boolean hasNext(){
 			return(current != endMarker);
 		}
 		
 		public AnyType next(){
 			if(modCount != expectedModCount){
 				throw new java.util.ConcurrentModificationException();
 			}
 			if(!hasNext()){
 				throw new java.util.NoSuchElementException();
 			}
 			
 			AnyType nextItem = current.data;
 			current = current.next;
 			okToRemove = true;
 			return nextItem;
 		}
 		
 		public void remove(){
 			if(modCount != expectedModCount){
 				throw new java.util.ConcurrentModificationException();
 			}
 			if(!okToRemove){
 				throw new IllegalStateException();
 			}
 			
 			MyLinkedList.this.remove(current.prev);
 			expectedModCount++;
 			okToRemove = false;		 			
 		}		
 	}
}
