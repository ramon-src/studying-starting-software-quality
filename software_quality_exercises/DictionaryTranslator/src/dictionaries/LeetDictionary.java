package dictionaries;

import tools.Map;

public class LeetDictionary extends DictionaryAbstract {

    private Map<Integer, String> dictionary;

    public LeetDictionary() {
        String[] alphabet = {"@", "|:", "[", "|>", "&", "ph", "c-", "#", "!", "(/", "x", "1_"
                , "|v|", "/v", "()", "|*", "(_,)", "12", "$", "+", "|_|", "\\/", "VV", ")(", "`/", "%", "l", "r",
                "e", "a", "s", "b", "t", "b", "g", "o"
        };
        dictionary = createDictionary(alphabet);
        SEPARATE_WORD = "    ";
        SEPARATE_LETTER = " ";
    }

    @Override
    public Map<Integer, String> getDictionary() {
        return dictionary;
    }

    public String getWordSeparator() {
        return SEPARATE_WORD;
    }

    public String getLetterSeparator() {
        return SEPARATE_LETTER;
    }
}
