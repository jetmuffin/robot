package com.dag.robot.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertOrg;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.entities.RelExpertPatent;
import com.dag.robot.entities.RelExpertTopic;
import com.dag.robot.entities.RelPaperJournal;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.ExpertForShow;
import com.dag.robot.web.bean.PaperForList;

public class EntitiesForShowUtil {
	
	public static ExpertForShow expertForShow(Expert expert){
		
		ExpertForShow expertForShow = new ExpertForShow();
		expertForShow.setAchievement(expert.getAchievement());
		expertForShow.setActivity(expert.getActivity());
		expertForShow.setAddress(expert.getAddress());
		expertForShow.setEmail(expert.getEmail());
		expertForShow.setExperience(expert.getExperience());
		expertForShow.setExpertId(expert.getExpertId());
		expertForShow.setGender(expert.getGender());
		expertForShow.setHomepage(expert.getHomepage());
		expertForShow.setInfo(expert.getInfo());
		expertForShow.setName(expert.getName());
		expertForShow.setPaperNum(expert.getPaperNum());
		expertForShow.setPatentNum(expert.getPatentNum());
		expertForShow.setPaperReferedNum(expert.getPaperReferedNum());
		expertForShow.setPrize(expert.getPrize());

		Iterator<?> iterator;
		
		Set<RelExpertPaper> relExpertPapers = expert.getRelExpertPapers();
		List<Paper> papers = new ArrayList<Paper>();
		iterator = relExpertPapers.iterator();
		while(iterator.hasNext()){
			RelExpertPaper relExpertPaper = (RelExpertPaper) iterator.next();
			Paper paper = relExpertPaper.getPaper();
			papers.add(paper);
		}
		expertForShow.setPapers(papers);
		
		Set<RelExpertPatent> relExpertPatents = expert.getRelExpertPatents();
		List<Patent> patents = new ArrayList<Patent>();
		iterator = relExpertPatents.iterator();
		while(iterator.hasNext()){
			RelExpertPatent relExpertPatent = (RelExpertPatent) iterator.next();
			Patent patent = relExpertPatent.getPatent();
			patents.add(patent);
		}
		expertForShow.setPatents(patents);
		
		Set<RelExpertTopic> relExpertTopics = expert.getRelExpertTopics();
		List<Topic> topics = new ArrayList<Topic>();
		iterator = relExpertTopics.iterator();
		while(iterator.hasNext()){
			RelExpertTopic relExpertTopic = (RelExpertTopic) iterator.next();
			Topic topic = relExpertTopic.getTopic();
			topics.add(topic);
		}
		expertForShow.setTopics(topics);
		
		Set<RelExpertOrg> relExpertOrgs = expert.getRelExpertOrgs();
		List<Orgnization> orgs = new ArrayList<Orgnization>();
		iterator = relExpertOrgs.iterator();
		while(iterator.hasNext()){
			RelExpertOrg relExpertOrg = (RelExpertOrg) iterator.next();
			Orgnization org = relExpertOrg.getOrgnization();
			orgs.add(org);
		}
		expertForShow.setOrgnizations(orgs);
		
		return expertForShow;
	}
	

}
