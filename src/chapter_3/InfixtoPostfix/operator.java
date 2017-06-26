package chapter_3.InfixtoPostfix;

public class operator implements Comparable<operator>{
	private boolean flagOperator;
	private int number;
	private String operator;   
	private int priority;  // operand -1; +- 1; */ 2;  () 0;
	
	public operator(){
		flagOperator = false;
		number = 0;
		operator = null;
		priority = -1;
	}
	
	public operator(boolean f, int n, String o, int p){
		flagOperator = f;
		number = n;
		operator = o;
		priority = p;
	}
	/* if is Operator, set flagOperator and estimate priority */
 	public void toOperator(String s){
		//if (s == "+" || s =="-" || s == "*" || s == "/" || s == "(" || s == ")"){
 		if (s.equals("+") ||s.equals("-") || s.equals("*") ||s.equals("/") || s.equals("(") || s.equals(")")){
			setFlagOperator(true);
			setPriority(estimatePriority(s));
			setOperator(s);
			setNumber("0");
		}
		else{
			setFlagOperator(false);
			setPriority(-1);
			setNumber(s);	
		}
	}
 	public boolean isOperator(operator opt){
 		return getFlagOperator();
 	}
	public int estimatePriority(String s){
		if(s.equals("(") ||s.equals(")")){
			return 0;
		}
		else if(s.equals("+") || s.equals("-")){
			return 1;
		}
		else if(s.equals("*")|| s.equals("/")){
			return 2;
		}
		else{
			System.out.println("can not handle");
			return -1;
		}
		
	}
	public void setFlagOperator( boolean b){
		flagOperator = b;
	}
	public void setOperator(String s){
		if(s == null)
			operator = null;
		else
			operator = s;
	}
 	public void setNumber(String s){
		if(s == null)
			number = 0;
		else
			number = Integer.parseInt(s);
	}
	public void setPriority(int p){
		priority = p;
	}
	
	
	public boolean getFlagOperator(){
		return flagOperator;
	}
	public int getPriority(){
		return priority;
	}	
	public String getOperator(){
		return operator;
	}
	public int getIntNumber(){
		return number;
	}
	public String getStringNumber(){
		return String.valueOf(number);
	}
	
	public int compareTo(operator opt){
		if(this.getPriority() < opt.getPriority())
			return -1;
		else if(this.getPriority() > opt.getPriority())
			return 1;
		else 
			return 0;	
	}
}
