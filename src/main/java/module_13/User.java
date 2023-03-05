package module_13;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public String toString() {
        return "{" + "\n" +
                "   id = " + id + "\n" +
                "   name = '" + name + '\'' + "\n" +
                "   username = '" + username + '\'' + "\n" +
                "   email = '" + email + '\'' + "\n" +
                "   address = " + address + "\n" +
                "   phone = '" + phone + '\'' + "\n" +
                "   website = '" + website + '\'' + "\n" +
                "   company = " + company + "\n" +
                '}';
    }
}
class Address {
    private final String street;
    private final String suite;
    private final String city;
    private final String zipcode;
    private final Geo geo;

    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }
    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    @Override
    public String toString() {
        return "\n" +
                "       street = '" + street + '\'' + "\n" +
                "       suite = '" + suite + '\'' + "\n" +
                "       city = '" + city + '\'' + "\n" +
                "       zipcode = '" + zipcode + '\'' + "\n" +
                "       geo = " + geo;
    }
}
class Geo {
    private String lat;
    private String lng;

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

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
    public String toString() {
        return "\n" +
                "           lat = '" + lat + '\'' + "\n" +
                "           lng = '" + lng + '\'';
    }
}

class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "\n" +
                "       name = '" + name + '\'' + "\n" +
                "       catchPhrase = '" + catchPhrase + '\'' + "\n" +
                "       bs = '" + bs + '\'';
    }
}
