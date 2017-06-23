package chapter_3;


/**
 * this program demonstrate how to implements an ArrayList with array.
 * @version 1.0 20176.21
 * @author Yao Qian
 *
 */public class MyArrayList<AnyType> implements Iterable<AnyType>{
	 private static final int DEFAULT_CAPACITY = 10;
	 
	 private int theSize;
	 private AnyType[] theItems;   // ArrayList is implemented by array 
	 
	 public MyArrayList(){
		 doClear();
	 }
	 
	 public void clear(){
		 doClear();
	 }
	 
	 public int size(){
		 return theSize;
	 }
	 
	 public boolean isEmpty(){
		 //return (theSize == 0);
		 return(size() == 0);  // ���������÷����ӿ�ʵ�֣�����ı�ṹ����
	 }
	 
	 public AnyType get(int idx){
		 if(idx<0 || idx>=size()){
			 throw new ArrayIndexOutOfBoundsException();
		 }
		 return theItems[idx];
	 }
	 
	 public AnyType set(int idx, AnyType newVal){
		 if(idx<0 || idx>=size()){
			 throw new ArrayIndexOutOfBoundsException();
		 }
		 AnyType old = theItems[idx];
		 theItems[idx] = newVal;
		 return old;
	 }

	 public void add(int idx, AnyType newVal){
		 if( idx<0 ){
			 throw new ArrayIndexOutOfBoundsException();
		 }
		 if( theItems.length == size()){
			 ensureCapacity(size()*2 + 1);
		 }
		 for( int i=size(); i>idx; i--){
			 theItems[i] = theItems[i-1];
		 }
		 theItems[idx] = newVal;
		 theSize ++;
	 }

	 public void add(AnyType newVal){
		 add(size(), newVal);
	 }
	 
	 public AnyType remove(int idx){
		 AnyType item = theItems[idx];
		 for(int i=idx; i<size()-1;i++){
			 theItems[i] = theItems[i+1];
		 }
		 theSize --;
		 return item;
	 }
	  
	 public void trimToSize(){
		 ensureCapacity(size());
	 }
	 
	 public void ensureCapacity(int newCapacity){    //ȷ�������ڲ����·���ռ��������ܱ������������Ԫ��
		 if( newCapacity < theSize){
			 return;
		 }
		 AnyType[] old = theItems;
		 theItems = (AnyType[]) new Object[newCapacity];
		 for(int i=0; i< size(); i++){
			 theItems[i] = old[i];
		 }
	 }
	 	 
	 private void doClear(){    //��ʼ��
		 theSize = 0;
		 ensureCapacity(DEFAULT_CAPACITY);
	 }
	 
	 public java.util.Iterator<AnyType> iterator(){    //implement the abstract method
		 return new ArrayListIterator();  // ����һ����װ���˵���
	 }
	 
	 private class ArrayListIterator implements java.util.Iterator<AnyType>{  //�ڲ���
		 private int current = 0;
		 
		 public boolean hasNext(){
			 return (current < size());
		 }
		 
		 public void remove(){
			 MyArrayList.this.remove(--current);    //LinkedList Ӧ�ò�������ʵ��
		 }
		 
		 public AnyType next(){
			 if(!hasNext()){
				 throw new java.util.NoSuchElementException();
			 }
			 return theItems[current++];
		 }
	 }
	 
	 

}
