package integracion.p2.dakar.base;

public class Cars extends  Vehicle{

    public Cars(double speed, double acceleration, double turnAngle, String patent) {
        super(speed, acceleration, turnAngle, patent, 1000, 4);
    }
}
