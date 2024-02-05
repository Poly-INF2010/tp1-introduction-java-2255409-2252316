package Letter;

import Point.Point2d;
import Shape.*;

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

        double rotationLegs = Math.toRadians(10);

        Rectangle leftLeg = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle rightLeg = leftLeg.clone();

        leftLeg.rotate(leftLeg.getCoords(), rotationLegs);
        leftLeg.translate(leftLeg.getCoords(), new Point2d(-halfMaxWidth/2, 0.0));
        rightLeg.rotate(rightLeg.getCoords(),-rotationLegs);
        rightLeg.translate(rightLeg.getCoords(), new Point2d(halfMaxWidth/2, 0.0));

        Rectangle middleBar = new Rectangle(halfMaxWidth, halfStripeThickness/2);

        BaseShape letterA = new BaseShape();
        letterA.add(leftLeg).add(middleBar).add(rightLeg);

        return letterA;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {

        Rectangle leftBand = new Rectangle(stripeThickness,maxHeight);
        leftBand.translate(leftBand.getCoords(), new Point2d(-halfMaxWidth,0.0));

        Circle innerCircle = new Circle((halfMaxHeight/2)-halfStripeThickness);

        Circle topO = new Circle(halfMaxHeight/2);
        topO.remove(innerCircle);
        topO.translate(topO.getCoords(), new Point2d(0.0,halfMaxHeight/2));

        Circle bottomO = new Circle(halfMaxHeight/2);
        bottomO.remove(innerCircle);
        bottomO.translate(bottomO.getCoords(), new Point2d(0.0, -halfMaxHeight/2));

        BaseShape letterB = new BaseShape();
        letterB.add(leftBand).add(topO).add(bottomO);

        return letterB;
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Ellipse curve = new Ellipse(halfMaxWidth, halfMaxHeight);

        Ellipse innerCurve = new Ellipse(halfMaxWidth-halfStripeThickness, halfMaxHeight-halfStripeThickness);
        curve.remove(innerCurve);

        Rectangle emptyRectangle = new Rectangle(maxWidth, 1.3 * halfMaxHeight);
        emptyRectangle.translate(emptyRectangle.getCoords(), new Point2d(halfMaxWidth, 0.0));

        BaseShape letterC = new BaseShape();
        letterC.add(curve).remove(emptyRectangle);

        return letterC;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {

        Rectangle mainRectangle = new Rectangle(maxWidth, maxHeight);

        Square topSquare = new Square(halfMaxHeight - stripeThickness);
        topSquare.translate(topSquare.getCoords(), new Point2d(halfStripeThickness, halfMaxHeight/2));
        Square bottomSquare = new Square(halfMaxHeight - stripeThickness);
        bottomSquare.translate(bottomSquare.getCoords(), new Point2d(halfStripeThickness, -halfMaxHeight/2));

        BaseShape letterE = new BaseShape();
        letterE.add(mainRectangle)
                .remove(topSquare)
                .remove(bottomSquare);

        return letterE;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {

        BaseShape leftLeg = new Rectangle(stripeThickness,maxHeight);
        leftLeg.translate(leftLeg.getCoords(), new Point2d(-halfMaxWidth , 0.0));

        BaseShape rightLeg = new Rectangle(stripeThickness,maxHeight);
        rightLeg.translate(rightLeg.getCoords(), new Point2d(halfMaxWidth, 0.0));

        BaseShape middleBar = new Rectangle(maxWidth,stripeThickness);

        BaseShape letterH = new BaseShape();
        letterH.add(leftLeg).add(rightLeg).add(middleBar);

        return letterH;
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        Rectangle leftRectangle = new Rectangle(halfStripeThickness,maxHeight);
        leftRectangle.translate(leftRectangle.getCoords(), new Point2d(-halfMaxWidth, 0.0));

        Rectangle rightRectangle = new Rectangle(halfStripeThickness,maxHeight);
        rightRectangle.translate(rightRectangle.getCoords(), new Point2d(halfMaxWidth, 0.0));

        Rectangle middleBar = new Rectangle(halfStripeThickness,maxHeight);
        double rotationAngle = Math.toRadians(23);
        middleBar.rotate(middleBar.getCoords(), - rotationAngle);

        BaseShape letterN = new BaseShape();
        letterN.add(leftRectangle).add(rightRectangle).add(middleBar);

        return letterN;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Ellipse outerEllipse = new Ellipse(halfMaxWidth, halfMaxHeight);
        Ellipse innerEllipse = new Ellipse(halfMaxWidth - halfStripeThickness, halfMaxHeight - halfStripeThickness);

        BaseShape letterO = new BaseShape();
        letterO.add(outerEllipse).remove(innerEllipse);

        return letterO;
    }

}
