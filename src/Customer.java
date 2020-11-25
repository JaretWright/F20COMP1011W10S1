import java.time.LocalDate;

public class Customer {
    private String firstName, lastName, province, gender, bloodType;
    private LocalDate birthday;

    public Customer(String firstName, String lastName, String province, String gender,
                    LocalDate birthday, String bloodtype) {
        setFirstName(firstName);
        setLastName(lastName);
        setProvince(province);
        setGender(gender);
        setBirthday(birthday);
        setBloodType(bloodtype);
    }

    public String getFirstName() {
        return firstName;
    }

    private boolean validateName(String name)
    {
        return name.length()>=1 && name.length()<=40;
    }

    public void setFirstName(String firstName) {
        if (validateName(firstName))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("first name must be 1-40 characters");

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (validateName(lastName))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("last name must be 1 to 40 characters");
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))
            this.gender = gender;
        else
            throw new IllegalArgumentException("gender must be male or female");
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
