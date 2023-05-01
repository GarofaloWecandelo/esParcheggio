import java.util.*;

public class Main {
    public static void main(String[] args) {

        Parcheggio p = new Parcheggio(4);
        ArrayList<Automobile> auto = new ArrayList<Automobile>();

        for (int i = 0; i < 8; i++)
            auto.add(new Automobile("Auto " + (i + 1) + "", p));

        
        auto.forEach(e -> e.start());
    }
}
