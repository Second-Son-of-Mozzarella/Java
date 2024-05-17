import java.util.ArrayList;
import java.util.List;

public class Member extends Person{
    private List<Activitys> activitys;
    private int points;

    public Member(String name, String email) {
        super(name, email);
        this.activitys = new ArrayList<>();
        this.points = 0;
    }

    public void addActivitys(char answer){
        switch (answer){
            case '1' -> { activitys.add(new Fundraser()); }
            case '2' -> { activitys.add(new Leadership()); }
            case '3' -> {activitys.add(new Recruiting()); }
            case '4' -> {activitys.add(new Fun()); }
        }

    }

    @Override
    public String getDetailLine() {
        String p1 = "Member: " +  this.getName() + " " + this.getEmail();
        for (Activitys a : activitys ) {
            p1 += "\n\t" + a.getActivityLine();
        }


        return p1;
    }
}
