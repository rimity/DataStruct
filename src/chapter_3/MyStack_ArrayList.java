package chapter_3;
import java.util.ArrayList;

/**
 * this program demonstrate how to implement Stack with ArrayList
 * @version 1.0 2017.6.23
 * @author Yao Qian
 *
 */
public class MyStack_ArrayList <AnyType>{
	private int count;
	private ArrayList<AnyType> MyStack;
	
	public MyStack_ArrayList(){
		MyStack = new ArrayList<AnyType>();
		count = 0;
	}
	public int size(){
		return count;
	}
	public synchronized void clear() throws InterruptedException{
		MyStack.clear();
		count = 0;
	}
	public synchronized boolean isEmpty() throws InterruptedException{
		return(size() == 0);
	}
	
	public void push(AnyType newVal){
		MyStack.add(newVal);
		count ++;
	}
	public synchronized AnyType pop() throws InterruptedException{
		if(isEmpty()){
			throw new NullPointerException();
		}
		else{
			count --;
			return MyStack.remove(size()-1);
		}
	}
	
	
}
