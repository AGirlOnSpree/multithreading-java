package multitreading.threadlocal;

import java.util.List;
import java.util.stream.Collectors;

class User implements Runnable {

    private Cart cart;
    private List<String> needs;

    public User(Cart cart, List<String> needs) {
        this.cart = cart;
        this.needs = needs;
    }

    @Override
    public void run() {
        for (String need : needs) {
            cart.addItem(need);
        }
        System.out.println(Thread.currentThread().getName() + " read " + cart.getItems().stream().collect(Collectors.joining(", ", "[", "]")));
    }
}


public class Driver {

    public static void main(String[] args) {

        Cart cart1 = new Cart();

        Thread t1 = new Thread(new User(cart1, List.of("rice", "dal")), "Thread1");

        Thread t2 = new Thread(new User(cart1, List.of("taco", "mexican rice")), "Thread2");

        t1.start();
        t2.start();
    }
}
