package flipboard;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.HashSet;


public class p1 {
	static int neginf=Integer.MIN_VALUE;
	public static String preUrl="https://challenge.flipboard.com/m?s=5917492456411459044.47";
	public static void main(String[] args) {
		int maze_size=100; // adjust it if u test on bigger maze
		int[][] matrix=new int[maze_size][maze_size];//distance 2d vector
//BFS shortest path
        try {
        	boolean end=false;
            String a=preUrl+"&x=4&y=3";

            String content;
            Point ret=new Point(0,0); //Origin of search 
            Queue<Point> q=new LinkedList();
    		q.add(ret);
    		HashSet<Point> set=new HashSet<Point>();
    		set.add(ret);
        	int dist=0;
        	Point cur=new Point();
            
            while(!q.isEmpty()){
            	 cur=q.poll();
            	dist=matrix[cur.x][cur.y];
            	
            	a=preUrl+"&x="+Integer.toString(cur.x)+"&y="+Integer.toString(cur.y);
                content=getUrl(a);
                if(!content.contains("/")) continue;
            	String[] parts=content.split("/");
            	if(parts[0].contains("true")){System.out.println("end point is "+cur.toString());break;}
            	ArrayList<Point> pts=getNeibour(parts[1]);
            	for(Point pt: pts){
            		if(!set.contains(pt)){q.add(pt);set.add(pt); matrix[pt.x][pt.y]=dist+1;}
            	}
            }
            
            ArrayList path=getPath(matrix, cur, dist);
            System.out.println("reach end!");
            writePath(path);
            writeMatrix(matrix);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	
	public static Point getPt(String str){
		String[] s=str.split("&");
		if(s.length<3) return new Point(neginf,neginf);
		
		Point ret=new Point();
		return ret;
		
	}
	
	public static String getUrl(String str) throws IOException{
		URL url;
		url = new URL(str);
        URLConnection conn = url.openConnection();
        BufferedReader br = new BufferedReader(
                           new InputStreamReader(conn.getInputStream()));
        String inputLine;
        inputLine = br.readLine();
        if(inputLine==null) System.out.println("no line for url given");
        br.close();

        return inputLine;

	}
	
	public static ArrayList<Point> getNeibour(String str){
		String[] newStr=str.replace("(", "").replace(")", "").split(",");
		ArrayList<Point> list=new ArrayList<Point>();
		for(int i=0;i<newStr.length;i+=2){
			Point pt=new Point( Integer.parseInt(newStr[i]), Integer.parseInt(newStr[i+1]));
			list.add(pt);
		}
		return list;
		
		
	}
	
	public static ArrayList<Point> getPath(int[][] matrix, Point end, int dist) throws IOException{
		ArrayList<Point> reverse_path=new ArrayList<Point>();
		Point cur=end;
		Point orig=new Point(0,0);
		Point prev;
		String a, content;
		int distance=dist;
		while(!cur.equals(orig)){
			prev=cur;
        	a=preUrl+"&x="+Integer.toString(cur.x)+"&y="+Integer.toString(cur.y);
            content=getUrl(a);
        	String[] parts=content.split("/");
        	ArrayList<Point> pts=getNeibour(parts[1]);
        	for(Point pt: pts){
        		if(matrix[pt.x][pt.y]==distance-1){
        			cur=pt;
        			reverse_path.add(pt);
        			distance--;
        			continue;
        		}
        	}
        	if(orig.equals(prev)){System.out.println("path error: dead loop");};
		}
		return reverse_path;
	}
	
	public static void writePath(ArrayList<Point> arr) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("Path.txt", "UTF-8");
		for(int i=arr.size()-1;i>=0;i--){
			writer.println("("+arr.get(i).x+","+arr.get(i).y+")");
		}
		writer.close();
	}
	
	public static void writeMatrix(int[][] matrix ) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("Maze.txt", "UTF-8");
		for(int i=0;i<=50;i++){
			for(int j=0;j<=50;j++){
				writer.print(matrix[i][j]+" ");
			}
			writer.println();
		}
		writer.close();
	}
	
	
	

}
