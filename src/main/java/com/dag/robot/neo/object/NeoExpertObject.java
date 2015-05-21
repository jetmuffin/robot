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
	private String DB_PATH="";
	private GraphDatabaseService graphDb=null;
	private Transaction transaction = null;
	
//	public enum Experts {
//		name("name"),
//		age("age"),
//		sex("sex");
//		private String value;
//		private Experts(String string){
//			value = string;
//		}
//		public String getValue(){
//			return value;
//		}
//	}
//	
//	public enum Papers {
//		name("name"),
//		year("year"),
//		author("author");
//		private String value;
//		private Papers(String string){
//			value = string;
//		}
//		public String getValue(){
//			return value;
//		}
//	}
//	
//	public enum Topics {
//		name("name");
//		private String value;
//		private Topics(String string){
//			value = string;
//		}
//		public String getValue(){
//			return value;
//		}
//	}	
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
	
	public GraphDatabaseService getGraphDb(){
		return this.graphDb;
	}
	public Transaction getTransaction(){
		return this.transaction;
	}
	public String getNodeString(long nid){
		Node node = graphDb.getNodeById(nid);
		String string = node.getId() + ":" + node.getProperty("name");
		return string ;
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
	 * 根据Lebel 及 属性来查找节点，返回符合条件的id的列表
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
	
	/**
	 * 输入五元组，创建一个有向关系
	 * @param label1	起点Label
	 * @param property1	起点键值属性名称
	 * @param value1	起点键值属性值
	 * @param relTypes	关系类型
	 * @param label2	终点Label
	 * @param property2	终点键值属性名称
	 * @param value2	终点键值属性值
	 */
	public void createLine(String label1,String property1,String value1
			,String relTypes
			,String label2,String property2,String value2){
		
		LabelTypes aLabel = LabelTypes.valueOf(label1);
		LabelTypes bLabel = LabelTypes.valueOf(label2);
		RelTypes relTypes0 = RelTypes.valueOf(relTypes);
		
		
		Node aNode = null;
		Node bNode = null;
		
		
		List<Long> ids = findNodes(aLabel, property1, value1);
		if(ids.size() == 0){
			aNode = graphDb.createNode(aLabel);
			aNode.setProperty(property1, value1);
		}else{
			aNode = getNode(ids.get(0));
		}
		ids = findNodes(bLabel, property2, value2);
		if(ids.size() == 0){
			bNode = graphDb.createNode(bLabel);
			bNode.setProperty(property2, value2);
		}else{
			bNode = getNode(ids.get(0));
		}
		System.out.println(aNode.getId() + " " + bNode.getId());
		aNode.createRelationshipTo(bNode, relTypes0);
	}
}
