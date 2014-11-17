package whatsup;

public class node {
	public int value;
	public node next;
	public node(int v){
		this.value=v;
		this.next=null;
	}
	public void print(){
		node cur=this;
		while(cur!=null){
			System.out.print(cur.value+" ");
			cur=cur.next;
		}
		System.out.println();
	}
}
