public class Practice1 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 5);
        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());

        Circle circle = new Circle(3);
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Circumference: " + circle.getCircumference());
    }
}

class Shape {
    protected double width;
    protected double height;

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}

class Circle extends Shape {
    public Circle(double radius) {
        super(radius, radius); 
    }

    public double getArea() {
        return Math.PI * width * width;
    }

    public double getCircumference() {
        return 2 * Math.PI * width;
    }
}