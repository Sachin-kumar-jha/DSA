package Tree.Impl;

public class HeightOfTree {
    
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

  static int idx=-1;
    public static Node buildTree(int nodes[]){
    idx++;
   if(nodes[idx]==-1) return null;
    Node newNode = new Node(nodes[idx]);
    newNode.left=buildTree(nodes);
    newNode.right=buildTree(nodes);
    return newNode;  
    }

    public static  void  Prorder(Node root){ //linear O(n)
            if (root == null){
           // System.out.print(-1 +" ");
            return;
            }
            System.out.print(root.data+" ");
            Prorder(root.left);
            Prorder(root.right);
            
       }

    public static int height(Node root){
      if(root==null) return 0;
      int lfh=height(root.left);
      int rfh=height(root.right);

      int rooth=Math.max(lfh,rfh)+1;
      return rooth;
    }

     public static int calculateNodes(Node root){
      if(root==null) return 0;
      int lfc=calculateNodes(root.left);
      int rfc=calculateNodes(root.right);
      return lfc+rfc+1;
    }

    public static void main(String[] args) {
  int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
   Node tree=buildTree(nodes);
     Prorder(tree);
//  System.out.print(height(tree));
 System.out.println(calculateNodes(tree));
    }
}
