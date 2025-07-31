class Solution {
    double getSolve(double x, long n){
        if(n==0) return 1;
        if(n==1) return x;
        if(n<0) return getSolve(1/x,-1*n);
        if(n%2==0) return getSolve(x*x,n/2);
        return x*getSolve(x*x, n/2);
    }
    public double myPow(double x, int n) {
     return getSolve(x,(long)n);
    }
}

