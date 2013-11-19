/**
 * Queue structure for the Queue ADT.
 * Queue is a first in, first out linked-structure using nodes.
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 *
 */
public class QueueReferenceBased implements QueueInterface
{
    protected Node back;

    /**
     * Constructor for objects of class QueueReferenceBased
     * creates an empty Queue
     */
    public QueueReferenceBased()
    {
        back = null;
    }

    /**
     * determines whether the queue is empty.
     *
     * @return boolean - true if the queue is empty, otherwise returns false
     */
    public boolean isEmpty()
    {
        return back == null;
    }

    /**
     * removes all items of a queue
     *
     */
    public void dequeueAll()
    {
        back = null;
    }

    /**
     * retrieves the item at the front of a queue
     *
     * @return Object - If the queue is not empty, the item that was added most recently is returned.
     * If the queue is empty, the QueueException is thrown
     *
     */
    public Object peek() throws QueueException
    {
        return back.getNext().getItem();
    }

    /**
     * adds an item at the back of a queue
     *
     * @param newItem item to be inserted
     *
     */
    public void enqueue(Object newItem)
    {
        Node newNode = new Node(newItem);
        if(back == null)
            newNode.setNext(newNode);
        else
        {
            newNode.setNext(back.getNext());
            back.setNext(newNode);
        }
        back = newNode;
    }

    /**
     * retrieves and removes the front of a queue
     *
     * @return item - if the queue is not empty, the item that was located in the front of the queue
     * is removed, else the QueueException is thrown
     *
     */
    public Object dequeue() throws QueueException
    {
        if(back != null)
        {
            Object result = back.getNext().getItem();
            if(back == back.getNext())
                back = null;
            else
                back.setNext(back.getNext().getNext());
            return result;
        }
        else
            throw new QueueException("No item to remove.");
    }

    /**
     * toString method to print all the nodes and information on them in a string
     *
     * @return string - returns the string with information of items in the queue
     */
    public String toString()
    {
        Node first = back.getNext();
        String queue = "" + first.getItem() + "\n";
        Node nextItem = back.getNext().getNext();
        while(nextItem != first)
        {
            queue = queue + nextItem.getItem() + "\n";
            nextItem = nextItem.getNext();
        }
        return queue;
    }

    /**
     * calculates the size of the queue
     *
     * returns total - returns the size of the queue
     */
    public int size()
    {
        int total = 1;
        if(isEmpty())
        {
            total = 0;
            return total;
        }
        Node first = back.getNext();
        Node nextItem = back.getNext().getNext();
        while(nextItem != first)
        {
            total++;
            nextItem = nextItem.getNext();
        }
        return total;
    }
}

