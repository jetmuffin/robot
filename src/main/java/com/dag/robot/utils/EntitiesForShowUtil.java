package com.dag.robot.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.analysis.function.Exp;

import com.dag.robot.entities.Activity;
import com.dag.robot.entities.CoreJournal;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.entities.RelExpertPatent;
import com.dag.robot.entities.RelExpertTopic;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.ExpertForShow;
import com.dag.robot.web.bean.PaperForShow;
import com.dag.robot.web.bean.PatentForShow;

public class EntitiesForShowUtil {

	public static ExpertForShow expertForShow(Expert expert) {

		ExpertForShow expertForShow = new ExpertForShow();
		expertForShow.setAchievement(expert.getAchievement());
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
		expertForShow.setRate(expert.getRate());
		expertForShow.setOrgnization(expert.getOrgnization());
		expertForShow.setAge(expert.getAge());
		expertForShow.setArea(expert.getArea());
		expertForShow.setField(expert.getField());
		
		Iterator<?> iterator;

		Set<RelExpertPaper> relExpertPapers = expert.getRelExpertPapers();
		List<Paper> papers = new ArrayList<Paper>();
		iterator = relExpertPapers.iterator();
		while (iterator.hasNext()) {
			RelExpertPaper relExpertPaper = (RelExpertPaper) iterator.next();
			Paper paper = relExpertPaper.getPaper();
			papers.add(paper);
		}
		expertForShow.setPapers(papers);

		Set<RelExpertPatent> relExpertPatents = expert.getRelExpertPatents();
		List<Patent> patents = new ArrayList<Patent>();
		iterator = relExpertPatents.iterator();
		while (iterator.hasNext()) {
			RelExpertPatent relExpertPatent = (RelExpertPatent) iterator.next();
			Patent patent = relExpertPatent.getPatent();
			patents.add(patent);
		}
		expertForShow.setPatents(patents);

		Set<RelExpertTopic> relExpertTopics = expert.getRelExpertTopics();
		List<Topic> topics = new ArrayList<Topic>();
		iterator = relExpertTopics.iterator();
		while (iterator.hasNext()) {
			RelExpertTopic relExpertTopic = (RelExpertTopic) iterator.next();
			Topic topic = relExpertTopic.getTopic();
			topics.add(topic);
		}
		expertForShow.setTopics(topics);

		List<Activity> activities = new ArrayList<Activity>();
		activities.addAll(expert.getActivities());
		expertForShow.setActivities(activities);

		return expertForShow;
	}

	public static PaperForShow paperForShow(Paper paper) {

		PaperForShow paperForShow = new PaperForShow();
		paperForShow.setPaperId(paper.getPaperId());
		paperForShow.setAbs(paper.getAbs());
		paperForShow.setKeywords(paper.getKeywords());
		paperForShow.setTitle(paper.getTitle());
		paperForShow.setReferencedNum(paper.getReferencedNum());
		paperForShow.setType(paper.getType());
		paperForShow.setConferences(paper.getConference());
		paperForShow.setJournal(paper.getJournal());
		
		List<CoreJournal> coreJournals = new ArrayList<CoreJournal>();
		coreJournals.addAll(paper.getCoreJournals());
		paperForShow.setCoreJournals(coreJournals);
		
		Set<Topic> topics = paper.getTopics();
		List<Topic> topicList = new ArrayList<Topic>();
		Iterator<Topic> iterator = topics.iterator();
		while(iterator.hasNext()){
			Topic topic = iterator.next();
			topicList.add(topic);
		}
		paperForShow.setTopics(topicList);
		
		Set<RelExpertPaper> relExpertPapers = paper.getRelExpertPapers();
		List<Expert> experts = new ArrayList<Expert>();
		Iterator<RelExpertPaper> iterator2 = relExpertPapers.iterator();
		while(iterator.hasNext()){
			RelExpertPaper relExpertPaper = iterator2.next();
			Expert expert = relExpertPaper.getExpert();
			experts.add(expert);
		}
		paperForShow.setExperts(experts);
		return paperForShow;
	}
	
	public static PatentForShow patentForShow(Patent patent){
		
		PatentForShow patentForShow = new PatentForShow();
		patentForShow.setPatentId(patent.getPatentId());
		patentForShow.setAbs(patent.getAbs());
		patentForShow.setApplicant(patent.getApplicant());
		patentForShow.setDate(patent.getDate());
		patentForShow.setInventor(patent.getInventor());
		patentForShow.setTitle(patent.getTitle());
		patentForShow.setOrgnization(patent.getOrgnization());
		Set<RelExpertPatent> relExpertPatents = patent.getRelExpertPatents();
		List<Expert> experts = new ArrayList<Expert>();
		Iterator<RelExpertPatent> iterator = relExpertPatents.iterator();
		while(iterator.hasNext()){
			RelExpertPatent relExpertPatent = iterator.next();
			Expert expert = relExpertPatent.getExpert();
			experts.add(expert);
		}
		patentForShow.setExperts(experts);
		return patentForShow;
		
	}

}
