package chapter_2.maxSubSum;
/**
 * Directly Calculating with O(N^3)
 * @author Yao Qian
 *
 */
public class maxSubSum1 {
	private int maxSum = 0;
	
	public void compute  (int[] array) {
		for(int start=0; start<array.length; start++){   //[start, end]
			for(int end=start; end<array.length; end++){
				int theSum = 0;
				for(int i=start; i<=end; i++){
					theSum += array[i];
				}
				if(theSum > maxSum){
					maxSum = theSum;
				}			
			}			
		}
	}
	public void setMaxSum(int maxsum){
		this.maxSum = maxsum;
	}
	public int getMaxSum(){
		return this.maxSum;
	}
}
