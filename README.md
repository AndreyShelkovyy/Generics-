# Домашнее задание по теме «Generics в коллекциях и методах»
## Задача 1 (обязательная)
Вам предстоит реализовать класс **MagicBox** (англ. магическая коробка), который умеет выбирать случайным образом один из сохранённых в него объектов.

При конструировании объекта этого класса указывается, сколько объектов в него можно положить (механика похожа на решение задачи про Полиморфизм).

Тип добавляемых объектов должен быть тип-параметром класса - т.е. сам класс должен быть дженерик-классом с одним тип-параметром.

У вас должен быть метод добавления объекта **boolean add(T item)**. Если коробка ещё не полна, то элемент должен в ней сохраниться и метод вернуть true. Если полна, то коробка не должна измениться, а метод должен вернуть false.

Также нужно реализовать метод **T pick()**, работающий следующим образом:

* Если коробка не полна, то он выкидывает **RuntimeException** с сообщением, что коробка не полна и осталось ещё столько-то ячеек заполнить
* Если коробка полна, то метод выбирает случайным образом (см. ниже) один из сохранённых элементов и возвращает его из метода.

Хранить сохранённые элементы предлагаем в массиве, как в задаче про Полиморфизм). Массив создавать в конструкторе, размером который был указан в его параметре. Для выбора случайного элемента воспользуйтесь классом Random (не забудьте заимпортить):

1. **Random random = new Random();**
2. **int randomInt = random.nextInt(ЧИСЛО);** // джава подберёт случайное число от 0 до ЧИСЛО невключительно

В Main продемонстрируйте работу класса, создайте для этого магическую коробку для строк и вторую для чисел и продемонстрируйте на них работу методов.

Не забудьте, что теперь мы сдаём через гитхаб!

### Подсказки
Для создания массива с ячейками типа дженерик-параметра используйте:___T[] items = (T[]) new Object[РАЗМЕР];___.

Для определения незаполненности кородки проверьте массив **items** на наличие **null**.

Для выбора случайного элемента выберите случайное число-индекс массива и верните его содержимое.

## Решение задачи
### Класс MagicBox
~~~java
import java.util.Random;

public class MagicBox<T> {
    protected T[] items;
    Random random = new Random();

    public MagicBox(int maxItems) {
        this.items = (T[]) new Object[maxItems];
    }

    public boolean add(T item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                System.out.println("Добавили: " + item);
                return true;
            }
        }
        System.out.println("Коробка еще не полная");
        return false;
    }

    public T pick() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                throw new RuntimeException("Коробка не полная, осталось заполнить ячеек: " + (items.length - i));
            }
        }
        int randomInt = random.nextInt(items.length - 1);
        return items[randomInt];
    }
}
~~~
### Класс Main
~~~java
public class Main {
    public static void main(String[] args) {
        stringsMagicBox();
        numbersMagicBox();
    }

    protected static void stringsMagicBox() {
        System.out.println("Магическая коробка со строками: ");
        MagicBox<String> magicBox = new MagicBox<>(2);

        System.out.println("Добавление " + magicBox.add("Стрелы"));
        System.out.println("Добавление " + magicBox.add("Луки"));
        System.out.println("Добавление " + magicBox.add("Копья"));

        String pick = magicBox.pick();
        System.out.println(pick);
    }

    protected static void numbersMagicBox() {
        System.out.println("Магическая коробка с числами: ");
        MagicBox<Integer> magicBox = new MagicBox<>(3);

        System.out.println("Добавление " + magicBox.add(100));
        System.out.println("Добавление " + magicBox.add(200));
        //System.out.println("Добавление " + magicBox.add(300));

        Integer pick = magicBox.pick();
        System.out.println(pick);
    }
}
~~~
