package com.dag.robot.data.search;

import java.util.List;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterable;

import com.dag.robot.neo.object.NeoSearchObject;
import com.dag.robot.neo.type.LabelTypes;
import com.dag.robot.neo.type.RelTypes;

public class SearchFromNeo extends NeoSearchObject {

	public SearchFromNeo(){
	}
	public SearchFromNeo(String db_path){
		super(db_path);
		begin();
	}
	
	/**
	 * 寻找同一组织的专家
	 * @param ExpertId	待寻找的专家
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSameOrg(int ExpertId){
		Node expertNode = findNodeById(ExpertId);
		return findSameTypes(RelTypes.WORK_FOR,expertNode);
	}
	/**
	 * 寻找同一Topic 的专家
	 * @param ExpertId	待寻找的专家
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSameTopic(int ExpertId){
		Node expertNode = findNodeById(ExpertId);
		return findSameTypes(RelTypes.RESEARCH,expertNode);
	}
	/**
	 * 寻找同一Paper 的专家
	 * @param ExpertId	待寻找的专家
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSamePaper(int ExpertId){
		Node expertNode = findNodeById(ExpertId);
		return findSameTypes(RelTypes.PUBLISH,expertNode);
	}
	/**
	 * 寻找同一专利 的专家
	 * @param ExpertId	待寻找的专家
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSamePatent(int ExpertId){
		Node expertNode = findNodeById(ExpertId);
		return findSameTypes(RelTypes.APPLLY,expertNode);
	}
	/**
	 * 寻找同一Field 的专家
	 * @param ExpertId	待寻找的专家
	 * @return		返回寻找到的专家的图id列表
	 */
	public List<Long> matchSameField(int ExpertId){
		Node expertNode = findNodeById(ExpertId);
		return findSameTypes(RelTypes.ENGAGED,expertNode);
	}
	public List<Long> findSameTypes(RelTypes reltype, Node node){
		setTraversalDescription();
		addRelationships(reltype);
		setDeepth(1);
		setTraverser(node);
		ResourceIterable<Node> nodes = getTmpNodes();
		
		setTraversalDescription();
		setDeepth(1);
		setTraverser(nodes);
		List<Long> idsList = getListSearch(LabelTypes.Expert);
		
		return idsList;
	}
	
}
