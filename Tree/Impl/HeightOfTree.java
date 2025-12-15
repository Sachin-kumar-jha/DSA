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

    public static int sumOfNodes(Node root){
        if(root == null) return 0;
       int lfcSum= sumOfNodes(root.left);
      int rfcSum= sumOfNodes(root.right);   
     return lfcSum+rfcSum+root.data;
    }


    static class Info{
        int diam;
        int ht;
        Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    /*APPROACH 1 */
    public static int calculateDiameter1(Node root){
        if(root==null)return 0;
        int ldiam=calculateDiameter1(root.left);
        int rdiam=calculateDiameter1(root.right);

        int selfdiam=height(root.left)+height(root.right)+1;

        return Math.max(Math.max(ldiam,rdiam),selfdiam);
    }

     /*APPROACH 2 */
    public static Info calculateDiameter2(Node root){

        if(root==null) return new Info(0, 0);
        Info lftInfo=calculateDiameter2(root.left);
        Info rftInfo=calculateDiameter2(root.right);
         
        int diam = Math.max(Math.max(lftInfo.diam, rftInfo.diam),lftInfo.ht+rftInfo.ht+1);
        int ht=Math.max(lftInfo.ht, rftInfo.ht)+1;

return new Info(diam, ht);
    }


    public static void main(String[] args) {
  int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
   Node tree=buildTree(nodes);
//      Prorder(tree);
// //  System.out.print(height(tree));
//  System.out.println(calculateNodes(tree));

System.out.println(calculateDiameter2(tree).diam);

//  System.out.println(sumOfNodes(tree));
    }
}
