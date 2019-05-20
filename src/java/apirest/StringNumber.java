
package apirest;

public class StringNumber {
    private String name;
    public String getName() {
        return this.name;
    }
    
    private int number;
    public int getNumber() {
        return this.number;
    } 
    
    public StringNumber(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    @Override 
    public String toString() {
        return this.getName();
    }
    
}
