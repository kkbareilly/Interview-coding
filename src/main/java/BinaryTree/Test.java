package BinaryTree;



import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


public class Test {
    public static void main(String[] args) throws Exception {

        ExecutorService service=Executors.newFixedThreadPool(20);
       // service.invokeAll();
     List< String> s=new ArrayList<>();

//        URL urlForGetRequest = new URL("https://jsonmock.hackerrank.com/api/food_outlets?city=Seattle&page=1");
//        String readLine = null;
//        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
//        conection.setRequestMethod("GET");
//        int responseCode = conection.getResponseCode();
//
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(conection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            while ((readLine = in .readLine()) != null) {
//                response.append(readLine);
//            }
//            in .close();
//
//            Configuration conf = Configuration.builder().jsonProvider(new GsonJsonProvider())
//                    .options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS).build();
//
//            JsonArray objArrJ = JsonPath.using(conf).parse(strJson).read(strJPath)
//            System.out.println("JSON String Result " + response);
//        } else {
//            System.out.println("GET NOT WORKED");
//        }
//    }

        StringBuffer response = null;
        List<Integer> result = new ArrayList();
        try {
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");

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
                UserData[] userData = gson.fromJson(response.toString(), UserData[].class);
                List<UserData> datas = Arrays.asList(userData);
                JsonParser parser = new JsonParser();

                JsonElement jsonTree = parser.parse(gson.toJson(datas.get(0)));
                System.out.println(jsonTree.getAsJsonObject().get("id"));
                 list.add(jsonTree.getAsJsonObject().get("id").getAsInt());
//                String field=inputList.get(0);
//                for(UserData usd:datas){
//                    if(null!= field&& field.contains(".")){
//                        if(field.contains("address")){
//                            if(inputList.get(1).equals("EQUALS")){
//                            }else{
//
//                            }
//                        }else{
//                            if(inputList.get(1).equals("EQUALS")){
//
//                            }else{
//
//                            }
//                        }
//                    }else{
//                        if(inputList.get(1).equals("EQUALS")){
//
//                        }else{
//
//                        }
//                    }
//                }
            }
        } catch (Exception e) {

        }


    }

    class DataBinder {

        int page;
        int paer_page;
        int total;
        int total_pages;
        Data data;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPaer_page() {
            return paer_page;
        }

        public void setPaer_page(int paer_page) {
            this.paer_page = paer_page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DataBinder)) return false;
            DataBinder that = (DataBinder) o;
            return getPage() == that.getPage() &&
                    getPaer_page() == that.getPaer_page() &&
                    getTotal() == that.getTotal() &&
                    getTotal_pages() == that.getTotal_pages() &&
                    Objects.equals(getData(), that.getData());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getPage(), getPaer_page(), getTotal(), getTotal_pages(), getData());
        }
    }

    class Data {
        String city;
        String name;
        Long estimated_cost;
        UserRating user_rating;
        Long id;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getEstimated_cost() {
            return estimated_cost;
        }

        public void setEstimated_cost(Long estimated_cost) {
            this.estimated_cost = estimated_cost;
        }

        public UserRating getUser_rating() {
            return user_rating;
        }

        public void setUser_rating(UserRating user_rating) {
            this.user_rating = user_rating;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Data)) return false;
            Data data = (Data) o;
            return Objects.equals(getCity(), data.getCity()) &&
                    Objects.equals(getName(), data.getName()) &&
                    Objects.equals(getEstimated_cost(), data.getEstimated_cost()) &&
                    Objects.equals(getUser_rating(), data.getUser_rating()) &&
                    Objects.equals(getId(), data.getId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCity(), getName(), getEstimated_cost(), getUser_rating(), getId());
        }
    }

    class UserRating {
        Float average_rating;
        Long votes;

        public Float getAverage_rating() {
            return average_rating;
        }

        public void setAverage_rating(Float average_rating) {
            this.average_rating = average_rating;
        }

        public Long getVotes() {
            return votes;
        }

        public void setVotes(Long votes) {
            this.votes = votes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserRating)) return false;
            UserRating that = (UserRating) o;
            return Objects.equals(getAverage_rating(), that.getAverage_rating()) &&
                    Objects.equals(getVotes(), that.getVotes());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAverage_rating(), getVotes());
        }
    }


    class UserData {
        private Integer id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private Geo geo;
        private String website;
        private Company company;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UserData)) return false;
            UserData userData = (UserData) o;
            return Objects.equals(getId(), userData.getId()) &&
                    Objects.equals(getName(), userData.getName()) &&
                    Objects.equals(getUsername(), userData.getUsername()) &&
                    Objects.equals(getEmail(), userData.getEmail()) &&
                    Objects.equals(getAddress(), userData.getAddress()) &&
                    Objects.equals(getGeo(), userData.getGeo()) &&
                    Objects.equals(getWebsite(), userData.getWebsite()) &&
                    Objects.equals(getCompany(), userData.getCompany());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName(), getUsername(), getEmail(), getAddress(), getGeo(), getWebsite(), getCompany());
        }
    }

    class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Address)) return false;
            Address address = (Address) o;
            return Objects.equals(getStreet(), address.getStreet()) &&
                    Objects.equals(getSuite(), address.getSuite()) &&
                    Objects.equals(getCity(), address.getCity()) &&
                    Objects.equals(getZipcode(), address.getZipcode());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getStreet(), getSuite(), getCity(), getZipcode());
        }
    }

    class Geo {
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Geo)) return false;
            Geo geo = (Geo) o;
            return Objects.equals(getLat(), geo.getLat()) &&
                    Objects.equals(getLng(), geo.getLng());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getLat(), getLng());
        }
    }

    class Company {
        private String name;
        private String basename;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBasename() {
            return basename;
        }

        public void setBasename(String basename) {
            this.basename = basename;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Company)) return false;
            Company company = (Company) o;
            return Objects.equals(getName(), company.getName()) &&
                    Objects.equals(getBasename(), company.getBasename());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getBasename());
        }
    }
}
/*class NameList {
    List<Security> list;

    public List<Security> getList() {
        return list;
    }

    public void setList(List<Security> list) {
        this.list = list;
    }
}*/

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
