
public class ListNode {

	private Object object;
	public ListNode next;
	public ListNode prev;
	
	public ListNode() {
		this.object=null;
		this.next=null;
		this.prev=null;
	}
	
	public ListNode(Object object) {
		this.object=object;
		this.next=null;
		this.prev=null;
	}
	
	

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "ListNode [object=" + object + ", next=" + next + "]";
	}

	
	
}



