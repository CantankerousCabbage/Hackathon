from Stack import Stack
import json

def display(stack):
    node = stack.list.head
    while node != None:
        print(node.data)
        node = node.next
        
#################################################
# Task 1: implement sort_stack function
################################################
def sort_stack(s_stack):
    #
    # your code goes here 
    #
    tmp_stack = Stack()
    temp = ''
    
    while s_stack:
        curr = s_stack.pop()
        
        while tmp_stack and tmp_stack.peek() < curr:
            s_stack.push(tmp_stack.pop())
            
        tmp_stack.push(curr)
        
    return tmp_stack

    
 
if __name__ == '__main__':
         
    stack_to_sort = Stack()

    json_file = ''
    pre_parsed_json = json.loads(json_file)
   
