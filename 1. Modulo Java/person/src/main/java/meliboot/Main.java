package meliboot;

public class Main {
    public static void main(String[] args){
        var defaultPerson = new Person();
        var secondPerson = new Person("Nogar",24,3234234);
        var theLastOnePerson = new Person("Neloi",34,213213213,22,43);

        System.out.println(String.format("The person -> %s, is %s legal of age and they wight level is: %s"
                ,theLastOnePerson,theLastOnePerson.isOfLegalAge()? "":"not",theLastOnePerson.toCalculeIMC() == -1 ? "Low Weight":
                        theLastOnePerson.toCalculeIMC() == 0 ? "Healthy Weight":"Is Fat"));
    }
}