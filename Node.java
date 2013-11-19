/**
 * Node implementation used for storing in queue ADT
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 *
 */

public class Node
{
    private Object item;
    private Node next;
    private Node back;

    /**
     * Constructor to create a Node by just stating the item
     *
     * @param newItem Object newItem to be set to a Node
     *
     */
    public Node(Object newItem)
    {
        item = newItem;
        next = null;
    } // end constructor

    /**
     * Constructor to create a Node by stating item, and the Node that
     * follows it in the queue of nodes
     *
     * @param newItem Object newItem to be set to a Node
     * @param nextNode Node to be set to follow node being added
     *
     */
    public Node(Object newItem, Node nextNode)
    {
        item = newItem;
        next = nextNode;
    } // end constructor

    /**
     * Constructor to create a Node by stating item, and the Node that
     * is to be located behind it, and in front of it in the queue.
     * This is to help place the item in the correct spot
     *
     * @param backNode Node to be set to be previous to the new node added
     * @param newItem Object newItem to be set to a Node
     * @param nextNode Node to be set to follow node being added
     *
     */
    public Node(Node backNode, Object newItem, Node nextNode)
    {
        back = backNode;
        item = newItem;
        next = nextNode;
    } // end constructor

    /**
     * mutator method to set the item in the node
     *
     * @param newItem Object to replace current item in the node
     *
     */
    public void setItem(Object newItem)
    {
        item = newItem;
    } // end setItem

    /**
     * accessor method to return the item that is currently in the node
     *
     * @return item - returns Object located in the node
     */
    public Object getItem()
    {
        return item;
    } // end getItem

    /**
     * mutator method to set the node to come next in the queue after the current one
     * being worked on.
     *
     * @param nextNode Node to be set to follow the node being modified at the moment
     */
    public void setNext(Node nextNode)
    {
        next = nextNode;
    } // end setNext

    /**
     * mutator method to set the node that is located back on position to the current node.
     *
     * @param backNode Node to be set to precede the node being modified at the moment
     */
    public void setBack(Node backNode)
    {
        back = backNode;
    } // end setBack

    /**
     * accessor method to return the node that procedes the current node
     *
     * @return next - returns the next Node in the queue following the current node
     */
    public Node getNext()
    {
        return next;
    } // end getNext

    /**
     * accessor method to return the Node that precedes the current node
     *
     * @return back - returns the back Node in the queue behind the current node
     */
    public Node getBack()
    {
        return back;
    } // end getBack
} // end class Node
