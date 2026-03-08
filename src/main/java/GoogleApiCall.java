import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.CustomsearchRequestInitializer;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class GoogleApiCall {


    public static void main(String[] args) throws Exception {
       /* String searchQuery = " cricket world cup 2023 news"; //The query to search
        String cx = "002845322276752338984:vxqzfa86nqc"; //Your search engine

        //Instance Customsearch
        Customsearch cs = new Customsearch.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                .setApplicationName("clari-nylas-integration")
                .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer("AIzaSyDtp0Hzzdr6n5ktg4ZvFKgmHrYx-8yA0z4"))
                .build();

        //Set search parameter
        Customsearch.Cse.List list = cs.cse().list(searchQuery).setCx(cx);

        //Execute search
        Search result = list.execute();
        if (result.getItems()!=null){
            for (Result ri : result.getItems()) {
                //Get title, link, body etc. from search
                System.out.println(ri.getTitle() + ", " + ri.getLink());
            }
        }*/
        searchGoogle();
    }


    public static void searchGoogle(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpTransport httpTransport = new NetHttpTransport();
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
            url.put("query", "cricket world cup 2023 news");
            url.put("limit", "1000");
            url.put("indent", "true");
            url.put("key", "AIzaSyDtp0Hzzdr6n5ktg4ZvFKgmHrYx-8yA0z4");
            HttpRequest request = requestFactory.buildGetRequest(url);
            HttpResponse httpResponse = request.execute();
            String responseString = httpResponse.parseAsString();

            JsonNode node = mapper.readTree(responseString).get("itemListElement").get(0).get("result");
            System.out.println(node.get("name"));
            System.out.println(node.get("@type"));
            System.out.println(node.get("detailedDescription").get("articleBody"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

 class GoogleResults {

    private ResponseData responseData;
    public ResponseData getResponseData() { return responseData; }
    public void setResponseData(ResponseData responseData) { this.responseData = responseData; }
    public String toString() { return "ResponseData[" + responseData + "]"; }

    static class ResponseData {
        private List<Result> results;
        public List<Result> getResults() { return results; }
        public void setResults(List<Result> results) { this.results = results; }
        public String toString() { return "Results[" + results + "]"; }
    }

    static class Result {
        private String url;
        private String title;
        public String getUrl() { return url; }
        public String getTitle() { return title; }
        public void setUrl(String url) { this.url = url; }
        public void setTitle(String title) { this.title = title; }
        public String toString() { return "Result[url:" + url +",title:" + title + "]"; }
    }

}