package epic;
import java.util.Arrays;

public class snake_path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid={{1,3,2,6,8},{-9,7,1,-1,2},{1,5,0,1,9}};
		int[][] m=new int[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				m[i][j]=1;
			}
		}
		
		
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(i>0 && Math.abs(grid[i-1][j]-grid[i][j])==1){
					m[i][j]=m[i-1][j]+1;
				}
				
				if(j>0 && Math.abs(grid[i][j-1]-grid[i][j])==1){
					m[i][j]=m[i][j-1]+1;
				}
			}
		}
		
		for(int i=0;i<grid.length;i++){
			System.out.println(Arrays.toString(m[i]));
		}
		

	}
	

}
