<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <%@include file ="/src1/main/webapp/common/taglib.jsp" %>
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    DASHBOARD
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" >
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        HELLO,${USERMODEL.fullName}
                    </a>
                    <li class="light-blue dropdown-modal">
                        <a href='<c:url value="/thoat?action=logout"/>'>
                            <i class="ace-icon fa fa-power-off"></i>
                            LOG OUT
                        </a>
                    </li>
              
            </ul>
        </div>
    </div>
</div>
