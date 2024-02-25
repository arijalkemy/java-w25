package meliboot.services.common.classes;


import meliboot.services.enums.EnumCategories;

public abstract class AbsCategory {
    private static int currentCategories = 0;
    private String _name;
    private String _description;
    private EnumCategories _type;
    public AbsCategory(String name, String description, EnumCategories type){
        this._name = name;
        this._description = description;
        this._type = type;
    }

    public EnumCategories GetType(){
        return this ._type;
    }
    public String GetName(){return this._name;}

}
