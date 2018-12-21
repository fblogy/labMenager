var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

var pageSize=11;//每页11条
var searchCont="";//搜索内容
var swID=true;
var swST=true;
var resultFlag=0;//最终排序方式
// =====================
// ---sortFlag----------
//      0 ID正
//      1 ID逆
//      2 状态正
//      3 状态逆
// =====================

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
        url:"sysBookAllApplicationRecordsByWords",
        type:'POST',
        data:{
            "word":"",
            "PageSize":pageSize,
            "start":"1",
            "sortFlag":"0"
        },
        success:function(data){
            //alert(data);
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error)
            }

            if(typeof(JSON.parse(data).zero)=="undefined"){}
            else{
                //alert('a');
                $('#zeroPart').append('<div style="width:100%;text-align:center">暂无申请记录！</div>');
            }

            // if(typeof(JSON.parse(data).zero)=="undefined"){}
            // else{
            //     //alert('a');
            //     $('#zeroPart').append('<div style="width:100%;text-align:center">暂无申请记录！</div>');
            // }

            if(typeof(JSON.parse(data).count)=="undefined"){}
            else{
                var jsonCount=JSON.parse(data).count;
                var jsonAllBook=JSON.parse(data).BorrowedBook;
                var jsonAllBookLength=jsonAllBook.length;
                for(var i=0;i<jsonAllBookLength;i++){
                    if((jsonAllBook[i].bookStatus=="1")||(jsonAllBook[i].bookStatus=="0")){//success
                        $('tbody').append(`
                    <tr>
                        <td>${jsonAllBook[i].id}</td>
                        <td>${jsonAllBook[i].isbn}</td>
                        <td>${jsonAllBook[i].bookName}</td>
                        <td>${jsonAllBook[i].bookWriter}</td>
                        <td>${jsonAllBook[i].bookPub}</td>
                        <td>${jsonAllBook[i].bookMark}</td>
                        <td>已通过</td>
                    </tr>                    
                    `);
                    }else if(jsonAllBook[i].bookStatus=="-2"){//fali
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].isbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td>已拒绝</td>
                        </tr>                    
                        `);
                    }else if(jsonAllBook[i].bookStatus=="-3"){//to be checked
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].isbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td style="padding:0;position:relative;">
                                <div style="position:absolute;width:100%;height:100%;display:flex;padding:1px">
                                    <div style="cursor:pointer;width:50%;height:100%;background-color:#5F99EB;color:white;display:table;"><div style="display:table-cell; vertical-align:middle;">通过</div></div>
                                    <div style="cursor:pointer;height:100%;width:50%;background-color:#CE4B67;color:white;display:table;"><div style="display:table-cell; vertical-align:middle;">拒绝</div></div>
                                </div>
                            </td>
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