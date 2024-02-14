public class Serie3 extends Serie{
    public Serie3() {
        super();
    }

    @Override
    public int siguiente() {
        serie += 3;
        return serie;
    }
}
