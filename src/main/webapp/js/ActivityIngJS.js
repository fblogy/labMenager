var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

$(document).ready(function(){
    $.ajax({
        url:'getHoldingActivityList',
        data:{

        },
        type:'POST',
        success:function(data){
            //alert(getCookie('acct'));
            alert(data);
            var jsonobj=JSON.parse(data);
            var jsontotal=jsonobj.total;
            var jsonrows=jsonobj.rows;
            //console.log(jsontotal+'is jsontotal');
            for(var i=0;i<jsontotal;i++){
                $('#accordion').append(`
                <div class="panel panel-default">
                <div class="panel-heading">
                <div class="activity">
                <div class="activityTitle">${jsonrows[i].activityName}</div>
                <div style="display: flex;align-items: flex-start;height: 82.6%; width: 100%">
                <div style="display: flex;justify-content: space-between;align-items: center;width: 69.3%;height: 100%;">
                <span class="activitytext">活动时间：${jsonrows[i].beginTimeStr}~${jsonrows[i].endTimeStr}</span>
                <span class="activitytext">发起人：${jsonrows[i].activityAccount}${jsonrows[i].activityUserName}</span>
                <span class="activitytext">报名截止：${jsonrows[i].beginTimeStr}</span>
                </div>
                <div style="width: 18.7%;height: 100%;margin-left: 12%;">
                <button type="button" class="btn btn2" data-actId="${jsonrows[i].id}" onclick="attendAct(this)">我要报名</button>
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse${i}" class="mov">
                详细
                </a>
                </div>
                </div>
                </div>
                </div>
                <div id="collapse${i}" class="panel-collapse collapse in">
                <div class="panel-body">
                <div class="activityDetail">
                <div class="activitytime">活动计划：${jsonrows[i].activityPosition}</div>
                <div class="activitytime">预计人数：${jsonrows[i].activityMin}~${jsonrows[i].activityMax}人</div>
                <div class="activitytime">预算经费：${jsonrows[i].activityMoney}</div>
                <div class="activitytime">备注：${jsonrows[i].activityRemark}</div>
                </div>
                </div>
                </div>
                </div>
                
                `)
            }
        }
    })
})

function attendAct(my){
    //alert($(my).attr('data-actId'));
    $.ajax({
        url:'attendActivity',
        data:{
            "activityID":$(my).attr('data-actId'),
            "activityAccount":getCookie('acct')
        },
        type:'POST',
        success:function(data){
            alert(JSON.parse(data).msg);
        }

    })
}
