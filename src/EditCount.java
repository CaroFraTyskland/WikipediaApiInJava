/**
 * Contains methods to retrieve the edit count of users.
 */
public class EditCount {

    /**
     * Returns the edit count of a given user.
     *
     * @param userName     the user's name (should only contain encoded special characters)
     * @param wikiLanguage the language of the Wikipedia (for example "en", "de")
     * @return the number of edits
     */
    public static int getEditCount(String userName, String wikiLanguage) {
        String apiResponse = getEditCountFromApi(userName, wikiLanguage);

        if (apiResponse == null) {
            return 0;
        }

        int indexStart = apiResponse.indexOf("editcount\":") + 11;
        int indexEnd = apiResponse.indexOf("}]");

        if (indexEnd < indexStart) {
            return 0;
        }

        return Integer.parseInt(apiResponse.substring(indexStart, indexEnd));
    }

    /**
     * Retrieves the JSON data containing the edit count of the given user in the given Wikipedia project.
     *
     * @param userName     the user's name
     * @param wikiLanguage the language of the Wikipedia project (for example "en", "de")
     * @return the API response in JSON format
     */
    private static String getEditCountFromApi(String userName, String wikiLanguage) {
        userName = userName.replaceAll(" ", "+");

        String url = "https://" + wikiLanguage + ".wikipedia.org/w/api.php?action=query&list=users&ususers=" + userName
                + "&usprop=editcount&format=json";

        return HttpRequestHelper.makeGetRequest(url);
    }
}