package com.dag.robot.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.classification.InterfaceAudience.Public;

import scala.Int;

import com.dag.robot.entities.CoreJournal;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.entities.RelFieldTopic;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.ExpertSimple;
import com.dag.robot.web.bean.PaperForShow;
import com.dag.robot.web.bean.PatentForShow;
import com.dag.robot.web.bean.TopicForShow;

public class EntitiesForListUtil {

	public static List<ExpertForList> expertForLists(List<Expert> experts) {
		List<ExpertForList> expertForLists = new ArrayList<ExpertForList>();
		if (experts == null || experts.size() == 0)
			return expertForLists;
		for (int i = 0; i < experts.size(); i++) {
			Expert expert = experts.get(i);
			ExpertForList expertForList = new ExpertForList();
			expertForList.setExpertId(expert.getExpertId());
			expertForList.setName(expert.getName());
			expertForList.setEmail(expert.getEmail());
			expertForList.setGender(expert.getGender());
			expertForList.setPaperNum(expert.getPaperNum());
			expertForList.setPatentNum(expert.getPatentNum());
			expertForList.setOrg(expert.getOrgnization().getName());
			expertForList.setPaperReferedNum(expert.getPaperReferedNum());
			expertForList.setRate(expert.getRate());
			expertForLists.add(expertForList);
		}
		return expertForLists;
	}

	public static List<PaperForShow> paperForLists(List<Paper> papers) {
		List<PaperForShow> paperForLists = new ArrayList<PaperForShow>();
		if (papers == null || papers.size() == 0)
			return paperForLists;
		for (int i = 0; i < papers.size(); i++) {
			Paper paper = papers.get(i);
			PaperForShow paperForList = new PaperForShow();
			paperForList.setPaperId(paper.getPaperId());
			paperForList.setAbs(paper.getAbs());
			paperForList.setKeywords(paper.getKeywords());
			paperForList.setTitle(paper.getTitle());
			paperForList.setReferencedNum(paper.getReferencedNum());
			paperForList.setType(paper.getType());
			paperForList.setConferences(paper.getConference());
			paperForList.setJournal(paper.getJournal());
			paperForList.setIssue(paper.getIssue());
			paperForList.setConferenceDate(paper.getConferenceDate());
			paperForList.setOrgnization(paper.getOrgnization());

			List<CoreJournal> coreJournals = new ArrayList<CoreJournal>();
			coreJournals.addAll(paper.getCoreJournals());
			paperForList.setCoreJournals(coreJournals);

			Set<Topic> topics = paper.getTopics();
			List<Topic> topicList = new ArrayList<Topic>();
			Iterator<Topic> iterator = topics.iterator();
			while (iterator.hasNext()) {
				Topic topic = iterator.next();
				topicList.add(topic);
			}
			paperForList.setTopics(topicList);

			Set<RelExpertPaper> relExpertPapers = paper.getRelExpertPapers();
			List<Expert> experts = new ArrayList<Expert>();
			Iterator<RelExpertPaper> iterator2 = relExpertPapers.iterator();
			while (iterator2.hasNext()) {
				RelExpertPaper relExpertPaper = iterator2.next();
				Expert expert = relExpertPaper.getExpert();
				experts.add(expert);
			}
			paperForList.setExperts(experts);

			paperForLists.add(paperForList);
		}
		return paperForLists;
	}

	public static List<PatentForShow> patentForLists(List<Patent> patents) {
		List<PatentForShow> patentForLists = new ArrayList<PatentForShow>();
		if (patents.size() == 0 || patents == null)
			return patentForLists;
		for (int i = 0; i < patents.size(); i++) {
			PatentForShow patentForList = new PatentForShow();
			Patent patent = patents.get(i);
			patentForList.setPatentId(patent.getPatentId());
			patentForList.setApplicant(patent.getApplicant());
			patentForList.setDate(patent.getDate());
			patentForList.setInventor(patent.getInventor());
			patentForList.setTitle(patent.getTitle());
			patentForList.setOrgnization(patent.getOrgnization());
			patentForList.setType(patent.getType());
			patentForLists.add(patentForList);
		}

		return patentForLists;
	}

	public static List<TopicForShow> topicForList(List<Topic> topics) {
		List<TopicForShow> topicForShows = new ArrayList<TopicForShow>();
		for (int i = 0; i < topics.size(); i++) {
			Topic topic = topics.get(i);
			TopicForShow topicForShow = new TopicForShow();
			topicForShow.setTopicId(topic.getTopicId());
			topicForShow.setName(topic.getName());
			Set<RelFieldTopic> relFieldTopics = topic.getRelFieldTopics();
			Iterator<RelFieldTopic> iterator = relFieldTopics.iterator();
			RelFieldTopic relFieldTopic = iterator.next();
			Field field = relFieldTopic.getField();
			topicForShow.setField(field);
			topicForShows.add(topicForShow);
		}
		return topicForShows;
	}

	
	public static List<ExpertSimple> expertForSimpleLists(List<Expert> experts) {
		List<ExpertSimple> ExpertSimples = new ArrayList<ExpertSimple>();
		if (experts == null || experts.size() == 0)
			return ExpertSimples;
		for (int i = 0; i < experts.size(); i++) {
			Expert expert = experts.get(i);
			ExpertSimple expertSimple = new ExpertSimple();
			expertSimple.setExpertId(expert.getExpertId());
			expertSimple.setName(expert.getName());
			expertSimple.setOrg(expert.getOrgnization().getName());
			expertSimple.setUrl(expert.getUrl());
		}
		return ExpertSimples;
	}
	
}
