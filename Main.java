
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int arrayLength = 4;

    public static void main(String... args) {

		
		//Input data
//////////////////////////////////////////////////////////////	


        int[] numberOfX = {-2, 2, 2, -2};
        int[] numberOfY = {2, 2, -2, -2};	
		

        /*int[] numberOfX = new int[arrayLength];
        int[] numberOfY = new int[arrayLength];

        System.out.println("Enter number of X coordinates:");
        arrayInit(numberOfX);

        System.out.println("Enter number of Y coordinates:");
        arrayInit(numberOfY);*/
		
		
		

//////////////////////////////////////////////////////////////


        int minX = minArrayElement(numberOfX);
        int maxX = maxArrayElement(numberOfX);
        int minY = minArrayElement(numberOfY);
        int maxY = maxArrayElement(numberOfY);

		
		
        //Rectangle
//////////////////////////////////////////////////////////////



        Polygon polygon = new Polygon(numberOfX, numberOfY, Main.arrayLength);

        double width = polygon.getBounds().width;
        double height = polygon.getBounds().height;

        double rectArea = rectangleAreaCalculation(width, height);

		
		
        //Shape
//////////////////////////////////////////////////////////////


        double pointsInRectangle = pointsInRectangleCalculation(maxX, maxY, minX, minY);
        double pointsInShape = pointsInShapeCalculation(polygon, maxX, maxY);
		
        double shapeArea = shapeAreaCalculation(pointsInRectangle, pointsInShape ,rectArea);
		
		

        //Output data
//////////////////////////////////////////////////////////////


        System.out.println("Points in rectangle :" + pointsInRectangle);
        System.out.println("Points in shape :" + pointsInShape);
        System.out.println("Width :" + width);
        System.out.println("Height :" + height);
        System.out.println(rectArea);
        System.out.println(shapeArea);
		
		
	
		
		

    }
	
	
	
	
	  //All Methods
////////////////////////////////////////////////////////////////////	
	

    private static double pointsInRectangleCalculation(int maxX, int maxY, int minX, int minY) {
        Random random = new Random();
        int numberOfPoints = 100000000;
        double pointsInside = 0;
        for (int i = 0; i < numberOfPoints; i++) {
            double randomXCoordinates = random.nextGaussian() ;
            double randomYCoordinates = random.nextGaussian() ;

            if (randomXCoordinates >= minX && randomXCoordinates <= maxX && randomYCoordinates >= minY && randomYCoordinates <= maxY) {
                pointsInside++;
            }
        }
        return pointsInside;
    }
	
    private static double pointsInShapeCalculation(Polygon polygon, int maxX, int maxY) {
        Random random = new Random();
        int numberOfPoints = 100000000;
        double pointsInside = 0;
        for (int i = 0; i < numberOfPoints; i++) {
            double randomXCoordinates = random.nextGaussian() ;
            double randomYCoordinates = random.nextGaussian() ;
            if (polygon.contains(randomXCoordinates, randomYCoordinates)) {
                pointsInside++;
            }
        }
        return pointsInside;
    }

//////////////////////////////////////////////////////////////

    private static double rectangleAreaCalculation(double width, double height) {
        return width * height;
    }
    private static double shapeAreaCalculation(double pointsInShape, double pointsInRectangle,double rectangleArea){
        return  (pointsInShape / pointsInRectangle) * (rectangleArea);
    }

//////////////////////////////////////////////////////////////

    private static int minArrayElement(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }
	
    private static int maxArrayElement(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }
        return max;
    }

//////////////////////////////////////////////////////////////

    private static void arrayShow(int[] array) {
        for (int value : array) System.out.print(value + " ");
        System.out.println();
    }
	
    private static int[] arrayInit(int[] array) {
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) array[i] = console.nextInt();
        return array;
    }
}
