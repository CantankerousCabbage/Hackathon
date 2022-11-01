from Node import Node
from LinkedList import LinkedList

class Stack:
    def __init__(self):
        self.list = LinkedList()
        
     
    # New - True if stack is NOT empty
    def __bool__(self):
        if self.list.head:
            return True
        else:
            return False

    def push(self, new_item):
        # Create a new node to hold the item
        new_node = Node(new_item)
        
        # Insert the node as the list head (top of stack)
        self.list.prepend(new_node)
    
    def pop(self):
        # If the stack is empty return None
        if self.list.head == None:
            return None

        # Copy data from list's head node (stack's top node)
        popped_item = self.list.head.data
        
        # Remove list head
        self.list.remove_after(None)
        
        # Return the popped item
        return popped_item

    # New - see what is on the top of the stack
    def peek(self):
        ret_val = self.list.head.data
        return ret_val