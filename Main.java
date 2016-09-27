/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: lab7
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class Main {

	public static void main(String[] args) {
	
		System.out.println("We are first going to create a new BST");
		
		// creating a new BST
		BST newBST = new BST();
		
		System.out.println("We are now going to populate the BST with the Sequence: 4 2 6 1 3 5 7");
		System.out.println("newBST.insert(4);");
		newBST.insert(4);
		System.out.println("newBST.insert(2);");
		newBST.insert(2);
		System.out.println("newBST.insert(6);");
		newBST.insert(6);
		System.out.println("newBST.insert(1);");
		newBST.insert(1);
		System.out.println("newBST.insert(3);");
		newBST.insert(3);
		System.out.println("newBST.insert(5);");
		newBST.insert(5);
		System.out.println("newBST.insert(7);");
		newBST.insert(7);

		System.out.println("Now Let's print out the tree in reverse inorder traversal");
		System.out.println("");
		System.out.println("");
		newBST.display();
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Now let's try the remove method...");
		System.out.println("For testing puposes, I will create a new tree as shown in the Lecture slide since it is better for demonstration...");
		
		BST BST2 = new BST();
		
		System.out.println("We are now going to populate the BST with the Sequence: 6 3 8 1 5 7 0 4");
		System.out.println("newBST.insert(6);");
		BST2.insert(6);
		System.out.println("newBST.insert(3);");
		BST2.insert(3);
		System.out.println("newBST.insert(8);");
		BST2.insert(8);
		System.out.println("newBST.insert(1);");
		BST2.insert(1);
		System.out.println("newBST.insert(5);");
		BST2.insert(5);
		System.out.println("newBST.insert(7);");
		BST2.insert(7);
		System.out.println("newBST.insert(0);");
		BST2.insert(0);
		System.out.println("newBST.insert(4);");
		BST2.insert(4);
		
		System.out.println("Now Let's print out the tree in reverse inorder traversal");
		System.out.println("");
		System.out.println("");
		BST2.display();
		System.out.println("");
		System.out.println("");
		
		System.out.println("First I'm going to try to remove a value that is not in the BST, so let's try 100");
		System.out.println("BST2.remove(100);");
		BST2.remove(100);
		
		System.out.println("Next, let's try removing a node without any children so let's remove '4'");
		System.out.println("BST2.remove(4);");
		BST2.remove(4);
		
		System.out.println("Now Let's print out the tree in reverse inorder traversal");
		System.out.println("");
		System.out.println("");
		BST2.display();
		System.out.println("");
		System.out.println("");
		
		System.out.println("Next, let's try removing a node with one child so let's remove '8'");
		System.out.println("BST2.remove(8);");
		BST2.remove(8);
		
		System.out.println("Now Let's print out the tree in reverse inorder traversal");
		System.out.println("");
		System.out.println("");
		BST2.display();
		System.out.println("");
		System.out.println("");
		
		System.out.println("Next, let's try removing a node with 2 children so let's remove '6'");
		System.out.println("BST2.remove(6);");
		BST2.remove(6);
		
		System.out.println("Now Let's print out the tree in reverse inorder traversal");
		System.out.println("");
		System.out.println("");
		BST2.display();
		System.out.println("");
		System.out.println("");
		
		System.out.println("Now with the current tree that we have right now, I will print out them in inorder postorder and preorder traversal...");
		System.out.println("Let's try first inorder()...");
		BST2.inorder();
		
		System.out.println("\nLet's try first postorder()...");
		BST2.postorder();
		
		System.out.println("\nLet's try first preorder()...");
		BST2.preorder();
		
		System.out.println("\n\nThe three methods for updating the height, depth and inorder position is being called after each insert and remove, let's see if they are correct by testing the display...");
		
		System.out.println("Key and Height:");
		BST2.displayKeyHeight();
		
		System.out.println("\nKey and Depth:");
		BST2.displayKeyDepth();
		
		System.out.println("\nKey and Inorder Position:");
		BST2.displayKeyInorderPosition();
		
	
		
	}

}
