package com.dag.robot.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.RelExpertOrg;
import com.dag.robot.entities.RelPaperJournal;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.PaperForList;

public class EntitiesForListUtil {
	
	public static List<ExpertForList> expertForLists(List<Expert> experts){
		List<ExpertForList> expertForLists = new ArrayList<ExpertForList>();
		if(experts == null || experts.size() == 0)
			return expertForLists;
		for(int i = 0; i < experts.size(); i++){
			Expert expert = experts.get(i);
			ExpertForList expertForList = new ExpertForList();
			expertForList.setExpertId(expert.getExpertId());
			expertForList.setName(expert.getName());
			expertForList.setEmail(expert.getEmail());
			expertForList.setGender(expert.getGender());
			expertForList.setPaperNum(expert.getPaperNum());
			expertForList.setPatentNum(expert.getPatentNum());
			
			Set<RelExpertOrg> relExpertOrgs = expert.getRelExpertOrgs();
			List<String> orgs = new ArrayList<String>();
			Iterator<RelExpertOrg> iterator = relExpertOrgs.iterator();
			while(iterator.hasNext()){
				RelExpertOrg relExpertOrg = iterator.next();
				Orgnization orgnization = relExpertOrg.getOrgnization();
				orgs.add(orgnization.getName());
			}
			expertForList.setOrg(StringMergeUtil.stringMerge(orgs));
			expertForLists.add(expertForList);
		}
		return expertForLists;
	}
	
	public static List<PaperForList> paperForLists(List<Paper> papers){
		List<PaperForList> paperForLists = new ArrayList<PaperForList>();
		if(papers == null || papers.size() == 0)
			return paperForLists;
		for(int i = 0; i < papers.size(); i++){
			Paper paper = papers.get(i);
			PaperForList paperForList = new PaperForList();
			paperForList.setPaperId(paper.getPaperId());
			paperForList.setAbs(paper.getAbs());
			paperForList.setKeywords(paper.getKeywords());
			paperForList.setTitle(paper.getTitle());
			
			Set<Topic> topics = paper.getTopics();
			List<String> topicList = new ArrayList<String>();
			Iterator<Topic> iterator = topics.iterator();
			while(iterator.hasNext()){
				Topic topic = iterator.next();
				topicList.add(topic.getName());
			}
			paperForList.setTopic(StringMergeUtil.stringMerge(topicList));
			paperForLists.add(paperForList);
		}
		return paperForLists;
	}

}
