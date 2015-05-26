package com.dag.robot.data.search;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.ResourceIterable;
import org.springframework.stereotype.Service;

import com.dag.robot.neo.object.NeoSearchObject;
import com.dag.robot.neo.type.LabelTypes;
import com.dag.robot.neo.type.RelTypes;
import com.dag.robot.web.bean.JsonExpertList;
import com.dag.robot.web.bean.LinkBean;
import com.dag.robot.web.bean.LinkExpertBean;
import com.dag.robot.web.bean.NodeBean;

@Service
public class SearchFromNeo extends NeoSearchObject {
	
	
	int nowType = 0;
	int nowDepth = 0;

	List<LinkExpertBean> linkExpertBeans = new ArrayList<LinkExpertBean>();
	List<NodeBean> nodeBeans = new ArrayList<NodeBean>();
	
	public SearchFromNeo(){
	}
	public SearchFromNeo(String db_path){
		super(db_path);
	}
	
	
	public JsonExpertList getExpertList(int ExpertId){
		
		linkExpertBeans.clear();
		nodeBeans.clear();
		
		begin();
		Node rootExpert = findExpertByMainKey(ExpertId);
		if(rootExpert != null){
			nodeBeans.add(new NodeBean(rootExpert.getId(), 0, rootExpert.getProperty("name").toString(), 0));
			/**
			 * 查找合作伙伴
			 * */
			{
				nowType = 2;
				nowDepth = 1;
				findSameNodes(RelTypes.PUBLISH, rootExpert);
				findSameNodes(RelTypes.APPLLY,rootExpert);
			}
			/**
			 * 查找同事
			 * */
			{
				nowType = 1;
				nowDepth = 1;
				findSameNodes(RelTypes.WORK_FOR, rootExpert);
			}			
		}
		finish();	
		
		JsonExpertList jsonExpertList = new JsonExpertList();
		jsonExpertList.setLinks(linkExpertBeans);
		jsonExpertList.setNodes(nodeBeans);
		
		return jsonExpertList;
		
	}
	
	public JsonExpertList getTopicExpertGraph(int TopicId,int n){
		linkExpertBeans.clear();
		nodeBeans.clear();
		
		begin();
		Node topicNode = findTopicByMainKey(TopicId);
		List<Node> nodelList = null;
		if(topicNode != null){
			nodeBeans.add(new NodeBean(topicNode.getId(), 2, topicNode.getProperty("name").toString(), 0));
			/**
			 * 查找专家
			 * */
			{
				nowType = 1;
				nowDepth = 1;
				nodelList = findExpertInTopic(topicNode,n);
				
				for(Node node : nodelList){
					nodeBeans.add(new NodeBean(node.getId(), nowType, node.getProperty("name").toString(), nowDepth));
					linkExpertBeans.add(new LinkExpertBean(topicNode.getProperty("name").toString(), node.getProperty("name").toString()));
				}
			}
//			/**
//			 * 挖掘专家关系
//			 * */
//			if(nodelList != null)
//			{
//				int nSize = nodelList.size();
//				Node node1,node2;
//				for(int i=0;i<nSize;i++){
//					node1 = nodelList.get(i);
//					for(int j=i+1;j<nSize;j++){
//						node2 = nodelList.get(j);
//						if(judgeIsRelation(node1,node2)){
//							linkExpertBeans.add(new LinkExpertBean(node1.getProperty("name").toString(),node2.getProperty("name").toString()));
//						}
//					}
//				}
//			}
			
		}
		finish();	
		
		JsonExpertList jsonExpertList = new JsonExpertList();
		jsonExpertList.setLinks(linkExpertBeans);
		jsonExpertList.setNodes(nodeBeans);
		
		return jsonExpertList;
	}
	
