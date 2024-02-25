package meliboot.services.common.classes;


import meliboot.services.common.interfaces.IClimbingGroundInStone;
import meliboot.services.common.interfaces.IJungleTerrain;
import meliboot.services.common.interfaces.IMudField;
import meliboot.services.common.interfaces.IStreamTerrain;
import meliboot.services.enums.EnumCategories;

class HightCircuit extends AbsCategory implements IJungleTerrain, IStreamTerrain, IMudField, IClimbingGroundInStone {
    public HightCircuit(String name, String description, EnumCategories type) {
        super(name, description,type);
    }

    @Override
    public int GetLengthOfLandInKilometersJungle() {
        return 10;
    }

    @Override
    public int GetLengthOfLandInKilometersStone() { return 10; }

    @Override
    public int GetLengthOfLandInKilometersMud() {
        return 10;
    }

    @Override
    public int GetLengthOfLandInKilometersStream() {
        return 10;
    }
}
