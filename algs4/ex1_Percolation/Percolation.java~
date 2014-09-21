//import home.yorkyi.AlgorithmI_Coursera.algs4.algs4.QuickFindUF;
public class Percolation {
 private int len;
 private int[][] state;
 private QuickFindUF p;

 public Percolation(int N)
 {             // create N-by-N grid, with all sites blocked
  if (N <= 0) {
   throw new IllegalArgumentException(); 
  }
  p = new QuickFindUF(N*N);
  len = N;
  int i, j;
  state = new int[N][N];
  for (i = 0; i < N; i++) {
   for (j = 0; j < N; j++) {
    state[i][j] = 0;
   }
  }
 }


 public void open(int i, int j)  
 {
// open site (row i, column j) if it is not already
  if (i < 1 || i > len || j < 1 || j > len) {
   throw new java.lang.IndexOutOfBoundsException();
  }
  state[i-1][j-1] = 1;

  int m = (i-1)*len+j-1;
  int mup = (i-2)*len+j-1;
  int mdown = i*len+j-1;
  int mleft = (i-1)*len+j-2;
  int mright = (i-1)*len+j;
  if (i != 1 && isOpen(i-2, j-1))
   p.union(m, mup);
  if (i != len && isOpen(i, j-1))
   p.union(m, mdown);
  if (j != 1 && isOpen(i-1, j-2))
   p.union(m, mleft);
  if (j != len && isOpen(i-1, j))
   p.union(m, mright);
    }


    public boolean isOpen(int i, int j)   {   // is site (row i, column j) open?
  if (i < 1 || i > len || j < 1 || j > len) {
   throw new java.lang.IndexOutOfBoundsException();
  }
        return state[i-1][j-1] == 1;
    }


    public boolean isFull(int i, int j)    {  // is site (row i, column j) full?
  if (i < 1 || i > len || j < 1 || j > len) {
   throw new java.lang.IndexOutOfBoundsException();
  } else {
   int m = (i-1)*len+j-1;
   for (int k = 0; k < len; k++) {
       if (p.connected(k, m))
     return true;
   }
   return false;
  }
    }


public boolean percolates() {         // does the system percolate?
  for (int i = 0; i < len; i++) {
   for (int j = 0; j < len; j++) {
    if (isFull(i, (len-1)*len+j))
     return true;
   }
  }
  return false;
}


    public static void main(String[] args)  { // test client, optional
    }
}
