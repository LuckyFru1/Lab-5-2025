import functions.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, FunctionPointIndexOutOfBoundsException, InappropriateFunctionPointException, ClassNotFoundException {
	    FunctionPoint[] points1 = {
                new FunctionPoint(0.0, 1.4),
                new FunctionPoint(1.0, 6.0),
                new FunctionPoint(10, 4.4)
        };

        FunctionPoint[] points2 = {
                new FunctionPoint(0.0, 1.4),
                new FunctionPoint(1.0, 6.0),
                new FunctionPoint(10, 4.4)
        };

        FunctionPoint[] points3 = {
                new FunctionPoint(0.0, 1.0),
                new FunctionPoint(1.0, 3.5),
                new FunctionPoint(2.0, 5.0)
        };

        ArrayTabulatedFunction array1 = new ArrayTabulatedFunction(points1);
        ArrayTabulatedFunction array2 = new ArrayTabulatedFunction(points2);
        ArrayTabulatedFunction array3 = new ArrayTabulatedFunction(points3);

        LinkedListTabulatedFunction linked1 = new LinkedListTabulatedFunction(points1);
		LinkedListTabulatedFunction linked2 = new LinkedListTabulatedFunction(points2);
		LinkedListTabulatedFunction linked3 = new LinkedListTabulatedFunction(points3);

        System.out.println("\n\t\ttoString()");
        System.out.println("array1.toString(): " + array1.toString());
        System.out.println("array2.toString(): " + array2.toString());
        System.out.println("array3.toString(): " + array3.toString() + "\n");

        System.out.println("linked1.toString(): " + linked1.toString());
        System.out.println("linked2.toString(): " + linked2.toString());
        System.out.println("linked3.toString(): " + linked3.toString());

        System.out.println("\n\t\tequals():");
        System.out.println("(cравнение одинаковых массивов) array1.equals(array2): " + array1.equals(array2));
		System.out.println("(cравнение разных массивов) array1.equals(array3): " + array1.equals(array3));
        System.out.println("array1(null): " + array1.equals(null));

        System.out.println("(cравнение одинаковых списков) linked1.equals(linked2): " + linked1.equals(linked2));
        System.out.println("(cравнение разных списков) linked1.equals(linked3): " + linked1.equals(linked3));
        System.out.println("linked1(null): " + linked1.equals(null));

        System.out.println("(cравнение одинакового массива и списка) array1.equals(linked2): " + array1.equals(linked2));
		System.out.println("(cравнение разного массива и списка) array1.equals(linked3): " + array1.equals(linked3));

        System.out.println("\n\t\thashCode()");
        System.out.println("array1.hashCode(): " + array1.hashCode());
        System.out.println("array2.hashCode(): " + array2.hashCode());
        System.out.println("array3.hashCode(): " + array3.hashCode());
        System.out.println("(одинаковые массивы) array1.hashCode() == array2.hashCode(): " + (array1.hashCode() == array2.hashCode()));

        System.out.println("linked1.hashCode(): " + linked1.hashCode());
        System.out.println("linked2.hashCode(): " + linked2.hashCode());
        System.out.println("linked3.hashCode(): " + linked3.hashCode());
        System.out.println("(одинаковые списки) linked1.hashCode() == linked2.hashCode(): " + (linked1.hashCode() == linked2.hashCode()));
        
        System.out.println("(одинаковые список и массив) array1.hashCode() == linked2.hashCode(): "+ (array1.hashCode() == linked2.hashCode()));

        System.out.println("\n\t\thashCode() после изменения массива и списка");
        double originalHash1 = array1.hashCode();
        System.out.println("(до изменения) array1.hashCode(): " + originalHash1);
        try {
            array1.setPoint(2, new FunctionPoint(9, 30));
        } catch (InappropriateFunctionPointException e) {
            System.out.println("Ошибка при изменении точки X" + e.getMessage());
        }
        System.out.println("(после изменения array1) array1.hashCode(): " + array1.hashCode());
        System.out.println("(после изменения array1) array1.hashCode() != array1.hashCode(): " + (originalHash1 != array1.hashCode()));

        System.out.println("\n\t\tТестирование глубокого клонирования");

        ArrayTabulatedFunction arrayClone = (ArrayTabulatedFunction) array1.clone();
        LinkedListTabulatedFunction linkedClone = (LinkedListTabulatedFunction) linked1.clone();
        System.out.println("Оригинальный массив array1 :" + array1.toString());
        System.out.println("Клон масса array1 :" + arrayClone.toString());
        
        System.out.println("Оригинальный список linked1 :" + linked1.toString());
        System.out.println("Клон списка linked1 :" + linkedClone.toString());

        System.out.println("array1.equals(arrayClone): " + array1.equals(arrayClone));
        System.out.println("linked1.equals(linkedClone): " + linked1.equals(linkedClone) + "\n");
        
        array1.setPointY(2, 436);
        linked1.setPointY(1, 436);
        
        System.out.println("Оригинальный массив array1(после изменения): " + array1.toString());
        System.out.println("Копия после изменения array1: " + arrayClone.toString());

        System.out.println("Оригинальный список linked1(после изменения): " + linked1.toString());
        System.out.println("Клон списка после изменения linked1: " + linkedClone.toString());

        System.out.println("array1.equals(arrayClone): " + array1.equals(arrayClone));
        System.out.println("linked1.equals(linkedClone): " + linked1.equals(linkedClone));
        
        System.out.println("\n\t\t Проверка FunctionPoint");
        FunctionPoint point = new FunctionPoint(10,30);
        FunctionPoint point2 = new FunctionPoint(12,31);
        FunctionPoint pointClone = (FunctionPoint) point.clone();
        
        System.out.println("point.toString:" + point.toString());
        System.out.println("point2.toString:" + point2.toString() +"\n");

        System.out.println("point.equals(pointClone): " + point.equals(pointClone));
        System.out.println("point.equals(point2): " + point.equals(point2) + "\n");

        System.out.println("point.hashCode() == pointCopy.hashCode(): " + (point.hashCode() == pointClone.hashCode()));
        System.out.println("point.hashCode() != point2.hashCode(): " + (point.hashCode() != point2.hashCode()));
    }
}
    


