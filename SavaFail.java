package byItAcademy.Lesson_17.Lesson;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;


public class SavaFail implements Callable<List<String>> {
    private final String name;
    public SavaFail(String name) {
        this.name = name;
    }


    @Override
    public List<String> call() throws Exception {
        Thread.currentThread().setName(name);
        List<String> list = new ArrayList<>();
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            File file = new File("src/byItAcademy/Lesson_17/Lesson/", "Файл" + (Math.random() * 100) + ".txt");
            writeString(file);
            list.add(file.getName());

        }
        return list;
    }
    public void writeString(File file) {
        String randomString = "";
        for (int i = 0; i < 10; i++) {
            randomString += UUID.randomUUID() + " ";
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(randomString);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
