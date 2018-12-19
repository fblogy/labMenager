var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

function cancelProj(idnum){
    var projID=idnum;//alert(projID+getCookie('userAccount'));
    $.ajax({
        url:'applyToOutProject',
        data:{
            "projectID":projID,
            "projectAccount":getCookie('userAccount')
        },
        type:'POST',
        success:function(data){
            alert(JSON.parse(data).msg);
            location.reload();
        },
        error:function(){

        }

    })
}



$(document).ready(function(){
    $.ajax({
        url:'getMyProjectList',
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
                var appState=jsonrows[i].applyStatus;//我报名的 0 1 -1 //我发起的 2
                //alert(projState);
                    if(appState!='2'){//我报名的项目
                        if((projState=='1')||(projState=='0')){//未开始已开始
                           // alert(++count);
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
                        <div class="join" onclick="cancelProj(${jsonrows[i].id});" >取消报名 ></div>
                        </div>
                        
                        `);
                        }else if(projState=='2'){//已结束
                           // alert(++count);
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
                        }
                        
                    }

            }
        },
        error:function(){

        }
        
    })



})