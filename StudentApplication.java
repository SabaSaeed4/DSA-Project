package DSA;

/**
 *
 * @author Saba saeed
 */
import java.util.Hashtable;
import java.util.Scanner;

public class StudentApplication {

    Scanner in = new Scanner(System.in);

    private Record head = new Record();
    private int size;

    // add student record at first
    public void addFirst(String name, String fname, int rollno, String city, String classs, String email) {
        head.next = head.next.prev = new Record(name, fname, rollno, city, classs, email, head, head.next);
        ++size;
    }

    //add student record at last
    public void addLast(String name, String fname, int rollno, String city, String classs, String email) {
        head.prev = head.prev.next = new Record(name, fname, rollno, city, classs, email, head.prev, head);
        ++size;
    }

    // Remove 
    // Remove first record
    public void removeFirst() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        String a = head.next.name + "  " + head.next.fname + " " + head.next.rollno + " " + head.next.city + " " + head.next.classs + " " + head.next.email;
        head.next = head.next.next;
        head.next.prev = head;
        System.out.println("\nRecord has deleted successfully..");
        --size;
    }

    // remove last record
    public void removeLast() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        String a = head.prev.name + "  " + head.prev.fname + " " + head.prev.rollno + " " + head.prev.city + " " + head.prev.classs + " " + head.prev.email;
        head.prev = head.prev.prev;
        head.prev.next = head;
        System.out.println("\nRecord has deleted successfully..");
        --size;
    }

    //Remove all records at once
    public void removeAll() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        head.name = null;
        head.fname = null;
        head.rollno = 0;
        head.city = null;
        head.classs = null;
        head.email = null;
        head.next = null;
        head.prev = null;
        size = 0;
        System.out.println("\nAll Records have deleted successfully..");
        System.out.println();
    }

    // You have 2 options
    //1. remove using email
    public boolean removeByEamil() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return false;
        }
        System.out.println("Enter email of the student: ");
        String email = in.next();
        for (Record a = head.next; a != head.prev; a = a.next) {
            if (a.next.email.equals(email)) {
                a.next = a.next.next;
                a.next.prev = a;
                --size;
                System.out.println("\nRecord has deleted successfully..");
                return true;
            } else {
                System.out.println("\nIncorrect Email..");
            }
        }
        if (head.prev.email.equals(email)) {
            head.prev = head.prev.prev;
            head.prev.next = head;
            --size;
            System.out.println("\nRecord has deleted successfully..");
            return true;
        } else {
            System.out.println("\nIncorrect Email..");
            return false;
        }
    }

    //remove using rollno
    public boolean removeByRollno() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return false;
        }
        System.out.println("Enter Rollno of the student: ");
        int rollno = in.nextInt();
        for (Record a = head.next; a != head.prev; a = a.next) {
            if (a.next.rollno == rollno) {
                a.next = a.next.next;
                a.next.prev = a;
                --size;
                System.out.println("\nRecord has deleted successfully..");
                return true;
            } else {
                System.out.println("\nNo record found..");
            }
        }
        if (head.prev.rollno == rollno) {
            head.prev = head.prev.prev;
            head.prev.next = head;
            --size;
            System.out.println("\nRecord has deleted successfully..");
            return true;
        } else {
            System.out.println("\nNo record found..");
            return false;
        }
    }

    //Traverse Loop from first using head.next to traverse upto last record
    public void viewFromFirst() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        System.out.println("STUDENT NAME       FATHER NAME       ROLL NO            CITY         CLASS              EMAIL");
        for (Record a = head.next; a != head.prev; a = a.next) {
            System.out.println(a.name + "         \t    " + a.fname + "         \t" + a.rollno + "         \t" + a.city + "         \t" + a.classs + "         \t" + a.email);
        }
        System.out.println(head.prev.name + "         \t    " + head.prev.fname + "         \t" + head.prev.rollno + "         \t" + head.prev.city + "         \t" + head.prev.classs + "         \t" + head.prev.email);
    }

    //Traverse Loop from last record using head.prev to traverse upto first record...in opposite direction
    public void viewFromLast() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        System.out.println("STUDENT NAME       FATHER NAME       ROLL NO            CITY         CLASS              EMAIL");
        for (Record a = head.prev; a != head.next; a = a.prev) {
            System.out.println(a.name + "         \t    " + a.fname + "         \t    " + a.rollno + "         \t    " + a.city + "         \t    " + a.classs + "         \t    " + a.email);
        }
        System.out.println(head.next.name + "         \t" + head.next.fname + "         \t" + head.next.rollno + "         \t" + head.next.city + "         \t" + head.next.classs + "         \t" + head.next.email);
    }

    //View top record
    public void viewFirst() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        System.out.println("STUDENT NAME       FATHER NAME       ROLL NO            CITY         CLASS              EMAIL");
        System.out.println(head.next.name + "         \t" + head.next.fname + "         \t" + head.next.rollno + "         \t" + head.next.city + "         \t" + head.next.classs + "         \t" + head.next.email);
    }

    //view last record
    public void viewLast() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        System.out.println("STUDENT NAME       FATHER NAME       ROLL NO            CITY         CLASS              EMAIL");
        System.out.println(head.prev.name + "         \t" + head.prev.fname + "         \t" + head.prev.rollno + "         \t" + head.prev.city + "         \t" + head.prev.classs + "         \t" + head.prev.email);
    }

    //Sorting Part
    //Sort rollno in ascending order
    public void sortByRollnoASC() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        Record record[] = new Record[size];
        int count = 0;
        Record temp;
        for (Record i = head.next; i != head.prev; i = i.next) {
            record[count] = i;
            count++;
        }
        record[record.length - 1] = head.prev;

        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record.length - 1 - i; j++) {
                if (record[j + 1].rollno < record[j].rollno) {
                    temp = record[j + 1];
                    record[j + 1] = record[j];
                    record[j] = temp;
                }
            }
        }
        for (int i = 0; i < record.length; i++) {
            System.out.println(record[i].name + "  " + record[i].fname + "  " + record[i].rollno + "  " + record[i].city + "  " + record[i].classs + "  " + record[i].email);
        }
    }

    //Sort rollno in descending order
    public void sortByRollnoDESC() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        Record record[] = new Record[size];
        int count = 0;
        Record temp;
        for (Record i = head.next; i != head.prev; i = i.next) {
            record[count] = i;
            count++;
        }
        record[record.length - 1] = head.prev;

        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record.length - 1 - i; j++) {
                if (record[j + 1].rollno > record[j].rollno) {
                    temp = record[j + 1];
                    record[j + 1] = record[j];
                    record[j] = temp;
                }
            }
        }
        for (int i = 0; i < record.length; i++) {
            System.out.println(record[i].name + "  " + record[i].fname + "  " + record[i].rollno + "  " + record[i].city + "  " + record[i].classs + "  " + record[i].email);
        }
    }

    //Sort name in ascending order
    public void sortByNameASC() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        Record record[] = new Record[size];
        int count = 0;
        Record temp;
        for (Record i = head.next; i != head.prev; i = i.next) {
            record[count] = i;
            count++;
        }
        record[record.length - 1] = head.prev;

        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record.length - 1 - i; j++) {
                if (record[j].name.compareTo(record[j + 1].name) > 0) {
                    temp = record[j];
                    record[j] = record[j + 1];
                    record[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < record.length; i++) {
            System.out.println(record[i].name + "  " + record[i].fname + "  " + record[i].rollno + "  " + record[i].city + "  " + record[i].classs + "  " + record[i].email);
        }
    }

    //Sort name in descending order
    public void sortByNameDESC() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        Record record[] = new Record[size];
        int count = 0;
        Record temp;
        for (Record i = head.next; i != head.prev; i = i.next) {
            record[count] = i;
            count++;
        }
        record[record.length - 1] = head.prev;

        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record.length - 1 - i; j++) {
                if (record[j].name.compareTo(record[j + 1].name) < 0) {
                    temp = record[j];
                    record[j] = record[j + 1];
                    record[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < record.length; i++) {
            System.out.println(record[i].name + "  " + record[i].fname + "  " + record[i].rollno + "  " + record[i].city + "  " + record[i].classs + "  " + record[i].email);
        }
    }

    //Update email
    public boolean updateEmail() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return false;
        }
        System.out.println("Enter your Old Email address: ");
        String oldEmail = in.next();
        System.out.println("Enter your New Email address: ");
        String newEmail = in.next();
        for (Record i = head.next; i != head.prev; i = i.next) {
            if (i.email.equals(oldEmail)) {
                System.out.println("Your old Email is: " + i.email);
                i.email = newEmail;
                System.out.println("Your updated Email is: " + i.email);
                System.out.println("\nupdated Successfully... ");
                return true;
            }
            else {
            System.out.println(oldEmail + " is not present");
        }
        }
        if (head.prev.email.equals(oldEmail)) {
            System.out.println("Your old Email is: " + head.prev.email);
            head.prev.email = newEmail;
            System.out.println("Your updated Email is: " + head.prev.email);
            System.out.println("\nupdated Successfully... ");
            return true;
        }
        else {
            System.out.println(oldEmail + " is not present");
            return false;
        }
    }

    // update name
    public boolean updateName() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return false;
        }
        System.out.println("Enter email:");
        String e = in.next();
        System.out.println("Enter Name:");
        String newName = in.next();
        for (Record i = head.next; i != head.prev; i = i.next) {
            if (i.email.equals(e)) {
                System.out.println("Your old name is: " + i.name);
                i.name = newName;
                System.out.println("Your Updated name is: " + i.name);
                System.out.println("\nupdated Successfully... ");
                return true;
            }
            else {
            System.out.println(e + " is not present");
            return false;
        }
        }
        if (head.prev.email.equals(e)) {
            System.out.println("Your old name is: " + head.prev.name);
            head.prev.name = newName;
            System.out.println("Your Updated name is: " + head.prev.name);
            System.out.println("\nupdated Successfully... ");
            return true;
        }
        else {
            System.out.println(e + " is not present");
            return false;
        }
    }

    //Search by email 
    public void searchByEmail() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        System.out.println("Enter Email:");
        String email = in.next();
        Hashtable h = new Hashtable();
        for (Record i = head.next; i != head.prev; i = i.next) {
            h.put(i.email, i.rollno);
        }
        h.put(head.prev.email, head.prev.rollno);
        Object value = h.get(email);
        if (value != null) {
            System.out.println(email + "  " + value);
        } else {
            System.out.println(email + " is not present");
        }
    }

    //search by rollno
    public void searchByRollno() {
        if (size == 0) {
            System.out.println("Record list is empty!");
            return;
        }
        System.out.println("Enter Rollno");
        int key = in.nextInt();
        Hashtable h = new Hashtable();
        for (Record i = head.next; i != head.prev; i = i.next) {
            h.put(i.rollno, i.email);
        }
        h.put(head.prev.rollno, head.prev.email);
        Object value = h.get(key);
        if (value != null) {
            System.out.println(value + "  " + key);
        } else {
            System.out.println(key + " is not present");
        }
    }

    public static void starLine() {
        System.out.println();
        for (int i = 1; i < 61; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    //View all records 
    public void view() {
        starLine();
        System.out.println("                   VIEW OPTIONS");
        starLine();
        System.out.println("\n                   1. VIEW ALL RECORDS");
        System.out.println("                   2. VIEW FROM LAST  RECORD");
        System.out.println("                   3. VIEW FIRST RECORD");
        System.out.println("                   4. VIEW LAST RECORD");
        System.out.println("                   5. BACK");
        starLine();
        System.out.print("Enter your choice : ");
        String ch1 = in.next();

        switch (ch1) {
            case "1":
                starLine();
                System.out.println("                   STUDENT RECORDS");
                starLine();
                viewFromFirst();
                view();
                break;
            case "2":
                starLine();
                System.out.println("                   STUDENT RECORDS");
                starLine();
                viewFromLast();
                view();
                break;
            case "3":
                starLine();
                System.out.println("                   STUDENT RECORDS");
                starLine();
                viewFirst();
                view();
                break;
            case "4":
                starLine();
                System.out.println("                   STUDENT RECORDS");
                starLine();
                viewLast();
                view();
                break;
            default:
                System.out.println("Invalid Choice!");
        }

    }

    //add
    public void add() {
        System.out.println("\n                   1. ADD AT FIRST");
        System.out.println("                   2. ADD AT LAST");
        System.out.println("                   3. BACK");

        System.out.print("Enter your choice : ");
        String ch3 = in.next();

        switch (ch3) {
            case "1":
                starLine();
                System.out.println("                  ADD STUDENT RECORD");
                starLine();
                System.out.print("\nEnter Name : ");
                String name = in.next();
                System.out.print("\nEnter Father Name : ");
                String Fname = in.next();
                System.out.print("\nEnter Rollno : ");
                int rollno = in.nextInt();
                System.out.print("\nEnter City : ");
                String city = in.next();
                System.out.print("\nEnter Calss: ");
                String classs = in.next();
                System.out.print("\nEnter Email : ");
                String email = in.next();
                addFirst(name, Fname, rollno, city, classs, email);
                System.out.println("Record has been added successfully..");
                add();
                break;
            case "2":
                starLine();
                System.out.println("                   aDD STUDENT RECORD AT LAST");
                starLine();

                System.out.print("\nEnter Name : ");
                String name1 = in.next();
                System.out.print("\nEnter Father Name : ");
                String Fname1 = in.next();
                System.out.print("\nEnter Rollno : ");
                int rollno1 = in.nextInt();
                System.out.print("\nEnter City : ");
                String city1 = in.next();
                System.out.print("\nEnter Calss: ");
                String classs1 = in.next();
                System.out.print("\nEnter Email : ");
                String email1 = in.next();
                addLast(name1, Fname1, rollno1, city1, classs1, email1);
                add();
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public void remove() {
        System.out.println("\n                   1. REMOVE ALL");
        System.out.println("                   2. REMOVE FIRST");
        System.out.println("                   3. REMOVE LAST");
        System.out.println("                   4. REMOVE BY NAME");
        System.out.println("                   5. REMOVE BY EMAIL");
        System.out.println("                   6. BACK");

        System.out.print("Enter your choice : ");
        String ch4 = in.next();

        switch (ch4) {
            case "1":
                removeAll();
                remove();
                break;
            case "2":
                removeFirst();
                remove();
                break;
            case "3":
                removeLast();
                remove();
                break;
            case "4":

                removeByEamil();
                remove();
                break;
            case "5":

                removeByRollno();
                remove();
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public void update() {
        System.out.println("\n                   1. UPDATE USING NAME");
        System.out.println("                   2. UPDATE USING EMAIL");
        System.out.println("                   3. BACK");

        System.out.print("Enter your choice : ");
        String ch5 = in.next();

        switch (ch5) {
            case "1":
                updateName();
                update();
                break;
            case "2":
                updateEmail();
                update();
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public void search() {
        System.out.println("\n                   1. SEARCH BY Email");
        System.out.println("                   2. SEARCH BY Rollno");
        System.out.println("                   3. BACK");

        System.out.print("Enter your choice : ");
        String ch6 = in.next();

        switch (ch6) {
            case "1":
                searchByEmail();
                search();
                break;
            case "2":
                searchByRollno();
                search();
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public void sort() {
        System.out.println("\n                   1. SORTING BY ROLL NUMBER ASCENDING");
        System.out.println("                   2. SORTING BY ROLL NUMBER DESCENDING");
        System.out.println("                   3. SORTING BY NAME ASCENDING");
        System.out.println("                   4. SORTING BY NAME DESCENDING");
        starLine();
        System.out.print("Enter your choice : ");
        String ch2 = in.next();
        starLine();
        switch (ch2) {
            case "1":
                sortByRollnoASC();
                sort();
                break;
            case "2":
                sortByRollnoDESC();
                sort();
                break;
            case "3":
                sortByNameASC();
                sort();
                break;
            case "4":
                sortByNameDESC();
                sort();
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    private static class Record {

        String name;
        int rollno;
        String fname;
        String city;
        String classs;
        String email;
        Record prev = this;
        Record next = this;

        Record() {
        }

        Record(String name, String fname, int rollno, String city, String classs, String email) {
            this.name = name;
            this.fname = fname;
            this.rollno = rollno;
            this.city = city;
            this.classs = classs;
            this.email = email;
        }

        Record(String name, String fname, int rollno, String city, String classs, String email, Record prev, Record next) {
            this.name = name;
            this.fname = fname;
            this.rollno = rollno;
            this.city = city;
            this.classs = classs;
            this.email = email;
            this.prev = prev;
            this.next = next;
        }
    }

    public static int display(StudentApplication l) {
        l.starLine();
        System.out.print("                   Student Record Application");
        l.starLine();
        String ch;

        do {

            System.out.println("\n                   1. ADD RECORDS");
            System.out.println("                   2. REMOVE RECORDS");
            System.out.println("                   3. UPDATE RECORDS");
            System.out.println("                   4. SEARCH RECORDS");
            System.out.println("                   5. VIEW RECORDS");
            System.out.println("                   6. SORT RECORDS");
            System.out.println("                   7. EXIT");

            Scanner sc = new Scanner(System.in);
            l.starLine();
            System.out.print("\n\nEnter your choice : ");
            ch = sc.next();

            switch (ch) {

                case "1":
                    l.add();
                    break;
                case "2":
                    l.remove();
                    break;
                case "3":
                    l.update();
                    break;
                case "4":
                    l.search();
                    break;
                case "5":
                    l.view();
                    break;

                case "6":
                    l.sort();
                    break;
                case "7":
                    System.out.println("Thank You!");
                    return 0;

                default:
                    System.out.println("Invalid choice try again!");
            }

        } while (ch != "7");
        return -1;
    }

    public static void main(String[] args) {
        StudentApplication mr = new StudentApplication();
        mr.addFirst("Saba", "Saeed", 53, "Rohri", "12", "abc@gmail.com");
        mr.addLast("Anusha", "Naeem", 54, "Jamshoro", "12", "anusha@gmail.com");
        mr.addLast("Aliza", "Saeed", 5, "Rohri", "12", "abe@gmail.com");
        mr.addLast("Farwah", "Saeed", 23, "Rohri", "12", "abf@gmail.com");
        mr.addLast("Muskan", "Saeed", 85, "Rohri", "12", "abg@gmail.com");
        mr.display(mr);

    }
}
