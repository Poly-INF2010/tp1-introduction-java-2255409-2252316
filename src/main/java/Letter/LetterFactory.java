package Letter;

import Point.Point2d;
import Shape.*;
import org.w3c.dom.css.Rect;

import java.text.CharacterIterator;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;


    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {

        Rectangle sideLegLeft = new Rectangle(stripeThickness, maxWidth);
        Rectangle sideLegRight = sideLegLeft.clone();

        Rectangle middleBar = new Rectangle(halfStripeThickness, halfMaxHeight);

        BaseShape letterA = new BaseShape();

        double rotationLegs = Math.PI / 4;

        letterA.add(middleBar);


        return null;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        Rectangle leftBand = new Rectangle(stripeThickness,maxHeight);
        Circle topO = new Circle(halfMaxWidth);
        Circle bottom0 = new Circle(halfMaxWidth);

        return null;
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Circle outterCircle = new Circle(halfMaxHeight);
        Circle innerCircle = new Circle(halfMaxHeight/2);
        Rectangle rightRectangle = new Rectangle((halfMaxHeight-(halfMaxHeight/2)),(halfMaxHeight*0.6));


        return null;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        Rectangle leftRectangle = new Rectangle(stripeThickness,maxHeight);
        Rectangle topRectangle = new Rectangle(halfStripeThickness,maxWidth);
        Rectangle middleRectangle = new Rectangle(halfStripeThickness,maxWidth);
        Rectangle bottomRectangle = new Rectangle(halfStripeThickness,maxWidth);
        return null;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle leftRectangle = new Rectangle(halfStripeThickness,maxHeight);
        Rectangle rightRectangle = new Rectangle(halfStripeThickness,maxHeight);
        Rectangle middleBar = new Rectangle(maxWidth,stripeThickness);
        return null;
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        Rectangle leftRectangle = new Rectangle(halfStripeThickness,maxHeight);
        Rectangle rightRectangle = new Rectangle(halfStripeThickness,maxHeight);
        Rectangle middleBar = new Rectangle(maxWidth,maxHeight);

        return null;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Circle outterCircle = new Circle(halfMaxHeight);
        Circle innerCircle = new Circle(halfMaxHeight/2);
        return null;
    }

}
