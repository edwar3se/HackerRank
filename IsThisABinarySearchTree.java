/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
     
     FALSE if:  left node is equal or greater than root, 
                anything on left side of tree is greater than original root,
                right node is less than or equal to root,
                anything on right side of tree is greater than original root
*/

    boolean checkBST(Node root) 
    {
        if (root == null)
            return true;
        
        return left(root.left, root.data) && right(root.right, root.data);
    }

    boolean left(Node root, int original)
    {
        
        if(root.data >= original)
            return false;
        
        if(root.left != null && root.right != null)
        {
            if(root.left.data >= root.data || root.right.data <= root.data)
                return false;
            
            return left(root.left, original) && left(root.right, original);
        }
        
        return true;
    }

    boolean right(Node root, int original)
    {
        
        if(root.data <= original)
            return false;
        
        if((root.left == null && root.right != null) || (root.left != null && root.right == null))
            return false;
        
        if(root.left != null && root.right != null)
        {
            
            if(root.left.data >= root.data || root.right.data <= root.data)
                return false;
            
            return right(root.left, original) && right(root.right, original);
        }
        
        return true;
    }

