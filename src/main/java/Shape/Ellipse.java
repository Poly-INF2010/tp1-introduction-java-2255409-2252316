package Shape;

import Point.Point2d;
import java.util.Collection;

public class Ellipse extends BaseShape {
    /** TODO
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        double increment = 0.5;
        for(double x = -widthDiameter; x< widthDiameter; x += increment){
            for(double y = -heightDiameter; y < heightDiameter; y += increment){
                double equation = ((Math.pow(x,2.0)/Math.pow(widthDiameter,2.0))+(Math.pow(y,2.0)/Math.pow(heightDiameter,2.0)));
                if(equation <= 1){
                    add(new Point2d(x,y));
                }
            }
        }
    }

    /** TODO
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(),dimensions.Y());
    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    /** TODO
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {
        return new Ellipse(cloneCoords());
    }
}
