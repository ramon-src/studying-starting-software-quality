package dictionaries;

import tools.Map;

public abstract class DictionaryAbstract implements IDictionary{
    protected Map<Integer, String> createDictionary(String[] alphabet) {
        Map<Integer, String> newDictionary = new Map<>();
        int index = 0;

        for (String letter : alphabet) {
            newDictionary.put(index++, letter);
        }
        return newDictionary;
    }

}
