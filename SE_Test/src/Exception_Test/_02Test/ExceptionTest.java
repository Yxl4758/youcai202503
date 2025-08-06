package Exception_Test._02Test;

public class ExceptionTest {
    public int arrayProcessing (String[] arr)throws Exception{
        int n = arr.length;
        int sum = 0;
        for(int i=0;i < n;i++){
            if(arr[i]==null){
                throw new NullPointerException(i + "位置上的字符串为空");
            }
            try {
                int a = Integer.parseInt(arr[i]);
                sum += a;
            }catch (NumberFormatException e){
                throw new NumberFormatException(arr[i] + "无法转换为整数");
            }
            if(i >= n){
                throw new ArrayIndexOutOfBoundsException(i + "越界了");
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] str = {"123","456","654","321"};
        try {
            int sum = new ExceptionTest().arrayProcessing(str);
            System.out.println(sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
