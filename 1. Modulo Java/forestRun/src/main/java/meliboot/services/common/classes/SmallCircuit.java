package meliboot.services.common.classes;


import meliboot.services.common.interfaces.IJungleTerrain;
import meliboot.services.common.interfaces.IStreamTerrain;
import meliboot.services.enums.EnumCategories;

class SmallCircuit extends AbsCategory implements IJungleTerrain, IStreamTerrain {
    public SmallCircuit(String name, String description, EnumCategories type) {
        super(name, description,type);
    }

    @Override
    public int GetLengthOfLandInKilometersJungle() {
        return 2;
    }

    @Override
    public int GetLengthOfLandInKilometersStream() {
        return 2;
    }
}
