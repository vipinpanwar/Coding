class Node:
    def __init__(self,data):
        self.data=data
        self.left=None
        self.right=None

def leftView(root,level,max_level):
    if root is None:
        return
    
    if(max_level[0]<level):
        print(max_level,level)
        print("%d\t"%(root.data))
        max_level[0]=level
        

    leftView(root.left,level+1,max_level)
    leftView(root.right,level+1,max_level)



root = Node(12) 
root.left = Node(10) 
root.right = Node(20) 
root.right.left = Node(25) 
root.right.right = Node(40) 
max_level=[0]
leftView(root, 1, max_level) 