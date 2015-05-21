package com.dag.robot.neo.object;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import com.dag.robot.neo.type.LabelTypes;
import com.dag.robot.neo.type.RelTypes;

/**
 * 知识库对象类
 * 建立一个基于include 的知识库-图数据库
 * 首先应该在构建函数中传入图数据库的路径，然后进行事务操作，操作完成后执行success()来标记事务执行成功
 * 然后执行finish()来结束事务
 * @author innerac
 *	
 */
public class KnowlageObject {
	
	private String DB_PATH="";
	private GraphDatabaseService graphDb=null;
	private Transaction transaction = null;
	public KnowlageObject(String db_path){
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
	
	/**
	 * 查找属性name 为value 的结点并返回他们的id列表
	 * @param value	属性name 的值
	 * @return	结点id的列表
	 */
	@SuppressWarnings("deprecation")
	public List<Long> findNodes(String value){
		ArrayList<Long> ids = new ArrayList<Long>();
		ResourceIterable<Node> nodes = this.graphDb.findNodesByLabelAndProperty(LabelTypes.KNOWLAGE, "name", value);
		for(Node iNode : nodes){
			ids.add(iNode.getId());
		}
		return ids;
	}
	
	/**
	 * 查找属性name 为value 的结点并返回第一个结点的id
	 * @param value	属性name 的值
	 * @return	结点的id
	 */
	@SuppressWarnings("deprecation")
	public Node getFirstNode(String value){
		Node node = null;
		ResourceIterable<Node> nodes = this.graphDb.findNodesByLabelAndProperty(LabelTypes.KNOWLAGE, "name", value);
		if(nodes.iterator().hasNext())
			node = nodes.iterator().next();
		return node;
	}
	
	/**
	 * 获取两个结点之间的关系，aNode -> bNode
	 * @param aNode	起始结点
	 * @param bNode	结束结点
	 * @return	单项关系
	 */
	public Relationship getRelationship(Node aNode,Node bNode){
		
		Iterable<Relationship> relationships = aNode.getRelationships(Direction.OUTGOING);
		for(Relationship relationship : relationships){
			if(relationship.getEndNode().getId() == bNode.getId())
				return relationship;
		}
		
		return null;
		
	}
	
	/**
	 * 建立只含有include 关系的基本知识库
	 * 输入前两个结点的主键 指向性关系为nodeString1 -> nodeString2
	 * @param nodeString1	父结点的主键
	 * @param nodeString2	子结点的主键
	 */
	public void createLine(String nodeString1,String nodeString2){

		Node aNode = null;
		Node bNode = null;
		
		aNode = getFirstNode(nodeString1);
		if(aNode == null){
			aNode = graphDb.createNode(LabelTypes.KNOWLAGE);
			aNode.setProperty("name", nodeString1);
		}
		bNode = getFirstNode(nodeString2);
		if(bNode == null){
			bNode = graphDb.createNode(LabelTypes.KNOWLAGE);
			bNode.setProperty("name", nodeString2);
		}
		aNode.createRelationshipTo(bNode, RelTypes.INCLUDE);
	}
}
