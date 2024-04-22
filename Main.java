import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Food implements Serializable {
    int itemno;
    int quantity;
    float price;

    Food(int itemno, int quantity) {
        this.itemno = itemno;
        this.quantity = quantity;
        switch (itemno) {
            case 1:
                price = quantity * 50;
                break;
            case 2:
                price = quantity * 60;
                break;
            case 3:
                price = quantity * 70;
                break;
            case 4:
                price = quantity * 30;
                break;

        }
    }

}

class Singleroom implements Serializable {

    String name;
    String contact;
    String gender;
    ArrayList<Food> food = new ArrayList<>();

    Singleroom() {
        name = "";
    }

    Singleroom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}

class Doubleroom extends Singleroom implements Serializable {

    String name;
    String contact;
    String gender;
    String name2;
    String contact2;
    String gender2;
    ArrayList<Food> food = new ArrayList<>();

    Doubleroom() {
        name = "";
        name2 = "";
    }

    Doubleroom(String name, String contact, String gender, String name2, String contact2, String gender2) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }
}

class NotAvailable extends Exception {
    @Override
    public String toString() {
        return "NotAvailable!";
    }

}

class holder implements Serializable {
    Doubleroom luxury_Doubleroom[] = new Doubleroom[10];
    Doubleroom delux_Doubleroom[] = new Doubleroom[20];
    Singleroom luxury_Singleroom[] = new Singleroom[10];
    Singleroom delux_Singleroom[] = new Singleroom[20];

}

class Hotel {
    static holder hotel_ob = new holder();
    static Scanner sc = new Scanner(System.in);

    static void CustomerDetail(int rn, int i) {
        String name;
        String contact;
        String gender;
        String name2 = null;
        String contact2 = null;
        String gender2 = null;

        System.out.println("Enter your name");
        name = sc.next();
        System.out.println("Enter your contact");
        contact = sc.next();
        System.out.println("Enter your gender");
        gender = sc.next();
        if (i < 3) {

            System.out.println("Enter your name");
            name2 = sc.next();
            System.out.println("Enter your contact");
            contact2 = sc.next();
            System.out.println("Enter your gender");
            gender2 = sc.next();
        }
        switch (i) {

            case 1:
                hotel_ob.luxury_Singleroom[rn] = new Singleroom(name, contact, gender);
                break;

            case 2:
                hotel_ob.delux_Singleroom[rn] = new Singleroom(name, contact, gender);
                break;

            case 3:
                hotel_ob.luxury_Doubleroom[rn] = new Doubleroom(name, name2, contact, contact2, gender, gender2);
                break;

            case 4:
                hotel_ob.delux_Doubleroom[rn] = new Doubleroom(name, name2, contact, contact2, gender, gender2);
                break;
            default:
                System.out.println("Wrong Option!");
                break;

        }

    }

    static void bookroom(int i) {
        int rn;
        int j;
        System.out.println("Choose room no from");
        switch (i) {
            case 1:
                for (j = 0; j < hotel_ob.luxury_Singleroom.length; j++) {
                    if (hotel_ob.luxury_Singleroom[j] == null) {
                        System.out.println(j + 1 + ",");
                    }
                    System.out.println("Enter room number:");
                    try {
                        rn = sc.nextInt();
                        rn--;

                        if (hotel_ob.luxury_Singleroom[rn] != null)
                            throw new NotAvailable();
                        CustomerDetail(rn, i);
                    } catch (Exception e) {
                        System.out.println("Invalid Option!");
                        return;
                    }

                }
                break;

            case 2:
                for (j = 0; j < hotel_ob.delux_Singleroom.length; j++) {
                    if (hotel_ob.delux_Singleroom[j] == null) {
                        System.out.println(j + 11 + ",");

                        System.out.println("Enter room number");
                        try {
                            rn = sc.nextInt();
                            rn = rn - 11;
                            CustomerDetail(rn, i);
                            if (hotel_ob.delux_Singleroom[rn] != null) {
                                throw new NotAvailable();

                            }
                        } catch (Exception e) {
                            System.out.println("Invalid option!");
                            return;

                        }

                    }
                }
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_Doubleroom.length; j++) {
                    if (hotel_ob.luxury_Doubleroom[j] == null) {
                        System.out.println(j + 31 + ",");
                        System.out.println("Enter you number");
                        try {
                            rn = sc.nextInt();
                            rn = rn - 31;

                            if (hotel_ob.luxury_Doubleroom[rn] != null)
                                throw new NotAvailable();
                            CustomerDetail(rn, i);
                        } catch (Exception e) {
                            System.out.println("Invalid Option!");
                            return;
                        }

                    }
                }
                break;
            case 4:
                for (j = 0; j < hotel_ob.delux_Doubleroom.length; j++) {
                    if (hotel_ob.delux_Doubleroom[j] == null) {
                        System.out.println(j + 41 + ",");
                    }
                    System.out.println("Enter your number");
                    try {
                        rn = sc.nextInt();
                        rn = rn - 41;
                        if (hotel_ob.delux_Doubleroom[rn] != null)
                            throw new NotAvailable();
                        CustomerDetail(rn, i);
                    } catch (Exception e) {
                        System.out.println("Invalid Option!");
                        return;
                    }

                }
                break;
            default:
                System.out.println("Invalid Option!");
        }

