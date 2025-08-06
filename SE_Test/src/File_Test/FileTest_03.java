package File_Test;

import java.io.File;

public class FileTest_03 {
    public static void main(String[] args) {
        File file = new File(".\\out");
        File result = deleteFile(file);
        System.out.println(result);
    }
    public static File deleteFile(File file) {
        if (file.getName().equals(".")){
            return null;
        }
        if (file.listFiles() != null){
            for(File file1 : file.listFiles()){
                deleteFile(file1);
            }
        }
        file.delete();
        return (new File(file.getParent()));
    }
}
