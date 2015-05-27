package com.dag.robot.web.answer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dag.robot.nlp.StanfordParser;
import com.dag.robot.web.bean.RobotResponse;
import com.dag.robot.analyzer.Analyzer;
import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;

@Service
public class Answer {

	@Autowired
	@Qualifier("expertDao")
	ExpertDao expertDao;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RobotResponse responseSingle(int expertId, String sentence) {
		RobotResponse response = new RobotResponse();
		Analyzer analyzer = new Analyzer();
		String[] words = analyzer.analyzeSplit(sentence);
		String keyword = StanfordParser.parse(words);
		List<String> points = expertDao.getPoint(expertId, keyword, 1);
		// 获取观点
		if (points == null || points.size() == 0) {
			response.setPoint(null);
		} else {
			response.setPoint(points.get(0));
		}
		// 获取论文信息
		List<String> paperList = new ArrayList<String>();
		List<Paper> papers = expertDao.getPaperFuzzyName(expertId, keyword);
		if (papers == null) {
			paperList.add(null);
		} else {
			int n = papers.size();
			if (n > 3)
				n = 3;
			for (int i = 0; i < n; i++) {
				String paperName = papers.get(i).getTitle();
				paperList.add("《"+paperName+"》 ");
			}
		}
		response.setPaper(paperList);
		// 获得专利信息
		List<String> patentList = new ArrayList<String>();
		List<Patent> patents = expertDao.getPatentsFuzzyName(expertId, keyword);
		if(patents == null){
			patentList.add(null);
		}else {
			int n = patents.size();
			if(n > 3)
				n = 3;
			for(int i = 0; i < n; i++){
				Patent patent = patents.get(i);
				String patentName = patent.getTitle();
				patentList.add("《"+patentName+"》 ");
			}
		}
		response.setPatents(patentList);
	}
}
