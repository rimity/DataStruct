package chapter_3;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;
/**
 * this program demonstrate how to implement Stack with LinkedList | Node
 * @version 1.0 2017.06.22
 * @author Yao Qian
 *
 */

public class MyStack_LinkedList<AnyType> {
	private int count = 0;
	private LinkedList<AnyType> MyStack;  
	private Stack<AnyType> a;
	
	public MyStack_LinkedList(){
		MyStack = new LinkedList<>();     //use java.util.LinkedList
		count = 0;
	}
	
	public AnyType top(){
		if(count == 0){
			throw new EmptyStackException();
		}
		else{
			return MyStack.getFirst();
		}
	}
	
	public  void clear() {
		MyStack.clear();
		count =0;
	}
	public int size(){
		return count;
	}
	public  boolean isEmpty() {
		return(size() == 0);
	}
	//public boolean isFull(){}
	
	public void push(AnyType newVal) {
		/**
		 * this batch uses java.util.linkedList
		 */
		MyStack.addFirst(newVal);
		count ++;
		
		/**
		 * this batch uses the instance and the method of this class
		 */
		
	}
	public AnyType pop(){
		/**
		 * this batch uses java.util.linkedList
		 */
		count --;
		return MyStack.removeFirst(); // LinkList has exception
	}
}
