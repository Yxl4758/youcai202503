package File_Test;

import java.io.File;

public class FileTest01 {
    public static void main(String[] args) {
        String filePath = ".";
        File file;
        int i = 1;
        while (i <= 100){
            filePath = filePath + "\\"+i;
            file = new File(filePath);
            file.mkdirs();
            i++;
        }
    }
}
