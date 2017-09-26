/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
     
For the purposes of this challenge, we define a binary search tree to be a binary tree with the following ordering properties:

The  value of every node in a node's left subtree is less than the data value of that node.
The  value of every node in a node's right subtree is greater than the data value of that node.


Given the root node of a binary tree, can you determine if it's also a binary search tree?
*/
    /*given a pointer to the root of the tree, returns true if the tree is a binary search
    tree and false otherwise */
    boolean checkBST(Node root) 
    {
        if (root == null)
            return true;
        
        return checkTree(root).check;
    }


    NodeInfo checkTree(Node root)
    {
        //set min and max to value of current node
        int min = root.data;
        int max = root.data;
        
        if(root.left != null && root.right != null)
        {
            //do stuff with the left side
            NodeInfo left = checkTree(root.left);
            if(!left.check || (left.max >= root.data))
            {
                //return false result
                return new NodeInfo(false, 0 ,0);
            }
            min = left.min;
            
            //do stuff with the right 
            NodeInfo right = checkTree(root.right);
            if(!right.check || (right.min <= root.data))
            {
                //return false result
                return new NodeInfo(false, 0, 0);
            }
            max = right.max;
        }
        
        return new NodeInfo(true, max, min);
    }

    class NodeInfo
    {
        boolean check;
        int max;
        int min;
        
        public NodeInfo(boolean check, int max, int min)
        {
            this.check = check;
            this.max = max;
            this.min = min;
        }
    }

