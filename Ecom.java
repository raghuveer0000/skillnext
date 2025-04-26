import java.util.*;

class Product {
    private String name;
    private double price;

    Product(String n, double p) {
        this.name = n;
        this.price = p;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setPrice(double p) {
        this.price = p;
    }
}

class ShoppingCart {
    ArrayList<Product> cart = new ArrayList<>();

    public void addProduct(Product p) {
	for(Product b:cart){
		if(b.getName().equals(p.getName())){
		System.out.println("Duplicate product found: ");
		b.setPrice(b.getPrice()+p.getPrice());
		System.out.println("product price updated");
		return;
		}
	}
		cart.add(p);
		System.out.println("product price updated");
            }

    public void removeProduct(String name) {
        Iterator<Product> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                iterator.remove();
                System.out.println("Product is removed from cart");
                return;
            }
        }
        System.out.println("Given name: " + name + " not found in the cart");
    }

    public void displayCart() {
        if (cart.size() == 0) {
            System.out.println("No products in cart");
            return;
        }
        for (Product p : cart) {
            System.out.println(p.getName() + " Rs." + p.getPrice());
        }
    }

    public void checkout() {
        double total = 0.0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        if (total >= 100000.0) {
            total -= total * 0.1;
            System.out.println("10% discount applied");
        }
        System.out.printf("Total cost to be paid: Rs.%.2f\n", total);
    }
}

public class Ecom {
    static int menu() {
        System.out.println("1. Add\n2. Remove\n3. Display\n4. Checkout\n5. Exit\nEnter choice:");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        int ch = 0;
        String name = "";
        Scanner sc = new Scanner(System.in);

        while (true) {
            ch = menu();
            switch (ch) {
                case 1:
                    System.out.println("Enter product name: ");
                    name = sc.next();
                    System.out.println("Enter product price: ");
                    double price = sc.nextDouble();
                    Product p = new Product(name, price);
                    cart.addProduct(p);
                    break;
                case 2:
                    System.out.println("Enter product name to remove: ");
                    name = sc.next();
                    cart.removeProduct(name);
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    cart.checkout();
                    break;
                case 5:
                    System.out.println("Thank you for visiting!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
