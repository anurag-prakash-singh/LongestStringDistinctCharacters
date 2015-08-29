import java.util.Hashtable;

/**
 * Created by anurags on 8/29/15.
 */
public class Main {
    private static String getLongestSubStringDistinctCharacters(String str) {
        String distinctCharSubstring = null;
        int maxLength = 0, length = 0;
        int startOffset = -1;
        Hashtable<Character, Integer> lastOffsetMap =
                new Hashtable<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            if (!lastOffsetMap.containsKey(str.charAt(i))) {
                length++;

                if (length > maxLength) {
                    maxLength = length;

                    startOffset = i - maxLength + 1;
                }
            } else {
                int lastOffset = lastOffsetMap.get(str.charAt(i));

                if (lastOffset < i - length) {
                    length++;

                    if (length > maxLength) {
                        maxLength = length;
                        startOffset = i - maxLength + 1;
                    }
                } else {
                    length = i - lastOffset;
                }
            }

            lastOffsetMap.put(str.charAt(i), i);
        }

        distinctCharSubstring = str.substring(startOffset, startOffset + maxLength);

        return distinctCharSubstring;
    }

    private static void test() {
        String[] strs = new String[] {
                "abcdaea",
                "abcdaef",
                "abcadaef",
                "aaaba",
                "aaaa",
                "abdbfghibd"
        };

        for (String str : strs) {
            System.out.println(String.format("%s => %s",
                    str,
                    getLongestSubStringDistinctCharacters(str)));
        }
    }

    public static void main(String[] args) {
        test();
    }
}
