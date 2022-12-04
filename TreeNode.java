public class TreeNode<T> {
    public TreeNode rightChild;
    public TreeNode leftChild;
    public String data;
    /**
     *
     * Constructors
     */
    public TreeNode(String dataEntry){
        rightChild=null;
        leftChild=null;
        data=dataEntry;
    }
    public TreeNode(TreeNode<T> tree){
        rightChild=tree.rightChild;
        leftChild=tree.leftChild;
        data=tree.data;

    }
    /**
     *
     * Getter
     */
    public String getData()
    {
        return data;
    }


}
