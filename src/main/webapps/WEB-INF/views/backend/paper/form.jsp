<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<div class="span12 field-box">
	<label>标题:</label> <input value="${paper.title}" name="title"
		class="span9" type="text" id="input-title" /> <span></span>
	<div class="span8 notice" id="title-notice"></div>
</div>

<div class="span12 field-box">

	<div id="authors">
		<div class="input-group">
			<label>作者:</label> <input id='author-input' name="authors[0]"
				value="" type='text' data-toggle="popover" title=" "
				data-content=" " class='author-input tags span8' onblur="duplicateName(this)">
		</div>
	</div>

	<div id="row-fluid show-grid">
		<a id="add-author" class="span1"><i
			class="btn btn-glow fa fa-plus"></i></a> <span
			class="charactersleft span4">若有多个作者,请按按钮添加</span>
	</div>
</div>

<div class="span8 notice" id="author-notice"></div>

<div class="field-box">
	<label>摘要:</label>
	<div class="span9">
		<textarea name="abs" class="span12 " rows="6"></textarea>
	</div>
</div>

<div class="span12 field-box">
	<label>关键词:</label> <input id='tags-keywords' name="keywords" value=""
		type='text' class='tags span9'>
	</p>
	<span class="charactersleft">输入关键词后,按","生成标签</span>
</div>

<div class="span12 field-box">
	<label>期刊:</label> <input value="${paper.journal}" name="journal"
		class="span9" type="text" id="input-journal" />
	<div class="span8 notice" id="journal-notice"></div>
</div>

<div class="span12 field-box">
	<label>刊号:</label> <input value="" name="issue" class="span9"
		type="text" id="input-issue" />
	<div class="span8 notice" id="issue-notice"></div>
</div>

<div class="span11 field-box actions">
	<input type="button" id="paper-submit" class="btn-glow primary"
		value="提交" /> <span>OR</span> <input type="reset" value="取消"
		class="reset" />
</div>