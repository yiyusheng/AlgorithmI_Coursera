public class PercolationStats {
   private double[] arraySta;
   private int ipt;
   public PercolationStats(int N, int T)
   {
// perform T independent computational experiments on an N-by-N grid
     if (N <= 0 || T <= 0) throw new IllegalArgumentException();
     arraySta = new double[T];
     ipt = T;
     int[] tag = new int[N*N];
     for (int i = 0; i < N*N; i++)
       tag[i] = i;
     for (int i = 0; i < T; i++) 
     {
       int [] ctag = tag;
       Percolation p = new Percolation(N);
       StdRandom.setSeed(i + 89757);
       StdRandom.shuffle(ctag);
       int j;
       for (j = 0; j < N*N; j++)
       {
         int cr = ctag[j];
         int crow = cr/N+1;
         int ccolumn = cr % N+1;
         p.open(crow, ccolumn);
         if (p.percolates())
           break;
       }
       arraySta[i] = (j+1)/N/N;
       System.out.print(arraySta[i]);
     }
   }
   public double mean()
   {                     // sample mean of percolation threshold
     return StdStats.mean(arraySta);
   }
   public double stddev()
   {                   // sample standard deviation of percolation threshold
     return StdStats.stddev(arraySta);
   }
   public double confidenceLo()
   {             // returns lower bound of the 95% confidence interval
     return StdStats.mean(arraySta) 
       - 1.96*StdStats.stddev(arraySta)/Math.sqrt(ipt);
   }
   public double confidenceHi()
   {             // returns upper bound of the 95% confidence interval
     return StdStats.mean(arraySta) 
       + 1.96*StdStats.stddev(arraySta)/Math.sqrt(ipt);
   }
   public static void main(String[] args) {
     // test client, described below
   }
}
