package com.dag.robot.data.search;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.ResourceIterable;

import com.dag.robot.neo.object.KnowlageObject;
import com.dag.robot.neo.object.NeoSearchObject;
import com.dag.robot.neo.type.RelTypes;
import com.dag.robot.utils.PropertiesUtil;
import com.dag.robot.web.bean.JsonShowList;
import com.dag.robot.web.bean.LinkBean;
import com.dag.robot.web.bean.NodeBean;

public class ShowNeoKnowlage extends NeoSearchObject {

	private String path; 
	KnowlageObject kObject = null;
	ResourceIterable<Node> nodes = null;
	
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
	
	public void close(){
		kObject.finish();
	}
	public JsonShowList getGraphJSON(String rootName,int deepth){
		nodes = kObject.getNodes(rootName);
		
		nc.clear();
		lc.clear();
		
		nodeId = 0;
		linkId = 0;
		nowDepth = 0;
		nowType = 1;
		Node node0 = nodes.iterator().next();
		nc.add(new NodeBean(node0.getId(), nowType, node0.getProperty("name").toString(), nowDepth));
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
			JsonShowList jsList = new JsonShowList();
			jsList.setNodes(nc);
			jsList.setLinks(lc);
			
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
	
	
}
