import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
    private static MorseCodeTree tree =new MorseCodeTree();

    /**
     * returns a string with all the data in the tree in LNR order with
     * an space in between them. Uses the toArrayList method in MorseCodeTree
     * It should return the data in this order:
     * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
     * Note the extra space between j and b - that is because there is an empty string that is the root,
     * and in the LNR traversal,
     * the root would come between the right most child of the left tree (j) and the left most child of the right tree (b).
     * This is used for testing purposes to make sure the MorseCodeTree has been built properly
     */
    public static String printTree()
    {
        String str="";
        ArrayList<String> list = tree.toArrayList();
        for(int i=0; i<list.size(); i++)
        {
            if (list.get(i)!=" ")
            {
                str+=list.get(i);
                str+=" ";
            }
        }
        return str.trim();
    }
    /**
     * A method that converts a given morse code into English
     * @param code which is the morse code
     */
    public static String convertToEnglish(String code)
    {
        String str= code;
        String engExpression="";
        String letterCode="";


            for (int i=0; i<str.length(); i++)
            {
                if (str.charAt(i)=='.'||str.charAt(i)=='-')
                {
                    letterCode+=String.valueOf(str.charAt(i));
                }
                else if (str.charAt(i)=='/') {
                    engExpression+=" ";
                    
                }
                else if (str.charAt(i)==' ') {
                    if (letterCode!="")
                    {
                        engExpression+= tree.fetch(letterCode);

                    letterCode="";
                    }

                }

                if (i+1==str.length() && letterCode!="") {

                    engExpression+= tree.fetch(letterCode);
                }

            }
        return engExpression;

    }
    /**
     * A method that takes a file and convert its morse code to an English string
     */
    public static String convertToEnglish(java.io.File codeFile)
            throws FileNotFoundException {

        String englishExp = "";

        try {
            Scanner scanner = new Scanner(codeFile);

            while (scanner.hasNextLine()) {
                String line= scanner.nextLine();
                englishExp += convertToEnglish(line);


            }
        } catch (FileNotFoundException e) {
        }

        return englishExp;
    }
}
