package Shape;

import Interface.Transform;
import Point.Point2d;

import java.awt.geom.Point2D;
import java.util.*;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;

public class BaseShape extends Transform implements Cloneable {
    private final Collection<Point2d> coords;

//helper function to clone a list of points 
  public Collection<Point2d> cloneCoords(Collection<Point2d> coords) {
        return coords.stream().map(Point2d::clone).collect(Collectors.toList());
    }

    /** TODO
     * Create a BaseShape with empty coordinades
     */
    public BaseShape() {this.coords = new ArrayList<>(); }

    /** TODO
     * Create a BaseShape from a collection of 2D points
     * @param coords The collection of 2D points
     */
    public BaseShape(Collection<Point2d> coords) {
        this.coords = cloneCoords(coords);
    }

    /** TODO
     * Add a deep copy of the 2D point to the Shape
     * @param coord 2D point to add
     * @return Updated BaseShape
     */
    public BaseShape add(Point2d coord) {
        coords.add(coord.clone());
        return this;
    }

    /** TODO
     * Add a deep copy of the 2D points of the shape to the current shape
     * @param shape Shape to add to the current shape
     * @return Updated BaseShape
     */
    public BaseShape add(BaseShape shape) {
        for (Point2d point : shape.getCoords()) {
            this.coords.add(point.clone());
        }
        return this;
    }

    /** TODO
     * Add a deep copy of the points in the collection to the shape
     * @param coords Collections of point to add
     * @return Updated BaseShape
     */
    public BaseShape addAll(Collection<Point2d> coords) {
        for (Point2d point: coords){
            this.coords.add(point.clone());
        }
        return this;
    }

    /** TODO
     * Remove the 2D point from the shape
     * @param coord Point to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(Point2d coord) {
        this.coords.remove(coord);
        return this;
    }

    /** TODO
     * Remove the 2D points in the shape from the current shape
     * @param shape Shape containing the points to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(BaseShape shape) {
        Iterator<Point2d> iterator = this.coords.iterator();
        while(iterator.hasNext()){
            Point2d currentPoint = iterator.next();

            for(Point2d point : shape.getCoords()){
                if(currentPoint.equals(point)){
                    iterator.remove();
                }
            }
        }
        return this;
    }

    /** TODO
     * Remove the 2D points in the collection from the current shape
     * @param coords Collection of 2D points to remove
     * @return Updated BaseShape
     */
    public BaseShape removeAll(Collection<Point2d> coords) {
        Iterator<Point2d> iterator = this.coords.iterator();
        while(iterator.hasNext()) {
            Point2d currentPoint = iterator.next();

            for (Point2d point : coords) {
                if (currentPoint.equals(point)) {
                    iterator.remove();
                }
            }
        }
        return this;
    }

    /** TODO
     *  Replace all the coords in a shape with new ones
     * @param newCoords new coords to replace the old one
     * @return Updated BaseShape
     * */
    public BaseShape replaceAll(Collection<Point2d> newCoords) {
        this.removeAll(this.coords);
        this.addAll(newCoords);
        return this;
    }

    /** TODO
     * Return a shallow copy of the coordinates of the shape
     * @return Shallow copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> getCoords() {
        if (coords == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(coords);
    }

    /** TODO
     * Create and return a deep copy of the coordinates of the shape
     * @return Deep copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> cloneCoords() {
        return cloneCoords(this.coords);
    }

    /** TODO
     * @return Maximum X coordinate of the shape
     */
    public Double getMaxX() {
        Iterator<Point2d> iterator = coords.iterator();
        if(!iterator.hasNext()){
            return -Double.MAX_VALUE;
        }
        Point2d maxXPoint = iterator.next();
        while(iterator.hasNext()) {
            Point2d currentPoint = iterator.next();
            if(currentPoint.X() > maxXPoint.X()){
                maxXPoint = currentPoint;
            }
        }
        return maxXPoint.X();
    }

    /** TODO
     * @return Maximum Y coordinate of the shape
     */
    public Double getMaxY() {
        Iterator<Point2d> iterator = coords.iterator();
        if(!iterator.hasNext()){
            return -Double.MAX_VALUE;
        }
        Point2d maxYPoint = iterator.next();
        while(iterator.hasNext()) {
            Point2d currentPoint = iterator.next();
            if(currentPoint.Y() > maxYPoint.Y()){
                maxYPoint = currentPoint;
            }
        }
        return maxYPoint.Y();
    }

    /** TODO
     * @return 2D Point containing the maximum X and Y coordinates of the shape
     */
    public Point2d getMaxCoord() {
        return new Point2d(this.getMaxX(),this.getMaxY());
    }

    /** TODO
     * @return Minimum X coordinate of the shape
     */
    public Double getMinX() {
        Iterator<Point2d> iterator = coords.iterator();
        if(!iterator.hasNext()){
            return Double.MAX_VALUE;
        }
        Point2d minXPoint = iterator.next();
        while(iterator.hasNext()) {
            Point2d currentPoint = iterator.next();
            if(currentPoint.X() < minXPoint.X()){
                minXPoint = currentPoint;
            }
        }
        return minXPoint.X();
    }

    /** TODO
     * @return Minimum Y coordinate of the shape
     */
    public Double getMinY() {
        Iterator<Point2d> iterator = coords.iterator();
        if(!iterator.hasNext()){
            return Double.MAX_VALUE;
        }
        Point2d minYPoint = iterator.next();
        while(iterator.hasNext()) {
            Point2d currentPoint = iterator.next();
            if(currentPoint.Y() < minYPoint.Y()){
                minYPoint = currentPoint;
            }
        }
        return minYPoint.Y();
    }

    /** TODO
     * @return 2D point containing the minimum X and Y coordinate of the shape
     */
    public Point2d getMinCoord() {
        return new Point2d(this.getMinX(),this.getMinY());
    }

    /** TODO
     * @return Deep copy of the current shape
     */
    public BaseShape clone() {
        BaseShape newShape = new BaseShape();
        for(Point2d point: coords){
            newShape.add(point.clone());
        }
        return newShape;
    }
}
