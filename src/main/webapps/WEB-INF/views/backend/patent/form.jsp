<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<div class="span12 field-box">
	<label>标题:</label> <input value="${patent.title}" name="title"
		class="span9" type="text" id="input-title" /> <span></span>
	<div class="span8 notice" id="title-notice"></div>
</div>

<div class="span12 field-box">

	<div id="authors">
		<div class="input-group">
			<label>发明人:</label> <input id='inventor-input' name="inventors"
				value="" type='text' data-toggle="popover" title=" "
				data-content=" " class='inventor-input tags span8' >
		</div>
	</div>

	<div id="row-fluid show-grid">
		<a id="add-author" class="span1"><i
			class="btn btn-glow fa fa-plus"></i></a> <span
			class="charactersleft span4">若有多个作者,请按按钮添加</span>
	</div>
</div>

<div class="field-box">
	<label>申请人:</label>
	<div class="span9">
		<input type="text" name="applicant" class="span12 " />
		<div class="span8 notice" id="applicant-notice"></div>
	</div>
</div>

<div class="field-box">
	<label>单位:</label>
	<div class="span9">
		<input type="text" name="organization" class="span12 " />
		<div class="span8 notice" id="organization-notice"></div>
	</div>
	
</div>

<div class="field-box">
	<label>摘要:</label>
	<div class="span9">
		<textarea name="abs" class="span12 " rows="6"></textarea>
	</div>
</div>

<div class="span11 field-box actions">
	<input type="button" id="patent-submit" class="btn-glow primary"
		value="提交" /> <span>OR</span> <input type="reset" value="取消"
		class="reset" />
</div>

