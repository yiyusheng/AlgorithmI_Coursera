public class PercolationStats {
	private	double[] count_array;
	private int ipt_T;
   public PercolationStats(int N, int T)
   {	   // perform T independent computational experiments on an N-by-N grid
	   if (N<=0 || T<=0) throw new IllegalArgumentException();
	   count_array=new double[T];
	   ipt_T=T;
	   int[] tag=new int[N*N];
	   for (int i=0;i<N*N;i++)
		   tag[i]=i;
	   for (int i=0;i<T;i++) 
	   {
		   int [] curr_tag=tag;
		   Percolation p=new Percolation(N);
		   StdRandom.setSeed(i+89757);
		   StdRandom.shuffle(curr_tag);
		   int j;
		   for (j=0;j<N*N;j++)
		   {
			   int curr_r=curr_tag[j];
			   int curr_row=curr_r/N+1;
			   int curr_column=curr_r%N+1;
			   p.open(curr_row,curr_column);
			   if (p.percolates())
				   break;
		   }
		   count_array[i]=(j+1)/N/N;
		   System.out.print(count_array[i]);
	   }
   }
   public double mean()
   {                     // sample mean of percolation threshold
	   return StdStats.mean(count_array);
   }
   public double stddev()
   {                   // sample standard deviation of percolation threshold
	   return StdStats.stddev(count_array);
   }
   public double confidenceLo()
   {             // returns lower bound of the 95% confidence interval
	   return StdStats.mean(count_array)-1.96*StdStats.stddev(count_array)/Math.sqrt(ipt_T);
   }
   public double confidenceHi()
   {             // returns upper bound of the 95% confidence interval
	   return StdStats.mean(count_array)+1.96*StdStats.stddev(count_array)/Math.sqrt(ipt_T);
   }
   public static void main(String[] args){
	   // test client, described below
   }
}
