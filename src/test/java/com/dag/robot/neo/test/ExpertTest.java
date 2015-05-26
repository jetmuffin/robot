package com.dag.robot.neo.test;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.neo4j.graphdb.Node;

import com.dag.robot.data.add.AddToNeo;
import com.dag.robot.data.search.SearchFromNeo;
import com.dag.robot.neo.type.LabelTypes;
import com.dag.robot.web.bean.JsonExpertList;


public class ExpertTest {
	
	String db_path = "/home/jeff/workspace/expertNeoDB";
	
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
	
	String expertNameOrg = "专家org";
	int expertIdOrg = 6;
	String expertNamePat = "专家pat";
	int expertIdPat = 7;
	String expertNamePar = "专家par";
	int expertIdPar = 8;
	String expertNameTop = "专家top";
	int expertIdTop = 9;
	String expertNameFie = "专家fie";
	int expertIdFie = 10;
	@Test
	public void test(){
		AddToNeo ato = new AddToNeo();
		ato.setDB_PATH(db_path);
//		ato.begin();
		
		ato.addExpertField(expertId, expertName, fieldId, fieldName);
		ato.addExpertOrg(expertId, expertName, orgId, orgName);
		ato.addExpertPaper(expertId, expertName, paperId, paperName);
		ato.addExpertPatent(expertId, expertName, patentId, patentName);
		ato.addExpertTopic(expertId, expertName, topicId, topicName);
		ato.addTopicField(topicId, topicName, fieldId, fieldName);

		ato.addExpertField(expertIdFie, expertNameFie, fieldId, fieldName);
		ato.addExpertOrg(expertIdOrg, expertNameOrg, orgId, orgName);
		ato.addExpertPaper(expertIdPar, expertNamePar, paperId, paperName);
		ato.addExpertPatent(expertIdPat, expertNamePat, patentId, patentName);
		ato.addExpertTopic(expertIdTop, expertNameTop, topicId, topicName);
		
		ato.success();	
		ato.finish();	
		ato.begin();
		
		Node node = ato.getNeoObject().findNode(LabelTypes.Expert, "mainKey", 0);
		System.out.println("id = "+node.getId());
	}
	
	@Test
	public void searchTest(){
		SearchFromNeo sfn = new SearchFromNeo();
		sfn.setDB_PATH(db_path);
		
//		List<Long> idslList = sfn.matchSameOrg(5);
//		for(long id : idslList){
//			System.out.println(sfn.findNodeById(id).getProperty("name"));
//		}
//		
//		System.out.println("----------------------------------");
//		idslList = sfn.matchSamePaper(5);
//		for(long id : idslList){
//			System.out.println(sfn.findNodeById(id).getProperty("name"));
//		}
//		
//		System.out.println("----------------------------------");
//		idslList = sfn.matchSameTopic(5);
//		for(long id : idslList){
//			System.out.println(sfn.findNodeById(id).getProperty("name"));
//		}
//		
//		System.out.println("----------------------------------");
//		idslList = sfn.matchSameField(5);
//		for(long id : idslList){
//			System.out.println(sfn.findNodeById(id).getProperty("name"));
//		}
//		
//		System.out.println("----------------------------------");
//		idslList = sfn.matchSamePatent(5);
//		for(long id : idslList){
//			System.out.println(sfn.findNodeById(id).getProperty("name"));
//		}
//		
//		sfn.finish();
		
		JsonExpertList jsonExpertList = sfn.getExpertList(5);
		
		
		{
			ObjectMapper objectMapper = new ObjectMapper();      
			JsonGenerator jsonGenerator = null;
			try {
				jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
			
			try {
				jsonGenerator.writeObject(jsonExpertList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.println(jsonExpertList.toString());
		}
	}
}
