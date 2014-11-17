package quantlab;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class solution {
	public static HashMap<String, trade> map;

	public static void main(String[] args) throws Exception {
		FileInputStream inputStream = null;
		Scanner sc = null;
		map=new HashMap<String, trade>();
		try {
			String path="src/quantlab/input.csv";
		    inputStream = new FileInputStream(path);
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        processLine(line);
		        
//		        System.out.println(line);
		    }
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		
		output();

	}
	
	public static void processLine(String line){
		String[] arr=line.split(",");
		if(arr.length!=4){
			System.out.println("file input error!");
			return;
		}
		if(map.get(arr[1])==null){
			trade cur=new trade(Long.parseLong(arr[0]),arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
			map.put(arr[1], cur);
		}
		else{
			map.get(arr[1]).update(Long.parseLong(arr[0]),arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]));
		}
		
	}
	
	public static void test(){
		for(String name: map.keySet()){
			map.get(name).print();
		}
	}
	
	public static void output(){
		int count=1;
		
		try
		{
		    String filename= "src/quantlab/output.csv";
		    File f = new File(filename);
		    if(f.exists()){
		    	System.out.println("file already exists, delete it first to process~");
		    	return;
		    }
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    
		    for(String name: map.keySet()){
		    	trade t=map.get(name);
		    	if(count%1000==0){
		    		//in case the output buffer is too big for memory
		    		fw.close();
		    		fw = new FileWriter(filename,true);
		    		count=0;
		    	}
		    	fw.write(t.symbol+","+t.maxTimeGap+","+t.Volume+","+t.weightAvg+","+t.maxPrice+"\n");
		    	count++;
			}
		    
		    
		    
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	

}
