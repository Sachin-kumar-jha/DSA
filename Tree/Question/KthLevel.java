package Tree.Question;

import java.util.LinkedList;
import java.util.Queue;

public class KthLevel {
    static class Node{
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    public static void kthLevel(Node root ,int level,int k){
        if(root == null){
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
       
        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);

    }

    public static void levelOrder(Node root,int k){
        Queue<Node>q = new LinkedList<>();

        int level = 1;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    return;
                }else{
                    level++;
                    q.add(null);
                }
            }else{
                if(level==k){
              System.out.print(curr.data + " ");
                }
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
         
            }
          
            
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        levelOrder(root,3);
       kthLevel(root, 1, 3);
    }
}
