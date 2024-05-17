import java.util.List;

public class UI {
    private static UI ui;
    private IO_Stratagy ioStratagy;
    private UI(IO_Stratagy ioStratagy) {
        this.ioStratagy = ioStratagy;
    };

    public static UI getInstance(IO_Stratagy ioStratagy){
        if(ui == null){
            ui = new UI(ioStratagy);
        }

        return ui;
    }


    public char getMenuSelection(){
       ioStratagy.outputLine("1. Add Person: ");
       ioStratagy.outputLine("2. Add Activities");
       ioStratagy.outputLine("3. Report ");
       ioStratagy.outputLine("4. Exit ");
       return ioStratagy.inputCharacter();
    }

    public String getName(){
        ioStratagy.outputLine("Please enter your name: ");
        return ioStratagy.inputString();

    }

    public String getEmail(){
        ioStratagy.outputLine("Please enter your email");
        return ioStratagy.inputString();
    }


    public PersonType getPersonType(){
        ioStratagy.outputLine("(F)aculty or (M)ember: ");
        switch (ioStratagy.inputCharacter()){
           // case 'M' -> {return PersonType.MEMBER;}
            case 'F' -> {return PersonType.FACULTY;}
            default -> {return PersonType.MEMBER;}
        }

    }

    public void runReport(List<Person> members){
        for (Person p : members) {

            ioStratagy.outputLine(p.getDetailLine());

        }
    }

    public void listMembers(List<Person> membership){
        for(int i=0; i<membership.size();i++){
            if(membership.get(i) instanceof Member aMember){
                ioStratagy.outputLine(i + ". " + aMember);
            }
        }
    }

    public int getMemberSelection(List<Person> membership){
        listMembers(membership);
        return Character.getNumericValue(ioStratagy.inputCharacter());
    }


    public char getActivityType(){
        ioStratagy.outputLine("1. Fundraiser");
        ioStratagy.outputLine("2. Leadership");
        ioStratagy.outputLine("3. Recruiting");
        ioStratagy.outputLine("4. Fun");
        return ioStratagy.inputCharacter();
    }


}
