package meliboot.services.common.interfaces;


import meliboot.services.common.classes.AbsCategory;
import meliboot.services.enums.EnumCategories;

public interface ICategoryFactory {
    public AbsCategory CreateCategory(EnumCategories categoryType);
}
