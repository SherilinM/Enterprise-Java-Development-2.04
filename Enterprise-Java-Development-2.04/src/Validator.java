import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean checkName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+\\s[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$");
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) throw new IllegalArgumentException("Name format must be Name Surname");
        return true;

    }

    public static boolean checkAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age must be greater than zero or zero");
        return true;
    }

    public static boolean writePerson(Person person)  {
        File dir = new File("src/main/resources/PersonDatabase/" + person.getName() + ".csv");
        try {
            createFile(person, dir);
        } catch (IOException e) {
            System.out.println("Couldn't create file");
            e.printStackTrace();
            return false;
        }

        return true;

    }

    private static void createFile(Person person, File dir) throws IOException {
        File file = new File(dir.getPath());
        FileWriter fileWriter = new FileWriter(file);

        file.createNewFile();
        fileWriter.write(person.toString());
        fileWriter.close();
    }
}