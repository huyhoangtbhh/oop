public class Introduction {
    public static void main(String[] args) {

        System.out.println("Bui Huy Hoang\t24020136\tINT22041\thuyhoantbhh\t24020136@vnu.edu.vn");

        for (int i = 9; i >= 1; i--) {
            if (i > 1) {
                System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
                System.out.println("Take one down, pass it around,");
            } else {

                System.out.println(i + " bottle of beer on the wall, " + i + " bottle of beer.");
                System.out.println("Take one down, pass it around,");
                System.out.println("No more bottles of beer on the wall.");
            }
        }
    }
}
