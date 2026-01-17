class Solution {

    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        // store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(0, inorder.length - 1, postorder);
    }

    private TreeNode build(int start, int end, int[] postorder) {

        if (start > end)
            return null;

        // root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        // build RIGHT first
        root.right = build(mid + 1, end, postorder);
        root.left = build(start, mid - 1, postorder);

        return root;
    }
}
