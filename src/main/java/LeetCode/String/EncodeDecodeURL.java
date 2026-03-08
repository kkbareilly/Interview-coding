package LeetCode.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeDecodeURL {
    private Map<String, String> urls = new HashMap<>();

    public String encode(String longUrl) {
        String path = generateRandomString(longUrl);
        urls.put(path, longUrl);

        return path;
    }

    public String decode(String shortUrl) {
        return urls.get(shortUrl);
    }

    private String generateRandomString(String longUrl) {
        String symb = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder result = new StringBuilder(6);

        for(int i = 0; i < 6; i++) {
            result.append(symb.charAt(random.nextInt(symb.length())));
        }

        return result.toString();
    }
}
