<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pages">

	<ul class="pagination">
		<c:if test="${paging.prevBlock+1 >5 }">
			<li><a href="./mCtrl?flag=3&cPage=${paging.prevBlock }">&laquo;</a></li>
			</c:if>
			<c:forEach var ="i" begin="${paging.prevBlock+1 }"
			end="${paging.totalPage }" step="1" varStatus="status">
			<c:if test="${status.count < 21 }">
			<c:choose>
			<c:when test="${i eq paging.cPage }">
			<li class="active"><a href="#">${i }</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="./mCtrl?flag=3&cPage=${i }">${i }</a>
			</li>
			</c:otherwise>
	</c:choose>
	</c:if>
	</c:forEach>
	<c:if test="${paging.nextBlock-1 < paging.totalPage}">
		<li><a href="./mCtrl?flag=3&cPage=${paging.nextBlock }">&raquo;</a>
		</li>
		</c:if>	
	</ul>
</div>