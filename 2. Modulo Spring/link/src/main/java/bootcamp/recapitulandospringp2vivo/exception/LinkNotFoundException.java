package bootcamp.recapitulandospringp2vivo.exception;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(Integer linkId) {
        super(String.format("El link con id " + linkId + " no fue encontrado."));
    }

}
