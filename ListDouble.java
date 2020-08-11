import java.util.Iterator;

public class ListDouble implements ListInterface, Iterable<ListNode> {
	
	
	private ListNode inode;
	private int size;
	
	public ListNode head;
	public ListNode tail;
	
	
    public ListDouble() {
		this.head = null;
		this.tail = null;
		size = 0;
	}
    
    public ListDouble(Object object) {
		this.head = new ListNode();
		this.tail = head;
	}
    
    public void recorrer() {
    	ListNode pointer=tail;
    	while(pointer!=null) {
    		System.out.println(pointer.toString());
    		pointer=pointer.prev;
    	}
    }

	@Override
	public boolean isEmpty() {
		return head==null;
	}

	@Override
	public int getSize() {
    	/*
    	ListNode pointer=head;
    	int cont=0;
    	while(pointer.next!=null) {
    		pointer=pointer.next;
    		cont++;
    	}
    	*/
		return size;
	}

	@Override
	public void clear() {
		try {
			 if(!isEmpty()) {
				 ListNode pointer = head;
	    		 while(pointer.next.next!=null) {
	    			 pointer=pointer.next;
	    		 }
	    		 pointer.next=null;
	    		 head=null;
	    		}
			}catch(Exception e) {
				System.out.println("se limpio");  
			}
		
	}

	@Override
	public Object getHead() {
		return head.getObject();
	}

	@Override
	public Object getTail() {
		return tail.getObject();
	}

	@Override
	public Object get(ListNode node) {
		ListNode pointer=head;
		while(pointer.next!=null) {
			if(pointer.toString().equals(node.toString())) {
				return pointer.getObject();
			}
    		pointer=pointer.next;
    	}
		return null;
	}

	@Override
	public Object search(Object object) {
		ListNode pointer=head;
    	while(pointer.next!=null) {
    		if(pointer.getObject().toString().equals(object.toString())) {
    			return pointer;
    		}
    		pointer=pointer.next;
    	}
    	
		return null;
	}

	
	
	public ListNode searchNode(Object object) {
		ListNode pointer=head;
    	while(pointer.next!=null) {
    		if(pointer.getObject().toString().equals(object.toString())) {
    			return pointer;
    		}
    		pointer=pointer.next;
    	}
    	
		return null;
	}	
	
	
	
	
	@Override
	public boolean add(Object object) {
		ListNode node = new ListNode(object);
		if(isEmpty()) {
    		head=node;
    		head.next=null;
    		head.prev=null;
    		tail=head;
    		size++;
    	}else {
    		tail.next=node;
    		node.prev=tail;
    		node.next=null;
    		tail=node;
    		size++;
    	}
    	
    	return false;
		
	}

	@Override
	public boolean insert(ListNode node, Object object) {
		ListNode node1 = new ListNode(object);
		ListNode pointer =head;
		while(pointer.next!=null) {
			if(pointer.toString().equals(node.toString())) {
				node1.next=pointer.next.prev;
				node1.prev=pointer.prev.next;
				pointer.prev.next=node1;
				pointer.next.prev=node1;
				return true;
			}
    		pointer=pointer.next;
    	}
		
		return false;
	}

