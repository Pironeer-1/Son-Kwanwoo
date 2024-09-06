public class jump2java_05 {

    static class Counter {
        int count = 0;
    }

    public static void main(String[] args) {
        jump2java_0501();
        jump2java_0502();
        jump2java_0503();
        jump2java_0504();
        jump2java_0505();
        jump2java_0506();
        jump2java_0507();
        jump2java_0508();
        jump2java_0509();
    }

    // 05-01 객체 지향 프로그래밍이란?
    public static void jump2java_0501() {
        class Calculator {
            int result = 0;

            // 더하기 메서드
            int add(int num) {
                result += num;
                return result;
            }

            // 빼기 메서드
            int sub(int num) {
                result -= num;
                return result;
            }
        }

        Calculator cal1 = new Calculator();
        System.out.println("3을 더하면: " + cal1.add(3));
        System.out.println("4를 더하면: " + cal1.add(4));
        System.out.println("2를 빼면: " + cal1.sub(2));
    }

    // 05-02 클래스
    public static void jump2java_0502() {
        class Animal {
            String name;

            public void setName(String name) {
                this.name = name;
            }
        }

        Animal cat = new Animal();
        cat.setName("Bobby");
        System.out.println("Cat's name: " + cat.name);

        Animal dog = new Animal();
        dog.setName("Happy");
        System.out.println("Dog's name: " + dog.name);
    }

    // 05-03 메서드 더 살펴보기
    public static void jump2java_0503() {
        // 1. 기본 메서드 사용
        class Sample {
            int sum(int a, int b) {
                return a + b;
            }
        }

        Sample sample = new Sample();
        int result = sample.sum(3, 4);
        System.out.println("Sum of 3 and 4: " + result);  // 7 출력

        // 2. 메서드의 매개변수 전달
        class VarTest {
            void changeValue(int a) {
                a++;
            }
        }

        int value = 5;
        VarTest varTest = new VarTest();
        varTest.changeValue(value);
        System.out.println("Value after method call: " + value);  // 값은 변하지 않음, 5 출력

        // 3. 참조 타입 매개변수 전달
        class ReferenceTest {
            int num;

            void changeValue(ReferenceTest ref) {
                ref.num++;
            }
        }

        ReferenceTest refTest = new ReferenceTest();
        refTest.num = 10;
        refTest.changeValue(refTest);
        System.out.println("ReferenceTest num after method call: " + refTest.num);  // 11 출력
    }

    // 05-04 값에 의한 호출과 객체에 의한 호출
    public static void jump2java_0504() {
        class Updater {
            void update(Counter counter) {
                counter.count++;
            }
        }

        Counter myCounter = new Counter();
        System.out.println("Before update: " + myCounter.count);
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter);
        System.out.println("After update: " + myCounter.count);
    }

    // 05-05 상속
    public static void jump2java_0505() {
        class Animal {
            String name;

            void setName(String name) {
                this.name = name;
            }
        }

        class Dog extends Animal {
            void sleep() {
                System.out.println(this.name + " zzz");
            }
        }

        class HouseDog extends Dog {
            void sleep(int hours) {
                System.out.println(this.name + " zzz for " + hours + " hours");
            }
        }

        HouseDog houseDog = new HouseDog();
        houseDog.setName("Buddy");
        houseDog.sleep();
        houseDog.sleep(3);
    }

    // 05-06 생성자
    public static void jump2java_0506() {
        class Animal {
            String name;

            Animal(String name) {
                this.name = name;
            }

            void setName(String name) {
                this.name = name;
            }
        }

        class Dog extends Animal {
            Dog(String name) {
                super(name);
            }

            void sleep() {
                System.out.println(this.name + " zzz");
            }
        }

        class HouseDog extends Dog {
            HouseDog(String name) {
                super(name);
            }

            void sleep(int hours) {
                System.out.println(this.name + " zzz in house for " + hours + " hours");
            }
        }

        HouseDog houseDog = new HouseDog("Happy");
        houseDog.sleep();
        houseDog.sleep(3);
    }

    // 05-07 인터페이스
    public static void jump2java_0507() {
        interface Predator {
            String getFood();
        }

        class Tiger implements Predator {
            public String getFood() {
                return "apple";
            }
        }

        class Lion implements Predator {
            public String getFood() {
                return "banana";
            }
        }

        class ZooKeeper {
            void feed(Predator predator) {
                System.out.println("feed " + predator.getFood());
            }
        }

        ZooKeeper zookeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        zookeeper.feed(tiger);  // feed apple 출력
        zookeeper.feed(lion);   // feed banana 출력
    }

    // 05-08 다형성
    public static void jump2java_0508() {
        interface Predator {
            String getFood();
        }

        interface Barkable {
            void bark();
        }

        class Tiger implements Predator, Barkable {
            public String getFood() {
                return "apple";
            }

            public void bark() {
                System.out.println("어흥");
            }
        }

        class Lion implements Predator, Barkable {
            public String getFood() {
                return "banana";
            }

            public void bark() {
                System.out.println("으르렁");
            }
        }

        class ZooKeeper {
            void feed(Predator predator) {
                System.out.println("feed " + predator.getFood());
            }
        }

        class Bouncer {
            void barkAnimal(Barkable animal) {
                animal.bark();
            }
        }

        ZooKeeper zooKeeper = new ZooKeeper();
        Bouncer bouncer = new Bouncer();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        zooKeeper.feed(tiger);  // feed apple 출력
        zooKeeper.feed(lion);   // feed banana 출력
        bouncer.barkAnimal(tiger);  // 어흥 출력
        bouncer.barkAnimal(lion);   // 으르렁 출력
    }

    // 05-09 추상 클래스
    public static void jump2java_0509() {
        abstract class Animal {
            String name;

            void setName(String name) {
                this.name = name;
            }

            abstract void sleep();
        }

        class Dog extends Animal {
            void sleep() {
                System.out.println(this.name + " zzz");
            }
        }

        class Cat extends Animal {
            void sleep() {
                System.out.println(this.name + " zzz in cozy bed");
            }
        }

        Dog dog = new Dog();
        dog.setName("Buddy");
        dog.sleep();  // Buddy zzz 출력

        Cat cat = new Cat();
        cat.setName("Kitty");
        cat.sleep();  // Kitty zzz in cozy bed 출력
    }
}