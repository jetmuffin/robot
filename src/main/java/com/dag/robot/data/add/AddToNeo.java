package com.dag.robot.data.add;

import org.springframework.stereotype.Service;

import com.dag.robot.neo.type.LabelTypes;
import com.dag.robot.neo.type.RelTypes;
import com.dag.robot.neo.object.NeoCreateObject;

@Service
public class AddToNeo extends NeoCreateObject{

	private String MAIN_KEY = "mainKey";
	private String NAME = "name";
	
	public AddToNeo(){
	}
	
	public void addExpertOrg(int expertId, String expertName, int OrgId,
			String orgName) {
		System.out.println("add link " + orgName + " - " +  expertName);
		createNormal(LabelTypes.Expert,expertId,expertName,RelTypes.WORK_FOR,LabelTypes.Organization,OrgId,orgName);
	}

	public void addExpertPaper(int expertId, String expertName, int paperId,
			String paperName) {
		createNormal(LabelTypes.Expert,expertId,expertName,RelTypes.PUBLISH,LabelTypes.Paper,paperId,paperName);
	}

	public void addExpertPatent(int expertId, String expertName, int patentId,
			String patentName) {
		createNormal(LabelTypes.Expert,expertId,expertName,RelTypes.APPLLY,LabelTypes.Patent,patentId,patentName);
	}
	
	public void addExpertTopic(int expertId, String expertName, int topicId,
			String topicName) {
		createNormal(LabelTypes.Expert,expertId,expertName,RelTypes.RESEARCH,LabelTypes.Topic,topicId,topicName);
	}
	
	public void addExpertField(int expertId, String expertName, int fieldId,
			String fieldName) {
		createNormal(LabelTypes.Expert,expertId,expertName,RelTypes.ENGAGED,LabelTypes.Field,fieldId,fieldName);
	}
	public void addTopicField(int topicId, String topicName, int fieldId,
			String fieldName) {
		createNormal(LabelTypes.Topic,topicId,topicName,RelTypes.BELONG_TO,LabelTypes.Field,fieldId,fieldName);
	}
	
	public void createNormal(LabelTypes aLabel,int aId,String aName,RelTypes relTypes,LabelTypes bLabel,int bId,String bName){
		createLine(aLabel,MAIN_KEY,aId,NAME,aName,relTypes,bLabel,MAIN_KEY,bId,NAME,bName);
	}
}
