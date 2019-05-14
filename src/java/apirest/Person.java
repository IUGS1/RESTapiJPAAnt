
package apirest;


public class Person {
    private String address;
    private String name;
    private int id;
    
    public Person() {
        this.name = "Ivancito";
        this.address = "La quinta avenida.";
        this.id = 13;
    }
    
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }    
}
