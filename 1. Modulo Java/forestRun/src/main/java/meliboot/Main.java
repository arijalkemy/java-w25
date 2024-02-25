package meliboot;

import meliboot.controller.EnrollController;
import meliboot.persistence.EnrollRepository;
import meliboot.persistence.domain.enroll.EnrollDTO;
import meliboot.persistence.domain.enroll.EnrollMapper;
import meliboot.persistence.domain.participant.Participant;
import meliboot.services.EnrollService;
import meliboot.services.common.classes.AbsCategory;
import meliboot.services.common.classes.CategoryFactory;
import meliboot.services.common.interfaces.ICategoryFactory;
import meliboot.services.enums.EnumBloodGroup;
import meliboot.services.enums.EnumCategories;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ICategoryFactory categoryFactory = new CategoryFactory();

        //Resolviendo punto a
        var smallCategory = categoryFactory.CreateCategory(EnumCategories.SMALL);
        var middleCategory = categoryFactory.CreateCategory(EnumCategories.MIDDLE);
        var higthCategory = categoryFactory.CreateCategory(EnumCategories.HIGHT);

        //Resolviendo punto b
        var defaultParticipant = new Participant(
                1,
                1234,
                "DanielSham",
                "TheBro",
                (byte) 21,
                0502222344,
                232324234,
                EnumBloodGroup.B_NEGATIVE
        );
        var adapter = new EnrollMapper();
        var repository = new EnrollRepository(adapter);
        var service = new EnrollService(repository);
        var controller = new EnrollController(service);

        controller.CreateEnrroll(new EnrollDTO(defaultParticipant,smallCategory));

        //Punto c

        for(byte elements = 2; elements < 10; elements++){
            controller.CreateEnrroll(new EnrollDTO(new Participant(
                    elements+new Random().nextInt(10),
                    elements+323+elements+3,
                    new String[]{"Daniel","Juan","Pedro","Moises"}[new Random().nextInt(3)],
                    new String[]{"Mon","Rumbey","Niles","Torres"}[new Random().nextInt(3)],
                    (byte) new Random().nextInt(5,40),
                    334+elements+223,
                    232+elements+324234,
                    EnumBloodGroup.B_NEGATIVE
            ),
                    new AbsCategory[]{smallCategory,middleCategory,higthCategory}[new Random().nextInt(2)]
            ));
        }
        var amountSmallCategory = 0;
        var amountMiddleCategory = 0;
        var amountHightCategory = 0;

        //Punto d
        var allEnrolls = controller.GetAll();
        for(var enroll:allEnrolls){
            System.out.println(enroll.getCategory().GetName()+enroll);
            if(enroll.getCategory().GetType().equals(EnumCategories.SMALL)){
                amountSmallCategory += enroll.getAmountPayable();
            }
            if(enroll.getCategory().GetType().equals(EnumCategories.HIGHT)){
                amountMiddleCategory += enroll.getAmountPayable();
            }
            if(enroll.getCategory().GetType().equals(EnumCategories.HIGHT)){
                amountHightCategory += enroll.getAmountPayable();
            }

        }

        //Punto e
        controller.Delete(1);
        //Punto c
        var total = amountSmallCategory+amountMiddleCategory+amountHightCategory;
        System.out.println("Small"+amountSmallCategory);
        System.out.println("Middle"+amountMiddleCategory);
        System.out.println("Hight"+amountHightCategory);
        System.out.println(String.format("Total: %s",total));
    }
}