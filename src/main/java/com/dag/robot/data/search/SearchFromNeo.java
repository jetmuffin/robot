package com.dag.robot.data.search;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.ResourceIterable;

import com.dag.robot.neo.object.NeoSearchObject;
import com.dag.robot.neo.type.LabelTypes;
import com.dag.robot.neo.type.RelTypes;

public class SearchFromNeo extends NeoSearchObject {

	public SearchFromNeo(){
	}
	public SearchFromNeo(String db_path){
		super(db_path);
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
		addRelationships(reltype);
		setDeepth(1);
		setTraverser(node);
		ResourceIterable<Node> nodes = getTmpNodes();
		
		setTraversalDescription();
		setDeepth(1);
		setTraverser(nodes);
		
		
		List<Long> idsList = getListSearch(LabelTypes.Expert);
		
//		finish();
		
		return idsList;
	}
	
	private List<Long> getJsonListSearch(LabelTypes label) {
		
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
}
