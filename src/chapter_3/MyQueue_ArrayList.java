package chapter_3;
import java.util.ArrayList;
/**
 * 
 * @author Yao Qian
 *
 */
public class MyQueue_ArrayList<AnyType> {
	private int count;
	private ArrayList<AnyType> MyQueue;
	
	public MyQueue_ArrayList(){
		MyQueue = new ArrayList<>();
		count = 0;
	}
	public int size(){
		return count;
	}
	public synchronized void clear() throws InterruptedException{
		MyQueue.clear();
		count = 0;
	}
	public synchronized boolean isEmpty() throws InterruptedException{
		return(size() == 0);
	}
	
	public void enQueue(AnyType newVal){
		MyQueue.add(newVal);
		count ++;
	}
	public synchronized AnyType deQueue() throws InterruptedException{
		if(isEmpty()){
			throw new NullPointerException();
		}
		else{
			count --;
			return MyQueue.remove(0);
		}
	}
	
}
