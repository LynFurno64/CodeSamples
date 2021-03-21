package members;

public class Customer {
    private String name, surname, gender, email, password, birthday;
    private String cell_num, home_num;
    private String address, province, zip_code, country, id;

    public Customer(String id, String name, String surname, String gender, String birthday, String address, String country, String province, String zip_code, String cell_num, String home_num, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.country = country;
        this.province = province;
        this.zip_code = zip_code;
        this.cell_num = cell_num;
        this.home_num = home_num;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCell_num() {
        return cell_num;
    }

    public String getHome_num() {
        return home_num;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getCountry() {
        return country;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getId() {
        return id;
    }
}
