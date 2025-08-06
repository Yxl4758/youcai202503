package File_Test;

import java.io.File;

public class FileTest02 {
    public static void main(String[] args) {
        String filePath = ".\\a.txt";
        String newPath = ".";
        File file2 = new File(filePath);
        int i = 1;
        while (i <= 100){
            newPath = newPath + "\\" + i;
            i++;
        }
        filePath = newPath + File.separator + filePath;
        file2.renameTo(new File(filePath));
    }
}