	@Override
	public boolean insert(Object ob, Object object) {
		try {
			if(ob != null) {
				ListNode pointer = (ListNode) this.search(object);
				if(pointer.next==null) {
					add(object);
					size++;
				}else {
					ListNode node = new ListNode(object);
					node.next=pointer.next.prev;
					node.prev=pointer.prev.next;
					pointer.prev.next=node;
					pointer.next.prev=node;
					size++;
				}
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insertHead(Object object) {
		ListNode node= new ListNode(object);
		if(isEmpty()) {
			head=node;
			size++;
		}else {
			node.next=head;
			head.prev=node;
			head=node;
			size++;
		}
		return false;
	}

	@Override
	public boolean insertTail(Object object) {
		ListNode node= new ListNode(object);
		if(isEmpty()) {
			head=node;
			size++;
			 
		}else {
			ListNode pointer=head;
			while(pointer.next!=null) {
				pointer=pointer.next;
			}
			pointer.next=node;
			node.prev=pointer;
			size++;
		}
		return false;
	}

	@Override
	public boolean set(ListNode node, Object object) {
		ListNode pointer=node.prev;
		this.remove(node);
		this.insert(pointer, object);
	
		return true;
	}

	@Override
	public boolean remove(ListNode node) {
		ListNode pointer=head;
		while(pointer.next!=null) {
			if(pointer.toString().equals(node.toString())) {
				pointer.prev.next=node.next;
				pointer.next.prev=node.prev;
				return true;
			}
    		pointer=pointer.next;
    	}
		return false;
	}

	@Override
	public boolean contains(Object object) {
    	ListNode pointer=head;
    	while(pointer.next!=null) {
    		if(pointer.getObject().toString().equals(object.toString())) {
    			return true;
    		}
    		pointer=pointer.next;
    	}
        return false;
	}

	@Override
	public boolean isEquals(Object object) {
    	ListNode pointer=head;
    	while(pointer.next!=null) {
    		if(pointer.getObject().toString().equals(object.toString())) {
    			return true;
    		}
    		pointer=pointer.next;
    	}
        return false;
	}

	@Override
	public Iterator<ListNode> iterator() {
		 inode = head;
         Iterator<ListNode> i = new Iterator<ListNode>() {
             @Override
             public boolean hasNext() {
                 return inode.next != null ? true : false;
             }

             @Override
             public ListNode next() {
                 if (hasNext()) {
                     ListNode tmp = inode;
                     inode = inode.next;
                     return tmp;
                 } else {
                     return null;
                 }
             }
         };
         return i;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
    	ListNode pointer=head;
    	try {
    		for (int i = 0; i < array.length; i++) {
    			if(pointer!=null) {
    				array[i]= getTo(pointer);
    				pointer=pointer.next;
    			}else {break;}
    	
    		}
    	}catch(Exception e) {
    		
    	}
        return array;
	}

	@Override
	public Object[] toArray(Object[] object) {
		Object[] array = new Object[size];
    	ListNode pointer=head;
    	try {
    		for (int i = 0; i < array.length; i++) {
    			if(pointer!=null) {
    				array[i]= getTo(pointer);
    				pointer=pointer.next;
    			}else {break;}
    	
    		}
    	}catch(Exception e) {
    		
    	}
        return array;
	}

	@Override
	public Object getBeforeTo() {
		return tail.prev.getObject();
	}

	@Override
	public Object getBeforeTo(ListNode node) {
		ListNode pointer =head;
		while(pointer.next!=null) {
			if(pointer.toString().equals(node.toString())) {
				return pointer.prev;
			}
    		pointer=pointer.next;
    	}

		return null;
	}

	@Override
	public Object getNextTo() {
		return head.next.getObject();
	}

	@Override
	public Object getNextTo(ListNode node) {
		ListNode pointer =head;
		while(pointer.next!=null) {
			if(pointer.toString().equals(node.toString())) {
				return pointer.next;
			}
    		pointer=pointer.next;
    	}

		return null;
	}

	@Override
	public ListDouble subList(ListNode from, ListNode to) {
    	ListDouble list = new ListDouble();
    	ListNode pointer =head;
		while(pointer.next!=null) {
			if(pointer.toString().equals(from.toString())) {
				pointer=from;
				break;
			}
    		pointer=pointer.next;
    	}
    	while(pointer.next!=to) { 
    		list.add(pointer.getObject());
    		pointer=pointer.next;
    	}
    	list.add(pointer.getObject());
    	
        return list;
	}
	
	//OBTENER UN VALOR
	public Object getTo(ListNode node) {
		if(node.next==null) {
			return node.getObject();
		}else {
			//getTo(node.next);
			return node.getObject();
		}	
		 
	}
	

	@Override
	public ListDouble sortList() {
    	ListDouble ob=new ListDouble();
    	Object[] array = new Object[size];
    	ListNode pointer=head;
    	try {
    		for (int i = 0; i < array.length; i++) {
    			if(pointer!=null) {
    				array[i]= getTo(pointer);
    				pointer=pointer.next;
    			}else {
    				break;
    			}
    	
    		}
    	}catch(Exception e) {
    		
    	}
    
       //METODO DE BURBUJA
       int tmp=0;
       for(int i = 0; i < size; i++){
    	  for (int k = 1; k < (array.length-i); k++) {
			if((int) array[k-1] > (int) array[k]) {
				tmp=(int)array[k-1];
				array[k-1]=array[k];
				array[k]=tmp;
			}
		}
       } 
    	  
    	for (int m = 0; m < array.length; m++) {
			ob.add(array[m]);
		}
    	
        return ob;
	}
	
	
    //RECURSIVIDAD
	public void rec(ListNode node) {
		if(node.next==null) {
			System.out.println(node.toString());
		}else {
			 
			System.out.println(node.toString());
			rec(node.next);
		}	
	}
 
}
