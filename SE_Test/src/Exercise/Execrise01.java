package Exercise;

import java.io.*;

public class Execrise01 {
    public static void main(String[] args) {
        File source = new File("D:\\a1");
        File dest = new File("F:\\b");
        copyFile(source,dest);
    }
/**
 *      try (
 *                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
 *                 BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
 *                 )
 *         {
 *
 *         }catch (IOException e){
 *             e.printStackTrace();
 *         }
 */
    /**
     *
     * @param source  :可以是一个文件夹，可能是一个文件
     * @param dest  : 是一个文件夹
     */
    public static void copyFile(File source, File dest){
        dest = new File(dest, source.getName());
        if (source.listFiles() != null) {
            for (String files : source.list()) {
                source = new File(source,files);
                copyFile(source, dest);
                source = source.getParentFile();
            }
        }
        if (source.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdirs();
            }
        }else if (source.exists()) {
            dest.getParentFile().mkdirs();
            try(BufferedReader br = new BufferedReader(new FileReader(source));
                PrintWriter pw = new PrintWriter(new PrintWriter(dest)))
            {
                while (br.readLine() != null) {
                    pw.println(br.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
