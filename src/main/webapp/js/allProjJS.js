function appProj(idnum){
    var idMy='#myModal'+idnum;
    setTimeout(function(){
        $(idMy).modal('show');
    },100)
}
$(document).ready(function(){
    $.ajax({
        url:'getAllProject',
        data:{

        },
        type:'POST',
        success:function(data){
            //alert(data);
            var jsonobj=JSON.parse(data);
            var jsontotal=jsonobj.total;
            var jsonrows=jsonobj.rows;//array
            for(var i=0;i<=jsontotal;i++){
                var projState=jsonrows[i].projectStatus;//项目状态 0:未开始/1:已开始/2:已结束
                var myState=jsonrows[i].myStatus;//0未报名 1已报名 2我（当前登录的账号）发起
                if(projState=='2'){//结束
                    $('.rightcenter').append(`
                    <div class="first">
								<div class="picDone">
									<div class="auditing">已结束</div>
								</div>
								<div class="demotext">
									<div class="demotitle">${jsonrows[i].projectName}</div>
									<div class="smalltitle">${jsonrows[i].projectRemark}</div>
									<div class="detail">
										<div>负责人：${jsonrows[i].projectUserName}</div>
										<div>开始时间：${jsonrows[i].projectBeginTimeStr}</div>
										<div>项目荣誉：${jsonrows[i].projectHonor}</div>
										<div>报名截止：${jsonrows[i].projectEndTimeStr}</div>
									</div>
								</div>
								
							</div>
                    `);
                }else{//未开始 已开始
                    if(myState=='0'){//未报名
                        $('.rightcenter').append(`
                        <div class="first">
                        <div class="pic">
                            <div class="auditing">报名中</div>
                        </div>
                        <div class="demotext">
                        <div class="demotitle">${jsonrows[i].projectName}</div>
                        <div class="smalltitle">${jsonrows[i].projectRemark}</div>
                        <div class="detail">
                            <div>负责人：${jsonrows[i].projectUserName}</div>
                            <div>开始时间：${jsonrows[i].projectBeginTimeStr}</div>
                            <div>项目荣誉：${jsonrows[i].projectHonor}</div>
                            <div>报名截止：${jsonrows[i].projectEndTimeStr}</div>
                        </div>
                        </div>
                        <div class="join" onclick="appProj(${jsonrows[i].id});" data-toggle="modal" >报名项目 ></div>
<div class="modal fade" id="myModal${jsonrows[i].id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content appMContent" style="width: 420px;height: 360px;padding-top:12px;padding-bottom:12px;padding-left:14px;padding-right:14px;">
            <div class="modal-body " style="position: relative;width:100%;height:100%;background-color:white;flex-direction: column;padding:10px">
                <div style="position: absolute;right: 8px;top: 8px;">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                        </button>
                </div>
                <div class="appMbodyTop" style="color:#345d89;width: 70%;height: 12%;border-bottom:1px solid #c6cedc;margin: 0 auto;text-align: center;">
                        项目报名
                </div>
                
                <div class="appMbodyCtr" style="height: 74%;padding-top: 18px;width: 100%;">
                    <textarea name="" id="text${jsonrows[i].id}"  rows="8" style="width:90%;display: block;margin: 0 auto;border:1px solid #c6cedc;"></textarea>
                </div>
                <div class="appMbodyBtm" style="width: 95%;display: flex;flex-direction: row-reverse;padding-top: 4px" >
                    <input onclick="sureProj(${jsonrows[i].id})" type="button" value="确定" data-dismiss="modal" style="cursor: pointer;float: right;width: 80px;height: 25px;border-radius: 6px;background-color: #345D89;color: white;border:none;font-size: 12px;">
                </div>

            </div>
            
        </div>
    </div>
</div>
                    </div>
                        `);
                    }else{//已报名、我发起
                        $('.rightcenter').append(`
                        <div class="first">
                        <div class="pic">
                            <div class="auditing">报名中</div>
                        </div>
                        <div class="demotext">
                        <div class="demotitle">${jsonrows[i].projectName}</div>
                        <div class="smalltitle">${jsonrows[i].projectRemark}</div>
                        <div class="detail">
                            <div>负责人：${jsonrows[i].projectUserName}</div>
                            <div>开始时间：${jsonrows[i].projectBeginTimeStr}</div>
                            <div>项目荣誉：${jsonrows[i].projectHonor}</div>
                            <div>报名截止：${jsonrows[i].projectEndTimeStr}</div>
                        </div>
                        </div>
                        <div class="join" onclick="location.href='myProj.html'">进入项目 ></div>
                    </div>                        
                        `);
                    }
                   

                }

            }
        },
        error:function(){

        }
        
    })

    // $.ajax({
    //     url:'getOverProjectList',
    //     type:'POST',
    //     data:{

    //     },
    //     success:function(data){
    //         alert(data);
    //         var jsonobj=JSON.parse(data);
    //         var jsontotal=jsonobj.total;
    //         var jsonrows=jsonobj.rows;//array
    //         for(var i=0;i<=jsontotal;i++){
    //             $('.rightcenter').append(`
    //                 <div class="first">
	// 							<div class="picDone">
	// 								<div class="auditing">已结束</div>
	// 							</div>
	// 							<div class="demotext">
	// 								<div class="demotitle">${jsonrows[i].projectName}</div>
	// 								<div class="smalltitle">${jsonrows[i].projectRemark}</div>
	// 								<div class="detail">
	// 									<div>负责人：${jsonrows[i].projectUserName}</div>
	// 									<div>开始时间：${jsonrows[i].projectBeginTimeStr}</div>
	// 									<div>项目荣誉：${jsonrows[i].projectHonor}</div>
	// 									<div>报名截止：${jsonrows[i].projectEndTimeStr}</div>
	// 								</div>
	// 							</div>
								
	// 						</div>
    //                 `);
    //         }

    //     }
    // })

})

function sureProj(idnum){
    //alert(idnum);
    var textID='#text'+idnum;
    //alert(textID);
    var textContent=$(textID).val();
    //alert(textContent);
    if(textContent==''){
        alert('输入不能为空!');
    }else{
        $.ajax({
            url:'applyToJoinProject',
            type:'POST',
            data:{
                "projectID":idnum,
                "pmReason":textContent
            },
            success:function(data){
                alert(JSON.parse(data).msg);
            },
            error:function(){

            }
        })
    }
}