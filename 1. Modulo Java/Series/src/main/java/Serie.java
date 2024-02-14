import java.util.Arrays;

public abstract class Serie {
    static int serie;

    public Serie() {
        this.serie = 0;
    }

    public int siguiente(){
        this.serie += 2;
        return  this.serie;
    }

    public void reiniciar(){
        this.serie = 0;
    }

    public static int getSerie() {
        return serie;
    }

    public static void setSerie(int serie) {
        Serie.serie = serie;
    }
}
