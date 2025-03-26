package org.howard.edu.lsp.assignment5;

public class Driver {
	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();

		System.out.println("--- Testing Add and toString() ---");
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("Set1: " + set1);

		set2.add(3);
		set2.add(4);
		set2.add(5);
		System.out.println("Set2: " + set2);

		System.out.println("\n--- Testing Contains ---");
		System.out.println("Set1 contains 2? " + set1.contains(2));
		System.out.println("Set2 contains 6? " + set2.contains(6));

		System.out.println("\n--- Testing Smallest and Largest ---");
		System.out.println("Smallest in Set1: " + set1.smallest());
		System.out.println("Largest in Set1: " + set1.largest());

		System.out.println("\n--- Testing Equals ---");
		IntegerSet set3 = new IntegerSet();
		set3.add(3);
		set3.add(2);
		set3.add(1);
		System.out.println("Set1 equals Set3? " + set1.equals(set3));

		System.out.println("\n--- Testing Union ---");
		System.out.println("Before Union Set1: " + set1);
		System.out.println("Set2: " + set2);
		set1.union(set2);
		System.out.println("After Union Set1: " + set1);

		System.out.println("\n--- Testing Intersect ---");
		set1 = new IntegerSet();
		set1.add(1); set1.add(2); set1.add(3);
		set2 = new IntegerSet();
		set2.add(3); set2.add(4); set2.add(5);
		System.out.println("Before Intersect Set1: " + set1);
		System.out.println("Set2: " + set2);
		set1.intersect(set2);
		System.out.println("After Intersect Set1: " + set1);

		System.out.println("\n--- Testing Difference ---");
		set1 = new IntegerSet();
		set1.add(1); set1.add(2); set1.add(3);
		set2 = new IntegerSet();
		set2.add(2); set2.add(3);
		System.out.println("Before Diff Set1: " + set1);
		System.out.println("Set2: " + set2);
		set1.diff(set2);
		System.out.println("After Diff Set1: " + set1);

		System.out.println("\n--- Testing Complement ---");
		set1 = new IntegerSet();
		set1.add(1); set1.add(2);
		set2 = new IntegerSet();
		set2.add(1); set2.add(2); set2.add(3); set2.add(4);
		System.out.println("Before Complement Set1: " + set1);
		System.out.println("Set2: " + set2);
		set1.complement(set2);
		System.out.println("After Complement Set1: " + set1);

		System.out.println("\n--- Testing Remove ---");
		set1 = new IntegerSet();
		set1.add(10); set1.add(20); set1.add(30);
		System.out.println("Before Remove Set1: " + set1);
		set1.remove(20);
		System.out.println("After Remove Set1: " + set1);

		System.out.println("\n--- Testing isEmpty and clear() ---");
		System.out.println("Set1 is empty? " + set1.isEmpty());
		set1.clear();
		System.out.println("Set1 after clear: " + set1);
		System.out.println("Set1 is empty now? " + set1.isEmpty());
	}
}
