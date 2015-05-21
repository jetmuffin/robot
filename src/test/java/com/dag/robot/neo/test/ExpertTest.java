package com.dag.robot.neo.test;

import org.junit.Test;

import com.dag.robot.data.add.AddToNeo;


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
	String expertName = "专利";
	int expertId = 5;
	
	@Test
	public void test(){
		AddToNeo ato = new AddToNeo(db_path);
		
		ato.addExpertField(expertId, expertName, fieldId, fieldName);
		ato.addExpertOrg(expertId, expertName, orgId, orgName);
		ato.addExpertPaper(expertId, expertName, paperId, paperName);
		ato.addExpertPatent(expertId, expertName, patentId, patentName);
		ato.addExpertTopic(expertId, expertName, topicId, topicName);
		
		ato.success();
		ato.finish();
	}
}
