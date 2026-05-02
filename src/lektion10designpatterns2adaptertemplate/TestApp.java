package lektion10designpatterns2adaptertemplate;

import lektion10designpatterns2adaptertemplate.opgave2_spiritusadapter.Spiritus;

import java.util.ArrayList;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        ElVare elVare = new ElVare(1000, "router");
        ElVare elVare2 = new ElVare(1250, "router2");

        FoedeVare foedeVare = new FoedeVare(120, "Hog");
        FoedeVare foedeVare2 = new FoedeVare(109, "Hog2");

        Spiritus spiritus = new Spiritus(400, "FlaskeManden");
        SpiritusAdapter spiritusAdapter = new SpiritusAdapter(spiritus);

        List<Vare> varer = new ArrayList<>(List.of(elVare, elVare2, foedeVare, foedeVare2, spiritusAdapter));

        varer.forEach(vare -> System.out.println(vare.getPris() + vare.getNavn() + vare.beregnMoms()));
    }
}
