package File_Test;

import java.io.File;

public class FileTest03 {
    public static void main(String[] args) {
        String filePath = ".";
        File file2;
        int i = 1;
        while (i <= 100){
            filePath = filePath + "\\" + i;
            i++;
        }
        file2 = new File(filePath);
        String[] strs = file2.list();
        pieFile(strs);
    }
    public static void pieFile(String[] strs){
        String filePath = "";
        for (String str : strs) {
            filePath = filePath + File.separator + str;
        }
        deleteFile(filePath);
    }
    public static void deleteFile(String path){
        File file = new File(path);
        if(!file.exists()){
            file.delete();
        }
        String[] Strs = file.list();
        pieFile(Strs);
    }
}
