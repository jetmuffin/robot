package com.dag.robot.db.dao;

import java.util.List;
import java.util.Map;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.ExpertForCheck;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.ExpertForShow;
import com.dag.robot.web.bean.JsonData;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PaperKeyword;
import com.dag.robot.web.bean.PaperNumTenYears;
import com.dag.robot.web.bean.PaperRefGrade;

public interface ExpertDao {
	
	/**
	 * 增加专家信息
	 * @param expert 专家信息
	 */
	public void addExpert(Expert expert);
	
	/**
	 * 更新专家信息
	 * @param expert 专家信息
	 */
	public void updateExpert(Expert expert);
	
	/**
	 * 根据姓名检索专家
	 * @param name 专家姓名
	 */
	public List<Expert> getByName(String name);
	
	/**
	 * 根据id检索专家
	 * @param expertId 专家id
	 */
	public Expert getById(int expertId);
	
	/**
	 * 删除专家信息
	 * @param expert 专家
	 * 	 */
	public void deleteExpert(Expert expert);
	
	/**
	 * 增加专家相关领域
	 * @param expert 专家
	 * @param field  领域
	 * @param weight 权值
	 */
	public void addField(Expert expert, Field field, int weight);
	
	/**
	 * 增加专家相关话题
	 * @param expert 专家
	 * @param topic 话题
	 * @param weight
	 */
	public void addTopic(Expert expert, Topic topic, int weight);
	
	/**
	 * 增加专家论文信息
	 * @param expert 专家
	 * @param paper 论文
	 * @param authorNum 作者次序
	 */
	public void addPaper(Expert expert, Paper paper, int authorOrder);
	
	/**
	 * 增加专家专利信息
	 * @param expert 专家
	 * @param patent 专利
	 * @param authorOrder 作者次序
	 */
	public void addPatent(Expert expert, Patent patent, int authorOrder);
	
	/**
	 * 增加专家所属组织信息
	 * @param expert 专家
	 * @param orgnization 组织
	 * @param job 工作
	 */
	public void addOrgnization(Expert expert, Orgnization orgnization, String job);
	
	/**
	 * 检索专家领域信息
	 * @param expertId 专家id
	 * @return 领域
	 */
	public Field getField(int expertId);
	
	/**
	 * 检索专家话题信息
	 * @param expertId 专家id
	 * @return 话题List
	 */
	public List<Topic> getTopics(int expertId);
	
	/**
	 * 检索专家论文信息
	 * @param expertId 专家id
	 * @return 论文List
	 */
	public List<Paper> getPapers(int expertId);
	
	/**
	 * 检索专家论文,按照被引用数量降序排列
	 * @param expertId
	 * @return
	 */
	public List<Paper> getPapersOrderByRefNum(int expertId);
	
	/**
	 * 检索专家专利
	 * @param expertId
	 * @return
	 */
	public List<Patent> getPatent(int expertId);
	
	/**
	 * 根据名称模糊检索专利
	 * @param expertId
	 * @return
	 */
	public List<Patent> getPatentsFuzzyName(int expertId,String string);
	
	/**
	 * 检索专家专利信息
	 * @param expertId 专家id
	 * @return 专利List
	 */
	public List<Patent> getPatents(int expertId);
	
	/**
	 * 检索专家组织信息
	 * @param expertId 专家id
	 * @return 组织List
	 */
	public Orgnization getOrgnization(int expertId);
	
	/**
	 * 分页
	 * @param pageSize 每页条数
	 * @param currenPage 当前页码
	 * @return 
	 */
	public Page<ExpertForList> page(int pageSize, int currenPage);
	
	/**
	 * 名字查重
	 * @param expertName 专家名字
	 * @return
	 */
	public List<ExpertForCheck> check(String expertName);
	
	/**
	 * 查询同一个专家
	 * @param name
	 * @return
	 */
	public Expert checkSame(String name, String OrgName);
	
	/**
	 * 更新专家履历信息
	 * @param expertId
	 * @param experience
	 * @return 
	 */
	public void updateExperience(int expertId, String experience);
	
	/**
	 * 更新专家简介信息
	 * @param expertId
	 * @param info
	 */
	public void updateInfo(int expertId, String info);
	
	/**
	 * 更新专家成果信息
	 * @param expertId
	 * @param achievement
	 */
	public void updateAchievement(int expertId, String achievement);
	
	/**
	 * 根据研究领域检索专家
	 * @param field
	 * @param num
	 * @return 
	 */
	public List<ExpertForList> getByField(String field, int num);
	
	/**
	 * 所有专家论文数量平均值
	 * @return
	 */
	public String getPaperAvg();
	
	/**
	 * 专家论文数量排名百分比
	 * @return
	 */
	public String getPaperRate();
	
	/**
	 * 获取专家论文关键字的出现次数
	 * @return
	 */
	public List<PaperKeyword> getPaperKey(int expertId, int num);
	
	/**
	 * 解决内存中多个同名引用问题
	 * @param object
	 */
	public void merge(Object object);
	
	/**
	 * 得到专家数量
	 * @return
	 */
	public long getExpertNum();
	
	/**
	 * 获得专家论文被引用与未被引用数量对比
	 * @return
	 */
	public List<JsonData> getPaperRefInfo(int expertId);
	
	
	/**
	 * 获取论文被引用次数的分级
	 * @param expertId
	 * @return
	 */
	public int[] getPaperRefGrade(int expertId);
	
	/**
	 * 获得近十年论文发表数量对比
	 * @param expertId
	 * @return 返回数组第0个是今年的，第1个是去年的，以此类推
	 */
	public int[] getPaperNumTenYears(int expertId);
	
	/**
	 * 根据姓名模糊检索
	 * @param name
	 * @return
	 */
	public List<ExpertForShow> getByFuzzyName(String name);
	
	/**
	 * 根据领域检索
	 * @param field
	 * @return
	 */
	public List<Expert> getByField(String field);
	
	/**
	 * 获取某领域下的专家省份分布
	 * @param field
	 * @return
	 */
	public Map<String, Integer> getAreaByField(String field);
	
	/**
	 * 根据名称模糊检索某个专家的相关论文
	 * @param expertId
	 * @param string
	 * @return
	 */
	public List<Paper> getPaperFuzzyName(int expertId, String string);
	
	/**
	 * 根据摘要模糊检索某个专家的相关论文
	 * @param expertId
	 * @param string
	 * @return
	 */
	public List<Paper> getPaperFuzzyAbs(int expertId, String string);
	
	/**
	 * 检索某个专家对某个问题的观点
	 * @param expertId
	 * @param string
	 * @return
	 */
	public List<String> getPoint(int expertId, String string, int num);
	
}
