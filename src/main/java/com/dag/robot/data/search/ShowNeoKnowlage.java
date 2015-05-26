package com.dag.robot.data.search;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.traversal.Evaluator;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.kernel.Traversal;
import org.springframework.stereotype.Service;

import com.dag.robot.neo.object.KnowlageObject;
import com.dag.robot.neo.type.RelTypes;
import com.dag.robot.utils.PropertiesUtil;
import com.dag.robot.web.bean.JsonShowList;
import com.dag.robot.web.bean.LinkBean;
import com.dag.robot.web.bean.NodeBean;

@Service
public class ShowNeoKnowlage {

	private String path; 
	KnowlageObject kObject = null;
	ResourceIterable<Node> nodes = null;
	
	protected TraversalDescription traversalDescription = null;
	protected Traverser traverser = null;
	
	List<NodeBean> nc = new ArrayList<NodeBean>();
	List<LinkBean> lc = new ArrayList<LinkBean>();
	
	int nodeId = 0;
	int linkId = 0;
	int nowDepth = 0;
	int nowType = 0;
	
	public ShowNeoKnowlage(){
		path = PropertiesUtil.getValue("neoDataPath");
		kObject = new KnowlageObject(path);
	}
	
	public ShowNeoKnowlage(String db_path){
		kObject = new KnowlageObject(db_path);
	}
	
	public void begin(){
		kObject.begin();
	}
	public void finish(){
		kObject.finish();
	}
	
	public JsonShowList getGraphJSON(String rootName,int deepth){
		
		System.out.println("path = "+path);
		
		begin();
		
		nodes = kObject.getNodes(rootName);
		
		JsonShowList jsList = new JsonShowList();
		
		nc.clear();
		lc.clear();
		
		nodeId = 0;
		linkId = 0;
		nowDepth = 0;
		nowType = 1;
		if(nodes.iterator().hasNext()){
			Node node0 = nodes.iterator().next();
			nc.add(new NodeBean(node0.getId(), 2, node0.getProperty("name").toString(), nowDepth));
		}else{
			finish();
			return jsList;
		}
		for(nowDepth=1;nowDepth<=deepth;nowDepth++){
			findSubNodes(nodes);
			nodes = getTmpNodes();
			if(nowDepth == deepth){
				nowType = 0;
			}
			for(Node node : nodes){
//				System.out.println("node.name = "+node.getProperty("name"));
				nc.add(new NodeBean(node.getId(), nowType, node.getProperty("name").toString(), nowDepth));
			}
			saveJSONs();
		}
		{
			jsList.setNodes(nc);
			jsList.setLinks(lc);			
			
			finish();
			
			return jsList;
			
		}
	}



	private void findSubNodes(ResourceIterable<Node> nodes){
		
		setTraversalDescription();
		addRelationships(RelTypes.INCLUDE,Direction.OUTGOING);
		excludeStartPosition();
		setDeepth(1);
		setTraverser(nodes);
	}
	
	public void saveJSONs(){
		Node aNode,bNode;
		for(Path path : traverser){
//			System.out.println(path.startNode().getProperty("name").toString()+" "+nowDepth+" "+path.endNode().getProperty("name").toString());
			aNode = path.startNode();
			bNode = path.endNode();
			lc.add(new LinkBean(aNode.getId(), bNode.getId()));
		}
	}
	
	private ResourceIterable<Node> getTmpNodes() {
		return traverser.nodes();
	}
	/**
	 * 创建搜索描述，默认为宽搜
	 */
	@SuppressWarnings("deprecation")
	private void setTraversalDescription(){
		traversalDescription = Traversal.description().breadthFirst();
	}
	
	/**
	 * 增加搜索关系
	 * @param reltype	关系	
	 * @param direction	搜索方向
	 */
	private void addRelationships(RelTypes reltype, Direction direction){
		traversalDescription = traversalDescription.relationships(reltype,direction);
	}
	
	/**
	 * 搜索时排除当前节点
	 */
	private void excludeStartPosition(){
		traversalDescription = traversalDescription.evaluator(Evaluators.excludeStartPosition());
	}
	/**
	 * 设置搜索长度
	 * @param deepth	搜索长度，默认为全部搜索
	 */
	private void setDeepth(int deepth){
		traversalDescription = traversalDescription.evaluator(Evaluators.toDepth(deepth));
	}
	/**
	 * 设置起始节点组
	 * @param nodes
	 */
	private void setTraverser(Iterable<Node> nodes){
		traverser = traversalDescription.traverse(nodes);
	}
	/**
	 * 设置起始节点
	 * @param node
	 */
	private void setTraverser(Node node){
		traverser = traversalDescription.traverse(node);
	}
	
}
