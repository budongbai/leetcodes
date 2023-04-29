package algorithm.offer;

import algorithm.offer.binarytree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return deserialize(dataList);
    }

    public String serialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        return str;
    }

    public TreeNode deserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);

        return root;
    }
}
