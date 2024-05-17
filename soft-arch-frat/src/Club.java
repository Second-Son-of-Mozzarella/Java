import java.util.ArrayList;
import java.util.List;
// Singleton Example
public class Club {

    private static Club club;
    private List<Person> membership;

    private UI ui;



    private Club(UI ui){
        this.membership = new ArrayList<>();
        this.ui = ui;
    }

    public static Club getInstance(UI ui){
        if(club == null){
            club = new Club(ui);
        }

        return club;
    }

    public List<Person> getMembership(){
        return membership;
    }

    public void addPerson(){
        String name = ui.getName();
        String email = ui.getEmail();
        PersonType personTypeChoice = ui.getPersonType();
        membership.add(PersonFactory.getPerson(name, email, personTypeChoice));



    }

    public void addActivity(){
    int answer = ui.getMemberSelection(membership);
        ((Member)membership.get(answer)).addActivitys(ui.getActivityType());
//    switch (ui.getActivityType()){
//        case '1' -> ((Member)membership).addActivitys(answer);
//    }
    }

}
