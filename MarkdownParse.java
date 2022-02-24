// // File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.ArrayList;

// public class MarkdownParse {
//     public static ArrayList<String> getLinks(String markdown) {
//         ArrayList<String> toReturn = new ArrayList<>();
//         // find the next [, then find the ], then find the (, then take up to
//         // the next )
//         int currentIndex = 0;
//         while(currentIndex < markdown.length()) {
//             int nextOpenBracket = markdown.indexOf("[", currentIndex);
//             if(nextOpenBracket == -1){
//                 int closeParen = markdown.indexOf(")", currentIndex);
//                 int nextCloseBracket = markdown.indexOf("]", closeParen);
//                 toReturn.add(markdown.substring(closeParen + 1, nextCloseBracket));
//                 return toReturn;
//             }
//             // helps test-file2.md
//             if(markdown.indexOf("]") == -1){
//                 int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
//                 int openParen = markdown.indexOf("(", nextCloseBracket);
//                 int closeParen = markdown.indexOf(")", openParen);
//                 toReturn.add(markdown.substring(openParen + 1, closeParen));
//                 currentIndex = closeParen + 1;
//                 return toReturn;
//             }
//             int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
//             // helps test-file4.md
//             if(markdown.indexOf("(") == -1 && markdown.indexOf(")") == -1){
//                 if(markdown.indexOf("[]") != -1){
//                     toReturn.add(markdown.substring(nextCloseBracket + 1));
//                     return toReturn;
//                 }
//                 toReturn.add(markdown.substring(nextOpenBracket + 1, nextCloseBracket));
//                 return toReturn;
//             }
//             int openParen = markdown.indexOf("(", nextCloseBracket);
//             int closeParen = markdown.indexOf(")", openParen);
//             toReturn.add(markdown.substring(openParen + 1, closeParen));
//             currentIndex = closeParen + 1;
//         }
//         return toReturn;
//     }
//     public static void main(String[] args) throws IOException {
// 		Path fileName = Path.of(args[0]);
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> links = getLinks(contents);
//         System.out.println(links);
//     }

//     public static int subtract(int a, int b){
//         return a - b;
//     }

// }

// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1) {
                break;
            }
            if(nextOpenBracket > 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
                break;
            }
            int nextCloseBracket = markdown.indexOf("](", nextOpenBracket);
            if(nextCloseBracket == -1) {
                break;
            }
            int closeParen = markdown.indexOf(")", nextCloseBracket);
            toReturn.add(markdown.substring(nextCloseBracket + 2, closeParen));
            currentIndex = closeParen + 1;
            // System.out.format("%d\t%d\t%d\t%d\n", currentIndex, nextOpenBracket, nextCloseBracket, closeParen);
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}