package com.dag.robot.neo.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import com.dag.robot.neo.object.KnowlageObject;
import com.dag.robot.neo.object.NeoSearchObject;

public class KnowlageTest {

	String dB_PATH = "/home/Sloriac/Workspace/neoDB";
	@SuppressWarnings("resource")
	@Test
	public void buildKnowlageTest(){
		KnowlageObject ko = new KnowlageObject(dB_PATH);
		
		String input[] = null;
		
		String s = null;
		try {
			FileInputStream is=new FileInputStream("/home/Sloriac/Desktop/wikipedia/list_chs");
			InputStreamReader ir=new InputStreamReader(is);
	        BufferedReader in =new BufferedReader(ir);
	        while((s=in.readLine()) !=null){
	        	input = s.split("#");
	        	ko.createLine(input[0], input[1]);
	        }
	        ko.success();
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
	        ko.finish();
		}
	}
	
	@Test
	public void searchRelation(){
		KnowlageObject ko = new KnowlageObject(dB_PATH);
		Node aNode = ko.getFirstNode("全球资讯网");
		Node bNode = ko.getFirstNode("网页标准");
		Relationship relationship = ko.getRelationship(aNode, bNode);
		System.out.println(relationship);
	}
	
	@Test
	public void searchNodeTest(){
		
		NeoSearchObject nso = new NeoSearchObject();
		
		KnowlageObject ko = new KnowlageObject(dB_PATH);
		Node aNode = ko.getFirstNode("全球资讯网");
		
		nso.setTraversalDescription();
		nso.setDeepth(5);
		nso.setTraverser(aNode);
		
		nso.printSearch();
		
		ko.finish();
	}
}
