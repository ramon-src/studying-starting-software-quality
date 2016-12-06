package tools;

import java.util.HashMap;

public class Map<Integer, String>  extends HashMap<Integer, String> {
    private HashMap<String, Integer> reverse;

    public Map(){
        reverse = new HashMap<String, Integer>();
    }

    public String put(Integer integer, String s) {
        super.put(integer, s);
        reverse.put(s, integer);
        return null;
    }

    public HashMap<String, Integer> getReverse() {
        return reverse;
    }

}
