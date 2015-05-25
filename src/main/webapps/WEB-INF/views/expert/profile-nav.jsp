	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
			<ul class="profile-nav">
					<li><h2><span>目录</span></h2></li>
				<li><a href="/robot/expert/basic/${expert.expertId}">基本信息</a></li>
				<li class="selected"><a href="/robot/expert/paper/${expert.expertId}">论文信息</a></li>
				<li><a href="/robot/expert/patent/${expert.expertId}">专利信息</a></li>
				<li><a href="/robot/expert/activity/${expert.expertId}">科研活动</a></li>
			</ul>