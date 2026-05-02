package lektion10designpatterns2adaptertemplate;

public class ElVare extends Vare{
    public ElVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        return 0;
    }
}
