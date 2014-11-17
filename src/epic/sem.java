package epic;
import java.util.*;
public class sem {
	public double pt=0;
	public int hr=0;
	public double gpa=0;
	public sem(ArrayList<ke> arr){
		for(ke k: arr){
			hr+=k.hr;
			pt+=k.pt;
		}
		gpa=pt/hr;
	}
}
