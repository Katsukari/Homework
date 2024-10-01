package nl.Katsukari;

// Initiate class
class Person {
    String name;
    Integer age;
    String email;
    String city;
    String bsn;
    String phoneNumber;

    // Constructor
    public Person(String name, Integer age, String email, String city, String bsn, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
        this.bsn = bsn;
        this.phoneNumber = phoneNumber;
    }

    // Display details if asked
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email +
                ", City: " + city + ", BSN: " + bsn + ", Phone: " + phoneNumber;
    }
}
