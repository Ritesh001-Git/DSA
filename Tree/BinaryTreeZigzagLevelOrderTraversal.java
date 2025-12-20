import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans=new ArrayList<>();
        int i=1;
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer> arr=new ArrayList<>();
            for(int j=0; j<sz; j++){
                TreeNode temp=q.poll();
                arr.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            if(i%2==0){
                Collections.reverse(arr);
                ans.add(arr);
            }else{
                ans.add(arr);
            }
            i++;
        }
        return ans;
    }
}
