package com.company;

public class extendedClass {
    public static void main(String[] args) {

        Fruit fruit1 = new Fruit();
        fruit1.name = "과일1";
        fruit1.sweetness = 10;

        Fruit fruit2 = new Fruit();
        fruit2.name = "과일2";
        fruit2.sweetness = 20;

        fruit1.print();
        fruit2.print();

        fruit1.rot();

        MetalFruit metalFruit = new MetalFruit();

        metalFruit.name = "고철과일";
        metalFruit.sweetness = 0;
        metalFruit.rot();

        fruit1.toString();

        YellowFruit yellowFruit = new YellowFruit();

        yellowFruit.name = "Banana";
        yellowFruit.sweetness = 30;
        yellowFruit.rot();

    }
}


// Animal

class Fruit {
    public String name;
    public int sweetness;

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", sweetness=" + sweetness +
                '}';
    }

    void print() {
        System.out.println("이름: " + name + " / 당도: " + sweetness);
    }

    void rot() {
        System.out.println("썩었다. 이름 : " + name);
    }

    //Overloading
    void rot(int day) {
        System.out.println(day + "일 내에 썩음");
    }
}

class MetalFruit extends Fruit {
    void rot() {
        System.out.println("녹슨다. 이름 : " + name);
    }

}

//Overriding
class YellowFruit extends Fruit {

    @Override
    void rot() {
        System.out.println("검어진다. 이름: " + name);
    }
}