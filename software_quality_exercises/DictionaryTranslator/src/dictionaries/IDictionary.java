package dictionaries;

import tools.Map;

public interface IDictionary {
    String SEPARATE_LETTER = null;
    String SEPARATE_WORD = null;

    Map getDictionary();

    String getWordSeparator();
    String getLetterSeparator();

}
