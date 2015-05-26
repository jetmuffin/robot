package com.dag.robot.neo.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.neo4j.cypher.internal.compiler.v2_0.functions.Nodes;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;

import com.dag.robot.data.search.ShowNeoKnowlage;
import com.dag.robot.neo.object.KnowlageObject;
import com.dag.robot.neo.object.NeoSearchObject;
import com.dag.robot.neo.type.RelTypes;
import com.dag.robot.web.bean.JsonShowList;

public class KnowlageTest {

	String dB_PATH = "/home/jeff/workspace/neoDB";
	@SuppressWarnings("resource")
	@Test
	public void buildKnowlageTest(){
		KnowlageObject ko = new KnowlageObject(dB_PATH);
		ko.begin();
		
		String input[] = null;
		
		String s = null;
		try {
			FileInputStream is=new FileInputStream("/home/jeff/workspace/list_chs");
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
		Node aNode = ko.getFirstNode("P2P");
//		Node aNode = ko.getFirstNode("全球资讯网");
		
		nso.setTraversalDescription();
		nso.addRelationships(RelTypes.INCLUDE, Direction.INCOMING);
		nso.setDeepth(1);
		nso.setTraverser(aNode);
		
		ResourceIterable<Node> nodes = nso.getTmpNodes();
		for(Node node : nodes){
			System.out.println(node.getProperty("name"));
		}
		for(Node node : nodes){
			System.out.println(node.getProperty("name"));
		}
		
		nso.printSearch();
		
		ko.finish();
	}
	
	@Test
	public void showTest(){
		ObjectMapper objectMapper = new ObjectMapper();      
		JsonGenerator jsonGenerator = null;
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		ShowNeoKnowlage snk = new ShowNeoKnowlage(dB_PATH);
		
		JsonShowList jsList = snk.getGraphJSON("计算机技术", 3);
		
		try {
			jsonGenerator.writeObject(jsList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println(jsList.toString());
		
	}
}
