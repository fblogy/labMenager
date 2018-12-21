var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

$(document).ready(function(){
    $.ajax({
        url:'getOverActivityList',
        type:'POST',
        data:{
    
        },
        success:function(data){
            //alert(data);
            var jsonobj=JSON.parse(data);
            var jsontotal=jsonobj.total;
            var jsonrows=jsonobj.rows;
            for(var i=0;i<jsontotal;i++){
                $('#actContainer').append(`
                <div class="activity">
                <div class="activityTitle">${jsonrows[i].activityName}</div>
                <div style="display: flex;align-items: flex-start;height: 82.6%; width: 100%">
                    <div style="display: flex;justify-content: space-between;align-items: center;width: 66.3%;height: 100%;">
                        <span class="activitytext">活动时间：${jsonrows[i].beginTimeStr}~${jsonrows[i].endTimeStr}</span>
                        <span class="activitytext">发起人：${jsonrows[i].activityUserName}</span>
                        <span class="activitytext">报名截止：${jsonrows[i].beginTimeStr}</span>
                    </div>
                </div>
            </div>
                `)
            }
        }
    })
})
