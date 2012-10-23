
import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

public class LevelTravel {

    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public class ValPack {
        private TreeNode node;
        private int level;
    }
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        
        
        if (root == null)
            return out;
        ValPack p =  new ValPack();
        p.node = root;
        p.level = 0;
        LinkedList<ValPack> nodeList = new LinkedList<ValPack>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        nodeList.addLast(p);
        int curLevel = 0;
        while (nodeList.size() != 0) {
            p = nodeList.removeFirst();
            if (p.level != curLevel) {
                out.add(item);
                item = new ArrayList<Integer>();
                curLevel = p.level;
            }
            item.add(p.node.val);
            
            if (p.node.left != null) {
                ValPack v = new ValPack();
                v.level = curLevel + 1;
                v.node = p.node.left;
                nodeList.addLast(v); 
            }
            if (p.node.right != null) {
                ValPack v = new ValPack();
                v.level = curLevel + 1;
                v.node = p.node.right;
                nodeList.addLast(v); 
            }
                
        }
        
        out.add(item);
        
        return out;

    }
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
                
        if (root == null)
            return out;
        ValPack p =  new ValPack();
        p.node = root;
        p.level = 0;
        LinkedList<ValPack> nodeList = new LinkedList<ValPack>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        nodeList.addLast(p);
        int curLevel = 0;
        while (nodeList.size() != 0) {
            p = nodeList.removeFirst();
            if (p.level != curLevel) {
                stack.push(item);
                item = new ArrayList<Integer>();
                curLevel = p.level;
            }
            item.add(p.node.val);
            
            if (p.node.left != null) {
                ValPack v = new ValPack();
                v.level = curLevel + 1;
                v.node = p.node.left;
                nodeList.addLast(v); 
            }
            if (p.node.right != null) {
                ValPack v = new ValPack();
                v.level = curLevel + 1;
                v.node = p.node.right;
                nodeList.addLast(v); 
            }
                
        }
        out.add(item);
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        
        return out;
        
    }
    
    
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        
        
        if (root == null)
            return out;
        ValPack p =  new ValPack();
        p.node = root;
        p.level = 0;
        LinkedList<ValPack> nodeList = new LinkedList<ValPack>();
        LinkedList<ValPack> list = new LinkedList<ValPack>();
        nodeList.addLast(p);
        int curLevel = 0;
        while (nodeList.size() != 0) {
            p = nodeList.removeFirst();
            
            if (p.level != curLevel) {
                ArrayList<Integer> item = new ArrayList<Integer>();
                while (!list.isEmpty()) {
                    if (curLevel % 2 == 0)
                        item.add(list.removeFirst().node.val);
                    else
                        item.add(list.removeLast().node.val);
                }
                out.add(item);
                list = new LinkedList<ValPack>();
                curLevel = p.level;
            }
            
            list.addLast(p);
            if (p.node.left != null) {
                ValPack v = new ValPack();
                v.node = p.node.left;
                v.level = p.level + 1;
                nodeList.addLast(v);
            }
            if (p.node.right != null) {
                ValPack v = new ValPack();
                v.node = p.node.right;
                v.level = p.level + 1;
                nodeList.addLast(v);
            }
           
        }
        ArrayList<Integer> item = new ArrayList<Integer>();
        while (!list.isEmpty()) {
            
            if (curLevel % 2 == 0)
                item.add(list.removeFirst().node.val);
            else
                item.add(list.removeLast().node.val);
        }
        out.add(item);
        return out;
    }
}
