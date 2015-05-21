package com.dag.robot.neo.object;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import com.dag.robot.neo.type.*;

public class NeoExpertObject {
	protected String DB_PATH="";
	protected GraphDatabaseService graphDb=null;
	protected Transaction transaction = null;
	
	public NeoExpertObject(){
		
	}
	public NeoExpertObject(String db_path){
		setDB_PATH(db_path);
	}
	public void setDB_PATH(String db_path){
		this.DB_PATH = db_path;
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
		transaction = graphDb.beginTx();
	}
	public void success() {
		transaction.success();
	}
	public void finish(){
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
	
	public Relationship addRelationship(Node node1,RelTypes relTypes,Node node2){
		return node1.createRelationshipTo(node2, relTypes);
	}
	public Relationship getRelationship(long relationId){
		return graphDb.getRelationshipById(relationId);
	}
	
	/**
	 * 根据 Label 查找节点，返回所有节点链表
	 * @param label	节点属性
	 * @return
	 */
	public List<Long> findNodes(LabelTypes label){
		ArrayList<Long> ids = new ArrayList<Long>();
		ResourceIterator<Node> nodes = this.graphDb.findNodes(label);
		while(nodes.hasNext()){
			ids.add(nodes.next().getId());
		}
		return ids;
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
	
	/**
	 * 输入十一元组，创建一个有向关系
	 * @param labela	起点Label
	 * @param ida		起点键值属性名称
	 * @param valueIda	起点键值属性值
	 * @param namea		起点名称参数
	 * @param valueNamea	起点名称值
	 * @param relTypes	关系类型
	 * @param labelb	终点Label
	 * @param idb		终点键值属性名称
	 * @param valueIdb	终点键值属性值
	 * @param nameb		终点名称参数
	 * @param valueNameb	终点名称值
	 */
	public void createLine(LabelTypes labela,String ida,int valueIda,String namea,String valueNamea
			,RelTypes relTypes
			,LabelTypes labelb,String idb,int valueIdb,String nameb,String valueNameb){
		
		Node aNode = null;
		Node bNode = null;
		
		
		List<Long> ids = findNodes(labela, ida, valueIda);
		if(ids.size() == 0){
			aNode = graphDb.createNode(labela);
			aNode.setProperty(ida, valueIda);
			aNode.setProperty(namea, valueNamea);
		}else{
			aNode = getNode(ids.get(0));
		}
		ids = findNodes(labelb, idb, valueIdb);
		if(ids.size() == 0){
			bNode = graphDb.createNode(labelb);
			bNode.setProperty(idb, valueIdb);
			bNode.setProperty(nameb, valueNameb);
		}else{
			bNode = getNode(ids.get(0));
		}
		aNode.createRelationshipTo(bNode, relTypes);
	}
	
}
