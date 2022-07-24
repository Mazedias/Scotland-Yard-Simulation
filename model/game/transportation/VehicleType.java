package model.game.transportation;

/**
 * This enum represents different types of transportation vehicles of the game
 * @author Mazedias
 */
public enum VehicleType {
    TAXI(1),
    BUS(2),
    SUBWAY(3);

    private final int typeValue;

    VehicleType(int type) {
        this.typeValue = type;
    }

    public int getType() {
        return this.typeValue;
    }
}
