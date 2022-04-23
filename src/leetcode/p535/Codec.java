package leetcode.p535;
// https://leetcode.com/problems/encode-and-decode-tinyurl/

import java.util.HashMap;
import java.util.Map;

public class Codec {

    private Integer cnt= 0;
    private Map<Integer,String> urls = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.put(cnt, longUrl);
        return "http://jooncco.com/"+(cnt++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String str[]= shortUrl.split("/");
        Integer key= Integer.parseInt(str[str.length-1]);
        return urls.get(key);
    }
}