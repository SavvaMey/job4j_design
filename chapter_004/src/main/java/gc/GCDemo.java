package gc;

public class GCDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        info();

        for (int i = 0; i < 1500; i++) {
            new User(i, "N" + i);
        }
        info();
    }
    /*
    Пустой объект без полей занимает для 64 битной системы: 16 байт
	объект c полями занимает 24 байта (12 байт заголовок + 16 байт String + 4 байт Int)
    24*1500=36000 байт  -> 36 кБ - сборщик мусора при 4 мб выделенной
    памяти вызывается
     */
}
