package chapter_3;
import java.util.LinkedList;
import java.lang.*;

/**
 * this program demonstrate how to implement Stack with LinkedList | Node
 * @version 1.0 2017.06.22
 * @author Yao Qian
 *
 */
public class MyStack_LinkedList<AnyType> {
	private int count;
	private LinkedList<AnyType> MyStack;   
	private Node<AnyType> topNode;      // how to define node??
	
	public MyStack_LinkedList(){
		MyStack = new LinkedList<>();     //use java.util.LinkedList
		topNode = ???;
		count = 0;
	}
	public void clear(){
		topNode = null;  // ??
		MyStack.clear();
		count =0;
	}
	public int size(){
		return count;
	}
	public synchronized boolean isEmpty() throws InterruptedException{
		return(size() == 0);
	}
	//public boolean isFull(){}
	
	public synchronized void push(AnyType newVal) throws InterruptedException{
		/**
		 * this batch uses java.util.linkedList
		 */
		MyStack.addFirst(newVal);
		count ++;
		
		/**
		 * this batch uses the instance and the method of this class
		 */
		Node<AnyType> newNode = new Node(newVal);
		//topNode.xxx
		//??????????  and then?? 
		count ++;
		
	}
	public synchronized AnyType pop() throws InterruptedException{
		/**
		 * this batch uses java.util.linkedList
		 */
		count --;
		return MyStack.removeFirst();
		/**
		 * this batch uses the instance and the method of this class
		 */
		if(isEmpty()){
			throw new NullPointerException();
		}
		topNode = getFirstNode;   // sad..
		count --;
		return getFirstNode().data;
	}
	
	private Node getFirstNode(){
		return topNode;
	}
}
