package chapter_3;
import java.util.*;
/**
 * this program demonstrate how to implement Queue with LinkedList | Node
 * @version 1.0 2017.06.22
 * @author Yao Qian
 *
 */
public class MyQueue_LinkedList<AnyType> {
	private int count;
	private LinkedList<AnyType> MyQueue;
	
	public MyQueue_LinkedList(){
		MyQueue = new LinkedList<>();
		count = 0;
	}
	public synchronized void clear() throws InterruptedException{
		MyQueue.clear();
		count = 0;
	}
	public int size(){
		return count;
	}
	public synchronized boolean isEmpty() throws InterruptedException{
		return(size()==0);
	}
	public void enQueue(AnyType newVal){
		MyQueue.addLast(newVal);
		count ++;
	}
	public AnyType deQueue(){
		count --;
		return MyQueue.removeLast();	
	}
	
}
