
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
    if(head==null)
    {
      head = newNode;
    }
    else
    {
      for(int i = 1; i<size;i++)
      {
       current = current.next;
      }
      current.next = newNode;
    }
    ++size;
  }
  public void add(E item, int position)
  {
    Node<E> current = head;
    Node<E> prev = head;
    Node<E> newNode = new Node<E>(item);
    if((position>size)||(position<0))
      return;
    if(position==0)
    {
      newNode.next = head;
      head = newNode;
    }
    else
    {
      for(int i = 0; i<position;i++)
      {
        prev = current;
        current = current.next;
      }
      newNode.next = current;
      prev.next = newNode;
    }
    size++;
  }
  public E get(int position)
  {
    Node<E> current = head;
    if((position>size)||(position<0))
      return null;
    else
    {
      for(int i = 0; i<position;i++)
      {
        current = current.next;
      }
      return current.value;
    }
  }
  public E remove(int position)
  {
    Node<E> current = head;
    Node<E> prev = null;

    if((position<0)||(position>=size))
    {
      return null;
    }
    else if(position==0)
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
  public E reverse(E head)
  {
    //add code here
    return null;
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

    input.add(1);
    input.add(2);
    input.add(3);
    input.add(4);
    input.add(5);
    System.out.println(input);
    input.add(6);
    System.out.println(input);
    input.add(7,0);
    System.out.println(input);
    System.out.println(input.get(2));
    System.out.println(input.remove(1));
    System.out.println(input);

  }
 
}
