var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

var pageSize=11;//每页11条
var searchCont="";//搜索内容
var swID=false;
var swST=false;
var resultFlag=0;//最终排序方式

function switchID(){
    swID=!swID;
    if(swID){
        resultFlag=0;
    }else{
        resultFlag=1;
    }
    turnPage(-1,resultFlag);
}
function switchST(){
    swST=!swST;
    if(swST){
        resultFlag=2;
    }else{
        resultFlag=3;
    }
    //alert(trans[resultFlag])
    turnPage(-1,resultFlag);
}

$('#searchText').keydown(function(e){
    if(e.keyCode==13){
        searchCont=$('#searchText').val();
        turnPage(-1,0,true);
    }
})

$(document).ready(function(){
    $.ajax({
        url:"sysBookMyApplicationRecordsByWords",
        type:'POST',
        data:{
            "word":"",
            "account":getCookie('userAccount'),
            "PageSize":pageSize,
            "start":"1",
            "sortFlag":"0"
        },
        success:function(data){
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error)
            }

            if(typeof(JSON.parse(data).zero)=="undefined"){}
            else{
                //alert('a');
                $('#zeroPart').append('<div style="width:100%;text-align:center">暂无申请记录！</div>');
            }

            if(typeof(JSON.parse(data).count)=="undefined"){}
            else{
                var jsonCount=JSON.parse(data).count;
                var jsonAllBook=JSON.parse(data).book;
                var jsonAllBookLength=jsonAllBook.length;
                for(var i=0;i<jsonAllBookLength;i++){
                    if((jsonAllBook[i].bookStatus=="1")||(jsonAllBook[i].bookStatus=="0")){//success
                        $('tbody').append(`
                    <tr>
                        <td>${jsonAllBook[i].id}</td>
                        <td>${jsonAllBook[i].bookIsbn}</td>
                        <td>${jsonAllBook[i].bookName}</td>
                        <td>${jsonAllBook[i].bookWriter}</td>
                        <td>${jsonAllBook[i].bookPub}</td>
                        <td>${jsonAllBook[i].bookMark}</td>
                        <td style="color: #059a21;">已通过</td>
                    </tr>                    
                    `);
                    }else if(jsonAllBook[i].bookStatus=="-2"){//fail
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].bookIsbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td style="color: #ff0000;">失败</td>
                        </tr>                    
                        `);
                    }else if(jsonAllBook[i].bookStatus=="-3"){//to be checked
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].bookIsbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td style="background-color: #C93756;color:white;cursor:pointer;" onclick="cancelAdd(${jsonAllBook[i].id});">取消申请</td>
                        </tr>                    
                        `);
                    }

                    
                }
                for (var j=1;j<=pageSize-jsonAllBookLength;j++){
                    $('tbody').append(`
                                    <tr>
										<td>&#12288;</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
                    `);
                }

                //  ====================================
                //  ------------页码--------------------
                //  ====================================

                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">上页</a></li>`);
                for(var i=1;i<=jsonCount;i++){
                    if(i==1){
                        $('#pageBar').append(`<li class="page-item active"><a class="page-link" href="#" onclick="turnPage(this);addActive(this)">1</a></li>`);
                    }else{
                        $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#" onclick="turnPage(this);addActive(this)">${i}</a></li>`);
                    }
                }
                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">下页</a></li>`);

            }
        },
        error:function(){

        }
    })
})

function turnPage(my,flag,createPage){
    $('tbody').children().remove();
    var tempaccount; var temppagesize; var tempstart ;var tempsortflag ;
    var mypage=my.innerHTML;//有my情况
    if(my==-1){//单纯的切换flag
        tempstart=1;//从第一页开始
        tempsortflag=flag;//顺序为选择顺序
    }else{//切换页面
        tempstart=mypage;//切换到要的页面
        tempsortflag=resultFlag;//顺序为默认顺序
    }
    
    // ======copy=====
    //console.log('word'+searchCont+'\n account'+getCookie('userAccount')+'\n pagesize'+pageSize+'\n start'+tempstart+'\n sortFlag'+tempsortflag);
    $.ajax({
        url:"sysBookMyApplicationRecordsByWords",
        type:'POST',
        data:{
            "word":searchCont,
            "account":getCookie('userAccount'),
            "PageSize":pageSize,
            "start":tempstart,
            "sortFlag":tempsortflag
        },
        success:function(data){
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error)
            }

            if(typeof(JSON.parse(data).zero)=="undefined"){}
            else{
                //alert('a');
                $('#zeroPart').append('<div style="width:100%;text-align:center">暂无申请记录！</div>');
            }

            if(typeof(JSON.parse(data).count)=="undefined"){}
            else{
                var jsonCount=JSON.parse(data).count;
                var jsonAllBook=JSON.parse(data).book;
                var jsonAllBookLength=jsonAllBook.length;
                for(var i=0;i<jsonAllBookLength;i++){
                    if((jsonAllBook[i].bookStatus=="1")||(jsonAllBook[i].bookStatus=="0")){//success
                        $('tbody').append(`
                    <tr>
                        <td>${jsonAllBook[i].id}</td>
                        <td>${jsonAllBook[i].bookIsbn}</td>
                        <td>${jsonAllBook[i].bookName}</td>
                        <td>${jsonAllBook[i].bookWriter}</td>
                        <td>${jsonAllBook[i].bookPub}</td>
                        <td>${jsonAllBook[i].bookMark}</td>
                        <td style="color: #059a21;">已通过</td>
                    </tr>                    
                    `);
                    }else if(jsonAllBook[i].bookStatus=="-2"){//fail
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].bookIsbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td style="color: #ff0000;">失败</td>
                        </tr>                    
                        `);
                    }else if(jsonAllBook[i].bookStatus=="-3"){//to be checked
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].bookIsbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td style="background-color: #C93756;color:white;cursor:pointer;" onclick="cancelAdd(${jsonAllBook[i].id})">取消申请</td>
                        </tr>                    
                        `);
                    }

                    
                }
                for (var j=1;j<=pageSize-jsonAllBookLength;j++){
                    $('tbody').append(`
                                    <tr>
										<td>&#12288;</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
                    `);
                }

                //  ====================================
                //  ------------页码--------------------
                //  ====================================
                if(createPage){
                    $('#pageBar').children().remove();
                    // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">上页</a></li>`);
                    for(var i=1;i<=jsonCount;i++){
                        if(i==1){
                            $('#pageBar').append(`<li class="page-item active"><a class="page-link" href="#" onclick="turnPage(this);addActive(this)">1</a></li>`);
                        }else{
                            $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#" onclick="turnPage(this);addActive(this)">${i}</a></li>`);
                        }
                    }
                    // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">下页</a></li>`);
                    }

            }
        },
        error:function(){

        }
    })
}
function addActive(my){
    //alert(my.value);
    $('#pageBar').children('li').removeClass('active');
    $(my).parent('.page-item').addClass('active');
}
function cancelAdd(bookid){
    $.ajax({
        url:'sysBookDelete',
        type:'POST',
        data:{
            "id":bookid
        },
        success:function(data){
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error)
            }
            if(typeof(JSON.parse(data).success)=="undefined"){}
            else{
                alert(JSON.parse(data).success);
                window.location.reload();
            }
            if(typeof(JSON.parse(data).expect)=="undefined"){}
            else{
                alert(JSON.parse(data).expect)
            }
        },
        error:function(){

        }
    })
}