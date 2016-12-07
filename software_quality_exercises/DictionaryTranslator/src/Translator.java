import dictionaries.DictionaryAbstract;
import exceptions.DictionaryEmptyException;

import tools.Map;

public class Translator {

    private String phrase;
    private String phraseTranslated;
    private DictionaryAbstract from;
    private DictionaryAbstract to;
    private String translatedWord = "";
    private String translatedLetter;
    private boolean hasNoLetterSeparator;

    public Translator() {
    }

    public Translator(DictionaryAbstract defaultDictionary) {
        from = defaultDictionary;
    }

    public Map<Integer, String> getOriginDictionary() {
        return from.getDictionary();
    }

    public Translator thePhrase(String phrase) {
        this.phrase = phrase.toLowerCase();
        return this;
    }

    public Translator from(DictionaryAbstract dictionary) {
        if (!dictionary.equals(null))
            from = dictionary;
        return this;
    }

    public Translator to(DictionaryAbstract dictionary) {
        if (!dictionary.equals(null))
            to = dictionary;
        return this;
    }

    public String translate() throws DictionaryEmptyException {
        if (!(to instanceof DictionaryAbstract))
            throw new DictionaryEmptyException();

        hasNoLetterSeparator = from.getLetterSeparator().isEmpty();

        String[] words = phrase.split(from.getWordSeparator());
        if (hasNoLetterSeparator) {
            for (String word : words) {
                translateFromDictionariesThatDontHaveLettersSeparators(word);
            }
        } else {
            for (String word : words) {
                translateFromDictionariesThatHaveLettersSeparators(word);
            }
        }
        phraseTranslated = translatedWord.trim();
        return phraseTranslated;
    }

    private void concatTheWordSeparator(){
        translatedWord += to.getWordSeparator();
    }

    private void translateFromDictionariesThatHaveLettersSeparators(String word) {
        String[] letters = word.split(from.getLetterSeparator());
        int wordSize = letters.length;
        int iterator = 0;
        for (String letter : letters) {

            if (fromDictionaryContainsLetter(letter)) {
                transformTheLetter(letter);
                addSeparatorIfIsNotTheEnd(iterator, wordSize);
            } else {
                translatedLetter = "?";
                addLetterAndSeparatorIfContains();
            }
            iterator++;
        }
        concatTheWordSeparator();
    }

    private void translateFromDictionariesThatDontHaveLettersSeparators(String word) {
        int length = word.length();
        for (int letterPosition = 0; letterPosition < length; letterPosition++) {
            String letter = String.valueOf(word.charAt(letterPosition));
            if (fromDictionaryContainsLetter(letter)) {
                transformTheLetter(letter);
                addSeparatorIfIsNotTheEnd(letterPosition, length);
            } else {
                translatedLetter = "?";
                addSeparatorIfIsNotTheEnd(letterPosition, length);
            }
        }
        concatTheWordSeparator();
    }

    private void transformTheLetter(String letter) {
        Integer key = (Integer) from.getDictionary().getReverse().get(letter);
        translatedLetter = (String) to.getDictionary().get(key);
    }

    private void addLetterAndSeparatorIfContains() {
        String addSeparatorOrNot = (hasNoLetterSeparator) ? "" : to.getLetterSeparator();
        translatedWord += translatedLetter + addSeparatorOrNot;
    }

    private void addSeparatorIfIsNotTheEnd(int iteration, int length) {
        String addSeparatorOrNot = (iteration == (length - 1)) ? "" : to.getLetterSeparator();
        translatedWord += translatedLetter + addSeparatorOrNot;
    }

    private boolean fromDictionaryContainsLetter(String letter) {
        return from.getDictionary().getReverse().containsKey(letter);
    }
}
