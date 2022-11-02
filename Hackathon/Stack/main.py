from stack import Stack
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

    #json_tags = ['07337', '07338','07339', '07340', '07341', '07343', '07347', '07354', '07356', '06994', '06998', '07001', '07003', '07003',
    # '07005', '070007', '02979', '02980', '02983', '02988'] 

    with open('AutoClave5 JSON Files/AC2-07337-anon.json', 'r') as json_file:
        json_dict = json.load(json_file)
        #print(json_dict)
        
        print(json_dict.keys())
        #Add to stack

    
   
