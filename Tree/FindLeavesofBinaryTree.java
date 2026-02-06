import java.util.*;

// ----- Tree Node Structure -----
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class FindLeavesofBinaryTree {

    // ===== WRITE YOUR LOGIC HERE =====
    static Map<Integer,List<Integer>> mp=new HashMap<>();
    public static int height(TreeNode root){
        if(root==null) return 0;
         int lh=height(root.left);
         int rh=height(root.right);

         int h=1+Math.max(lh,rh);

         if (!mp.containsKey(h)) {
            mp.put(h, new ArrayList<>());
        }
        mp.get(h).add(root.val);
        return h;
    }
    public static List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // ✍️ YOUR CODE GOES HERE
        height(root);

        for(var i:mp.entrySet()){
            result.add(i.getValue());
        }
        return result;
    }
    // =================================



    // ----- Helper: Build Tree from Array (null as -1) -----
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();

            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.add(cur.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.add(cur.right);
            }
            i++;
        }

        return root;
    }


    // ----- Print Result -----
    public static void print(List<List<Integer>> res) {
        for (List<Integer> level : res) {
            System.out.println(level);
        }
    }


    // ----- MAIN FUNCTION -----
    public static void main(String[] args) {

        // Example Tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        Integer[] input = {1,2,3,4,5,null,null};

        TreeNode root = buildTree(input);

        List<List<Integer>> ans = findLeaves(root);

        print(ans);
    }
}

