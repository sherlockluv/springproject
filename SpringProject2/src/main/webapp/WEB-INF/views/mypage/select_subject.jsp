<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="register_center">


	<c:catch>

			<input type="hidden" name="flag" value="1">
			<div class="register_right">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>과목</th>
							<th>반</th>
							<th>학년</th>
							<th>선생님</th>
							<th>시작일</th>
							<th>종료일</th>
							<th>난이도</th>
							<th>강의신청</th>
						</tr>
					</thead>
					<tbody>
				
	<c:forEach var="svo" items="${mList}" >


						<form action="./myCtrl" method="post" id="myform" name="myform">
							<input type="hidden" name="flag" value="1">
								
							<tr>
						 <c:catch>
   							 <c:choose>
   
							<c:when test="${id eq svo.id }">
								<td><input type="hidden" name="subject"
									value="${svo.subject }">${svo.subject }</td>
								<td><input type="hidden" id="s_class" name="s_class" value="${svo.s_class  }">${svo.s_class  }</td>
								<td><input type="hidden" name="grade" value="${svo.grade }">${svo.grade }</td>
								<td><input type="hidden" name="tname" value="${svo.tname }">${svo.tname }</td>
						<td><span>${svo.id }</span></td>
								<td><input type="hidden" name="open_date"
									value="${svo.open_date }">${svo.open_date }</td>
								<td><input type="hidden" name="delete_date"
									value="${svo.delete_date }">${svo.delete_date }</td>
								<td><input type="hidden" name="mark" value="${svo.mark }">${svo.mark }</td>
					
							<td><span>신청완료</span>
									</td>
									</c:when>
								
									
										<c:otherwise>
						
								<td><input type="hidden" name="subject"
									value="${svo.subject }">${svo.subject }</td>
								<td><input type="hidden" id="s_class" name="s_class" value="${svo.s_class  }">${svo.s_class  }</td>
								<td><input type="hidden" name="grade" value="${svo.grade }">${svo.grade }</td>
								<td><input type="hidden" name="tname" value="${svo.tname }">${svo.tname }</td>
								<td><span>${svo.id }</span></td>
								<td><input type="hidden" name="open_date"
								
									value="${svo.open_date }">${svo.open_date }</td>
								<td><input type="hidden" name="delete_date"
									value="${svo.delete_date }">${svo.delete_date }</td>
								<td><input type="hidden" name="mark" value="${svo.mark }">${svo.mark }</td>
					
							<td><input type="submit" class="a" value="신청하기" id="a" name="a">
									</td>
									
									
					
									
				
									<c:otherwise>
									<c:when test="${svo.s_class eq svo.s_class }">
							<input type="hidden" name="subject"
									value="${svo.subject }">${svo.subject }
								<input type="hidden" id="s_class" name="s_class" value="${svo.s_class  }">${svo.s_class  }
								<td><input type="hidden" name="grade" value="${svo.grade }">${svo.grade }</td>
								<td><input type="hidden" name="tname" value="${svo.tname }">${svo.tname }</td>
								<td><span>${svo.id }</span></td>
								<td><input type="hidden" name="open_date"
								
									value="${svo.open_date }">${svo.open_date }</td>
								<td><input type="hidden" name="delete_date"
									value="${svo.delete_date }">${svo.delete_date }</td>
								<td><input type="hidden" name="mark" value="${svo.mark }">${svo.mark }</td>
					
							<td><input type="submit" class="a" value="신청하기" id="a" name="a">
									</td>
				</c:when>					
</c:otherwise>
</c:otherwise>
</c:choose>
	</c:catch>
							</tr>
										</form>		
										
						</c:forEach>


					</tbody>


				</table>
			
						<jsp:param value="${paging.prevBlock }" name="prevBlock" />
						<jsp:param value="${paging.startNo }" name="startNo" />
						<jsp:param value="${paging.totalPage }" name="totalPage" />
						<jsp:param value="${paging.cPage }" name="cPage" />
						<jsp:param value="${paging.endNo }" name="endNo" />
						<jsp:param value="${paging.nextBlock }" name="nextBlock " />
					
		

			</div>
	
	</c:catch>
</div>

  <script>
 
 $('.a').click(function() {
	
	 var result = "${result}";
				if (result == '1') {
					
				alert("수강된 과목입니다 확인부탁드립니다");
				
					}
				else {
			
					
			 }		
		

			});	 	


 </script> 
 
 