        System.out.println("Room Booked!");
    }

    static void features(int i) {
        switch (i) {
            case 1:
                System.out.println("Number of double beds 1\nAC: Yes\n Free Breakfast Yes\n Charges per day: 4000 ");
                break;
            case 2:
                System.out.println("Number of double beds \1nAC: No\n Free Breakfast Yes\n Charges per day: 3000 ");
                break;
            case 3:
                System.out.println("Number of single beds 1\nAC: Yes\n Free Breakfast Yes\n Charges per day: 2200 ");
                break;
            case 4:
                System.out.println("Number of single beds 1\nAC: No\n Free Breakfast Yes\n Charges per day: 1200 ");
                break;

            default:
                System.out.println("Enter valid option");
                break;
        }

    }

    static void availability(int i) {
        int j;
        int count = 0;

        switch (i) {
            case 1:
                for (j = 0; j < hotel_ob.luxury_Singleroom.length; j++) {
                    if (hotel_ob.luxury_Singleroom[j] == null)
                        count++;
                }
                break;
            case 2:
                for (j = 0; j < hotel_ob.delux_Singleroom.length; j++) {
                    if (hotel_ob.delux_Singleroom[j] == null)
                        count++;

                }
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_Doubleroom.length; j++) {
                    if (hotel_ob.luxury_Doubleroom[j] == null)
                        count++;

                }
                break;
            case 4:
                for (j = 0; j < hotel_ob.delux_Doubleroom.length; j++) {
                    if (hotel_ob.delux_Doubleroom[j] == null)
                        count++;

                }
                break;
            default:
                System.out.println("Invalid Option!");
                break;

        }

    }

    static void bill(int rn, int rtype) {
        double amount = 0;
        String list[] = { "Sandwich", "Coke", "Roll", "Pasta" };
        System.out.println("\n***********");
        System.out.println("Your Bill");
        System.out.println("***********");

        switch (rtype) {
            case 1:
                amount += 4000;
                System.out.println("Room Charge = " + 4000);
                System.out.println("\n-----------------------------");
                System.out.println("Food Charges");
                System.out.println("-------------------------------");
                System.out.println("Item Quantity Price");
                for (Food obb : hotel_ob.luxury_Doubleroom[rn].food) {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }

                break;
            case 2:
                amount += 3000;
                System.out.println("Room Charge = " + 3000);
                System.out.println("\n-----------------------------");
                System.out.println("Food Charges");
                System.out.println("-------------------------------");
                System.out.println("Item Quantity Price");
                for (Food obb : hotel_ob.delux_Doubleroom[rn].food) {

                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            case 3:
                amount += 2200;
                System.out.println("Room Charge " + 2200);
                System.out.println("\n-----------------------------");
                System.out.println("Food Charges");
                System.out.println("--------------------------------");
                System.out.println("Item Quantity Price");
                for (Food obb : hotel_ob.luxury_Singleroom[rn].food) {
                    amount += obb.price;

                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            case 4:
                amount += 1200;
                System.out.println("Room Charges" + 1200);
                System.out.println("\n--------------------------------");
                System.out.println("Food Charges");
                System.out.println("-----------------------------------");
                System.out.println("Item Quantity Charges");
                for (Food obb : hotel_ob.delux_Singleroom[rn].food) {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            default:
                System.out.println("Invalid Option");
        }
        System.out.println("Total Amount" + amount);
    }

    static void deallocate(int rn, int rtype) {
        char w;
        switch (rtype) {
            case 1:
                if (hotel_ob.luxury_Singleroom[rn] != null) {
                    System.out.println("Room allocated by" + hotel_ob.luxury_Singleroom[rn].name);
                } else {
                    System.out.println("Already Empty");
                    return;
                }
                System.out.println("Do you want to checkout Y/N");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.luxury_Singleroom[rn] = null;
                    System.out.println("deallocated successfully");
                }
                break;

            case 2:
                if (hotel_ob.delux_Singleroom[rn] != null) {

                    System.out.println("Room already occupied by" + hotel_ob.delux_Singleroom[rn].name);
                } else {
                    System.out.println("Already Empty");
                    return;
                }
                System.out.println("Do you want to checkout Y/N");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    System.out.println("Deallocated successfully");
                }
                break;
            case 3:
                if (hotel_ob.luxury_Doubleroom[rn] != null) {
                    System.out.println("Room already allocated by" + hotel_ob.luxury_Doubleroom[rn].name);
                } else {
                    System.out.println("Already Empty");
                    return;
                }
                System.out.println("Do you want to checkout");
                w = sc.next().charAt(0);
                if (w == 'Y' || w == 'y') {
                    bill(rn, rtype);
                    hotel_ob.luxury_Doubleroom = null;
                    System.out.println("Deallocated successfully");

                }
            case 4:
                if (hotel_ob.delux_Doubleroom[rn] != null) {
                    System.out.println("Room occupied by" + hotel_ob.delux_Doubleroom[rn].name);
                } else {
                    System.out.println("Already empty");
                    return;
                }
                System.out.println("Do you want to checkout Y/N");
                w = sc.next().charAt(0);
                if (w == 'Y' || w == 'y') {
                    bill(rn, rtype);
                    hotel_ob.delux_Doubleroom = null;
                }
                System.out.println("Deallocated successfully");

            default:
                break;
        }
    }

    static void order(int rn, int rtype) {
        int wish = 0;

        try {
            System.out.println("=======================================");
            System.out.println("---------------Menu--------------------");
            System.out.println("=======================================");
            System.out.println("1. Sandwich: Rs.70\n 2. Coke: Rs.50\n 3. Roll: Rs.120\n 4. Pasta: Rs.700");

            do {
                int i = 0;
                int q = 0;

                System.out.println("What do you want to order?");
                i = sc.nextInt();

                System.out.println("Quantity");
                q = sc.nextInt();
                switch (rtype) {
                    case 1:
                        hotel_ob.luxury_Singleroom[rn].food.add(new Food(i, q));
                        break;
                    case 2:
                        hotel_ob.delux_Singleroom[rn].food.add(new Food(i, q));
                        break;
                    case 3:
                        hotel_ob.luxury_Doubleroom[rn].food.add(new Food(i, q));
                        break;
                    case 4:
                        hotel_ob.delux_Doubleroom[rn].food.add(new Food(i, q));
                    default:
                        System.out.println("Invalid Option!");
                        break;
                }

                System.out.println("Do you want to order anything else?");
                wish = sc.next().charAt(0);
            } while (wish == 'Y' || wish == 'y');
            order(rn, rtype);
        }

        catch (NullPointerException e) {
            System.out.println("Room not booked");
        } catch (Exception e) {
            System.out.println("cannot be done");
        }
    }

}

