/**
 * @author tariq
 */
import java.util.ArrayList;
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
private TreeNode<String> root;

    /**
     * Constructor
     */
    public MorseCodeTree() {
        buildTree();
    }
    /**
     * Returns a reference to the root
     * @return reference to root
     */
public TreeNode getRoot()
{
    return this.root;
}
    /**
     * sets the root of the Tree
     * @param newNode a TreeNode<T> that will be the new root
     */
public void setRoot(TreeNode newNode){
    this.root=newNode;
}
    /**
     * A method that takes morse code of a letter an insert in the appropriate position in the tree
     * @param code  which is morse code
     * @param letter  which is the letter added for the morse code
     */
public void insert(String code, String letter){
    addNode(this.root, code, letter);

}
    /**
     * A method that takes morse code of a letter and add the letter in the appropriate position in the tree
     * @param code  which is morse code
     * @param letter  which is the letter added for the morse code
     * @param root which is the root of tree that morse code letters will be added to
     */
    public void addNode (TreeNode root, String code, String letter)
    {
    if (code.length()==1)
    {
        if(code.charAt(0)=='-') {
            root.rightChild=new TreeNode<String>(letter);
        }
        else if (code.charAt(0)=='.') {
            root.leftChild=new TreeNode<String>(letter);
        }
    }
    else {
        if(code.charAt(0)=='-')
        {
            addNode(root.rightChild, code.substring(1),letter);
        }
        if(code.charAt(0)=='.')
        {
            addNode(root.leftChild, code.substring(1),letter);
        }
    }
    }
    /**
     * A method that takes morse code of a letter and the root of the tree and gets the letter associated with morse code
     * @param code  which is morse code
     * @param root which is the root of tree that morse code letters will be added to
     */
    public String fetchNode(TreeNode<String> root, String code){

    if (code.length()==1)
    {
        if(code.charAt(0)=='-') {
            return root.rightChild.getData();
        }
        else if (code.charAt(0)=='.') {
            return root.leftChild.getData();
        }
    }
    else {
        if(code.charAt(0)=='-')
        {
           return fetchNode(root.rightChild, code.substring(1));
        }
        if(code.charAt(0)=='.')
        {
            return fetchNode(root.leftChild, code.substring(1));
        }
    }
    return null;
}
    /**
     * A method that takes morse code of a letter and gets the English letter associated with the morse code
     * @param code  which is morse code
     */
    public String fetch(String code) {
        return fetchNode(getRoot(), code);
    }
    /**
     * A recursive method that takes a given root of tree and stores its element in an inorder approach
     * @param root which is the root of tree that morse code letters will be added to
     * @param list an array list that the letters in the tree will be stored in it in an inorder
     */
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
    {
        if(root !=null)
        {
            LNRoutputTraversal(root.leftChild,list);
            list.add(root.getData());
            LNRoutputTraversal(root.rightChild,list);
        }

    }
    /**
     * A method that stores morse code letters tree in an inorder in  an arraylist
     */
    public java.util.ArrayList<String> toArrayList()
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        LNRoutputTraversal(getRoot(),arrayList);
        return arrayList;

    }
    /**
     * A method that construct the tree of morse code
     */
    public void buildTree()
    {
        // root level 0
        setRoot(new TreeNode<String>(""));
        // level 1
        insert(".", "e");
        insert("-", "t");

        // level 2
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");

        // level 3
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");

        // level 4
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }
    /**
     * This operation is not supported for a LinkedConverterTree
     * @param data data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    }
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException();
    }

}
