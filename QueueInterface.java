
/**
 * Interface for QueueReferenceBased class
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 *
 */
public interface QueueInterface
{

    /**
     * determines whether a queue is empty.
     *
     * @see QueueReferenceBased method - isEmpty()
     */
    public boolean isEmpty();
    // Determines whether a queue is empty.
    // Precondition: None.
    // Postcondition: Returns true if the queue is empty;
    // otherwise returns false.

    /**
     * adds an item at the back of a queue
     *
     * @see QueueReferenceBased method - enqueue(Object newItem)
     */
    public void enqueue(Object newItem) throws QueueException;
    // Adds an item at the back of a queue.
    // Precondition: newItem is the item to be inserted.
    // Postcondition: If the operation was successful, newItem
    // is at the back of the queue. Some implementations
    // may throw QueueException if newItem cannot be added
    // to the queue.

    /**
     * retrieves and removes the front of a queue
     *
     * @see QueueReferenceBased method - dequeue() throws QueueException
     */
    public Object dequeue() throws QueueException;
    // Retrieves and removes the front of a queue.
    // Precondition: None.
    // Postcondition: If the queue is not empty, the item that
    // was added to the queue earliest is removed. If the queue is
    // empty, the operation is impossible and QueueException is thrown.

    /**
     * removes all items of a queue.
     *
     * @see QueueReferenceBased method - dequeueAll()
     */
    public void dequeueAll();
    // Removes all items of a queue.
    // Precondition: None.
    // Postcondition: The queue is empty.

    /**
     * retrieves the item at the front of a queue
     *
     * @see QueueReferenceBased method - peek() throws QueueException
     */
    public Object peek() throws QueueException;
    // Retrieves the item at the front of a queue.
    // Precondition: None.
    // Postcondition: If the queue is not empty, the item
    // that was added to the queue earliest is returned.
    // If the queue is empty, the operation is impossible
    // and QueueException is thrown.
}  // end QueueInterface

