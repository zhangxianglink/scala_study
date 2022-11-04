package book.chapter11;

/**
 * @author xiangzhang
 * @since 2022-11-04 11:52
 */
public class Demo2 {
    public static Integer loop2(Integer num){
        if (num == 1){
            return 1;
        }else {
            return num * loop2(num -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(loop2(5));
    }
}
