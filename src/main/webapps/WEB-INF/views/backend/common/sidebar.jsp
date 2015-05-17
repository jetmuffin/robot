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
                    <li><a href="/robot/backend/expert/import">导入专家</a></li>
                </ul>                
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="fa fa-book"></i>
                    <span>论文管理</span>
                    <i class="fa fa-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="/robot/backend/paper/papers">论文列表</a></li>
                    <li><a href="/robot/backend/paper/add">添加论文</a></li>
                    <li><a href="/robot/backend/paper/import">导入论文</a></li>
                </ul>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="fa fa-file-text-o"></i>
                    <span>专利管理</span>
                    <i class="fa fa-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="/robot/backend/paper/papers">专利列表</a></li>
                    <li><a href="/robot/backend/paper/add">添加专利</a></li>
                    <li><a href="/robot/backend/paper/import">导入专利</a></li>
                </ul>
            </li>            
            <li>
                <a href="#">
                    <i class="fa fa-bug"></i>
                    <span>爬取数据</span>
                </a>
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