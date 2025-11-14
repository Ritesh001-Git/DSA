public class WaterOverFlow{
    public static void main(String[] args) {
        int K=5;
        int R=3;
        int C=2;
        System.out.println(waterOverflow(K,R,C));
    }
    public static double waterOverflow(int K,int R,int C){
        double[][] mat=new double[R+2][R+2];
        mat[0][0]=K;
        for(int i=0; i<=R; i++){
            for(int j=0; j<=i; j++){
                if(mat[i][j]>1){
                    double extra=mat[i][j]-1;
                    mat[i][j]=1;
                    mat[i+1][j]=extra/2;
                    mat[i+1][j+1]=extra/2;
                }
            }
        }
        return mat[R-1][C-1]>1?1:mat[R-1][C-1];
    }
}