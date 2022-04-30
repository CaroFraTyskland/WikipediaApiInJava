package userStats;

import helper.HttpRequestHelper;

import java.util.ArrayList;

public class ArticleList {

    public static void main(String[] args) {
        printArticles("CaroFraTyskland");
    }

    public static void printArticles(String userName) {
        ArrayList<String> articles = getArticles(userName, true);

        for (String article : articles) {
            System.out.println(article.replaceAll("_", " "));
        }
    }

    public static ArrayList<String> getArticles(String userName, boolean withReplacements) {
        ArrayList<String> articles = new ArrayList<>();
        String jsonData = getArticleListFromApi(userName);

        while (jsonData.contains("title")) {
            int indexStart = jsonData.indexOf("title\":") + 8;
            int indexEnd = jsonData.indexOf("\",\"timestamp\"");

            String articleName = jsonData.substring(indexStart, indexEnd);

            if (withReplacements) {
                articleName = replaceUnicode(articleName);
            }

            articles.add(articleName);

            int next = jsonData.indexOf("}") + 1;
            jsonData = jsonData.substring(next);
        }

        return articles;
    }

    /**
     * Retrieves and returns the JSON data with a list of all articles by a certain user.
     *
     * @param userName the user's name (should only contain encoded special characters)
     * @return the API response in JSON format
     */
    private static String getArticleListFromApi(String userName) {
        userName = userName.replaceAll(" ", "+");

        String url = "https://pageviews.toolforge.org/userviews/api.php?username=" + userName + "&project=de.wikipedia.org&redirects=0&namespace=0&format=json";

        return HttpRequestHelper.makeGetRequest(url);
    }

