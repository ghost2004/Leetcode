/*
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node.

 If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all 
leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
import java.util.LinkedList;
public class PopNextRightP {
    
     public class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
     }
     
     public class TLQueue {
         int level;
         TreeLinkNode node;
     }
     

     
     public void connect(TreeLinkNode root) {
         
         if (root == null)
             return;
         LinkedList<TLQueue> queue = new LinkedList<TLQueue>();
         TLQueue r1 = new TLQueue();
         r1.node = root;
         r1.level = 0;
         TLQueue r2;
         
         queue.addLast(r1);
         while (!queue.isEmpty()) {
             r1 = queue.removeFirst();
             if (queue.isEmpty())
                 r1.node.next = null;
             else {
                 r2 = queue.getFirst();
                 if (r2.level == r1.level)
                     r1.node.next = r2.node;
                 else
                     r1.node.next = null;
             }
             if (r1.node.left != null) {
                 r2 = new TLQueue();
                 r2.level = r1.level + 1;
                 r2.node = r1.node.left;
                 queue.addLast(r2);
             }
             if (r1.node.right != null) {
                 r2 = new TLQueue();
                 r2.level = r1.level + 1;
                 r2.node = r1.node.right;
                 queue.addLast(r2);
             }
                 
         }

         
     }     

}
