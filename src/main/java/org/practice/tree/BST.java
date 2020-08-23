package org.practice.tree;

import java.util.ArrayDeque;
import java.util.Queue;
//Binary Search Tree
public class BST
{
   static class Node
   {
      private int data;
      private Node left;
      private Node right;

      private Node(int data)
      {
         this.data = data;
      }

      public void setRightChild(Node n)
      {
         right = n;
      }

      public void setLeftChild(Node n)
      {
         left = n;
      }

      public Node getRightChild()
      {
         return right;
      }

      public Node getLeftChild()
      {
         return left;
      }

      public int getData()
      {
         return data;
      }

      public void setData(int x)
      {
         data = x;
      }
   }

   public static void main(String[] args)
   {
      Node root;
      root = new Node(20);
      insert(root, 5);
      insert(root, 1);
      insert(root, 15);
      insert(root, 9);
      insert(root, 7);
      insert(root, 12);
      insert(root, 30);
      insert(root, 25);
      insert(root, 40);
      insert(root, 45);
      insert(root, 42);

      inorder(root);
      System.out.println("");
      preorder(root);
      System.out.println("");
      postorder(root);
      System.out.println("");
      /*
      20
    /    \
   /      \
  5       30
/   \     /\
/     \   /  \
1      15 25  40
   /          \
  /            \
 9             45
/   \          /
/     \        /
7      12      42
       */



      bfs(root);
      int h = findHeight(root);
      System.out.println("height of binary tree:  "+h);

      deleteNode(root,42);
      System.out.println("inorder of binary tree after deletion of node having value 42:");
      inorder(root);
      System.out.println("");
      Node successorNode = findInorderSuccessor(root, 5);//Node has right subtree
      System.out.println("inorder successor of node with value 5 is : "+successorNode.getData());
      Node successorNode1 = findInorderSuccessor(root, 7);//No right subtree
      System.out.println("inorder successor of node with value 7 is : "+successorNode1.getData());


      Node preNode = findInorderPredecessors(root, 30);//Node has left subtree
      System.out.println("inorder Predecessor of node with value 30 is : "+preNode.getData());
      Node preNode1 = findInorderPredecessors(root, 40);//No left subtree
      System.out.println("inorder Predecessor of node with value 40 is : "+preNode1.getData());
   }



   private static Node deleteNode(Node root, int value)
   {
      if(root == null) return root;
      else if(root.getData()>value)
         root.setLeftChild(deleteNode(root.getLeftChild(), value));
      else if(root.getData()<value)
         root.setRightChild(deleteNode(root.getRightChild(), value));
      else
      {
         //we find the root which need to delete
         if(root.getLeftChild()==null && root.getRightChild() == null)//if node is leaf node
         {
            root = null;
         }
         else if(root.getRightChild() == null)
         {
            root = root.getLeftChild();
         }
         else if(root.getLeftChild()==null)
         {
            root = root.getRightChild();
         }
         else
         {
            Node temp = findMin(root.getRightChild());
            root.setData(temp.getData());
            root.setRightChild(deleteNode(root.getRightChild(), temp.getData()));
         }
      }
      return root;
   }



   private static Node findMin(Node root)
   {
      if(root==null)
         System.out.println("root node is null");
      else if(root.getLeftChild()!=null)
         findMin(root.getLeftChild());

      return root;
   }



   //Breadth first Search Traversal
   private static void bfs(Node root)
   {
      if(root==null) return;
      Queue<Node> queue = new ArrayDeque<Node>();
      queue.add(root);
      while(!queue.isEmpty())
      {
         Node node = queue.poll();
         System.out.print(" "+node.getData()+" ");
         Node leftChild = node.getLeftChild();
         if(leftChild!=null)
            queue.add(leftChild);
         Node rightChild = node.getRightChild();
         if(rightChild!=null)
            queue.add(rightChild);

      }
      System.out.println("");

   }



   private static Node insert(Node root, int element)
   {
      if (root == null)
      {
         root = new Node(element);
      }
      else if (element > root.data)// element is greater. Should be inserted to right
      {
         root.setRightChild(insert(root.getRightChild(), element));
      }
      else {// x is smaller or equal should be inserted to left
         root.setLeftChild(insert(root.getLeftChild(),element));
      }
      return root;
   }

   //method for inorder traversal <left><root><right>
   public static void inorder(Node root){
      if(root!=null){ // checking if the root is not null
         inorder(root.getLeftChild()); // visiting left child
         System.out.print(" "+root.getData()+" "); // printing data at root
         inorder(root.getRightChild()); // visiting right child
      }
   }


   //method for Depth First search preorder traversal <root><left><right>
   public static void preorder(Node root)
   {

      if(root!=null)
      {
         System.out.print(" "+ root.getData() + " ");
         preorder(root.getLeftChild());
         preorder(root.getRightChild());
      }

   }

   //method for postorder traversal <left><right><root>
   public static void postorder(Node root) {
      if(root!=null) {
         preorder(root.getLeftChild());
         preorder(root.getRightChild());
         System.out.print(" "+ root.getData() + " ");
      }
   }

   /*
    * Height of a binary tree = number of edges in longest path from root to a leaf node
    */
   public static int findHeight(Node root)
   {
      if(root == null)
         return -1;
      int leftHeight = findHeight(root.getLeftChild());
      int rightHeight = findHeight(root.getRightChild());
      return Math.max(leftHeight, rightHeight)+1;
   }

   public static Node findInorderSuccessor(Node root,int data)
   {
      if(root == null) return null;
      Node current = find(root,data);
      if(current.getRightChild()!=null)//case 1 node has right subtree
      {
         Node temp = current.getRightChild();
         while(temp.getLeftChild()!=null)
         {
            temp = temp.getLeftChild();
         }
         return temp;
      }
      //case 2 no right subtree
      else
      {
         Node ancestor = root;
         Node successor = null;
         while(ancestor!=current) {
            if(ancestor.getData()>current.getData())
            {
               successor = ancestor;
               ancestor  = ancestor.getLeftChild();
            }
            else
            {
               ancestor = ancestor.getRightChild();
            }
         }
         return successor;
      }

   }


   public static Node findInorderPredecessors(Node root , int data){
      if(root == null) return null;
      Node current = find(root, data);
      //case 1 Node has left subtree
      if(current.getLeftChild()!=null)
         return  findMax(current.getLeftChild());

      else {
         Node predecessor = null;
         Node ancester = root;
         while(ancester!=current)
         {
            if(current.getData()>ancester.getData())
            {
               predecessor = ancester;
               ancester = ancester.getRightChild();
            }
            else
               ancester = ancester.getLeftChild();
         }
         return predecessor;
      }
   }

   private static Node findMax(Node root)
   {
      Node max = root;
      while(root.getRightChild()!=null)
         max = root.getRightChild();
      return max;
   }



   private static Node find(Node root, int data)
   {
      if(root == null) return null;
      while(root.getData()!=data) {
         if(root.getData()> data)
            root = root.getLeftChild();
         else
            root = root.getRightChild();
      }
      return root ;
   }
}
