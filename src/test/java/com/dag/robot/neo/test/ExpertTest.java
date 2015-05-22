package com.dag.robot.neo.test;

import java.util.List;

import org.junit.Test;
import org.neo4j.graphdb.Node;

import com.dag.robot.data.add.AddToNeo;
import com.dag.robot.data.search.SearchFromNeo;
import com.dag.robot.neo.type.LabelTypes;


public class ExpertTest {
	
	String db_path = "/home/innerac/workspace/neoDB";
	
	String fieldName = "领域";
	int fieldId = 0;
	String topicName = "主题";
	int topicId = 1;
	String paperName = "论文";
	int paperId = 2;
	String patentName = "专利";
	int patentId = 3;
	String orgName = "组织";
	int orgId = 4;
	String expertName = "专家";
	int expertId = 5;
	
	String expert1Name = "专家1";
	int expert1Id = 6;
	
	@Test
	public void test(){
		AddToNeo ato = new AddToNeo(db_path);
		
		ato.addExpertField(expertId, expertName, fieldId, fieldName);
		ato.addExpertOrg(expertId, expertName, orgId, orgName);
		ato.addExpertOrg(expert1Id, expert1Name, orgId, orgName);
		ato.addExpertPaper(expertId, expertName, paperId, paperName);
		ato.addExpertPatent(expertId, expertName, patentId, patentName);
		ato.addExpertTopic(expertId, expertName, topicId, topicName);
		ato.addTopicField(topicId, topicName, fieldId, fieldName);
		

		
		ato.success();	
		ato.finish();	
		ato.begin();
		
		Node node = ato.getNeoObject().findNode(LabelTypes.Expert, "mainKey", 5);
		System.out.println("id = "+node.getId());
	}
	
	@Test
	public void searchTest(){
		SearchFromNeo sfn = new SearchFromNeo(db_path);
		List<Long> idslList = sfn.matchSameOrg(0);
		for(long id : idslList){
			System.out.println(sfn.findNodeById(id).getProperty("name"));
		}
	}
}
