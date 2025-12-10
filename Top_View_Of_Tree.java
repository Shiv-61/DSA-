 import java.util.*;
 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode(int val) { data = val; left = null;right = null; }
 } 
public class Top_View_Of_Tree {
    public static List<Integer> topView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if(root==null)
            return arr;
        TreeNode node = root;
        if(node.left!=null){
        node = node.left;
        while(node!=null){
            arr.add(node.data);
            node = node.left;
        }
        }
        Collections.reverse(arr);
        arr.add(root.data);
        node = root;
        if(node.right!=null){
        node = node.right;
         while(node!=null){
            arr.add(node.data);
            node = node.right;
        }   
        }
        return arr;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        
        root.right.left = new TreeNode(90);
        root.right.right = new TreeNode(100);
        System.out.println(topView(root));
    }   
}
