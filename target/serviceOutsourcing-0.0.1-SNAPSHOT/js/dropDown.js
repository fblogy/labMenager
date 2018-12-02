var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

var checkDrop=false;//没有被打开过
var transArr=['x','超级管理员','管理员','研究生','项目负责人','组长','本科生']
$('#dropBtn').mouseenter(function(){
    if(checkDrop){
    }
    else{
        var roleStr=getCookie('roleList');
        var currentRole=getCookie('role');
        //console.log(currentRole);
        //console.log(roleStr);/////////
        var roleArr=roleStr.split('_');
        //console.log(roleArr);/////////
        //console.log(roleArr.length);/////////
        // $('.mydropdownContent').append('<div style="border:none;text-align:left">Hi,'+getCookie('userName')+'!请选择身份：</div>');
        for(var i=0;i<roleArr.length;i++){
            if(currentRole==roleArr[i]){ 
                //console.log(roleArr[i]);//////////////////
                $('.mydropdownContent').append('<div class="dpCont selectRole selectEDRole" onclick="selectRoleFunc(this);" data-role='+roleArr[i]+'>'+transArr[roleArr[i]]+'</div>');
            }else{
                $('.mydropdownContent').append('<div class="dpCont selectRole" onclick="selectRoleFunc(this);" data-role='+roleArr[i]+'>'+transArr[roleArr[i]]+'</div>');
            }
        }
        $('.mydropdownContent').append('<div class="dpCont" style="color:gray;line-height:50px" onclick="exitAcct()">退出</div>');
        checkDrop=true;//已打开
    }

})
function selectRoleFunc(myself){//切换角色
    //alert('22222222');
     $('.dpCont').removeClass('selectEDRole');//移除选中
     $(myself).addClass('selectEDRole');//增加选中
    //alert();
    $.ajax({
        url:"changeRole",
        data:{
            "role":$(myself).data('role'),
        },
        success:function(data){
            //console.log('success');
        }
    })
}

$(document).ready(function(){
    $.ajaxSetup({
        complete : function(XMLHttpRequest, textStatus) { // 通过XMLHttpRequest取得响应头，REDIRECT
            var redirect = XMLHttpRequest.getResponseHeader("REDIRECT");//若HEADER中含有REDIRECT说明后端想重定向
            if (redirect == "REDIRECT") {
                var win = window;
                if (win != win.top){
                    win = win.top;
                }
                win.location.href= XMLHttpRequest.getResponseHeader("CONTEXTPATH");//CONTEXTPATH为重定向的地址,在后端已设置好
            }
        }
    });
})
function exitAcct(){
        //http://119.23.36.199:9999/serviceOutsourcing/
        $.post("out",{
        },
        function(data){
            //alert(data);
            //http://119.23.36.199:9999/serviceOutsourcing/
        });
}




