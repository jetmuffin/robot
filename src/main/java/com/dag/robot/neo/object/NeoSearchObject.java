package com.dag.robot.neo.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.traversal.Evaluator;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.kernel.Traversal;

import com.dag.robot.neo.type.LabelTypes;
import com.dag.robot.neo.type.RelTypes;

/**
 * @author innerac
 *
 */
@SuppressWarnings("deprecation")
public class NeoSearchObject {

	protected NeoObject neoObject = null;
	protected TraversalDescription traversalDescription = null;
	protected Traverser traverser = null;
	
	public NeoSearchObject() {
		neoObject = new NeoObject();
	}
	public NeoSearchObject(String db_path){
		neoObject = new NeoObject(db_path);
		neoObject.begin();
	}
	public void setDB_PATH(String dB_PATH){
		neoObject.setDB_PATH(dB_PATH);
		neoObject.begin();
	}
	
	/**
	 * 进行查找之前，需要先启动事务
	 */
	public void begin(){
		neoObject.begin();
	}
	public void success(){
		neoObject.success();
	}
	
	/**
	 * 事务结束后，记得关闭呦 
	 */
	public void finish(){
		neoObject.finish();
	}
	
	public Node findNodeById(long nodeId){
		return neoObject.getNode(nodeId);
	}
	public Node findExpertByMainKey(int mainKey){
		return neoObject.findNode(LabelTypes.Expert, "mainKey", mainKey);
	}
	public Node findNode(LabelTypes label, String property, String value){
		return neoObject.findNode(label, property, value);
	}
	public Node findNode(LabelTypes label, String property, int value){
		return neoObject.findNode(label, property, value);
	}
	
	
	/**
	 * 创建搜索描述，默认为宽搜
	 */
	public void setTraversalDescription(){
		traversalDescription = Traversal.description().breadthFirst();
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
	public void setSection(int fDeepth,int toDeepth){
		traversalDescription = traversalDescription.evaluator(Evaluators.fromDepth(fDeepth));
		traversalDescription = traversalDescription.evaluator(Evaluators.toDepth(toDeepth));
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
	
	/**
	 * 输出搜索的结果
	 */
	public void printSearch(){
		for(Path path : traverser){
			System.out.println(path.startNode().getProperty("name")+" =( "+path.length()+ " )=> "+path.endNode().getProperty("name"));
		}
	}
	
	/**
	 * 获得搜索结果节点的id和权值
	 * @return	结点id和权值的map
	 */
	public Map<Long, Integer> getMapSearch() {
		Map<Long, Integer> idsMap = new HashMap<Long, Integer>();
		for(Path path : traverser){
			idsMap.put(path.endNode().getId(),path.length());
		}
		return idsMap;
	}
	public List<Long> getListSearch(LabelTypes label) {
		List<Long> idsList = new ArrayList<Long>();
		if(label == null){
			for(Path path : traverser){
				idsList.add(path.endNode().getId());
			}
		}else{
			for(Path path : traverser){
				Label aLabelTypes = path.endNode().getLabels().iterator().next();
				if(aLabelTypes.toString().equals(label.toString()))
					idsList.add(path.endNode().getId());
			}
		}

		return idsList;
	}
	public Map<String, String> getLink() {
		Map<String, String> idsMap = new HashMap<String, String>();
		for(Path path : traverser){
			idsMap.put(path.startNode().getProperty("name").toString(),path.endNode().getProperty("name").toString());
		}
		return idsMap;
	}
	public ResourceIterable<Node> getTmpNodes() {
//		Map<Long, Integer> idsMap = new HashMap<Long, Integer>();
		return traverser.nodes();
//		List<Long> idsList = new ArrayList<Long>();
//		for(Path path : traverser){
//			idsList.add(path.endNode().getId());
//		}
//		return idsList;
	}
	
	public long getRootNode(Node aNode){
		setTraversalDescription();
		addRelationships(RelTypes.INCLUDE, Direction.INCOMING);
		setTraverser(aNode);
		
		long rid = -1;
		
		for(Path path : traverser){
			rid = path.endNode().getId();
		}
		return rid;
		
	}
}
