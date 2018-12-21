function deleteProj(idnum){
    //alert(idnum);
    $.ajax({
        url:'deleteProjectByID',
        data:{
            "projectID":idnum,
        },
        type:'POST',
        success:function(data){
            alert(JSON.parse(data).msg);
            location.reload();
        },
        error:function(data){

        }
    })
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
                                <div class="delete" onclick="deleteProj(${jsonrows[i].id})">删除项目</div>
								
							</div>
                    `);
                }else{//未开始 已开始
                    
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
                        <div class="delete" onclick="deleteProj(${jsonrows[i].id})">删除项目</div>
                    </div>                        
                        `);
                    
                   

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

