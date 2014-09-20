public class Percolation {
    int[][] p;
	int len;

    public Percolation(int N) throws Exception
  	{             // create N-by-N grid, with all sites blocked
		if (N<=0) {
			throw new IllegalArgumentException();	
		}
		p=new int[N][N];
		len=N;
       int i,j;
       for(i=0;i<=N;i++) {
           for (j=0;j<N;j++) {
			   if i==0 || j==0
				   p[i][j]=-1;
			   else
				   p[i][j]=0;      // 0 means blocked
           }
       }
    }
    public void open(int i, int j)   {        // open site (row i, column j) if it is not already
		if (i<1 || i>N ||j<1 || j>N) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		p[i][j]=1;
    }
    public boolean isOpen(int i, int j)   {   // is site (row i, column j) open?
		if (i<1 || i>N ||j<1 || j>N) {
			throw new java.lang.IndexOutOfBoundsException();
		}
        return p[i][j]==1;
    }
    public boolean isFull(int i, int j)    {  // is site (row i, column j) full?
		if (i<1 || i>N ||j<1 || j>N) {
			throw new java.lang.IndexOutOfBoundsException();
		}
        return true;
    }
    public boolean percolates()     {         // does the system percolate?
        return true;
    }
    public static void main(String[] args)  { // test client, optional
    }
}
