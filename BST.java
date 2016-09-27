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
 * Filename : BST.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 

public class BST {

	//inner class
	private static class BinaryNode{
		
		// private fields of BinaryNode
		private int value;		// unique key of this node
		private BinaryNode left;	// left child of this BinaryNode
		private BinaryNode right;	// right child of this BinaryNode 
		
		private int height; 	// the height of the BinaryNode
		private int depth;		// the depth of the BinaryNode
		private int inorder_pos;	// the position of a given node in a sorted order(determined by inorder traversal)
		
		
		// default constructor
		public BinaryNode(int newVal){
			value = newVal;
		}
		
		// finding max - used for removing when there are both right and left child
		public static BinaryNode findMax(BinaryNode t){
			if(t.right != null){
				return findMax(t.right);
			}
			return t;
		}
		
		// finding the depth of a given node
		public static int findDepth(int value, BinaryNode t){
			int counter = 0;
			while(t != null){
				if(t.value == value){
					break;
				}
				else if(value < t.value){
					t = t.left;
				}
				else{
					t = t.right;
				}
				
				counter++;
			}
			
			return counter;
		}
		
		// finding the height of a given node
		public static int findHeight(BinaryNode t){
			if(t == null){
				return -1;
			}
			
			return Math.max(findHeight(t.left), findHeight(t.right)) + 1;
		}
		
		// Method for inserting a new node into BST
		private static BinaryNode insert(int value, BinaryNode t){
			
			// checking if the root is null
			if(t == null){
				t = new BinaryNode(value);
				return t;
			}
			else{
				
				// traverse left
				if(value < t.value){
					t.left = insert(value, t.left);	
				}
				
				// else traverse right
				else{
					t.right = insert(value, t.right);
				}
				return t;
			}	
		}
		
		// Method for removing a node in BST
		private static BinaryNode remove(int value, BinaryNode t){
		
			// if t == null means that there is no node with such value
			if(t == null){
				System.out.println("Cannot find a node with such value");
				return t;
			}
			
			// traverse left
			else if(value < t.value){
				t.left = remove(value, t.left);
			}
			
			// traverse right
			else if(value > t.value){
				t.right = remove(value, t.right);
			}
			
			// found the node with the same value so delete it
			else{
				
				// node has no child
				if(t.left == null && t.right == null){
					t = null;
				}
				
				// node has one child - right child
				else if(t.left == null){
					t = t.right;
				}
				
				// node has one child - left child
				else if(t.right == null){
					t = t.left;
				}
				
				// else has both left and right child
				else{
					
					// finding the max of the leftchild
					BinaryNode temp = findMax(t.left);
					t.value = temp.value;
					t.left = remove(temp.value, t.left);
				}	
			}
			
			return t;		
		}
		
		// printing BST in reverse inorder traversal
		private static void display(BinaryNode t){
			if(t != null){
				display(t.right);
				
				// prints spaces per level
				for(int i = 0; i < t.depth; i++){
					System.out.print(" ");
				}
				
				// print out the value
				System.out.println(t.value);
				
				display(t.left);
			}
	
		}
		
		// printing out in inorder traversal
		private static void inorder(BinaryNode t){
			if(t != null){
				inorder(t.left);
				System.out.println(t.value);
				inorder(t.right);
			}
		}
		
		// printing out in postorder traversal
		private static void postorder(BinaryNode t){
			if(t != null){
				postorder(t.left);
				postorder(t.right);
				System.out.println(t.value);
			}
		}
		
		// printing out in preorder traversal
		private static void preorder(BinaryNode t){
			if(t != null){
				System.out.println(t.value);
				preorder(t.left);
				preorder(t.right);
			}
		}
		
		// Method for updating the Height of each node
		private static void updateHeight(BinaryNode t){
			if(t != null){
				t.height = findHeight(t);
				updateHeight(t.left);
				updateHeight(t.right);
			}
		}
		
		// Method for updating the Depth of each node
		private static void updateDepth(BinaryNode t){
			if(t != null){
				t.depth = findDepth(t.value, mainRoot);
				updateDepth(t.left);
				updateDepth(t.right);
			}
		}
		
		// Method for updating the InorderPosition of each node
		private static void updateInorderPosition(BinaryNode t){
			if(t != null){
				updateInorderPosition(t.left);
				t.inorder_pos = curr_depth++;
				updateInorderPosition(t.right);
			}

		}
		
		// Method for diplaying the key and the height
		private static void displayKeyHeight(BinaryNode t){
			if(t != null){
				displayKeyHeight(t.left);
				System.out.println("The key is: " + t.value + "\tThe height is; " + t.height);
				displayKeyHeight(t.right);
			}
		}
		
		// Method for displaying the key and the depth
		private static void displayKeyDepth(BinaryNode t){
			if(t != null){
				displayKeyDepth(t.left);
				System.out.println("The key is: " + t.value + "\tThe depth is; " + t.depth);
				displayKeyDepth(t.right);
			}
		}
		
		// Method for displaying the key and the InorderPosition
		private static void displayKeyInorderPosition(BinaryNode t){
			if(t != null){
				displayKeyInorderPosition(t.left);
				System.out.println("The key is: " + t.value + "\tThe inorder position is; " + t.inorder_pos);
				displayKeyInorderPosition(t.right);
			}
		}
	
	}	// end of Binary class
	
	
	// fields for BST
	private static int curr_depth;
	private BinaryNode root = null;

	
	// Making mainRoot only because don't want to make 'root' static to 'break' skeleton, mainRoot is only used to update depth
	private static BinaryNode mainRoot = null; 
	
	// BST method for inserting a new value into BST
	public void insert(int value){
		
		//setting curr_depth = 0 since starting with the root first, but will increase as it traverses in different levels
		curr_depth = 0;
		root = BinaryNode.insert(value, root);
		mainRoot = root;

		updateDepth();
		updateHeight();
		updateInorderPosition();
	}
	
	// BST method for removing a value in BST
	public void remove(int value){
		root = BinaryNode.remove(value, root);
		mainRoot = root;
		
		updateDepth();
		updateHeight();
		updateInorderPosition();
	}
	
	// Method for displaying the BST in a required format
	public void display(){
		BinaryNode.display(root);
	}
	
	// Method for printing out in inorder traversal
	public void inorder(){
		BinaryNode.inorder(root);
	}
	
	// Method for printing out in postorder traversal
	public void postorder(){
		BinaryNode.postorder(root);
	}
	
	// Method for printing out in preoder traversal
	public void preorder(){
		BinaryNode.preorder(root);
	}
	
	// Method for updating the Height of each node
	public void updateHeight(){
		BinaryNode.updateHeight(root);
	}
	
	// Method for updating the Depth of each node
	public void updateDepth(){
		BinaryNode.updateDepth(root);
	}
	
	// Method for updating the InorderPosition of each node
	public void updateInorderPosition(){
		curr_depth = 0;
		BinaryNode.updateInorderPosition(root);
	}
	
	// Method for displaying the Key and the height
	public void displayKeyHeight(){
		BinaryNode.displayKeyHeight(root);
	}
	
	// Method for displaying the Key and the Depth
	public void displayKeyDepth(){
		BinaryNode.displayKeyDepth(root);
	}
	
	// Method for displaying the Key and the InorderPosition
	public void displayKeyInorderPosition(){
		BinaryNode.displayKeyInorderPosition(root);
	}
	
	
}	// end of BST class
