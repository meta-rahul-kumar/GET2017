package com.metacube.resource;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MirrorTreesTest {
	MirrorTrees mirrorTrees;
	MirrorTrees mirrorTrees2;
	
	@Before
	public void setObjects() {
		mirrorTrees = new MirrorTrees();
		mirrorTrees2 = new MirrorTrees();
	}
	
	@Test
	public void checkMirrorTest_true() {
		mirrorTrees.addNode(1);
		mirrorTrees.addNode(2);
		mirrorTrees.addNode(3);
		mirrorTrees.addNode(4);
		mirrorTrees.addNode(6);
		mirrorTrees.addNode(7);
		
		mirrorTrees.addNode(2);
		mirrorTrees.addNode(1);
		mirrorTrees.addNode(7);
		mirrorTrees.addNode(6);
		mirrorTrees.addNode(4);
		mirrorTrees.addNode(3);
		
		assertEquals(true, mirrorTrees.checkMirror(mirrorTrees.getRootNode(), mirrorTrees2.getRootNode()));
	}
	
	@Test
	public void checkMirrorTest_False() {
		mirrorTrees.addNode(1);
		mirrorTrees.addNode(2);
		mirrorTrees.addNode(3);
		mirrorTrees.addNode(4);
		mirrorTrees.addNode(6);
		mirrorTrees.addNode(7);
		
		mirrorTrees.addNode(2);
		mirrorTrees.addNode(1);
		mirrorTrees.addNode(7);
		mirrorTrees.addNode(6);
		mirrorTrees.addNode(4);
		mirrorTrees.addNode(3);
		
		assertNotEquals(false, mirrorTrees.checkMirror(mirrorTrees.getRootNode(), mirrorTrees2.getRootNode()));
	}
}
