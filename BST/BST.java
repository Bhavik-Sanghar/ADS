package BST;

//Binary Search Tree

class Node{
    int key;
    Node left, right;

    public Node(int item){
        key = item;
        left = right = null;
    }
}

class BinaryTree{
    Node root;

    public BinaryTree(){
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.key)
            root.left = insertRec(root.left, key);
        else if(key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key){
        if(root == null)
            return false;
        if(root.key == key)
            return true;
        else if(key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.print(root.key + " , ");
            inorderRec(root.right);
        }
    }

}


class BST {
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        /* Let us create the following BST
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 
        */

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print inorder traversal of the BST 
        System.out.println("Inorder traversal of the BST:");
        bst.inorder();
        System.out.println();

         // Search for a key
         System.out.println("Search for 40: " + bst.search(40));
         System.out.println("Search for 100: " + bst.search(100));
    }

}
