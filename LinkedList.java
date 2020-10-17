
public class LinkedList<E>
{
    class Node<E>
    {
        E value;
        Node<E> next;

        Node(E value)
        {
          this.value = value;
          this.next = null;
        }
    }
    private Node<E> head;
    private int size;

  // 6 Functions
  public LinkedList()
  {
 
    head = null;
    size = 0;
  }
  public void add(E item)
  {
    Node<E> current = head;
    Node<E> newNode = new Node<E>(item);
    if(head==null) // if nothing in the list
    {
      head = newNode; // set the head node to the value of item held by NewNode
    }
    else
    {
      for(int i = 1; i<size;i++)
      {
       current = current.next; //set current node to the index position
      }
      current.next = newNode; //set node pointer to the newnode
    }
    ++size;
  }
  public void add(E item, int position)
  {
    Node<E> current = head; // current node
    Node<E> prev = head; // previous node
    Node<E> newNode = new Node<E>(item); //new node tha story the value of the item E

    if((position>size)||(position<0)) //check validation
      return;

    if(position==0) // if added item is at index 0
    {
      newNode.next = head;
      head = newNode;
    }
    else
    {
      for(int i = 0; i<position;i++)
      {
        prev = current; //set previous node point to current node
        current = current.next; // loop through the list and set current to the index position
      }
      newNode.next = current;// set new node point to the current node
      prev.next = newNode; // replace the previous node with the node at newNode
    }
    size++;
  }
  public E get(int position)
  {
    Node<E> current = head;
    if((position>size)||(position<0))//check validation
      return null;
    else
    {
      for(int i = 0; i<position;i++)
      {
        current = current.next; // set node point to to the desire index
      }
      return current.value; //return the value of that node
    }
  }
  public E remove(int position)
  {
    Node<E> current = head;
    Node<E> prev = null;

    if((position<0)||(position>=size)) // check validation
    {
      return null;
    }

    else if(position==0) // if the item was at index 0
    {
      head = head.next;
      size--;
      return head.value;
    }

    else if(position<size)
    {
      for(int i = 0; i<position&&current!=null;i++)
      {
        prev = current;
        current = current.next;
      }
      //System.out.println("###"+prev.value);
      prev.next = current.next;//skip the variable at the position
      size--;
    }
    return current.value;
  }
  public E reverse() //couldn't do the same as in the instruction so I changed the  param
  {
    //add code here
    Node<E> current = head;
    Node<E> prev = null;
    Node<E> newNode = null;
    
    while(current!=null)
    {
    	newNode = current.next;
    	current.next = prev;
    	prev = current;
    	current = newNode;
    }
    head = prev;
    return head.value;
  }

  public String toString()
  {
    String result = "[";
    Node<E> current = head;
    for(int i = 0; i < size; i++)
    {
      result += current.value;
      current = current.next;

      if(i<size-1)
      {
        result+=", ";
      }
    }
    result+="]";
    return result;
  }
  public static void main(String[] args)
  {
    LinkedList<Object> input = new LinkedList<Object>();
    LinkedList<Object> input2 = new LinkedList<Object>();
    LinkedList<Object> input3 = new LinkedList<Object>();
    LinkedList<Object> input4 = new LinkedList<Object>();
    LinkedList<Object> input5 = new LinkedList<Object>();
    for(int i = 0; i<5;i++)
    {
    	input.add(i+1);
    	input2.add(i+1);
    	input3.add(i+1);
    	input4.add(i+1);
    	input5.add(i+1);
    }
    System.out.println("Add 6");
    System.out.println("Given List: "+input);
    input.add(6);
    System.out.println("Output: "+input);
    System.out.println();

    System.out.println("Add 6 at index 0");
    System.out.println("Given List: "+input2);
    input2.add(6,0);
    System.out.println("Output: "+input2);
    System.out.println();

    System.out.println("Get position 2");
    System.out.println("Given List: "+input3);
    System.out.println(input3.get(2));
    System.out.println("Output: "+input3);
    System.out.println();

    System.out.println("Remove position 4");
    System.out.println("Given List: "+input4);
    System.out.println(input4.remove(4));
	System.out.println("Output: "+input4);
	System.out.println();

	System.out.println("Reverse");
    System.out.println("Given List: "+input5);
    System.out.println(input5.reverse());
    System.out.println("Output: "+input5);

  }
 
}
