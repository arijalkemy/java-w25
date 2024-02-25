package meliboot.services.common.classes;


import meliboot.services.common.interfaces.ICategoryFactory;
import meliboot.services.enums.EnumCategories;

public class CategoryFactory implements ICategoryFactory {
    @Override
    public AbsCategory CreateCategory(EnumCategories categoryType) {
        return switch (categoryType){
            case SMALL -> new SmallCircuit("Circuito chico","2 km por selva y arroyos.",categoryType);
            case MIDDLE -> new MiddleCircuit("Circuito medio","5 km por selva, arroyos y barro.",categoryType);
            case HIGHT -> new HightCircuit("Circuito avanzado","10 km por selva, arroyos, barro y escalada en piedra.",categoryType);
        };
    }
}
