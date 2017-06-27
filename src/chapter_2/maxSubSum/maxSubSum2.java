package chapter_2.maxSubSum;
/**
 * use  sum(a1,a2,...,an) = an + sum(a1,a2,...,a<n-1>)   O(N^2) avoid repeated calculation
 * @author Yao Qian
 *
 */

public class maxSubSum2 {
private int maxSum = 0;
	
	public void compute(int[] array){
		for(int start=0; start<array.length; start++){
			int theSum = 0;
			for(int end=start; end<array.length; end++){
				theSum += array[end];            // sum(a1,a2,...,an) = an + sum(a1,a2,...,a<n-1>)
				if(theSum > this.maxSum)
					this.maxSum = theSum;
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
