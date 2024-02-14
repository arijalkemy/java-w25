package bootcamp.dtoresponseentityvivo.service;

public interface IBirthdayService {

    boolean checkDate(Integer day, Integer month, Integer year);
    int calculateAge(Integer day, Integer month, Integer year);

}
