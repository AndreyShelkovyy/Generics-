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
