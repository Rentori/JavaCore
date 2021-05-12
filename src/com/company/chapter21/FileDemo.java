package chapter21;

import java.io.File;

public class FileDemo {
    static final String path = "/home/viktor/java-projects/JavaCore/src/chapter21/chapter21.txt";

    static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File(path);
        print("Имя файла: " + f1.getName());
        print("Путь: " + f1.getPath());
        print("Абсолютный путь: " + f1.getAbsolutePath());
        print("Родительский каталог: " + f1.getParent());
        print(f1.exists() ? "Существует" : "Не существует");
        print(f1.canWrite() ? "Доступен для записи" : "Не доступен для записи");
        print(f1.canRead() ? "Доступен для чтения" : "Не доступен для чтения");
        print(f1.isDirectory() ? "Является каталогом" : "Не является каталогом");
        print(f1.isFile() ? "Является файлом" : "Не является файлом");
        print(f1.isAbsolute() ? "Является абсолютным" : "Не является абсолютным");
        print("Последние изменения: " + f1.lastModified());
        print("Размер: " + f1.length() + " байт");
    }
}
