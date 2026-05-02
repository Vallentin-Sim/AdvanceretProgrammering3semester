package lektion10designpatterns2adaptertemplate;

public class FoedeVare extends Vare{
    public FoedeVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        return 0;
    }
}
