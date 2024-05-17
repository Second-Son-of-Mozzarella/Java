public class Main {
    public static void main(String[] args) {

        IO_Stratagy ioStratagy;
        switch (args[0].indexOf(0)){
            case 'C': ioStratagy = new IO_CONSOLE();break;
            default:ioStratagy = new IO_CONSOLE(); break;
        }
        UI ui = UI.getInstance(ioStratagy);
        Club club = Club.getInstance(ui);


        char answer = ' ';
        do{
            answer = ui.getMenuSelection();
            switch (answer){
                case '1' -> {club.addPerson();}

                case '2' -> {club.addActivity();}

                case '3' -> {ui.runReport(club.getMembership());}

            }
        }while(answer != '4');
    }
}