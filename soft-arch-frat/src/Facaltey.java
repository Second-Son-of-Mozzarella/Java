public class Facaltey extends Person{
    public Facaltey(String name, String email) {
        super(name, email);
    }

    @Override
    public String getDetailLine() {
        return "Faculty: " +  this.getName() + " " + this.getEmail();
    }
}
