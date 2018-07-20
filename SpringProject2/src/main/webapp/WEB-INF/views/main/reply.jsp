<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<section class="content container-fluid">
		<div class="col-lg-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Reply&nbsp;&nbsp;
						<button type="button" class="btn btn-primary">REGISTER</button></h3>
				</div>
				<div class="box-body">
					<div class="form-group">
						<label for="newReplyText">Reply Text</label> <input
							class="form-control" id="newReplyText" name="replyText"
							placeholder="Enter Reply Text">
					</div>
					<div class="form-group">
						<label for="newReplyWriter">Reply Writer</label> <input
							class="form-control" id="newReplyWriter" name="replyWriter"
							placeholder="Enter Reply Writer">
					</div>
				</div>
				<div class="box-footer">
					<ul id="replies">

					</ul>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination pagination-sm no-margin">

						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="modifyModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Reply Moidfication</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="replyNo">Reply Number</label> <input class="form-control"
								id="replyNo" name="replyNo" readonly>
						</div>
						<div class="form-group">
							<label for="replyText">Reply Text</label> <input class="form-control"
								id="replyText" name="replyText" placeholder="Enter Reply Text">
						</div>
						<div class="form-group">
							<label for="replyWriter">Reply Writer</label> <input
								class="form-control" id="replyWriter" name="replyWriter"
								readonly>
						</div>
					</div>
					<div class="modal-footer">						
						<button type="button" class="btn btn-success pull-left modalModBtn">Modify</button>
						<button type="button" class="btn btn-danger pull-left modalDelBtn">Delete</button>
						<button type="button" class="btn btn-default pull-right"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
<!-- /.content-wrapper -->
	<!-- jQuery 2.1.4 -->
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script>	
var bno = 11;
//getAllList();
getPageList(1);

function getAllList() {
    $.getJSON("/replies/all/" + bno, function (data) {
        console.log(data);
        var str = "";

        $(data).each(function () {
            str += "<li data-rno='"+this.rno+"' class='replyLi'>"
            	+ "<p>"+ this.rno +"</p>"
                + "<p class='replyText'>" + this.replytext + "</p>"
                + "<p class='replyWriter'>" + this.replyer + "</p>"
                + "<button type='button' class='btn btn-xs btn-warning'"
                + "data-toggle='modal' data-target='#modifyModal'>"
                + "Modifying</button>"
                + "</li>"
                + "<hr/>";
        });
        $("#replies").html(str);
    });
}
$(".btn-primary").on("click", function() {

	var replyer = $("#newReplyWriter").val();
	var replytext = $("#newReplyText").val();

	$.ajax({
		type : 'post',
		url : '/replies',
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType : 'text',
		data : JSON.stringify({
			bno : bno,
			replyer : replyer,
			replytext : replytext
		}),
		success : function(result) {

			if (result == 'SUCCESS') {

				alert("Regist Complete!");
				//getAllList();
				getPageList(1);
			}
		}
	});
});
$("#replies").on("click", ".replyLi button", function () {
    var reply = $(this).parent();	
    var replyNo = reply.attr("data-rno");
    var replyText = reply.find(".replyText").text();
    var replyWriter = reply.find(".replyWriter").text();

    $("#replyNo").val(replyNo);
    $("#replyText").val(replyText);
    $("#replyWriter").val(replyWriter);
});
$(".modalDelBtn").on("click", function () {    
    var rno = $(this).parent().parent().find("#replyNo").val();

    $.ajax({
        type : "delete",
        url : "/replies/" + rno,
        headers : {
            "Content-type" : "application/json",
            "X-HTTP-Method-Override" : "DELETE"
        },
        dataType : "text",
        success : function (result) {
            console.log("result : " + result);
            if (result == "SUCCESS") {
                alert("Delete Complete!");
                $("#modifyModal").modal("hide");
                //getAllList();
                getPageList(1);
            }
        }
    });
});
$(".modalModBtn").on("click", function () {
    var reply = $(this).parent().parent();
    var rno = reply.find("#replyNo").val();
    var replyText = reply.find("#replyText").val();
 
    $.ajax({
        type : "put",
        url : "/replies/" + rno,
        headers : {
            "Content-type" : "application/json",
            "X-HTTP-Method-Override" : "PUT"
        },
        data : JSON.stringify(
            {replytext : replyText}
        ),
        dataType : "text",
        success : function (result) {
            console.log("result : " + result);
            if (result == "SUCCESS") {
                alert("Modifying Complete!");
                $("#modifyModal").modal("hide");
                //getAllList();
                getPageList(1);
            }
        }
    });
});

function getPageList(page) {
    $.getJSON("/replies/" + bno + "/" + page, function (data) {
        console.log(data.list.length);
        var str = "";

        $(data.list).each(function () {
            str += "<li data-rno='"+this.rno+"' class='replyLi'>"
        	+ "<p>"+ this.rno +"</p>"
            + "<p class='replyText'>" + this.replytext + "</p>"
            + "<p class='replyWriter'>" + this.replyer + "</p>"
            + "<button type='button' class='btn btn-xs btn-warning'"
            + "data-toggle='modal' data-target='#modifyModal'>"
            + "Modifying</button>"
            + "</li>"
            + "<hr/>";
        });

        $("#replies").html(str);        
        printPaging(data.pageMaker);
    });
}

function printPaging(pageMaker) {

    var str = "";
    
    if (pageMaker.prev) {
        str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
    }
    
    for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
        var strClass = pageMaker.cri.page == i ? 'class=active' : '';
        str += "<li "+strClass+"><a href='"+i+"'>"+i+"</a></li>";
    }
    
    if (pageMaker.next) {
        str += "<li><a href='"+(pageMaker.endPage + 1)+"'> >> </a></li>";
    }

    $(".pagination-sm").html(str);
}
var replyPage = 1;

$(".pagination").on("click", "li a", function (event) {
 event.preventDefault();
 replyPage = $(this).attr("href"); 
 getPageList(replyPage);
});
</script>
	
