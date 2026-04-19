import java.util.*;
import java.time.Instant;
import java.time.LocalTime;

abstract class Payment {
    abstract void pay();
}

class User {
    private String u_name;
    private int u_id;
    private String u_phno;
    private String u_email;
    private String u_add;

    User(String u_name, int u_id, String u_phno, String u_email, String u_add) {
        this.u_name = u_name;
        this.u_id = u_id;
        this.u_phno = u_phno;
        this.u_email = u_email;
        this.u_add = u_add;
    }

    public String getUname() { return u_name; }
    public int getUid() { return u_id; }
    public String getUphno() { return u_phno; }
    public String getUemail() { return u_email; }
    public String getUadd() { return u_add; }
}

class Restaurant {
    private int r_id;
    public String res_name;
    public String res_add;
    public String res_phno;

    LocalTime openTime = LocalTime.of(8, 0);
    LocalTime closeTime = LocalTime.of(22, 0);

    Restaurant(int r_id, String res_name, String res_add, String res_phno) {
        this.r_id = r_id;
        this.res_name = res_name;
        this.res_add = res_add;
        this.res_phno = res_phno;
    }

    public int getRid() { return r_id; }
    public String getResname() { return res_name; }
    public String getResadd() { return res_add; }
    public String getResphno() { return res_phno; }

    public boolean shopavail() {
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(openTime) || currentTime.isAfter(closeTime)) {
            System.out.println("Sorry, " + res_name + " is closed now.");
            return false;
        } else {
            System.out.println("Welcome to " + res_name);
            return true;
        }
    }
}

class Menu {
    private int m_id;
    public String m_type;
    public double m_price;
    public String m_name;

    Menu(int m_id, String m_type, double m_price, String m_name) {
        this.m_id = m_id;
        this.m_type = m_type;
        this.m_price = m_price;
        this.m_name = m_name;
    }

    public int getMid() { return m_id; }
    public String getMname() { return m_name; }
}

class Order {
    private int order_id;
    public int quantity;
    public double total_price;
    public String order_status;
    Instant order_time;
    Menu menu;
    Restaurant res;

    Order(int order_id, int quantity, double total_price, String order_status, Instant order_time, Menu menu, Restaurant res) {
        this.order_id = order_id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.order_status = order_status;
        this.order_time = order_time;
        this.menu = menu;
        this.res = res;
    }

    public int getOrder_id() { return order_id; }

    public void orderdetails() {
        System.out.println("Order ID: " + order_id);
        System.out.println("Menu: " + menu.getMname());
        System.out.println("Restaurant: " + res.getResname());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + total_price);
        System.out.println("Status: " + order_status);
        System.out.println("Time: " + order_time);
    }
}

class PaymentProcess extends Payment {
    private int payment_id;
    public String payment_method;
    public double payment_amount;
    Order order;

    PaymentProcess(int payment_id, String payment_method, double payment_amount, Order order) {
        this.payment_id = payment_id;
        this.payment_method = payment_method;
        this.payment_amount = payment_amount;
        this.order = order;
    }

    public void pay() {
        System.out.println("Payment ID: " + payment_id);
        System.out.println("Order ID: " + order.getOrder_id());
        System.out.println("Amount: " + payment_amount);
        System.out.println("Method: " + payment_method);
        System.out.println("Payment Time: " + Instant.now());
        System.out.println("Payment Success");
    }
}

class DeliveryPartner {
    private int partner_id;
    public String partner_name;
    public String partner_phno;
    User user;
    Order order;

    DeliveryPartner(int partner_id, String partner_name, String partner_phno, User user, Order order) {
        this.partner_id = partner_id;
        this.partner_name = partner_name;
        this.partner_phno = partner_phno;
        this.user = user;
        this.order = order;
    }

    public void deliverypartnerDetails() {
        System.out.println("Partner ID: " + partner_id);
        System.out.println("Order ID: " + order.getOrder_id());
        System.out.println("User Name: " + user.getUname());
        System.out.println("Address: " + user.getUadd());
        System.out.println("Contact: " + user.getUphno());
        System.out.println("Delivery Partner: " + partner_name);
        System.out.println("Partner Phone: " + partner_phno);
        System.out.println("Delivery Status: On the way");
    }
}

public class FoodDelivery {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter User Name:");
        String user_name = sc.nextLine();

        System.out.println("Enter User Phone:");
        String user_phno = sc.nextLine();

        System.out.println("Enter User Email:");
        String user_email = sc.nextLine();

        System.out.println("Enter User Address:");
        String user_add = sc.nextLine();

        User user = new User(user_name, 1, user_phno, user_email, user_add);

        System.out.println("Enter Restaurant Name:");
        String res_name = sc.nextLine();

        System.out.println("Enter Restaurant Address:");
        String res_add = sc.nextLine();

        System.out.println("Enter Restaurant Phone:");
        String res_phno = sc.nextLine();

        Restaurant res = new Restaurant(1, res_name, res_add, res_phno);

        if (res.shopavail()) {

            System.out.println("Enter Menu Type:");
            String menu_type = sc.nextLine();

            System.out.println("Enter Menu Price:");
            double menu_price = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter Menu Name:");
            String menu_name = sc.nextLine();

            Menu menu = new Menu(1, menu_type, menu_price, menu_name);

            System.out.println("Enter Quantity:");
            int quantity = sc.nextInt();
            sc.nextLine();

            double total_price = menu_price * quantity;

            System.out.println("Enter Order Status:");
            String order_status = sc.nextLine();

            Order order = new Order(1, quantity, total_price, order_status, Instant.now(), menu, res);

            System.out.println("Enter Payment Method:");
            String payment_method = sc.nextLine();

            PaymentProcess payment = new PaymentProcess(1, payment_method, total_price, order);

            System.out.println("Enter Delivery Partner Name:");
            String partner_name = sc.nextLine();

            System.out.println("Enter Delivery Partner Phone:");
            String partner_phno = sc.nextLine();

            DeliveryPartner partner = new DeliveryPartner(1, partner_name, partner_phno, user, order);

            order.orderdetails();
            payment.pay();
            partner.deliverypartnerDetails();
        } else {
            System.out.println("Try again later");
        }

        sc.close();
    }
}