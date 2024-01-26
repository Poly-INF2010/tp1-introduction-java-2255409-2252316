package Point;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    /** TODO
     * 2D Point Constructor from coordinates
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point2d(Double x, Double y) {super(new double[] {x, y});}

    /** TODO
     * 2D Point Constructor from vector
     * @param vector Vector containing X and Y coordinates
     */
    public Point2d(Double[] vector) {this(vector[0], vector[1]);}

    /**
     * @return X coordinate
     */
    public double X() { return vector[0];}

    /**
     * @return Y coordinate
     */
    public double Y() { return vector[1];}

    /** TODO
     * Translate the point by the given vector
     * @param translateVector The vector by which to translate
     * @return Translated point
     */
    @Override
    public Point2d translate(Double[] translateVector) {

        vector[0] += translateVector[0];
        vector[1] += translateVector[1];

        return this;
    }

    /** TODO
     * Translate the point by the given 2D Point
     * @param translateVector The 2D Point by which to translate
     * @return Translated point
     */
    public Point2d translate(Point2d translateVector) {

        this.translate(translateVector.vector);

        return this;
    }

    /** TODO
     * Rotate the point by the given rotation Matrix
     * @param rotationMatrix Matrix by which to rotate
     * @return Rotated point
     */
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {

        Double[] newVector = {0.0, 0.0};

        for (int i = 0; i < vector.length; i++) {
            double sum = 0;
            for (int j = 0; j < vector.length; j++) {
                sum += (rotationMatrix[i][j] * vector[j]);
            }
            newVector[i] += sum;
        }

        vector = newVector;

        return this;
    }

    /** TODO
     * Rotate the point by the given angle
     * @param angle Angle in radians
     * @return Rotated point
     */
    public Point2d rotate(Double angle) {

        Double[] oldVector = {vector[0], vector[1]};


        vector[0] = (oldVector[0] * Math.cos(angle)) - (oldVector[1] * Math.sin(angle));
        vector[1] = (oldVector[1] * Math.cos(angle)) + (oldVector[0] * Math.sin(angle));

        return this;
    }

    /** TODO
     * Divide the X and Y coordinates of a 2D point by a scalar
     * @param divider Scalar used to divide
     * @return Divided point
     */
    @Override
    public Point2d divide(Double divider) {

        vector[0] /= divider;
        vector[1] /= divider;

        return this;
    }

    /** TODO
     * Multiply the X and Y coordinates of a 2D point by a scalar
     * @param multiplier Scalar used to multiply
     * @return Multiplied point
     */
    @Override
    public Point2d multiply(Double multiplier) {

        vector[0] *= multiplier;
        vector[1] *= multiplier;

        return this;
    }

    /** TODO
     * Add a scalar to the X and Y coordinates of a 2D point
     * @param adder Scalar to add
     * @return Added point
     */
    @Override
    public Point2d add(Double adder) {

        vector[0] += adder;
        vector[1] += adder;

        return this;
    }

    /** TODO
     * @return Deep copy of the 2D point
     */
    @Override
    public Point2d clone() {

        Point2d newPoint2d = new Point2d(this.vector);


        return newPoint2d;
    }
}
