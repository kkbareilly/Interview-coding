package StringPermutation;

import java.io.*;
import java.lang.reflect.Type;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Arsecium {

    /*
     * Complete the 'calculateNAV' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING date as parameter.
     */

    public static void main(String[] args) throws IOException {
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       // String date = bufferedReader.readLine();

        double result = Arsecium.calculateNAV("20190101");
        System.out.println("result"+result);

      //  bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

      //  bufferedReader.close();
      //  bufferedWriter.close();
    }
    public static double calculateNAV(String date) {

        StringBuffer response = null;
        Double results=0.0d;
        List<Integer> result = new ArrayList();
        try {
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");

            String readLine = null;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            ArrayList<Integer> list=new ArrayList<>();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                response = new StringBuffer();
                while ((readLine = br.readLine()) != null) {
                    response.append(readLine);
                }
                br.close();
                Gson gson = new Gson();
                // System.out.println(response.toString());
                Map<String,Double> price= getPricing(date);
                Type listType = new TypeToken<ArrayList<Security>>() {}.getType();
               // ArrayList<Security> users = new Gson().fromJson(list , listType);
                ArrayList<Security> securityData = gson.fromJson(response.toString(),listType );

                for(Security security:securityData){
                    if(security.getDate().toString().equals(date)) {
                        Double ps = price.get(security.getSecurity());
                        if (ps != null) {
                            results = results + (ps * security.getQuantity());
                            System.out.println("Security" + security.getSecurity() + "   quantity" + security.getQuantity() + " Price:" + ps + " Results:" + results);

                        }
                    }
                }

            }
        } catch (Exception e) {

        }
        System.out.println("Results"+results);

        return results;

    }
    public static Map<String,Double> getPricing(String date) {

        StringBuffer response = null;
        List<Integer> result = new ArrayList();
        Map<String,Double> price=null;
        try {


            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing");

            String readLine = null;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            ArrayList<Integer> list=new ArrayList<>();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                response = new StringBuffer();
                while ((readLine = br.readLine()) != null) {
                    response.append(readLine);
                }
                br.close();
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Price>>() {}.getType();
                ArrayList<Price> prices = gson.fromJson(response.toString(),listType);
               System.out.println(prices.get(0).getDate());
                price= prices.stream().filter(p->p.getDate().equals(Long.parseLong(date)+"")).collect(Collectors.toMap(Price::getSecurity, Price::getPrice));
                price.entrySet().stream().forEach(a->System.out.println("from map"+a.getKey()));
            }
        } catch (Exception  e) {
          System.out.println(e);
        }
        return price;

    }


}


class NameList {
    List<Security> list;
    List<Price> prices;
    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
    public List<Security> getList() {
        return list;
    }

    public void setList(List<Security> list) {
        this.list = list;
    }
}
class Security{
    private String date;
    private String security;
    private long quantity;
    private String portfolio;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security1 = (Security) o;
        return quantity == security1.quantity && Objects.equals(date, security1.date) && Objects.equals(security, security1.security) && Objects.equals(portfolio, security1.portfolio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, security, quantity, portfolio);
    }

    @Override
    public String toString() {
        return "Security{" +
                "date='" + date + '\'' +
                ", security='" + security + '\'' +
                ", quantity=" + quantity +
                ", portfolio='" + portfolio + '\'' +
                '}';
    }
}
class Price{
    private String date;
    private String security;
    private  double price;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0 && Objects.equals(date, price1.date) && Objects.equals(security, price1.security);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, security, price);
    }
}