	/**
	 * 寻找同一组织的专家
	 * @param ExpertId	待寻找的专家的主键
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSameOrg(int ExpertId){
		begin();
		Node expertNode = findExpertByMainKey(ExpertId);
		return findSameTypes(RelTypes.WORK_FOR,expertNode);
	}
	/**
	 * 寻找同一Topic 的专家
	 * @param ExpertId	待寻找的专家的主键
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSameTopic(int ExpertId){
		begin();
		Node expertNode = findExpertByMainKey(ExpertId);
		return findSameTypes(RelTypes.RESEARCH,expertNode);
	}
	/**
	 * 寻找同一Paper 的专家
	 * @param ExpertId	待寻找的专家的主键
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSamePaper(int ExpertId){
		begin();
		Node expertNode = findExpertByMainKey(ExpertId);
		return findSameTypes(RelTypes.PUBLISH,expertNode);
	}
	/**
	 * 寻找同一专利 的专家
	 * @param ExpertId	待寻找的专家的主键
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSamePatent(int ExpertId){
		begin();
		Node expertNode = findExpertByMainKey(ExpertId);
		return findSameTypes(RelTypes.APPLLY,expertNode);
	}
	/**
	 * 寻找同一Field 的专家
	 * @param ExpertId	待寻找的专家的主键
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSameField(int ExpertId){
		begin();
		Node expertNode = findExpertByMainKey(ExpertId);
		return findSameTypes(RelTypes.ENGAGED,expertNode);
	}
	private List<Long> findSameTypes(RelTypes reltype, Node node){

		setTraversalDescription();
		addRelationships(reltype,Direction.OUTGOING);
		addRelationships(reltype,Direction.INCOMING);
		setSection(2,2);
		setTraverser(node);	
			
		getJsonListSearch(LabelTypes.Expert);
		
		return getListSearch(LabelTypes.Expert);
	}
	private List<Node> findExpertInTopic(Node topicNode,int n){
		setTraversalDescription();
		addRelationships(RelTypes.RESEARCH,Direction.INCOMING);
		excludeStartPosition();
		setDeepth(1);
		setTraverser(topicNode);	
		
		return getNodeList(n);
	}
	private void findSameNodes(RelTypes reltype, Node node) {
		setTraversalDescription();
		addRelationships(reltype,Direction.OUTGOING);
		addRelationships(reltype,Direction.INCOMING);
		setSection(2,2);
		setTraverser(node);	
			
		getJsonListSearch(LabelTypes.Expert);
	}

	private boolean judgeIsRelation(Node aNode,Node bNode){
		boolean res = false;
		
		{
			setTraversalDescription();
//			addRelationships(RelTypes.WORK_FOR,Direction.OUTGOING);
//			addRelationships(RelTypes.WORK_FOR,Direction.INCOMING);
//			addRelationships(RelTypes.PUBLISH,Direction.OUTGOING);
//			addRelationships(RelTypes.PUBLISH,Direction.INCOMING);
//			addRelationships(RelTypes.APPLLY,Direction.OUTGOING);
//			addRelationships(RelTypes.APPLLY,Direction.INCOMING);
			setSection(2,2);
			setTraverser(aNode);	
			int i=0;
			for(Path path : traverser){
				System.out.println(path.endNode().getId() +" (i++) "+ bNode.getId());
				if(path.endNode().getId() == bNode.getId()){
					System.out.println(path.endNode().getProperty("name")+" ^ "+bNode.getProperty("name"));
					res = true;
					break;
				}
				
			}
			
		}
	
		
		return res;
	}
	
	private void getJsonListSearch(LabelTypes label) {
		Node aNode = null,bNode = null;
		if(label == null){
			for(Path path : traverser){
				//idsList.add(path.endNode().getId());
				aNode = path.startNode();
				bNode = path.endNode();
				
				nodeBeans.add(new NodeBean(bNode.getId(), nowType, bNode.getProperty("name").toString(), 1));
				linkExpertBeans.add(new LinkExpertBean(aNode.getProperty("name").toString(), bNode.getProperty("name").toString()));
			}
		}else{
			for(Path path : traverser){
				Label aLabelTypes = path.endNode().getLabels().iterator().next();
				if(aLabelTypes.toString().equals(label.toString()))
					aNode = path.startNode();
					bNode = path.endNode();
				
					nodeBeans.add(new NodeBean(bNode.getId(), nowType, bNode.getProperty("name").toString(), nowDepth));
					linkExpertBeans.add(new LinkExpertBean(aNode.getProperty("name").toString(), bNode.getProperty("name").toString()));
			}
		}

	}
}
