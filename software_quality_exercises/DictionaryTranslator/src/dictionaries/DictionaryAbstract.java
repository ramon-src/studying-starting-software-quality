package dictionaries;

import tools.Map;

public abstract class DictionaryAbstract implements IDictionary{

    protected String SEPARATE_WORD;
    protected String SEPARATE_LETTER;

    protected Map<Integer, String> createDictionary(String[] alphabet) {
        Map<Integer, String> newDictionary = new Map<>();
        int index = 0;

        for (String letter : alphabet) {
            newDictionary.put(index++, letter);
        }
        return newDictionary;
    }

}
