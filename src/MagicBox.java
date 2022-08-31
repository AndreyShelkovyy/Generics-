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
