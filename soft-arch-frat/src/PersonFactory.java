public class PersonFactory {
    private PersonFactory(){

    }
    public static Person getPerson(String name, String email, PersonType personType){
        switch(personType) {
            case MEMBER -> {return new Member(name,email);}
            case FACULTY -> {return new Facaltey(name,email);}
            default -> {return null;}
        }
    }
}
