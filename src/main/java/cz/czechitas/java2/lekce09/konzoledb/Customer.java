package cz.czechitas.java2.lekce09.konzoledb;

public class Customer {

    private long id;
    private String firstName;
    private  String lastName;
    private  String address;
    private boolean deleted;
    private long version;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getId() == customer.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    public long getId() {
        return id;
    }

    public void setId(long newValue) {
        id = newValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newValue) {
        firstName = newValue;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newValue) {
        lastName = newValue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newValue) {
        address = newValue;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean newValue) {
        deleted = newValue;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long newValue) {
        version = newValue;
    }
}
