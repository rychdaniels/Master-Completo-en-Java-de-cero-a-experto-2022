public class SentenciaFor {
    public static void main(String[] args) {

        for(int i = 0; i <= 10; i++) {
            System.out.println("i = " + i);
        }
        
        for(int i = 10; i >= 0; i--){
            System.out.println("i = " + i);
        }
        for(int i = 1, j = 10; i < j; i++, j--){
            System.out.println(i + " - " + j);
        }

        for(int i = 0; i <= 10; i++) {
            if( !(i % 2 == 0) ){
                continue;
            }
            System.out.println("i = " + i);
        }
    }
}
