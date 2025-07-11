public class WordSearch {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"Hello world", "Java programming", "ChatGPT is helpful"};
        String word = "Java";
        System.out.println("Sentence found: " + findSentence(sentences, word));
    }
}