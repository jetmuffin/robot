<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- sidebar -->
    <div id="sidebar-nav">
        <ul id="dashboard-menu">
            <li class="active">
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
                <a href="/robot/backend/index">
                    <i class="fa fa-home"></i>
                    <span>首页</span>
                </a>
            </li>            
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="fa fa-user-secret"></i>
                    <span>专家管理</span>
                    <i class="fa fa-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="/robot/backend/expert/experts">专家列表</a></li>
                    <li><a href="/robot/backend/expert/add">增加专家</a></li>
                </ul>                
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="fa fa-book"></i>
                    <span>文献管理</span>
                    <i class="fa fa-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="/robot/backend/paper/papers">论文管理</a></li>
                    <li><a href="#">专利管理</a></li>
                </ul>
            </li>
            <li>
                <a class="dropdown-toggle ui-elements" href="#">
                    <i class="fa fa-code-fork"></i>
                    <span>数据录入</span>
                    <i class="fa fa-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="ui-elements.html">UI Elements</a></li>
                    <li><a href="fa fas.html">fa fas</a></li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-group"></i>
                    <span>用户管理</span>
                </a>
            </li>            
            <li>
                <a href="#">
                    <i class="fa fa-cog"></i>
                    <span>系统设置</span>
                </a>
            </li>
        </ul>
    </div>
    <!-- end sidebar -->