$(document).ready(function(){
    //
    $('#remember').click(function(event){
        event.preventDefault();
    }) 

    //
    var getWidth=$(window).width();
    //alert(getWidth);
    if(getWidth>1400){
        //alert('login')
        $('.imgContainer').attr("src","./img/login.png");
    }else{
        //alert('login1400')
        $('.imgContainer').attr("src","./img/login1400.png");
    }


})

$('#remember').mouseup(function(){
    $(this).prop("checked",!$(this).is(":checked"));
})  
$(window).resize(function(){
    var getWidth=$(window).width();
    if(getWidth>1400){
        //alert('login')
        $('.imgContainer').attr("src","./img/login.png");
    }else{
        //alert('login1400')
        $('.imgContainer').attr("src","./img/login1400.png");
    }
})

var p=document.createElement('script');
p.setAttribute('type','text/javascript');
p.setAttribute('src','./js/coki.js');
document.body.appendChild(p);



function clickLogin(){
    
    var myacct=document.querySelector('#getAcct').value;
    var mypwd=document.querySelector('#getPwd').value;
    alert('click'+myacct+mypwd);
    if((myacct=='')||(mypwd=='')){
        alert('输入不能为空!')
    }else{
        //console.log(typeof(myacct))

        $.ajax({
            url:'login',
            data:{
                "userAccount":myacct,
                "userPassword":mypwd
            },
            type:'POST', 
            success:function(data){
                console.log(data);//////////////////
                var jsonobj=JSON.parse(data);
                var checkeState=jsonobj.result;
                //console.log(checkeState);///////////////
                if(checkeState=="1"){
                    //console.log(jsonobj.role.join('s'));
                    //setCookie('acct',jsonobj.userAccount);
                    //setCookie('name',jsonobj.userName);
                    //setCookie('cuRole',jsonobj.role[0]);
                    //setCookie('ownRole',jsonobj.role.join('_'));
                    window.location.href='./index.html';
                }else{
                    alert(jsonobj.msg);
                }

            },
            error:function(code){
                
            }
        })
        
    }
    
}