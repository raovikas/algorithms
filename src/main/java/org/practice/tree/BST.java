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

   //method for inorder traversal
   public static void inorder(Node root){
      if(root!=null){ // checking if the root is not null
         inorder(root.getLeftChild()); // visiting left child
         System.out.print(" "+root.getData()+" "); // printing data at root
         inorder(root.getRightChild()); // visiting right child
      }
   }


   //method for Depth First search preorder traversal
   public static void preorder(Node root)
   {

      if(root!=null)
      {
         System.out.print(" "+ root.getData() + " ");
         preorder(root.getLeftChild());
         preorder(root.getRightChild());
      }

   }

   //method for postorder traversal
   public static void postorder(Node root) {
      if(root!=null) {
         preorder(root.getLeftChild());
         preorder(root.getRightChild());
         System.out.print(" "+ root.getData() + " ");
      }
   }

}
