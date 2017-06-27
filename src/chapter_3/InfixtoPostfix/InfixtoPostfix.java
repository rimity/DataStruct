package chapter_3.InfixtoPostfix;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;


import chapter_3.MyStack_LinkedList;

/**
 * This program
 * @author Yao Qian
 *
 */

public class InfixtoPostfix {
	private String[] Infix;  
	private ArrayList<operator> Postfix;
	private MyStack_LinkedList<operator> container;
	
	
	
	public InfixtoPostfix(){
		container = new MyStack_LinkedList<operator>();
	}
	public InfixtoPostfix(String[] In){
		this();
		//Infix = In;    // encapsulation??
		Infix = Arrays.copyOf(In, In.length); 
		Postfix = new ArrayList<operator>();		
	}
	
	public ArrayList<operator> getPostfix(){
		return Postfix;
	}
	
	public void printPostfix(){
		Iterator<operator> iter= Postfix.iterator();
		while(iter.hasNext()){
			operator p = iter.next();
			if(p.getFlagOperator()){
				System.out.println(p.getOperator());
			}
			else
				System.out.println(p.getStringNumber());
		}	
	}
	
	
	
	public void transform (){
		Integer flagBrackets = 0;
		container = new MyStack_LinkedList<operator>();   //room will release with the process of method??
		for(int i=0; i<Infix.length; i++){   //get string cache in container
			String s = Infix[i];
			operator opt = new operator();
			opt.toOperator(s);
			if(opt.getFlagOperator()){
				if(opt.getPriority() == 0){
					flagBrackets = flagBrackets + 1;
				}
				handleOperator(container, Postfix, opt, flagBrackets);  //though flagBrackets is Integer but it is not changed ???
			}
			else{ 
				handleOperand(Postfix, opt);
			}	
		}		
		/** handle the problem: the number of brackets is not matched.  
		 * how about the problem: the number of operator and operand is not matched??   at calculator
		 */
		if(flagBrackets!=0 && !container.isEmpty()) 
			System.out.println("Bad in put equation!!!");
		while(!container.isEmpty()){
			Postfix.add(container.pop());
		}
	}
	
	public void handleOperand(ArrayList<operator> Postfix, operator opt){
		Postfix.add(opt);
	}
	public void handleOperator(MyStack_LinkedList<operator> container, ArrayList<operator> Postfix, operator opt, Integer flag){
		
		if(container.isEmpty())
		{
			container.push(opt);
		}
		else{
			while(!container.isEmpty()){
				if(flag == 0 ){     // has no brackets 
					int result = opt.compareTo(container.top());
					if( result <= 0 ){
						Postfix.add(container.top());
						container.pop();
					}
					else{
						container.push(opt);
						break;
					}
				}
				else if(flag == 1){    // has one brackets 
					if(opt.getPriority() == 0){   //opt is brackets
						container.push(opt);
						break;
					}
					else{    //opt is not brackets 
						int result = opt.compareTo(container.top());
						if( result <= 0 && container.top().getPriority()!=0){   
							Postfix.add(container.top());
							container.pop();
						}
						else{
							container.push(opt);
							break;
						}
					}
				}
				else{  // flag == 2 the other brackets comes
					while(container.top().getPriority() != 0){   //pop all the +-*/ before the first brackets 
						Postfix.add(container.top());
						container.pop();
					}
					container.pop();  //pop the first brackets
					flag = flag - 2;   //push the first brackets
				}
			}
		}
	}
}
