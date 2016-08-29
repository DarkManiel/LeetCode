/**
 * Created by markdaniel on 6/20/16.
 */
public class Justify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String wordLine = sc.nextLine();
        wordLine = wordLine.replace("\"", "").replace(" ", "");
        wordLine = wordLine.replace(" ", "");

        String[] words = wordLine.split(",");
        int lineLen = sc.nextInt();

        System.out.println(fullJustify(words, lineLen));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        // Total space used by words for a given line
        int currentLineOffset = 0;
        int curLine = 0;

        /**
         *  For each word, get the offset including past single spaces. Then either add it to the curLine or line below.
         */
        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];
            int offset = curWord.length() + currentLineOffset;

            if (offset < (maxWidth - 1)) {
                // Add to current line and can still fit more here.
                addWord(lines, curLine, curWord);
                currentLineOffset = offset + 1;
            } else {
                if (offset <= maxWidth) {
                    // Add to current line, but must increm curLine since we're at the edge.
                    addWord(lines, curLine, curWord);
                    curLine++;
                    currentLineOffset = 0;
                } else {
                    // No space for this word, so must add to next line.
                    curLine++;
                    addWord(lines, curLine, curWord);
                    currentLineOffset = curWord.length() + 1;
                }

            }
        }

        List<String> res = new ArrayList<>();
        int index = 0;

        /**
         * Handle justification based on specs and write to sb.
         * Specs:
         * * Extra spaces distributed as evenly as possible
         * * If uneven for a line, start stacking from left
         * * Last line of text should be left aligned with no extra space
         */
        for (List<String> list : lines) {
            StringBuilder sb = new StringBuilder();

            if (index == lines.size() - 1) {
                // Handling left alignment for last line
                for (int i = 0; i < list.size(); i++) {
                    sb.append((i == 0) ? list.get(i) : " " + list.get(i));
                }

                int widToAdd = maxWidth - sb.length();
                for (int i = 0; i < widToAdd; i++) {
                    sb.append(" ");
                }
            } else {
                // Handling evenly distributed justification
                int wordGroupLen = 0;
                int wordNum = list.size();
                for (String s : list) {
                    wordGroupLen += s.length();
                }

                int baseAddition = maxWidth - wordGroupLen;
                int excess = baseAddition % (((wordNum - 1) > 0) ? (wordNum - 1) : 1);
                baseAddition -= excess;
                baseAddition /= ((wordNum - 1) > 0) ? (wordNum - 1) : 1;


                for (int i = 0; i < list.size() - 1; i++) {
                    sb.append(list.get(i));
                    for (int j = 0; j < baseAddition; j++) {
                        sb.append(" ");
                    }
                    sb.append((excess > 0) ? " " : "");
                    excess--;
                }

                sb.append(list.get(list.size() - 1));

                if (list.size() == 1) {
                    for (int j = 0; j < baseAddition; j++) {
                        sb.append(" ");
                    }
                }
            }

            res.add(sb.toString());
            index++;
        }

        return res;
    }

    public static void addWord(List<List<String>> lines, int curLine, String curWord) {
        List wordsInLine = (lines.size() > curLine) ? lines.get(curLine) : new ArrayList();
        if (lines.size() > curLine) {
            wordsInLine.add(curWord);
            lines.set(curLine, wordsInLine);
        } else {
            wordsInLine.add(curWord);
            lines.add(wordsInLine);
        }

    }
}