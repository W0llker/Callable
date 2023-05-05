package byItAcademy.Lesson_17.Lesson;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
Создать задачу Callable, которая генерирует 10 файлов с 10 произвольными строками
 -> засыпает произвольно на 1-3 секунды, результат выполнения –коллекция имен файлов.
 Запустить 10 задач параллельно в пуле из 3 потоков. Вывести ход программы на экран с указанием имени потока,
  который выполняет работу.
 */
public class Main {
    public static void main(String[] args) {
        SavaFail savaFail = new SavaFail("1Поток");
        SavaFail savaFail1 = new SavaFail("2Поток");
        SavaFail savaFail2 = new SavaFail("3Поток");
        SavaFail savaFail3 = new SavaFail("4Поток");
        SavaFail savaFail4 = new SavaFail("5Поток");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<List<String>> future = executorService.submit(savaFail);
        Future<List<String>> future1 = executorService.submit(savaFail1);
        Future<List<String>> future2 = executorService.submit(savaFail2);
        Future<List<String>> future3 = executorService.submit(savaFail3);
        Future<List<String>> future4 = executorService.submit(savaFail4);
        try {
            List<String> list = future.get();
            System.out.println(list);

            List<String> list1 = future1.get();
            System.out.println(list1);

            List<String> list2 = future2.get();
            System.out.println(list2);

            List<String> list3 = future3.get();
            System.out.println(list3);

            List<String> list4 = future4.get();
            System.out.println(list4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
