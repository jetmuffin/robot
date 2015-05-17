package com.dag.robot.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.RelExpertOrg;
import com.dag.robot.web.bean.ExpertForList;

public class ExpertForListUtil {
	
	public static List<ExpertForList> forList(List<Expert> experts){
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
		}
		return expertForLists;
	}

}
