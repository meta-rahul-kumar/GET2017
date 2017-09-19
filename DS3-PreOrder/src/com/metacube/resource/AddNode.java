package com.metacube.resource;
import java.util.Scanner;

import com.metacube.menu.Action;

/**
 * class Adds a Node in Tree
 * @author Rahul Kumar
 *
 */
public class AddNode implements Action {

	@Override
	public void performAction(PreOrderTreeTraversal tree) {
		int item = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Enter Node Value");
			try { 
				item = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Please Enter a Valid Number !!");
				sc.nextLine();
				continue;
			}
			break;
		} while (true);
		
		tree.addNode(item);
	}

}
