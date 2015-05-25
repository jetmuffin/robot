package com.dag.robot.neo.object;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import com.dag.robot.neo.type.LabelTypes;
import com.dag.robot.neo.type.RelTypes;

public class NeoObject {
	protected String DB_PATH="";
	protected GraphDatabaseService graphDb=null;
	protected Transaction transaction = null;
	
	public GraphDatabaseService getGraphDb() {
		return graphDb;
	}

	public NeoObject(){
	}
	
	public NeoObject(String db_path){
		setDB_PATH(db_path);
	}
	public void setDB_PATH(String dB_PATH) {
		DB_PATH = dB_PATH;
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
	}
	public void begin(){
		System.out.println("begin");
		transaction = graphDb.beginTx();
	}
	public void success() {
		System.out.println("success");
		transaction.success();
	}
	public void finish(){
		System.out.println("finish");
		transaction.close();
	}
	
	public Node addNode(LabelTypes label) {
		return graphDb.createNode(label);
	}
	public Node addNode(){
		return graphDb.createNode();
	}
	public Node getNode(long nodeId){
		return graphDb.getNodeById(nodeId);
	}
	
	/**
	 * 根据Label 及 属性来查找节点，返回首个符合条件的结点
	 * @param label		待查找节点的Label
	 * @param property	待查找节点的属性名称
	 * @param value		待查找节点的属性值
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Node findNode(LabelTypes label,String property,String value){
		ArrayList<Long> ids = new ArrayList<Long>();
		ResourceIterable<Node> nodes = this.graphDb.findNodesByLabelAndProperty(label, property, value);
		for(Node iNode : nodes){
			return iNode;
		}
		return null;
	}
	public Node findNode(LabelTypes label,String property,int value){
		ArrayList<Long> ids = new ArrayList<Long>();
		ResourceIterable<Node> nodes = this.graphDb.findNodesByLabelAndProperty(label, property, value);
		for(Node iNode : nodes){
			return iNode;
		}
		return null;
	}
	/**
	 * 根据Label 及 属性来查找节点，返回符合条件的id的列表
	 * @param label		待查找节点的Label
	 * @param property	待查找节点的属性名称
	 * @param value		待查找节点的属性值
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public List<Long> findNodes(LabelTypes label,String property,String value){
		ArrayList<Long> ids = new ArrayList<Long>();
		ResourceIterable<Node> nodes = this.graphDb.findNodesByLabelAndProperty(label, property, value);
		for(Node iNode : nodes){
			ids.add(iNode.getId());
		}
		return ids;
	}
	public List<Long> findNodes(LabelTypes label,String property,int value){
		ArrayList<Long> ids = new ArrayList<Long>();
		ResourceIterable<Node> nodes = this.graphDb.findNodesByLabelAndProperty(label, property, value);
		for(Node iNode : nodes){
			ids.add(iNode.getId());
		}
		return ids;
	}
	
	public Relationship addRelationship(Node node1,RelTypes relTypes,Node node2){
		return node1.createRelationshipTo(node2, relTypes);
	}
	public Relationship getRelationship(long relationId){
		return graphDb.getRelationshipById(relationId);
	}
}
