import java.util.Iterator;

public interface ListInterface {
	

	
  	public boolean isEmpty(); //LISTO   //REVISADA

    public int getSize(); //LISTO   //REVISADA

    public void clear();//LISTO   //REVISADA

    public Object getHead(); //LISTO //REVISADA

    public Object getTail(); //LISTO //REVISADA

    public Object search(Object object); //LISTO //REVISADA

    public boolean add(Object object); //LISTO  //REVISADA

    public boolean insert(Object ob, Object object);//LISTO //REVISADA

    public boolean insertHead(Object object); //LISTO //REVISADA

    public boolean insertTail(Object object); //LISTO //REVISADA

    
    
    
    /*
    expansion operations
     */
    
    public boolean contains(Object object);//LISTO //REVISADA

    public boolean isEquals(Object object);//LISTO //REVISADA

    public Iterator<ListNode> iterator();//LISTO

    public Object[] toArray();//LISTO //REVISADA

    public Object[] toArray(Object[] object);//LISTO //REVISADA

    public Object getBeforeTo();//LISTO //REVISADA

    public Object getNextTo();//LISTO //REVISADA

    public ListDouble sortList(); //LISTO //REVISADA
    
    
    
    //NODOS
     
    public Object get(ListNode node);//LISTO  //REVISADA
    
    public boolean set(ListNode node, Object object);//LISTO //REVISADA

    public boolean remove(ListNode node);//LISTO //REVISADA
    
    public boolean insert(ListNode node, Object object);// LISTO //REVISADA
    
    public Object getBeforeTo(ListNode node);//LISTO //REVISADA
    
    public Object getNextTo(ListNode node);//LISTO //REVISADA

    public ListDouble subList(ListNode from, ListNode to);//LISTO //REVISADA

}
