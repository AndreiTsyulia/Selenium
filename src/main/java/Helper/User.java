package Helper;

import java.util.GregorianCalendar;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class User
{
    private String taxID;
    private String company;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String postcode;
    private String city;
    private String country;
    private String state;
    private String email;
    private String phone;
    private String password;

    public User(String taxID, String company, String firstName, String lastName, String address1, String address2,
                String postcode, String city, String country, String state, String phone, String password)
    {
        this.taxID = taxID;
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.state = state;
        this.email = generateEmail();
        this.phone = phone;
        this.password = password;
    }

    public String getTaxID()
    {
        return taxID;
    }

    public void setTaxID(String taxID)
    {
        this.taxID = taxID;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    private String generateEmail()
    {
        return (new GregorianCalendar().getTimeInMillis()) + "@yandex.ru";
    }

    @Override
    public String toString()
    {
        return "User{" +
            "taxID='" + taxID + '\'' +
            ", company='" + company + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address1='" + address1 + '\'' +
            ", address2='" + address2 + '\'' +
            ", postcode='" + postcode + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            ", state='" + state + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", password='" + password + '\'' +
            '}';
    }

}
