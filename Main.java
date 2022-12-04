public class Main {
    public static void main(String[] args) {
        MorseCodeTree codeTree=new MorseCodeTree();
        MorseCodeConverter treeConv =new MorseCodeConverter();
        System.out.println(codeTree.fetch("-..-" ));
        System.out.println(codeTree.toArrayList());
        System.out.println(treeConv.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. "));


    }
}