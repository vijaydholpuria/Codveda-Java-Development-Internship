import java.util.Scanner;

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {

    TreeNode root;

    public TreeNode insert(TreeNode root, int data) {

        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public boolean search(TreeNode root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public TreeNode delete(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private int minValue(TreeNode root) {

        int min = root.data;

        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }

        return min;
    }

    public void inorder(TreeNode root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void preorder(TreeNode root) {

        if (root != null) {

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(TreeNode root) {

        if (root != null) {

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class BinarySearchTree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BST tree = new BST();

        while (true) {

            System.out.println("\n===== BINARY SEARCH TREE =====");
            System.out.println("1. Insert Node");
            System.out.println("2. Search Node");
            System.out.println("3. Delete Node");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    tree.root = tree.insert(tree.root, value);

                    System.out.println("Node Inserted.");
                    break;

                case 2:

                    System.out.print("Enter value to search: ");
                    int search = sc.nextInt();

                    if (tree.search(tree.root, search)) {
                        System.out.println("Node Found.");
                    } else {
                        System.out.println("Node Not Found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter value to delete: ");
                    int delete = sc.nextInt();

                    tree.root = tree.delete(tree.root, delete);

                    System.out.println("Node Deleted.");
                    break;

                case 4:

                    System.out.print("Inorder Traversal: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 5:

                    System.out.print("Preorder Traversal: ");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;

                case 6:

                    System.out.print("Postorder Traversal: ");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case 7:

                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}