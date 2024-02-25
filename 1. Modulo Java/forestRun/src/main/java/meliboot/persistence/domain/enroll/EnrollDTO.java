package meliboot.persistence.domain.enroll;


import meliboot.persistence.domain.participant.Participant;
import meliboot.services.common.classes.AbsCategory;

public record EnrollDTO(Participant participant, AbsCategory category) {
}