class write implements Runnable {
    holder hotel_ob;

    write(holder hotel_ob) {
        this.hotel_ob = hotel_ob;
    }

    @Override
    public void run() {
        try {
            FileOutputStream fout = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);

        } catch (Exception e) {
            System.out.println("Error in writing" + e);
        }

    }
}

class Main {
    public static void main(String[] args) {
        try {
            File f = new File("backup");
            if (f.exists()) {
                FileInputStream fin = new FileInputStream("backup");
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (holder) ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch, ch2;
            char wish;
            x: do {
                System.out.println(
                        "\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
                ch = sc.nextInt();

                switch (ch) {

                    case 1:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.println("Enter room number");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.order(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.order(ch2, 3);
                        else if (ch2 > 20)
                            Hotel.order(ch2, 2);
                        else if (ch2 > 10)
                            Hotel.order(ch2, 1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.println("Enter room number");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.deallocate(ch2, 4);
                        else if (ch2 > 30)
                            Hotel.deallocate(ch2, 3);
                        else if (ch2 > 20)
                            Hotel.deallocate(ch2, 2);
                        else if (ch2 > 10)
                            Hotel.deallocate(ch2, 1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:
                        break x;
                }

                System.out.println("\nContinue: (Y/N)?");
                wish = sc.next().charAt(0);
                if (!(wish == 'Y' || wish == 'y' || wish == 'N' || wish == 'n')) {
                    System.out.println("Invalid option!");
                    System.out.println("\nContinue: (Y/N)?");
                    wish = sc.next().charAt(0);

                }
            } while (wish == 'Y' || wish == 'y');
            Thread t = new Thread(new write(Hotel.hotel_ob));

            t.start();
        } catch (Exception e) {
            System.out.println("Not a valid input!");
        }
    }
}
