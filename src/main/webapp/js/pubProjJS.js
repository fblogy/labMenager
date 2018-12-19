var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

$('#submBtn').click(function(){
   var projName=$('#actName').val();
   var projRemark=$('#actPlan').val();
   var projMax=$('#actMax').val();
   var projBegin=$('#begin1').val();
   var projEnd=$('#end2').val();
    //alert(projName+projRemark+projMax+projBegin+projEnd);
    if((projName=="")||(projRemark=="")||(projMax=="")||(projBegin=="")||(projEnd=="")){
        alert('输入不能为空！');
    }else{
        //alert(getCookie('userAccount'));
        $.ajax({
            url:'addProject',
            type:'POST',
            data:{
                "projectName":projName,
                "projectAccount":getCookie('userAccount'),
                "projectRequired":projMax,
                "projectRemark":projRemark,
                "projectBeginTime":projBegin,
                "projectEndTime":projEnd
            },
            success:function(data){
                alert(JSON.parse(data).msg);
                location.reload();
            },
            error:function(){

            }
        })
    }
})