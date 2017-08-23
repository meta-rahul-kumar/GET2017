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
		
		System.out.println("Enter Node Value");
		item = sc.nextInt();
		tree.addNode(item);
	}

}
