<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<div class="span12 field-box">
	<label>姓名:</label> <input value="${expert.name}" name="name"
		class="span9" type="text" id="input-name" data-toggle="popover" title=" " data-content=" "/>
	<span></span>
	<div class="span8 notice" id="name-notice"></div>
</div>
<div class="span12 field-box">
	<label>性别:</label>
	<c:choose>

		<c:when test="${empty expert.gender or expert.gender eq 'male'}">
			<div class="span8">
				<label class="radio">
					<div class="radio" id="uniform-optionsRadios1">
						<span class=""><input type="radio" name="gender"
							id="gender-male" value="male" checked></span>
					</div> 男
				</label> <label class="radio">
					<div class="radio" id="uniform-optionsRadios2">
						<span class="checked"><input type="radio" name="gender"
							id="gender-female" value="female"></span>
					</div> 女 
		</c:when>
		<c:otherwise>
			<div class="span8">
				<label class="radio">
					<div class="radio" id="uniform-optionsRadios1">
						<span class=""><input type="radio" name="gender"
							id="gender-male" value="male"></span>
					</div> 男
				</label> <label class="radio">
					<div class="radio" id="uniform-optionsRadios2">
						<span class="checked"><input type="radio" name="gender"
							id="gender-female" value="female" checked></span>
					</div> 女 
		</c:otherwise>
	</c:choose>
	</label>
</div>
</div>
<div class="span12 field-box ">
	<label>单位:</label> <input value="${organization}" class="span9"
		name="organization" type="text" /><span class="charactersleft">若属于多个单位,请以英文逗号隔开</span>
	<div class="span8 notice" id="org-notice"></div>
</div>
<div class="span12 field-box">
	<label>Email:</label> <input class="span9" value="${expert.email}"
		type="text" name="email" />
	<div class="span8 notice" id="email-notice"></div>
</div>
<div class="span12 field-box">
	<label>Website:</label> <input value="${expert.homepage}" class="span9"
		type="text" name="homepage" />
	<div class="span8 notice" id="homepage-notice"></div>
</div>
<div class="span12 field-box">
	<label>地址:</label>
	<div class="address-fields">
		<input class="span12" type="text" placeholder="街道地址" name="street" />
		<input class="span12 small" type="text" placeholder="市" name="city" />
		<input class="span12 small" type="text" placeholder="省"
			name="province" /> <input type="text" name="address"
			style="display: none" />
	</div>
</div>
<div class="field-box">
	<label>个人简介:</label>
	<div class="wysi-column span9">
		<textarea id="wysi-info" name="info" class="span12 wysihtml5" rows="6"></textarea>
	</div>
</div>
<div class="span12 field-box ">
	<label>研究方向:</label> <input class="span9" type="text" name="topic" /> <span
		class="charactersleft">若有多个方向,请以英文逗号隔开</span>
</div>
<div class="field-box">
	<label>个人履历:</label>
	<div class="wysi-column span9">
		<textarea id="wysi-experience" name="experience"
			class="span12 wysihtml5" rows="6"></textarea>
	</div>
</div>
<div class="field-box">
	<label>科研成果:</label>
	<div class="wysi-column span9">
		<textarea id="wysi-achievement" name="achievement"
			class="span12 wysihtml5" rows="6"></textarea>
	</div>
</div>
<div class="span11 field-box actions">
	<input type="button" id="expert-submit" class="btn-glow primary"
		value="提交" /> <span>OR</span> <input type="reset" value="取消"
		class="reset" />
</div>
