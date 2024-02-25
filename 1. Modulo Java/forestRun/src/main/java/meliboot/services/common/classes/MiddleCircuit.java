package meliboot.services.common.classes;


import meliboot.services.common.interfaces.IJungleTerrain;
import meliboot.services.common.interfaces.IMudField;
import meliboot.services.common.interfaces.IStreamTerrain;
import meliboot.services.enums.EnumCategories;

class MiddleCircuit extends AbsCategory implements IJungleTerrain, IStreamTerrain, IMudField {
    public MiddleCircuit(String name, String description, EnumCategories type) {
        super(name, description, type);
    }

    @Override
    public int GetLengthOfLandInKilometersJungle() {
        return 5;
    }

    @Override
    public int GetLengthOfLandInKilometersMud() {
        return 5;
    }

    @Override
    public int GetLengthOfLandInKilometersStream() {
        return 5;
    }
}