    public static String replaceUnicode(String text) {
        text = text.replaceAll("\\\\u00e5", "å");
        text = text.replaceAll("\\\\u00f8", "ø");
        text = text.replaceAll("\\\\u00f6", "ö");
        text = text.replaceAll("\\\\u00e4", "ä");
        text = text.replaceAll("\\\\u00e6", "æ");
        text = text.replaceAll("\\\\u00c5", "Å");
        text = text.replaceAll("\\\\u00d8", "Ø");
        text = text.replaceAll("\\\\u00e1", "á");
        text = text.replaceAll("\\\\u00c1", "Á");
        text = text.replaceAll("\\\\u0161", "š");
        text = text.replaceAll("\\\\u00e9", "é");
        text = text.replaceAll("\\\\u2013", "–");
        text = text.replaceAll("\\\\u00fc", "ü");
        text = text.replaceAll("\\\\u00f3", "ó");
        text = text.replaceAll("\\\\u00df", "ß");
        text = text.replaceAll("\\\\u00c4", "Ä");
        text = text.replaceAll("\\\\u0113", "ē");
        text = text.replaceAll("\\\\u014d", "ō");
        text = text.replaceAll("\\\\u2019", "’");
        text = text.replaceAll("\\\\u1e6d", "ṭ");
        text = text.replaceAll("\\\\u2026", "…");
        text = text.replaceAll("\\\\u00d6", "Ö");
        text = text.replaceAll("\\\\u1e24", "ō");
        text = text.replaceAll("\\\\u012b", "Ḥ");
        text = text.replaceAll("\\\\u0101", "ī");
        text = text.replaceAll("\\\\u014d", "ā");
        text = text.replaceAll("\\\\u0131", "ı");
        text = text.replaceAll("\\\\u00e7", "ç");
        text = text.replaceAll("\\\\u015a", "Ś");
        text = text.replaceAll("\\\\u0119", "ę");
        text = text.replaceAll("\\\\u011f", "ğ");
        text = text.replaceAll("\\\\u0160", "Š");
        text = text.replaceAll("\\\\u1e2b", "ḫ");
        text = text.replaceAll("\\\\u0107", "ć");
        text = text.replaceAll("\\\\u0151", "ő");
        text = text.replaceAll("\\\\u0130", "İ");
        text = text.replaceAll("\\\\u015f", "ş");
        text = text.replaceAll("\\\\u00eb", "ë");
        text = text.replaceAll("\\\\u00dc", "Ü");
        text = text.replaceAll("\\\\u0146", "ņ");
        text = text.replaceAll("\\\\u010d", "č");
        text = text.replaceAll("\\\\u00e3", "ã");
        text = text.replaceAll("\\\\u00ed", "í");
        text = text.replaceAll("\\\\u0159", "ř");
        text = text.replaceAll("\\\\u011b", "ě");
        text = text.replaceAll("\\\\u0142", "ł");
        text = text.replaceAll("\\\\u017e", "ž");
        text = text.replaceAll("\\\\u00e8", "è");
        text = text.replaceAll("\\\\u0141", "Ł");
        text = text.replaceAll("\\\\u017c", "ż");
        text = text.replaceAll("\\\\u00c9", "É");
        text = text.replaceAll("\\\\u016b", "ū");
        text = text.replaceAll("\\\\u00fa", "ú");
        text = text.replaceAll("\\\\u0144", "ń");
        text = text.replaceAll("\\\\u014c", "Ō");
        text = text.replaceAll("\\\\u201c", "“");
        text = text.replaceAll("\\\\u201e", "„");
        text = text.replaceAll("\\\\u0117", "ė");
        text = text.replaceAll("\\\\u017d", "Ž");
        text = text.replaceAll("\\\\u015b", "ś");
        text = text.replaceAll("\\\\u017a", "ź");
        text = text.replaceAll("\\\\u0148", "ň");
        text = text.replaceAll("\\\\u00ef", "ï");
        text = text.replaceAll("\\\\u00fd", "ý");
        text = text.replaceAll("\\\\u0103", "ă");
        text = text.replaceAll("\\\\u02bf", "ʿ");
        text = text.replaceAll("\\\\u1e33", "ḳ");
        text = text.replaceAll("\\\\u010c", "Č");
        text = text.replaceAll("\\\\u00e2", "â");
        text = text.replaceAll("\\\\u021a", "Ț");
        text = text.replaceAll("\\\\u021b", "ț");
        text = text.replaceAll("\\\\u0218", "Ș");
        text = text.replaceAll("\\\\u0137", "ķ");
        text = text.replaceAll("\\\\u0219", "ș");
        text = text.replaceAll("\\\\u00f5", "õ");
        text = text.replaceAll("\\\\u00f4", "ô");
        text = text.replaceAll("\\\\u00fe", "þ");
        text = text.replaceAll("\\\\u0153", "œ");
        text = text.replaceAll("\\\\u013d", "Ľ");
        text = text.replaceAll("\\\\u0105", "ą");
        text = text.replaceAll("\\\\u00ee", "î");
        text = text.replaceAll("\\\\u0110", "Đ");
        text = text.replaceAll("\\\\u0111", "đ");
        text = text.replaceAll("\\\\u0106", "Ć");
        text = text.replaceAll("\\\\u015e", "Ş");
        text = text.replaceAll("\\\\u02bb", "ʻ");
        text = text.replaceAll("\\\\u00f1", "ñ");
        text = text.replaceAll("\\\\u013c", "ļ");
        text = text.replaceAll("\\\\u016f", "ů");
        text = text.replaceAll("\\\\u00e0", "à");
        text = text.replaceAll("\\\\u1ead", "ậ");
        text = text.replaceAll("\\\\u00c7", "Ç");
        text = text.replaceAll("\\\\u00d3", "Ó");
        text = text.replaceAll("\\\\u017b", "Ż");
        text = text.replaceAll("\\\\u0259", "ə");
        text = text.replaceAll("\\\\u018f", "Ə");
        text = text.replaceAll("\\\\u00ea", "ê");
        text = text.replaceAll("\\\\u00da", "Ú");
        text = text.replaceAll("\\\\u00cd", "Í");
        text = text.replaceAll("\\\\u00b0", "°");
        text = text.replaceAll("\\\\u0136", "Ķ");
        text = text.replaceAll("\\\\u00d7", "×");
        text = text.replaceAll("\\\\u0171", "ű");

        return text;
    }
}