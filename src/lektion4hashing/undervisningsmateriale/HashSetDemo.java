package lektion4hashing.undervisningsmateriale;

/**
 * This program demonstrates the hash set class.
 */
public class HashSetDemo {
    public static void main(String[] args) {
        MyHashSetChaining<String> names = new MyHashSetChaining<>(13);
        //MyHashSetLinearProbing names = new MyHashSetLinearProbing(13);

        names.add("Harry");
        names.add("Sue");
        names.add("Nina");
        names.add("Susannah");
        names.add("Larry");
        names.add("Eve");
        names.add("Sarah");
        names.add("Adam");
        names.add("Tony");
        names.add("Katherine");
        names.add("Juliet");
        names.add("Romeo");

        names.writeOut();
        System.out.println();

        System.out.println("HashSet Size: " + names.size());
        System.out.println("Contains Romeo from set");
        System.out.println(names.contains("Romeo"));
        System.out.println("Remove Romeo from set");
        names.remove("Romeo");
        System.out.println("Is Romeo still in list?");
        System.out.println(names.contains("Romeo"));
        System.out.println("George: "+names.contains("George"));
        names.remove("George");
        System.out.println("Size?: "+names.size());
        System.out.println();
        names.writeOut();
        System.out.println();
        names.clear();
        System.out.println("Clear list: "+names.size());
        names.writeOut();
        System.out.println();

    }
}
