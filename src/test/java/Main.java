
public class Main {

    public static void main(String[] args) {

         WishListTest wishlist = new WishListTest();
         wishlist.addtoWishlist();

        RegisterTest register = new RegisterTest();
        register.registernew();

        LoginTest login = new LoginTest();
        login.loginWithValidCredentials();
        login.loginWithInvalidCredentials();

        System.out.println("\n Tests Completed \n");
    }
}
