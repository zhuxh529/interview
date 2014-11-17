package quantlab;

public class trade {
	String symbol;
	long maxTimeGap;
	int weightAvg;
	int maxPrice;
	int totalWeight;
	int Volume;
	
	long lastTime=0;
	
	public trade( long time,String sym, int number, int price){
		totalWeight=number* price;
		Volume=number;
		maxTimeGap=0;
		lastTime=time;
		symbol=sym;
		maxPrice=price;
	}
	
	public int getWeightedAveragePrice(){
		return weightAvg;
	}

	public void update( long time,String sym, int number, int price){
		if(!sym.equals(symbol)){
			System.out.println("symbol wrong dude");
		}
		
		totalWeight+=number* price;
		Volume+=number;
		maxTimeGap=time-lastTime>maxTimeGap?time-lastTime:maxTimeGap;
		lastTime=time;
		maxPrice=price>maxPrice?price:maxPrice;
		weightAvg=totalWeight/Volume;
		
	}
	
	public void print(){
		System.out.println("Name: "+symbol+" time: "+maxTimeGap+" Volumne:"+ Volume+ "  weightAvg:"+weightAvg);
	}
}
