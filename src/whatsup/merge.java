package whatsup;

public class merge {

	public static void main(String[] args) {
		
		//TEST 1
		node n1=createList1();
		node n2=createList2();
		System.out.println("TEST1:");
		System.out.println("list1:");
		n1.print();
		System.out.println("list2:");
		n2.print();
		node result0=merge2lists(n1, n2);
		System.out.println("resulting merged list is:");
		result0.print();
		System.out.println("--------------------------------");
		
		
		
		//TEST 2
		n1=createList1();
		node n3=createList3();
		System.out.println("TEST2:");
		System.out.println("list1:");
		n1.print();
		System.out.println("list2:");
		n3.print();
		node result1=merge2lists(n1,n3);
		System.out.println("resulting merged list is:");

		result1.print();
		System.out.println("--------------------------------");
		
		
		//TEST 3
		System.out.println("TEST3:");
		System.out.println("list1:");
		System.out.println("NULL");
		System.out.println("list2:");
		
		n3=createList3();
		node n4=null;
		n3.print();
		node result2=merge2lists(n4,n3);
		System.out.println("resulting merged list is:");
		result2.print();
		System.out.println("--------------------------------");

		
		

	}
	
	public static node merge2lists(node l1, node l2){
		 	node preHead = new node(-1);
	        node lastNode = preHead;
	        
	        while (l1 != null && l2 != null) {
	            if (l1.value < l2.value) {
	                lastNode.next = l1;
	                l1 = l1.next;
	            } else {
	                lastNode.next = l2;
	                l2 = l2.next;
	            }
	            lastNode = lastNode.next;
	        }
	        
	        if (l1 != null) {
	            lastNode.next = l1;
	        } else {
	            lastNode.next = l2;
	        }
	        
	        node newHead=preHead.next;
	        return newHead;
	}
	
	public static node createList1(){
		node cur, prev;
		node head=new node(1);
		cur=new node(3);
		head.next=cur;
		prev=cur;
		cur=new node(5);
		prev.next=cur;
		prev=cur;
		cur=new node(7);
		prev.next=cur;
		prev=cur;
		cur=new node(9);
		prev.next=cur;
		prev=cur;
		
		
		
		return head;
	}
	
	
	public static node createList2(){
		node cur, prev;
		node head=new node(2);
		cur=new node(4);
		head.next=cur;
		prev=cur;
		cur=new node(6);
		prev.next=cur;
		prev=cur;
		cur=new node(8);
		prev.next=cur;
		prev=cur;
		cur=new node(10);
		prev.next=cur;
		prev=cur;
		
		
		return head;
	}
	
	
	public static node createList3(){
		node cur, prev;
		node head=new node(6);
		cur=new node(18);
		head.next=cur;
		prev=cur;
		cur=new node(189);
		prev.next=cur;
		prev=cur;
		cur=new node(200);
		prev.next=cur;
		prev=cur;
		cur=new node(999);
		prev.next=cur;
		prev=cur;
		
		
		return head;
	}
	

}
