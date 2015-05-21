package com.dag.robot.neo.object;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.traversal.Evaluator;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.kernel.Traversal;

import com.dag.robot.neo.type.RelTypes;

@SuppressWarnings("deprecation")
public class NeoSearchObject {

	TraversalDescription traversalDescription = null;
	Traverser traverser = null;
	
	public NeoSearchObject() {
	}
	
	/**
	 * 创建搜索描述，默认为宽搜
	 */
	public void setTraversalDescription(){
		traversalDescription = Traversal.description().breadthFirst();
	}
	
	public void addRelationships(){
	}
	public void addRelationships(RelTypes reltype){
		traversalDescription = traversalDescription.relationships(reltype);
	}
	/**
	 * 增加搜索关系
	 * @param reltype	关系	
	 * @param direction	搜索方向
	 */
	public void addRelationships(RelTypes reltype, Direction direction){
		traversalDescription = traversalDescription.relationships(reltype,direction);
	}
	
	/**
	 * 增加计算关系
	 * @param evaluator	计算关系
	 */
	public void addEvaluator(Evaluator evaluator){
		traversalDescription = traversalDescription.evaluator(evaluator);
	}
	/**
	 * 搜索时排除当前节点
	 */
	public void excludeStartPosition(){
		traversalDescription = traversalDescription.evaluator(Evaluators.excludeStartPosition());
	}
	/**
	 * 设置搜索长度
	 * @param deepth	搜索长度，默认为全部搜索
	 */
	public void setDeepth(int deepth){
		traversalDescription = traversalDescription.evaluator(Evaluators.toDepth(deepth));
	}
	
	/**
	 * 设置起始节点组
	 * @param nodes
	 */
	public void setTraverser(Iterable<Node> nodes){
		traverser = traversalDescription.traverse(nodes);
	}
	/**
	 * 设置起始节点
	 * @param node
	 */
	public void setTraverser(Node node){
		traverser = traversalDescription.traverse(node);
	}
	
	public void printSearch(){
		for(Path path : traverser){
			System.out.println(path.startNode().getProperty("name")+" =( "+path.length()+ " )=> "+path.endNode().getProperty("name"));
		}
	}
	
	/**
	 * 获得搜索结果节点的id和权值
	 * @return
	 */
	public Map<Long, Integer> getSearch() {
		Map<Long, Integer> idsMap = new HashMap<Long, Integer>();
		for(Path path : traverser){
			//ids.add(path.endNode().getId());
			idsMap.put(path.endNode().getId(),path.length());
		}
		return idsMap;
	}
}
