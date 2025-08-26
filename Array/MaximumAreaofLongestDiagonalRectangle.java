public class MaximumAreaofLongestDiagonalRectangle {
    public static void main(String[] args) {
        int[][] points = {{9,3},{8,6},{1,0},{0,1}};
        System.out.println(areaOfMaxDiagonal(points));
    }
    public static int areaOfMaxDiagonal(int[][] d) {
        int maxDia=-1;
        int index=0;
        for(int i=0; i<d.length; i++){
            int r=d[i][0];
            int c=d[i][1];
            int dia=r*r+c*c;
            if(dia>maxDia || (dia == maxDia && r*c > d[index][0]*d[index][1])){
                maxDia=dia;
                index=i;
            }
        }
        return d[index][0]*d[index][1];
    }
}
